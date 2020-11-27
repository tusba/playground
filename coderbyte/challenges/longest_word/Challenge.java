package coderbyte.challenges.longest_word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge implements IChallenge {

    @Override
    public String longestWord(String sen) {
        if (sen == null) {
            return "";
        }

        String result = "";
        int maxLength = 0;

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(sen);
        while (matcher.find()) {
            int from = matcher.start();
            int to = matcher.end();
            if (maxLength < to - from) {
                result = sen.substring(from, to);
                maxLength = to - from;
            }
        }

        return result;
    }

}
