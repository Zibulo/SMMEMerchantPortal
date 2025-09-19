@smmeLogoff


Feature: SMME Merchant Portal Logoff

  Scenario Outline: "<ScenarioDescription>"

    Given I can login to SMME site "<ScenarioType>" "<userName>" "<passWord>" "<appChannel>"
    When I get a valid response "<ExpectedResponseCode>"
    Given  I can logoff to SMME site "<ScenarioType>" "<userId>"
    When I get a valid response "<ExpectedResponseCode>"
    Examples:
      | TC | ScenarioDescription | ScenarioType | userName        | passWord         | appChannel | ExpectedResponseCode |
      | 1  | SMME valid logoff   | Positive     | VPS360199273438 | TWF5b2dhQDE0Mw== | Web        | 200                  |
