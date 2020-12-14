package coderbyte.challenges.codeland_username_validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;

import util.annotation.ChallengeTest;
import util.test.ITest;

@DisplayName("Codeland Username Validation challenge")
@Testable
public class TestChallenge implements ITest {

    private static final IChallenge challenge = new Challenge();

    @ChallengeTest
    @DisplayName("Test Codeland username validation")
    @Override
    public void perform() {
        assertTrue(challenge.codelandUsernameValidation("u__hello_world123"));
        assertFalse(challenge.codelandUsernameValidation("aa_"));
        assertFalse(challenge.codelandUsernameValidation("oooooooooooooooooo________a"));
        assertFalse(challenge.codelandUsernameValidation("a______b_________555555555555aaaa"));
    }

}
