@merchantPasswordChange

Feature: Merchant Password Change

  Scenario Outline: "<ScenarioDescription>"
    Given I can login to SMME site "<ScenarioType>" "<userName>" "<passWord>" "<appChannel>"
    When I get a valid response "<ExpectedResponseCode>"
    And I can change  password "<ScenarioType>" "<oldPassWord>" "<newPassword>"
    Then I get a valid response "<ExpectedResponseCode>"
    Examples:
      | TC | ScenarioDescription         | ScenarioType | userName        | passWord | appChannel | oldPassWord | newPassword  | ExpectedResponseCode |
      | 1  | Successful Merchant Password Change  | Positive     | VPS475074793423 | NzYxNg== | Web        | NzYxNg==    | TWFya29zQDAx | 200                  |
