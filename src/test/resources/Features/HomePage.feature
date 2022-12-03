Feature: Checkout product item

  Scenario: User checkout product item at amazon website
    Given User opened chrome browser
    When User opened amazon website
    And User wants to search product item
    And User wants to checkout product item
    Then User registered to amazon website
