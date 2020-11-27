package coderbyte.challenges.longest_word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Longest Word challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test longest word")
    @Override
    public void perform() {
        assertEquals("time", challenge.longestWord("fun&!! time"));
        assertEquals("love", challenge.longestWord("I love dogs"));
    }

}
