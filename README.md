# SauceDemo E2E Automation Testing Project

## Overview
This project is an end-to-end automation testing framework for the [SauceDemo](https://www.saucedemo.com/v1/) sample e-commerce website. It demonstrates a complete Page Object Model (POM) design pattern implementation using Selenium WebDriver, Java, and TestNG.

## Project Structure
- **Actions**: Core classes for browser and element interactions
    - `BrowserActions`: Manages browser initialization, window control, and cleanup
    - `ElementActions`: Provides reusable methods for interacting with web elements
- **POM (Page Object Model)**: Page-specific classes
    - `LoginPage`: Login page interactions
    - `ProductsPage`: Product listing page interactions
    - `InventoryPage`: Individual product page interactions
    - `CartPage`: Shopping cart page interactions
    - `CheckOutPage`: Checkout information page interactions
    - `OverviewPage`: Order overview page interactions
    - `ThanksPage`: Order confirmation page interactions
- **Wrappers**: Utility classes
    - `ExtentReporterNG`: TestNG listener for Extent Report generation
- **Test Classes**
  - `BaseTest.java`: Common setup and tear-down procedures
  - `LoginPageTest.java`: Login scenarios with different user types
  - `ProductsPageTest.java`: Product interactions tests
  - `InventoryPageTest.java`: Product detail tests
  - `CartPageTest.java`: Shopping cart functionality tests
  - `CheckOutPageTest.java`: Checkout process tests
  - `OverviewPageTest.java`: Order summary validation tests
- **Configuration**
  - `testng.xml`: Test suite configuration with parallel execution settings
  - `pom.xml`: Maven dependencies and project configuration

## Features
- **Parallel Test Execution**: Supports running tests in parallel across different browsers and test scenarios
- **Multi-browser Support**: Configurable to run tests on Chrome, Firefox, and Edge
- **Page Object Model**: Structured approach with separate classes for page interactions and test logic
- **Thread-safe Design**: Uses ThreadLocal variables to safely handle parallel execution
- **Detailed Reporting**: Integration with ExtentReports for comprehensive test execution reports with screenshots
- **Multiple User Flows**: Tests different user types (standard, locked out, problem, and performance glitch)
- **Comprehensive E-commerce Flow**: Tests complete shopping experience from login to checkout


## Test Scenarios

The framework tests four user flows:

1. **Standard User Flow**
- Complete E2E flow from login to purchase confirmation

2. **Locked Out User Flow**
- Validates locked out user access restrictions

3. **Problem User Flow**
- Tests handling of known issues with the problem user account

4. **Performance User Flow**
- Tests application behavior with performance glitches

## Main Workflow Tested
1. Login with credentials
2. Add products to cart
3. Verify cart badge count updates
4. Navigate to product details
5. Add/remove products from cart
6. Proceed to checkout
7. Fill in personal information
8. Verify input field validations
9. Verify price calculation
10. Complete purchase
11. Verify order confirmation

## Reports
After test execution, detailed HTML reports will be generated in the `reports` folder. These reports include:
- Test case pass/fail status
- Screenshots of failed tests
- Execution time details
- Error logs for failed tests

The main report file is located at:
```
/reports/Summary.html
```


