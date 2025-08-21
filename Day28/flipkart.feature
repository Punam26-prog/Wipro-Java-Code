
 @flipkart  

Feature: Flipkart Search Functionality
 @positive
 Scenario: Successful Product Search
   Given I launch Flipkart website
   When  I search for product "Laptop"
   Then  I should see the search results


 @negative
 Scenario: Invalid Product Search
   Given I launch Flipkart website
   When  I search for product "asdfghjklzxcvbnm"
   Then  I should see no results message