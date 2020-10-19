package coderbyte.challenges.min_window_substring;

import decorators.DSyncResult;
import entities.Result;
import static java.util.logging.Logger.*;
import util.array.*;

public class ChallengeConcurrent implements IChallenge, Runnable {

    /** where to search for */
    private static String haystack;

    /** what to search for */
    private static String needle;

    /** an incapsulation of the minimal found substring */
    private static DSyncResult<String> minWindow = new DSyncResult<>();

    /** an index in haystack to start searching from */
    private int searchFromIndex;

    /** whether the search completed ahead of time */
    private static boolean searchCompletedAot;

    /** the total number of performed concurrent searches */
    private static int performedSearchCount;

    /** the total number of planned concurrent searches */
    private static int plannedSearchCount;

    public ChallengeConcurrent() {
        minWindow.decorate(new Result<>(""));
    }

    /** what index to start search from in a new separate thread */
    public ChallengeConcurrent(int searchFrom) {
        searchFromIndex = searchFrom;
    }

    /** mark the whole search as completed ahead of time */
    private static void markAotCompletedSearch() {
        searchCompletedAot = true;
    }

    /** whether the whole search completed at all */
    private static boolean searchCompleted() {
        return searchCompletedAot || performedSearchCount == plannedSearchCount;
    }

    /** mark one of the concurrent searches as performed */
    private static void markPerformedSearch() {
        performedSearchCount++;
        if (searchCompleted()) {
            synchronized (minWindow) {
                minWindow.notifyAll();
            }
        }
    }

    /** adjust the total number of planned concurrent searches */
    private static void setSearchPlan(int count) {
        plannedSearchCount = count;
    }

    /** decrease the total number of planned concurrent searches */
    private static void skipPlannedSearch() {
        plannedSearchCount--;
    }

    /** suspend the main thread to wait for another threads complete their search */
    private static void suspend() {
        try {
            while (!searchCompleted()) {
                synchronized (minWindow) {
                    minWindow.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** get the current value of the result */
    private static String getMinWindow() {
        return minWindow.getValue();
    }

    /** set the current value for the result */
    private static void setMinWindow(String value) {
        minWindow.setValue(value);

        // no more searching if the exact match was found
        if (getMinWindow().length() == needle.length())
            markAotCompletedSearch();
    }

    /** initialize search environment */
    private static void init(String where, String what) {
        haystack = where == null ? "" : where;
        needle = what == null ? "" : what;
        cleanUp();
    }

    /** clean up shared member values between subsequent executions */
    private static void cleanUp() {
        setMinWindow("");
        searchCompletedAot = false;
        performedSearchCount = 0;
        plannedSearchCount = 0;
    }

    /**
     * Perform the actual search starting from the current haystack index
     * Return whether the found substring exactly equals to the needle
     */
    private boolean actualSearch() {
        char[] charsWhat = needle.toCharArray();
        int lenWhere = haystack.length();

        for (int j = searchFromIndex; j < lenWhere && !searchCompleted(); j++) {
            ICharArray charArray = CharArray.wrap(charsWhat);

            int indexWhat = charArray.indexOf(haystack.charAt(j));
            if (indexWhat == -1)
                continue;

            charsWhat = charArray.truncate(indexWhat);
            if (
                // search completed
                charsWhat.length == 0
                &&
                (
                    // some substring was found for the first time
                    getMinWindow().equals("")
                    ||
                    // a shorter substring was found
                    getMinWindow().length() > j + 1 - searchFromIndex
                )
            ) {
                setMinWindow(haystack.substring(searchFromIndex, j + 1));

                // no more searching if the exact needle was found
                if (searchCompleted())
                    return true;
            }
        }

        return false;
    }

    @Override
    public void run() {
        actualSearch();
        markPerformedSearch();
    }

    @Override
    public String minWindowSubstring(String where, String what) {
        init(where, what);

        int lenWhere = haystack.length();
        int lenWhat = needle.length();
        if (lenWhere < lenWhat || lenWhat == 0)
            return getMinWindow();

        setSearchPlan(lenWhere - lenWhat + 1);
        for (int i = 0; i <= lenWhere - lenWhat; i++) {
            // no need to search for if the needle doesn't contain the current character
            if (needle.indexOf(haystack.charAt(i)) == -1) {
                skipPlannedSearch();
                continue;
            }

            var newThread = new Thread(new ChallengeConcurrent(i), "From index " + i);
            try {
                newThread.join();
            } catch (InterruptedException e) {
                getLogger(GLOBAL_LOGGER_NAME).severe("The main thread was interrupted: " + e.getMessage());
                return null;
            }
            newThread.start();
        }

        // wait for other threads to finish
        suspend();

        return getMinWindow();
    }

}
