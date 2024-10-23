# Password Validator

## Overview

The Password Validator project provides a framework for validating passwords based on specific criteria. It consists of an interface for password validation and a record for representing the result of the validation. This project is designed to help students implement their own password validation logic and understand the concepts of interfaces and records in Java.

## Components

### PasswordValidator Interface

The `PasswordValidator` interface defines a contract for validating potential passwords based on specific criteria. Implementing classes must provide their own validation logic and describe the criteria used.

```java
package com.cthiebaud.passwordvalidator;

/**
 * The {@code PasswordValidator} interface defines a contract for validating
 * potential passwords based on specific criteria. Implementing classes must
 * provide their own validation logic and a description of the criteria used.
 * 
 * <p>
 * This interface facilitates the creation of various password validation
 * strategies, allowing users to easily integrate and manage multiple validation
 * rules in a consistent manner.
 * </p>
 * 
 * @see ValidationResult
 */
public interface PasswordValidator {
    /**
     * Validates a potential password based on specific criteria.
     * 
     * @param potentialPassword the password to validate
     * @return ValidationResult containing the validation status and an optional
     *         message describing the result of the validation
     */
    ValidationResult validate(String potentialPassword);

    /**
     * Describes the validation criteria of this PasswordValidator.
     * 
     * @return A string description of the validation criteria.
     */
    // String describe();
}
```

### ValidationResult Record

The `ValidationResult` record represents the result of a password validation, containing the validation status and an optional message.

```java
package com.cthiebaud.passwordvalidator;

/**
 * Represents the result of a password validation, containing the validation
 * status and an optional message.
 */
public record ValidationResult(boolean isValid, String message) {
    // No additional methods or fields are needed, as the record automatically
    // provides accessors
}
```

### PasswordValidatorTester Class

The `PasswordValidatorTester` class serves as the main entry point of the application. It dynamically loads and tests password validators implemented by students.

## Student Deliverables

Students are expected to:

1. Implement the `PasswordValidator` interface by creating their own validation class (e.g., `PasswordLengthValidator`) that adheres to specific criteria.
2. Include the implementation in a JAR file.
3. Provide a description of the validation criteria used in their implementation.
4. Ensure the `PasswordValidatorTester` class can successfully load and test their implementation.

## Usage

To use the Password Validator, run the `PasswordValidatorTester` class and provide the necessary inputs as required.

## License

This project is licensed under the MIT License.

---

Feel free to adjust any section or wording as needed!