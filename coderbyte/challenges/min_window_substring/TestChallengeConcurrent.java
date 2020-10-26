package coderbyte.challenges.min_window_substring;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.annotation.Testable;
import util.annotation.ChallengeTest;
import util.test.ITest;

@Disabled("Until concurrent code will be correct")
@DisplayName("Min Window Substring challenge (concurrent)")
@Testable
class TestChallengeConcurrent implements ITest {

    private final IChallenge challenge = new ChallengeConcurrent();

    private class Multiple implements Executable {

        private int times;

        Multiple(int times) {
            this.times = times;
        }

        @Override
        public void execute() throws Throwable {
            for (int i = 0; i < times; i++) {
                baseTest();
            }
        }

    }

    private void baseTest() {
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

    @ChallengeTest
    @DisplayName("Test min window substring (concurrent)")
    @Override
    public void perform() {
        baseTest();
    }

    @ChallengeTest
    @DisplayName("Test min window substring (concurrent, multiple)")
    void multiplePerform() {
        assertTimeout(Duration.ofSeconds(10), new Multiple(10));
    }

}
