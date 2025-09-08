Feature: NopCommerce End-to-End Testing

  Scenario: Launch browser and verify home page
    Given user launches Chrome browser
    When user opens nopCommerce homepage
    Then page title should contain "nopCommerce"

  Scenario: User Registration
    Given user navigates to Register page
    When user enters valid details and registers
    Then user should see "Your registration completed" message
    And credentials should be saved in excel

  Scenario: User Login
    Given user navigates to Login page
    When user enters stored email and password
    Then user should be logged in successfully

  Scenario: Add Product to Cart
    Given user navigates to Computers > Desktops
    When user selects a product and adds to cart
    And user selects product attributes
    Then product should appear in cart

  Scenario: Shopping Cart & Checkout
    Given user is on the cart page
    When user updates quantity
    And applies shipping estimate
    And accepts terms and proceeds to checkout
    Then checkout page should open successfully

  Scenario: Browse Categories
    When user navigates to Digital Downloads
    Then digital downloads page should load
    When user navigates to Books
    Then books page should load