package change.me.please;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.cthiebaud.passwordvalidator.*;

/**
 * Unit tests for PasswordLengthValidator.
 */
class PasswordLengthValidatorTest {

    private final PasswordValidator validator = new PasswordLengthValidator();

    @Test
    void testValidPassword() {
        ValidationResult result = validator.validate("validPassword123");
        assertTrue(result.isValid());
        assertNull(result.message());
    }

    @Test
    void testInvalidPassword() {
        ValidationResult result = validator.validate("short");
        assertFalse(result.isValid());
        assertEquals("Password must be longer than 8 characters.", result.message());
    }

    @Test
    void testDefaultExitHandler() {
        // Mock ExitHandler
        final int[] exitStatus = { Integer.MIN_VALUE }; // Use an array to modify it inside the lambda

        ExitHandler mockExitHandler = new ExitHandler() {

            @Override
            public void exit(int status) {
                exitStatus[0] = status; // Capture the exit status
            }
        };

        // Inject a mock ExitHandler by overriding getExitHandler in a test subclass
        PasswordValidator testValidator = new PasswordLengthValidator() {
            @Override
            public ExitHandler getExitHandler() {
                return mockExitHandler;
            }
        };

        // Simulate MAX_TRIALS reached
        for (int i = 0; i < 4; i++) {
            testValidator.prompt();
            testValidator.validate("short" + i);
        }

        // Assert that the exit handler was called
        assertEquals(-2, exitStatus[0]);
    }
}
