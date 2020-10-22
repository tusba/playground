package coderbyte.challenges.min_window_substring;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;
import util.test.ITest;

public class TestChallengeConcurrent implements ITest {

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

        assertEquals("", challenge.minWindowSubstring("qwe", ""));
        assertEquals("", challenge.minWindowSubstring("qwe", "qqwe"));
        assertEquals("", challenge.minWindowSubstring("qwe", "r"));
    }

    @Test
    @Override
    public void perform() {
        baseTest();
    }

    @Test
    public void multiplePerform() {
        assertTimeout(Duration.ofSeconds(10), new Multiple(10));
    }

}
