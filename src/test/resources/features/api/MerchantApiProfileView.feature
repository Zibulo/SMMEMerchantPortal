@merchantProfileView

Feature: View Merchant Profile

  Scenario Outline: "<ScenarioDescription>"
    Given I can login to SMME site "<ScenarioType>" "<userName>" "<passWord>" "<appChannel>"
    When I get a valid response "<ExpectedResponseCode>"
    Then I can View Merchant Profile "<ScenarioType>" "<userId>"
    And I get a valid response "<ExpectedResponseCode>"
    Then  I can logoff to SMME site "<ScenarioType>" "<userId>"
    When I get a valid response "<ExpectedResponseCode>"




    Examples:
      | TC | ScenarioDescription   | ScenarioType | userName        | passWord         | appChannel | ExpectedResponseCode |
      | 1  | Merchant Profile View | Positive     | VPS475074793423 | TWFya29zQDAx | Web        | 200                  |
