package change.me.please;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cthiebaud.passwordvalidator.*;

/**
 * Unit tests for PasswordLengthValidator.
 */
class PasswordLengthValidatorMaxTrialsTest {

    private PasswordValidator validator;

    // Using an array to allow modification inside the mock ExitHandler, as
    // lambda expressions and anonymous classes can only capture final or
    // effectively final variables.
    private final int[] exitStatus = { Integer.MIN_VALUE };

    @BeforeEach
    void setUp() {
        // Mock ExitHandler
        ExitHandler mockExitHandler = new ExitHandler() {
            @Override
            public void exit(int status) {
                exitStatus[0] = status; // Capture the exit status
            }
        };

        // Initialize the PasswordValidator with the mock ExitHandler
        validator = new PasswordLengthValidator() {
            @Override
            public ExitHandler getExitHandler() {
                return mockExitHandler;
            }
        };
    }

    @Test
    void testMaxTrialsFails() {
        // Simulate MAX_TRIALS reached
        for (int i = 0; i <= 3; i++) {
            validator.validate("short");
        }

        // Assert that the exit handler was called with status -2
        assertEquals(-2, exitStatus[0]);
    }

    @Test
    void testPositiveValidation() {
        // MAX_TRIALS-1 failed validations
        for (int i = 0; i < 2; i++) {
            validator.validate("short");
        }
        // Validate a password that meets the minimum length
        ValidationResult result = validator.validate("longenough");

        // Assert that the validation passes and exit status remains unchanged
        assertTrue(result.isValid());
        assertEquals(Integer.MIN_VALUE, exitStatus[0]);
    }
}
