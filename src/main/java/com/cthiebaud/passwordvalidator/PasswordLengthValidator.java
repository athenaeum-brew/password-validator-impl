package com.cthiebaud.passwordvalidator;

/**
 * Validates that a password is longer than 8 characters.
 */
public class PasswordLengthValidator implements PasswordValidator {

    private static final int MIN_LENGTH = 8;

    @Override
    public ValidationResult validate(String potentialPassword) {
        if (potentialPassword.length() >= MIN_LENGTH) {
            return new ValidationResult(true, "Password length is valid.");
        } else {
            return new ValidationResult(false, "Password must be longer than " + MIN_LENGTH + " characters.");
        }
    }

    // @Override
    // public String describe() {
    // return "Password must be longer than " + MIN_LENGTH + " characters.";
    // }
}
