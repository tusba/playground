package coderbyte.challenges.min_window_substring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import util.test.ITest;

public class TestChallenge implements ITest {

    private final IChallenge challenge = new Challenge();

    @Override
    @Test
    public void perform() {
        assertEquals("dae", challenge.minWindowSubstring("aaabaaddae", "aed"));
        assertEquals("aabd", challenge.minWindowSubstring("aabdccdbcacd", "aad"));
        assertEquals("aksfaje", challenge.minWindowSubstring("ahffaksfajeeubsne", "jefaa"));
        assertEquals("affhkkse", challenge.minWindowSubstring("aaffhkksemckelloe", "fhea"));

        assertEquals("", challenge.minWindowSubstring("qwe", ""));
        assertEquals("", challenge.minWindowSubstring("qwe", "qqwe"));
        assertEquals("", challenge.minWindowSubstring("qwe", "r"));
    }

}
