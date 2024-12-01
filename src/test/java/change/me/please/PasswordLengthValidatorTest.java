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
}
