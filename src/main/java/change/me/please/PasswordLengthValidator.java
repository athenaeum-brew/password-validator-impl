package change.me.please;

import com.cthiebaud.passwordvalidator.*;

/**
 * The {@code PasswordLengthValidator} class is an implementation of the
 * {@link PasswordValidator}
 * interface that checks whether a given password meets a minimum length
 * requirement.
 * <p>
 * This validator ensures that the password length is at least
 * {@value #MIN_LENGTH} characters.
 * If the password meets this criterion, it is considered valid; otherwise, it
 * is invalid.
 * </p>
 *
 * <h2>Usage Example:</h2>
 * 
 * <pre>{@code
 * PasswordValidator validator = new PasswordLengthValidator();
 * ValidationResult result = validator.validate("examplePassword");
 * if (result.isValid()) {
 *     System.out.println("Password is valid!");
 * } else {
 *     System.out.println(result.getMessage());
 * }
 * }</pre>
 *
 * @see PasswordValidator
 * @see ValidationResult
 */
public class PasswordLengthValidator implements PasswordValidator {

    /**
     * The minimum length required for a valid password.
     */
    private static final int MIN_LENGTH = 8;
    /**
     * The maximum trials
     */
    private static final int MAX_TRIALS = 3;

    /**
     * The counter for trials
     */
    int trials = 0;

    /**
     * Validates whether the given password meets the minimum length requirement.
     * <p>
     * A password is considered valid if its length is greater than or equal to
     * {@value #MIN_LENGTH}.
     * </p>
     *
     * @param potentialPassword the password to validate; must not be {@code null}.
     * @return a {@link ValidationResult} object containing the validation outcome:
     *         <ul>
     *         <li>{@code true} and a success message if the password length is
     *         valid.</li>
     *         <li>{@code false} and an error message if the password length is less
     *         than
     *         {@value #MIN_LENGTH} characters.</li>
     *         </ul>
     * @throws NullPointerException if {@code potentialPassword} is {@code null}.
     */
    @Override
    public ValidationResult validate(String potentialPassword) {
        if (++trials > MAX_TRIALS) {
            getExitHandler().exit(-2); // Use the default ExitHandler provided by the interface
        }

        if (potentialPassword == null) {
            throw new IllegalArgumentException("The password to validate cannot be null.");
        }

        if (potentialPassword.length() >= MIN_LENGTH) {
            return new ValidationResult(true, null); // the message may be null
        } else {
            return new ValidationResult(false, "Password must be longer than " + MIN_LENGTH + " characters.");
        }
    }

    @Override
    public String prompt() {
        return trials + "/" + MAX_TRIALS + " Try a password: ";
    }
}
