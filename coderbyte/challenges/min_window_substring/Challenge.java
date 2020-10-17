package coderbyte.challenges.min_window_substring;

import util.array.*;

public class Challenge implements IChallenge {

    @Override
    public String minWindowSubstring(String where, String what) {
        String minMatch = ""; // the resulting minimal substring

        if (where == null)
            where = "";

        if (what == null)
            what = "";

        int lenWhere = where.length();
        int lenWhat = what.length();
        if (lenWhere < lenWhat || lenWhat == 0)
            return minMatch;

        for (int i = 0; i <= lenWhere - lenWhat; i++) {
            // optimization
            if (what.indexOf(where.charAt(i)) == -1)
                continue;

            char[] charsWhat = what.toCharArray(); // the second argument as a char array
            for (int j = i; j < lenWhere; j++) {
                ICharArray charArray;
                try {
                    charArray = new CharArray(charsWhat);
                } catch (NullArrayException e) {
                    continue;
                }

                int indexWhat = charArray.indexOf(where.charAt(j));
                if (indexWhat == -1)
                    continue;

                charsWhat = charArray.truncate(indexWhat);
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
