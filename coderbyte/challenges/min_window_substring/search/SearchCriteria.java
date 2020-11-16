package coderbyte.challenges.min_window_substring.search;

public class SearchCriteria {

    /** where to search for */
    private String haystack;

    /** what to search for */
    private String needle;

    public SearchCriteria(String where, String what) {
        haystack = where == null ? "" : where;
        needle = what == null ? "" : what;
    }

    public String what() {
        return needle;
    }

    public String where() {
        return haystack;
    }

}
