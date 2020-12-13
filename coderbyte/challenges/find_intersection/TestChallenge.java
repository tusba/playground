package coderbyte.challenges.find_intersection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Find Intersection challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test find intersection")
    @Override
    public void perform() {
        assertEquals("1,4,13", challenge.findIntersection(new String[] { "1, 3, 4, 7, 13", "1, 2, 4, 13, 15" }));
        assertEquals("1,9,10", challenge.findIntersection(new String[] { "1, 3, 9, 10, 17, 18", "1, 4, 9, 10" }));
        assertEquals("false", challenge.findIntersection(new String[] { "2, 22", "12, 32" }));
    }

}
