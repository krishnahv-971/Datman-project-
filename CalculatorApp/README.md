# Appium Calculator Automation

This project automates the Samsung Calculator app on Android devices using Appium and Java.

## Prerequisites

- Java 17 JDK
- Maven 3.6.0 or higher
- Node.js and NPM
- Appium 2.0.0 or higher
- Android SDK
- A real Android device or emulator with USB debugging enabled

## Setup

1. Clone this repository
2. Connect your Android device via USB with USB debugging enabled
3. Make sure Appium server is running
4. Update the device name and other capabilities in `BaseTest.java` if needed

## Running Tests

To run all tests:

```bash
mvn clean test
```

To run a specific test class:

```bash
mvn test -Dtest=CalculatorTest
```

## Project Structure

- `src/test/java/base/BaseTest.java` - Base test class with setup and teardown
- `src/test/java/pages/CalculatorPage.java` - Page object for the calculator
- `src/test/java/tests/CalculatorTest.java` - Test cases
- `pom.xml` - Maven dependencies

## Test Cases

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Decimal operations

## Troubleshooting

- If tests fail, check that:
  - The device is connected and authorized
  - Appium server is running
  - The correct app package and activity are set
  - No other app is using the device

## Notes

- The project uses TestNG for test execution
- Implicit and explicit waits are used for better element handling
- The project follows the Page Object Model (POM) design pattern
