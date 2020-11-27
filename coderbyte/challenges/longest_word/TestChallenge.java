package coderbyte.challenges.longest_word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Longest Word challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @DisplayName("Test sentences containing no words")
    @ParameterizedTest
    @Tag(ChallengeTest.TAG)
    @ValueSource(strings = { "", "!@#", " % - () ." })
    void noWords(String sentence) {
        assertEquals("", challenge.longestWord(sentence));
    }

    @ChallengeTest
    @DisplayName("Test longest word")
    @Override
    public void perform() {
        assertEquals("", challenge.longestWord(null));
        assertEquals("time", challenge.longestWord("fun&!! time"));
        assertEquals("love", challenge.longestWord("I love dogs"));
    }

}
