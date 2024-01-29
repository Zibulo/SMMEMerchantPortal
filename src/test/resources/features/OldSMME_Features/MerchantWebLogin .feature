@merchantweblogin

Feature: SMME Web Login

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    #And I Populate Credentials "<merchantId>" "<passWord>"
    #And I logoff from Merchant Portal


    Examples:
      | TC | ScenarioDescription         | ScenarioType | reportName          |  | landingPage | reportAuthor    | landingPageSuccess | merchantId      | passWord   |
      | 1  | SMME valid credential login | Positive     | SMME Merchant Login |  | smmeURL     | Itumeleng Phale |                    | VPS983577986487 | 143@Mayoga |






