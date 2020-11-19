package coderbyte.challenges.first_factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("First Factorial challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @DisplayName("Test out-of-range argument")
    @ParameterizedTest
    @Tag(ChallengeTest.TAG)
    @ValueSource(ints = { 0, 19 })
    void outOfRange(int number) {
        Exception exception = assertThrows(OutOfRangeException.class, () -> challenge.firstFactorial(number));
        assertEquals("The value is out of range", exception.getMessage());
    }

    @ChallengeTest
    @DisplayName("Test first factorial")
    @Override
    public void perform() {
        assertAll("Correct calculations",
            () -> assertEquals(1, challenge.firstFactorial(1)),
            () -> assertEquals(24, challenge.firstFactorial(4)),
            () -> assertEquals(40320, challenge.firstFactorial(8))
        );
    }

}
