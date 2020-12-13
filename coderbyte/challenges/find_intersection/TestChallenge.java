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
        assertEquals("6,11,16", challenge.findIntersection(new String[] { "5, 6, 9, 11, 12, 16", "4, 6, 7, 11, 16" }));
        assertEquals("1,9,10", challenge.findIntersection(new String[] { "1, 3, 9, 10, 17, 18", "1, 4, 9, 10" }));
        assertEquals("11,12", challenge.findIntersection(new String[] { "11, 12, 14, 16, 20", "11, 12, 13, 18, 21" }));
        assertEquals("21,25", challenge.findIntersection(new String[] { "21, 22, 23, 25, 27, 28", "21, 24, 25, 29" }));
        assertEquals("false", challenge.findIntersection(new String[] { "2, 22", "12, 32" }));
    }

}
