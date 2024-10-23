package com.cthiebaud.passwordvalidator;

/**
 * Represents the result of a password validation, containing the validation
 * status and an optional message.
 */
public record ValidationResult(boolean isValid, String message) {
    // No additional methods or fields are needed, as the record automatically
    // provides accessors
}
