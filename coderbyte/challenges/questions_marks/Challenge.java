package coderbyte.challenges.questions_marks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge implements IChallenge {

    private String withoutLetters(String str) {
        Pattern pattern = Pattern.compile("[^?\\d]");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }

    @Override
    public boolean questionsMarks(String str) {
        // check string for minimum requirements
        if (str == null || str.length() < 2 + IChallenge.QUESTIONS) {
            return false;
        }

        String chars = withoutLetters(str);
        boolean found = false;

        Pattern pattern = Pattern.compile("(\\d)(?=(\\?+)(\\d))");
        Matcher matcher = pattern.matcher(chars);

        // traverse over each found group
        while (matcher.find()) {
            try {
                int first = Integer.parseInt(matcher.group(1));
                int questions = matcher.group(2).length();
                int second = Integer.parseInt(matcher.group(3));

                boolean sumDone = first + second == IChallenge.SUM;
                if (sumDone && questions != IChallenge.QUESTIONS) {
                    return false;
                }

                if (!found && sumDone) {
                    found = true;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return found;
    }

}
