@all
Feature: Profile

  Scenario Outline: user can access his profile
    When user navigates to "LANDING_PAGE"
    And user logins with credentials "<user>", "<password>"
    Then "PROFILE_PAGE" is displayed
    And user logs out
    Examples:
      | user  | password |
      | admin | hero     |

  Scenario Outline: admin user can access his profile
    When user navigates to "LANDING_PAGE"
    When user logins with credentials "<user>", "<password>"
    Then "PROFILE_PAGE" is displayed
    Then admin superpower is displayed
    Then the users table is displayed
    And user logs out
    Examples:
      | user  | password |
      | admin | hero     |


  Scenario Outline: dev user has waterfall superpower
    When user navigates to "LANDING_PAGE"
    When user logins with credentials "<user>", "<password>"
    Then "PROFILE_PAGE" is displayed
    Then dev superpower is displayed
    And user logs out
    Examples:
      | user | password |
      | dev  | wizard   |

  Scenario Outline: tester user has waterfall superpower
    When user navigates to "LANDING_PAGE"
    When user logins with credentials "<user>", "<password>"
    Then "PROFILE_PAGE" is displayed
    Then tester superpower is displayed
    And user logs out
    Examples:
      | user   | password |
      | tester | maniac   |

