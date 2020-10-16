package coderbyte.challenges.min_window_substring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import util.test.ITest;

public class TestChallenge implements ITest {

    private final IChallenge challenge = new Challenge();

    @Override
    @Test
    public void perform() {
        assertEquals("12", challenge.minWindowSubstring("1", "2"));
        assertEquals("abcXYZ", challenge.minWindowSubstring("abc", "XYZ"));
    }

}
