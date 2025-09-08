Feature: nopCommerce Actions

  Scenario: User Registration
    Given I am on the registration page
    When I register with valid details
    Then I should see registration success

  Scenario: Add Product to Cart
    Given I am on the Desktops category page
    When I add a desktop product to the cart
    Then The product should be added to the cart

  Scenario: Select Dropdown on Product Page
    Given I am on a product details page
    When I select 8GB RAM option from dropdown
    Then The dropdown selection should be applied

  Scenario: Select Radio Button on Product Page
    Given I am on a product details page
    When I select HDD option
    And I add the product to the cart
    Then The product should be added with HDD option

  Scenario: Open Cart Page
    Given I am on the home page
    When I open the shopping cart
    Then The shopping cart should be displayed