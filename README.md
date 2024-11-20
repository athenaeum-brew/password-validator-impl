# Password Length Validation

## Overview
This project provides a reference implementation of the `PasswordValidator` interface, as defined [here](https://github.com/athenaeum-brew/password-validator), specifically a validator that checks whether a password is longer than 8 characters.

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
This project depends on the [password-validator](https://github.com/athenaeum-brew/password-validator) library.


```xml
<dependency>
    <groupId>com.cthiebaud</groupId>
    <artifactId>password-validator</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Information required in pom.xml

### scm

```xml
<scm>
    <url>https://github.com/athenaeum-brew/password-validator-impl</url>
    <connection>scm:git:https://github.com/athenaeum-brew/password-validator-impl.git</connection>
    <developerConnection>scm:git:git@github.com:athenaeum-brew/password-validator-impl.git</developerConnection>
    <tag>HEAD</tag>
</scm>
```

### developers

```xml
<developers>
    <developer>
        <id>cthiebaud</id>
        <name>Christophe Thiebaud</name>
        <email>christophe.t60@gmail.com</email>
        <url>https://github.com/cthiebaud</url>
    </developer>
</developers>
```

### distributionManagement

```xml
<distributionManagement>
    <repository>
        <id>github-repo</id>
        <url>https://maven.pkg.github.com/athenaeum-brew/maven-repo</url>
    </repository>
</distributionManagement>
```

### repositories

```xml
<repositories>
    <repository>
        <id>github-repo</id>
        <url>https://maven.pkg.github.com/athenaeum-brew/maven-repo</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```
