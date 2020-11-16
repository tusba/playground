package coderbyte.challenges.min_window_substring.search;

public class SearchState {

    /** whether the search completed ahead of time */
    private boolean completedAot;

    /** the total number of performed searches */
    private int performedCount;

    /** the total number of planned concurrent searches */
    private int plannedCount;

    public synchronized void plan(int count) {
        plannedCount = count;
    }

    public synchronized void skip() {
        plannedCount--;
    }

}
