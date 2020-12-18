package coderbyte.challenges.bracket_matcher;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Bracket Matcher challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test bracket matcher")
    @Override
    public void perform() {
        assertFalse(challenge.bracketMatcher("(coder)(byte))"));
        assertFalse(challenge.bracketMatcher("letter(s) gal(o)(r)((e)"));
        assertTrue(challenge.bracketMatcher("(c(oder)) b(yte)"));
        assertTrue(challenge.bracketMatcher("twice thri(c)(e)()()"));
    }

}
