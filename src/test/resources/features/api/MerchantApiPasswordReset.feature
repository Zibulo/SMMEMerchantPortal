@merchantPasswordReset

Feature: Merchant Password Request

  Scenario Outline: "<ScenarioDescription>"
    Given I can request to reset password "<ScenarioType>" "<userName>"
    When I get a valid response "<ExpectedResponseCode>"

    Examples:
      | TC | ScenarioDescription                | ScenarioType | userName        | ExpectedResponseCode |
      | 1  | Merchant Request to reset password | Positive     | VPS475074793423 | 200                  |
