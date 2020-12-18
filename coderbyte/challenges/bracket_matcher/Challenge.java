package coderbyte.challenges.bracket_matcher;

public class Challenge implements IChallenge {

    @Override
    public boolean bracketMatcher(String str) {
        if (str == null || str.equals("")) {
            return true;
        }

        int level = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch != IChallenge.BRACKET_OPEN && ch != IChallenge.BRACKET_CLOSE) {
                continue;
            }
            level += ch == IChallenge.BRACKET_OPEN ? 1 : -1;
            if (level < 0) {
                return false;
            }
        }

        return level == 0;
    }

}
