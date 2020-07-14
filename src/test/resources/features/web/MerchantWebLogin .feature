@merchantweblogin

Feature: SMME Web Login

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    # Given I am on merchant landing login page "<ScenarioDescription>" "<merchantlandingpage>"
    And I Populate Credentials "<merchantId>" "<passWord>"


    Examples:
      | TC | ScenarioDescription         | ScenarioType | merchantlandingpage | merchantId      | passWord  |
      | 1  | SMME valid credential login | Positive     | smmeUIURL           | VPS475074793423 | Mayoga@01 |






