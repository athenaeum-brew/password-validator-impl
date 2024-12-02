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
        ValidationResult result = validator.validate("longenough");
        assertTrue(result.isValid());
        assertNull(result.message());
    }

    @Test
    void testInvalidPassword() {
        ValidationResult result = validator.validate("short");
        assertFalse(result.isValid());
        String regex = "^Password must be longer than \\d+ characters.*";
        assertTrue(result.message().matches(regex), "Message should match the expected pattern");
    }

}
