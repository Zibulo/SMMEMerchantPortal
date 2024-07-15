@merchantApiLogin

Feature: SMME Login

  Scenario Outline: "<ScenarioDescription>"
    Given I can login to SMME site "<ScenarioType>" "<userName>" "<passWord>" "<appChannel>"
    When I get a valid response "<ExpectedResponseCode>"

    Examples:
      | TC | ScenarioDescription         | ScenarioType | userName        | passWord | appChannel | ExpectedResponseCode |
      | 1  | SMME valid credential login | Positive     | VPS397935709375 | Password001!     | Web        | 200                  |






