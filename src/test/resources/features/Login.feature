@all
Feature: Login

  Scenario Outline: user cannot login to WAES HEROES with wrong credentials
    When user navigates to "LANDING_PAGE"
    And user logins with credentials "<user>", "<password>"
    Then error message is displayed
    And "LOGIN_PAGE" is displayed
    Examples:
      | user   | password |
      | admin  | notHero  |
      | hacker | hero     |

  Scenario Outline: user cannot access WAES HEROES pages without authorization
    When user navigates to "<page>"
    Then "File not found" message is displayed
    Examples:
      | page         |
      | PROFILE_PAGE |

  Scenario Outline: user can login to WAES HEROES
    When user navigates to "LANDING_PAGE"
    And user logins with credentials "<user>", "<password>"
    Then "PROFILE_PAGE" is displayed
    And user logs out
    Examples:
      | user  | password |
      | admin | hero     |

  Scenario Outline: user can log out from WAES HEROES
    When user navigates to "LANDING_PAGE"
    And user logins with credentials "<user>", "<password>"
    Then "PROFILE_PAGE" is displayed
    And user logs out
    Examples:
      | user  | password |
      | admin | hero     |