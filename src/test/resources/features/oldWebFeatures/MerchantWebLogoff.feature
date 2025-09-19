@merchantweblogoff


Feature: SMME Merchant Portal Logoff

  Scenario Outline: "<ScenarioDescription>"

    Given  I am logged on site then I can logoff
    When I get a valid response "<ExpectedResponseCode>"
    Examples:
      | TC | ScenarioDescription | ScenarioType |
      | 1  | SMME valid logoff   | Positive     |
