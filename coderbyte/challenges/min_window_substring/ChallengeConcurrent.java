package coderbyte.challenges.min_window_substring;

import coderbyte.challenges.min_window_substring.search.SearchCriteria;
import coderbyte.challenges.min_window_substring.search.SearchState;
import decorators.DSyncResult;
import entities.Result;

public class ChallengeConcurrent implements IChallenge, Runnable {

    /**
     * incapsulation of the minimal found substring
     * will be shared among multiple threads
     */
    private DSyncResult<String> minWindow;

    private SearchCriteria params;

    /** will be shared among multiple threads */
    private SearchState search;

    /** get the current value of the result */
    private String getMinWindow() {
        return minWindow.getValue();
    }

    public ChallengeConcurrent() {
        minWindow = new DSyncResult<>();
        minWindow.decorate(new Result<>(""));

        search = new SearchState();
    }

    @Override
    public String minWindowSubstring(String where, String what) {
        params = new SearchCriteria(where, what);

        String haystack = params.where();
        String needle = params.what();

        int lenWhere = haystack.length();
        int lenWhat = needle.length();
        if (lenWhere < lenWhat || lenWhat == 0)
            return getMinWindow();

        search.plan(lenWhere - lenWhat + 1); // maximum number of searches to be performed concurrently

        for (int i = 0; i <= lenWhere - lenWhat; i++) {
            // no need to perform a search if the needle doesn't contain the current character
            if (needle.indexOf(haystack.charAt(i)) == -1) {
                search.skip(); // decrease the total number of planned concurrent searches
                continue;
            }
        }
    }

}
