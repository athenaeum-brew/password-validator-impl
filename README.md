# Password Length Validation

## Overview
This project provides an implementation of the `PasswordValidator` interface, specifically a validator that checks whether a password is longer than 8 characters.

## Implementation

### PasswordLengthValidator
The `PasswordLengthValidator` class implements the `PasswordValidator` interface. It validates passwords based on a minimum length criterion.

```java
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
}
```

## Project Structure
```
password-validator/
├── pom.xml               # Maven configuration file
├── src/
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── cthiebaud
│   │               └── passwordvalidator
│   │                   └── PasswordLengthValidator.java
│   └── test
│       └── java
│           └── com
│               └── cthiebaud
│                   └── passwordvalidator
│                       └── PasswordLengthValidatorTest.java
└── README.md             # Project documentation
```

## Dependencies
This project depends on the password-validator library.


```xml
<dependency>
    <groupId>com.cthiebaud</groupId>
    <artifactId>password-validator</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## License
This project is licensed under the MIT License.

---

Feel free to modify any sections as needed to fit your project specifics!
