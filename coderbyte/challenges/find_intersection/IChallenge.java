package coderbyte.challenges.find_intersection;

public interface IChallenge {

    static final String NO_INTERSECTION = "false";

    String findIntersection(String[] lists);

    int[] findIntersection(int[] first, int[] second);

}
