package coderbyte.challenges.first_reverse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("First Reverse challenge")
@Testable
public class TestChallenge implements ITest {

    private final static IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test first reverse")
    @Override
    public void perform() {
        assertEquals("etybredoc", challenge.firstReverse("coderbyte"));
        assertEquals("edoC evoL I", challenge.firstReverse("I Love Code"));
        assertEquals("", challenge.firstReverse(""));
        assertEquals("Refer", challenge.firstReverse("refeR"));
        assertNotEquals("A.k.a", challenge.firstReverse("A.k.a"));
    }

}
