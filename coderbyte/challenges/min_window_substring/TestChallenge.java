package coderbyte.challenges.min_window_substring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;
import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Min Window Substring challenge")
@Testable
class TestChallenge implements ITest {

    private final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test min window substring")
    @Override
    public void perform() {
        assertEquals("dae", challenge.minWindowSubstring("aaabaaddae", "aed"));
        assertEquals("aabd", challenge.minWindowSubstring("aabdccdbcacd", "aad"));
        assertEquals("aksfaje", challenge.minWindowSubstring("ahffaksfajeeubsne", "jefaa"));
        assertEquals("affhkkse", challenge.minWindowSubstring("aaffhkksemckelloe", "fhea"));
        assertEquals("vvave", challenge.minWindowSubstring("vvavereveaevafefaef", "vvev"));
        assertEquals("a", challenge.minWindowSubstring("aaaaaaaaa", "a"));
        assertEquals("affsf", challenge.minWindowSubstring("aaffsfsfasfasfasfasfasfacasfafe", "fafsf"));
        assertEquals("caae", challenge.minWindowSubstring("caae", "cae"));

        assertEquals("", challenge.minWindowSubstring("qwe", ""));
        assertEquals("", challenge.minWindowSubstring("qwe", "qqwe"));
        assertEquals("", challenge.minWindowSubstring("qwe", "r"));
    }

}
