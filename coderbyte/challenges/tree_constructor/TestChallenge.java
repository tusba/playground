package coderbyte.challenges.tree_constructor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Tree Constructor challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test tree constructor")
    @Override
    public void perform() {
        assertTrue(challenge.treeConstructor(new String[] { "(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)" }));
        assertFalse(challenge.treeConstructor(new String[] { "(1,2)", "(3,2)", "(2,12)", "(5,2)" }));
    }

}
