package coderbyte.challenges.first_reverse;

import util.array.CharArray;
import util.array.ICharArray;

public class Challenge implements IChallenge {

    @Override
    public String firstReverse(String source) {
        ICharArray helper = CharArray.split(source);
        char[] reverted = helper.reverse();
        return String.valueOf(reverted);
    }

}
