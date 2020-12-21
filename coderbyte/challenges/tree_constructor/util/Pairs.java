package coderbyte.challenges.tree_constructor.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pairs {

    private final Pattern pattern = Pattern.compile("^\\((-?\\d+),(-?\\d+)\\)$");

    public int[] convert(String pair) {
        final int pairSize = 2;
        int[] result = new int[pairSize];

        Matcher matcher = pattern.matcher(pair);
        matcher.find();

        for (int i = 0; i < pairSize; i++) {
            result[i] = Integer.valueOf(matcher.group(i + 1));
        }

        return result;
    }

    public int[][] convert(String[] pairs) {
        int pairCount = pairs.length;
        int[][] result = new int[pairCount][];

        for (int i = 0; i < pairCount; i++) {
            result[i] = convert(pairs[i]);
        }

        return result;
    }

}
