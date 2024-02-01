@merchantOnBoardingPosSelection

Feature: OnBoarding New Merchant Choose POS Option

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I Choose Avalaible POS Option
    And Submit Merchant details "<ownershipDetails>" "<firstName>" "<surName>" "<eMail>" "<mobileNo>" "<idType>" "<idNo>" "<businessStreetName>" "<businessPostalCode>" "<businessSuburb>" "<businessTown>" "<Province>"
    And I Then Complete Device Order
    #And I Provide Company and Personal Details
    #And I logoff from Merchant Portal


    Examples:
      | TC | ScenarioDescription         | ScenarioType | reportName          |  | landingPage | reportAuthor    | landingPageSuccess | merchantId      | passWord   | ownershipDetails        | firstName       | surName   | eMail                         | mobileNo   | idType   | idNo          | businessStreetName     | businessPostalCode | businessSuburb | businessTown | Province |
      | 1  | SMME valid credential login | Positive     | SMME Merchant Login |  | smmeURL     | Itumeleng Phale |                    | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | Itumeleng.Phale@vodacom.co.za | 0829973883 | Passport | 0104041074089 | 4586 Isacholo Crescent | 0157               |  Amberville              | Centurion    | Gauteng  |
