package coderbyte.challenges.find_intersection;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Challenge implements IChallenge {

    private String[] findIntersection(String[] first, String[] second) {
        String[] noIntersection = new String[0];
        if (first.length == 0 || second.length == 0) {
            return noIntersection;
        }

        List<String> intersection = new ArrayList<>(Math.min(first.length, second.length));
        int secondIndex = 0;
        int firstNumber;

        try {
            int secondNumber = Integer.parseInt(second[secondIndex]);

            for (int i = 0; i < first.length && secondIndex < second.length; i++) {
                firstNumber = Integer.parseInt(first[i]);

                while (firstNumber > secondNumber && ++secondIndex < second.length) {
                    secondNumber = Integer.parseInt(second[secondIndex]);
                }

                if (secondIndex == second.length) {
                    break;
                }

                if (firstNumber == secondNumber) {
                    intersection.add(first[i]);
                }
            }
        } catch (NumberFormatException e) {
            return noIntersection;
        }

        return intersection.toArray(noIntersection);
    }

    @Override
    public String findIntersection(String[] lists) {
        if (lists.length != 2 || lists[0] == null || lists[1] == null) {
            return IChallenge.NO_INTERSECTION;
        }

        Pattern pattern = Pattern.compile(",\\s*");
        String[] intersection = findIntersection(pattern.split(lists[0]), pattern.split(lists[1]));
        return intersection.length > 0
            ? String.join(",", intersection)
            : IChallenge.NO_INTERSECTION;
    }

}
