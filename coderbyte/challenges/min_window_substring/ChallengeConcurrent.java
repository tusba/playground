package coderbyte.challenges.min_window_substring;

import static java.util.logging.Logger.*;

import coderbyte.challenges.min_window_substring.search.SearchCriteria;
import coderbyte.challenges.min_window_substring.search.SearchState;
import entities.IResult;
import entities.Result;
import util.array.CharArray;
import util.array.ICharArray;

public class ChallengeConcurrent implements IChallenge, Runnable {

    /** error flag */
    private boolean errorOccurred;

    /**
     * incapsulation of the minimal found substring
     * will be shared among multiple threads
     */
    private IResult<String> minWindow;

    private SearchCriteria params;

    /** will be shared among multiple threads */
    private SearchState search;

    /** get the current value of the result */
    private String getMinWindow() {
        return minWindow.getValue();
    }

    /** set the current value for the result */
    private void setMinWindow(String value) {
        if (value == null || search.completed()) {
            return;
        }

        minWindow.setValue(value);

        // no more searching if the exact match was found
        if (value.length() == params.what().length())
            search.completeAot();
    }

    /**
     * Store the result if it meets requirements
     * @param candidate result candidate
     * @return whether the exact needle was found
     */
    private boolean storeMinWindow(String candidate) {
        synchronized (minWindow) {
            String currentValue = getMinWindow();
            if (!currentValue.equals("") && currentValue.length() <= candidate.length()) {
                // there is already some result and it is not shorter than a candidate
                return false;
            }

            setMinWindow(candidate);
            return search.completed();
        }
    }

    /** mark one of the concurrent searches as accomplished */
    private void accomplishSearch() {
        search.perform();
        if (search.completed()) {
            synchronized (minWindow) {
                minWindow.notifyAll();
            }
        }
    }

    /** initialize synchronized members */
    private void init() {
        minWindow = new Result<>("");

        search = new SearchState();
    }

    /** suspend the main thread to wait for another threads to complete their search */
    private void suspend() {
        try {
            while (!search.completed()) {
                synchronized (minWindow) {
                    minWindow.wait();
                }
            }
        } catch (InterruptedException e) {
            getLogger(GLOBAL_LOGGER_NAME).severe(() -> "The main thread was awaken: " + e.getMessage());
            errorOccurred = true;
        }
    }

    /**
     * Perform the actual search
     * @return whether the found substring exactly equals to the needle
     */
    private boolean performSearch() {
        char[] charsWhat = params.what().toCharArray();
        String haystack = params.where();

        for (int i = 0, lenWhere = haystack.length(); i < lenWhere && !search.completed(); i++) {
            ICharArray charArray = CharArray.wrap(charsWhat);

            int indexWhat = charArray.indexOf(haystack.charAt(i));
            if (indexWhat == -1)
                continue;

            charsWhat = charArray.truncate(indexWhat); // kick out the found character

            // search completed, all characters have been kicked out
            if (charsWhat.length == 0 && storeMinWindow(haystack.substring(0, i + 1))) {
                // no more searching if the exact needle was found
                return true;
            }
        }

        return false;
    }

    /** what string to search in in a new separate thread */
    private ChallengeConcurrent(ChallengeConcurrent main, String where) {
        minWindow = main.minWindow;
        search = main.search;

        params = new SearchCriteria(where, main.params.what());
    }

    public ChallengeConcurrent() {
        init();
    }

    @Override
    public String minWindowSubstring(String where, String what) {
        if (search.completed())
            init();

        params = new SearchCriteria(where, what);

        String haystack = params.where();
        String needle = params.what();

        int lenWhere = haystack.length();
        int lenWhat = needle.length();
        if (lenWhere < lenWhat || lenWhat == 0)
            return getMinWindow();

        int maxThreads = lenWhere - lenWhat + 1; // maximum number of searches to be performed concurrently

        search.plan(maxThreads);
        int searchCounter = 0;
        Thread[] newThreads = new Thread[maxThreads];

        for (int i = 0; i < maxThreads; i++) {
            // no need to perform a search if the needle doesn't contain the current character
            if (needle.indexOf(haystack.charAt(i)) == -1) {
                search.skip(); // decrease the total number of planned concurrent searches
                continue;
            }

            String newHaystack = haystack.substring(i);
            Thread newThread = new Thread(new ChallengeConcurrent(this, newHaystack),
                "Search #" + ++searchCounter + " [" + i + ": " + newHaystack + "]");
            newThreads[i] = newThread;
            newThread.start();
        }

        for (int i = 0; i < maxThreads && newThreads[i] != null; i++) {
            try {
                newThreads[i].join();
            } catch (InterruptedException e) {
                getLogger(GLOBAL_LOGGER_NAME).severe(() -> "The main thread was interrupted: " + e.getMessage());
                errorOccurred = true;
                break;
            }
        }

        if (!errorOccurred) {
            suspend();
        }

        return errorOccurred ? null : getMinWindow();
    }

    @Override
    public void run() {
        performSearch();
        accomplishSearch();
    }

}
