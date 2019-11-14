@all
Feature: Loan details

  Scenario Outline: user can activate valid promocode
    When user opens loan page
    When user activates "<discount>" promocode
    Then total repayable sum is decreased by "<discount>"
    Examples:
      | discount |
      | 5OFF     |