package coderbyte.challenges.questions_marks;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Questions Marks challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test questions marks")
    @Override
    public void perform() {
        assertAll("Should be true",
            () -> assertTrue(challenge.questionsMarks("acc?7??sss?3rr1??????5")),
            () -> assertTrue(challenge.questionsMarks("arrb6???4xxbl5???eee5"))
        );

        assertAll("Should be false",
            () -> assertFalse(challenge.questionsMarks("")),
            () -> assertFalse(challenge.questionsMarks("aa6?9"))
        );
    }

}
