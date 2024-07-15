@merchantRecentTransactions

Feature: View Merchant Recent Transactions

  Scenario Outline: "<ScenarioDescription>"
    Given I can login to SMME site "<ScenarioType>" "<userName>" "<passWord>" "<appChannel>"
    When I get a valid response "<ExpectedResponseCode>"
    Then I can View Merchant Recent Transactions "<ScenarioType>" "<userId>"
    And I get a valid response "<ExpectedResponseCode>"
    Then  I can logoff to SMME site "<ScenarioType>" "<userId>"
    When I get a valid response "<ExpectedResponseCode>"



    Examples:
      | TC | ScenarioDescription   | ScenarioType | userName        | passWord         | appChannel | ExpectedResponseCode |
      | 1  | Merchant  | Positive     | VPS328270822652 | Test@123 | Web        | 200                |
