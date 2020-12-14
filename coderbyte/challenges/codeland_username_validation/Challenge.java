package coderbyte.challenges.codeland_username_validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge implements IChallenge {

    @Override
    public boolean codelandUsernameValidation(String str) {
        int min = IChallenge.MIN_LENGTH;
        int max = IChallenge.MAX_LENGTH;

        String start = "\\p{Alpha}"; // must start with a letter
        String body = "\\w"; // can only contain letters, numbers, and the underscore character
        String length = "{" + (min - 2) + "," + (max - 2) + "}"; // is between 4 and 25 characters
        String end = "[^_]"; // cannot end with an underscore character

        String regex = "^" + start + body + length + end + "$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

}
