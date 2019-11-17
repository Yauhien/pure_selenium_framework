@all
Feature: Registration

  Scenario: user can register to WAES HEROES
    When user navigates to "LANDING_PAGE"
    When user clicks to sigh up
    When new user sigh ups to the application
    Then "NEW_USER_PAGE" is displayed
    Then welcome message is displayed
    And user logs out

  Scenario Outline: user cannot finish registration with empty required fields
    When user navigates to "LANDING_PAGE"
    And user clicks to sigh up
    And new user sigh ups with empty "<field>"
    Then "REGISTRATION_PAGE" is displayed
    Examples:
      | field    |
      | username |
      | password |
      | email    |
      | name     |
      | day      |
      | month    |
      | year     |

  Scenario: user cannot register with invalid format email
    When user navigates to "LANDING_PAGE"
    And user clicks to sigh up
    And new user sigh ups with invalid email
    Then "REGISTRATION_PAGE" is displayed

  Scenario: new user can access his profile page
    When user navigates to "LANDING_PAGE"
    And user clicks to sigh up
    And new user sigh ups to the application
    Then "NEW_USER_PAGE" is displayed
    When user opens profile
    Then new user's profile has no superpowers
    And user logs out

  Scenario: new user can access his details page
    When user navigates to "LANDING_PAGE"
    When user clicks to sigh up
    When new user sigh ups to the application
    Then "NEW_USER_PAGE" is displayed
    When user opens details
    Then user info is displayed in the details
    And user logs out
