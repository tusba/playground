package coderbyte.challenges.min_window_substring;

import decorators.DSyncResult;
import entities.IResult;
import entities.Result;
import util.array.*;

public class Challenge implements IChallenge {

    /** thread count */
    private static final int THREADS = 1;

    /** where to search for */
    private String haystack;

    /** what to search for */
    private String needle;

    /** an incapsulation of the minimal found substring */
    private DSyncResult<String, IResult<String>> minWindow;

    public Challenge() {
        minWindow = new DSyncResult<>();
        minWindow.decorate(new Result<>(""));
    }

    public Challenge(DSyncResult<String, IResult<String>> minWindow) {
        this.minWindow = minWindow;
    }

    private String getMinWindow() {
        return minWindow.getValue();
    }

    private void setMinWindow(String value) {
        minWindow.setValue(value);
    }

    private void init(String where, String what) {
        haystack = where == null ? "" : where;
        needle = what == null ? "" : what;
        setMinWindow("");
    }

    /**
     * Perform the actual search starting from the specified haystack's index
     * Return whether the found substring exactly equals to the needle
     */
    private boolean actualSearch(int fromHaystackIndex) {
        char[] charsWhat = needle.toCharArray();
        int lenWhere = haystack.length();

        for (int j = fromHaystackIndex; j < lenWhere; j++) {
            ICharArray charArray = CharArray.wrap(charsWhat);

            int indexWhat = charArray.indexOf(haystack.charAt(j));
            if (indexWhat == -1)
                continue;

            charsWhat = charArray.truncate(indexWhat);

            if (
                // search finished
                charsWhat.length == 0
                &&
                (
                    // some substring was found for the first time
                    getMinWindow().equals("")
                    ||
                    // a shorter substring was found
                    getMinWindow().length() > j + 1 - fromHaystackIndex
                )
            ) {
                setMinWindow(haystack.substring(fromHaystackIndex, j + 1));

                // no more searching if the exact needle was found
                if (getMinWindow().equals(needle))
                    return true;
            }
        }

        return false;
    }

    @Override
    public String minWindowSubstring(String where, String what) {
        init(where, what);

        int lenWhere = haystack.length();
        int lenWhat = needle.length();
        if (lenWhere < lenWhat || lenWhat == 0)
            return getMinWindow();

        for (int i = 0; i <= lenWhere - lenWhat; i++) {
            // no more searching if the needle doesn't contain the current character
            if (needle.indexOf(haystack.charAt(i)) == -1)
                continue;

            if (actualSearch(i)) {
                return getMinWindow();
            }
        }
        return getMinWindow();
    }

}
