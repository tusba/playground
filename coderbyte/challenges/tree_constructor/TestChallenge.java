package coderbyte.challenges.tree_constructor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import coderbyte.challenges.tree_constructor.util.Pairs;
import util.annotation.ChallengeTest;
import util.annotation.UtilityTest;
import util.test.ITest;

@DisplayName("Tree Constructor challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @DisplayName("Test pair parsing and conversion")
    @UtilityTest
    void parsePairs() {
        Pairs convertor = new Pairs();
        assertArrayEquals(new int[] { -1, 2 }, convertor.convert("(-1,2)"));
        assertArrayEquals(new int[] { 0, 3 }, convertor.convert("(0,3)"));

        int[][] intPairs = new int[][] { {-2, 4}, {10, 0}, {99, -100} };
        int[][] resultPairs = convertor.convert(new String[] { "(-2,4)", "(10,0)", "(99,-100)" });
        for (int i = 0; i < intPairs.length; i++) {
            assertArrayEquals(intPairs[i], resultPairs[i]);
        }
    }

    @ChallengeTest
    @DisplayName("Test tree constructor")
    @Override
    public void perform() {
        assertTrue(challenge.treeConstructor(new String[] { "(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)" }));
        assertTrue(challenge.treeConstructor(new String[] { "(1,2)", "(2,4)", "(7,2)" }));
        assertTrue(challenge.treeConstructor(new String[] { "(10,20)" }));
        assertTrue(challenge.treeConstructor(new String[] { "(1,2)", "(2,4)", "(7,4)" }));
        assertTrue(challenge.treeConstructor(new String[] { "(5,6)", "(6,3)", "(2,3)", "(12,5)" }));
        assertTrue(challenge.treeConstructor(new String[] { "(10,20)", "(20,50)" }));
        assertTrue(challenge.treeConstructor(new String[] { "(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)" }));
        assertFalse(challenge.treeConstructor(new String[] { "(3,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)" }));
        assertFalse(challenge.treeConstructor(new String[] { "(2,5)", "(2,6)" }));
        assertFalse(challenge.treeConstructor(new String[] { "(1,2)", "(3,2)", "(2,12)", "(5,2)" }));
        assertFalse(challenge.treeConstructor(new String[] { "(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)" }));
    }

}
