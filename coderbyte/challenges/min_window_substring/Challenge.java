package coderbyte.challenges.min_window_substring;

public class Challenge implements IChallenge {

    private int indexInCharArray(char[] array, char element) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == element)
                return i;
        return -1;
    }

    private char[] truncateCharArray(char[] origin, int index)
    {
        char[] result = new char[origin.length == 0 ? 0 : origin.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = origin[i >= index ? i + 1 : i];
        }
        return result;
    }

    @Override
    public String minWindowSubstring(String where, String what) {
        int lenWhere = where.length(), lenWhat = what.length();
        String minMatch = ""; // the resulting minimal substring
        if (lenWhere < lenWhat || lenWhat == 0)
            return minMatch;

        for (int i = 0; i <= lenWhere - lenWhat; i++) {
            // optimization
            if (what.indexOf(where.charAt(i)) == -1)
                continue;

            char[] charsWhat = what.toCharArray(); // the second argument as a char array
            for (int j = i; j < lenWhere; j++) {
                int indexWhat = indexInCharArray(charsWhat, where.charAt(j));
                if (indexWhat == -1)
                    continue;

                charsWhat = truncateCharArray(charsWhat, indexWhat);
                if (charsWhat.length != 0)
                    continue;

                // match found
                if (minMatch.length() == 0 || minMatch.length() > j + 1 - i) {
                    // less length found
                    minMatch = where.substring(i, j + 1);

                    // optimization
                    if (minMatch.length() == lenWhat)
                        return minMatch;
                }
            }
        }
        return minMatch;
    }

}
