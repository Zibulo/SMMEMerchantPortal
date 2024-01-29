@completeReferenceMerchantOnBoarding

Feature: OnBoarding New Merchant Choose POS Option

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I Choose Avalaible POS Option "<deviceOption>"
    And Submit Merchant details "<ownershipDetails>" "<firstName>" "<surName>" "<eMail>" "<mobileNo>" "<idType>" "<idNo>" "<businessStreetName>" "<businessPostalCode>" "<businessSuburb>" "<businessTown>" "<Province>"
    And I Then Complete Device Order
    And I Provide Company and Personal Details "<companyTypeOption>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<companyRegName>" "<companyDifferentName>" "<companyRegNo>" "<businessCategory>" "<companyTradingName>"
    #And I tell about partners
    #And I logoff from Merchant Portal


    Examples:
      | TC | ScenarioDescription               | ScenarioType | reportName          |  | landingPage | reportAuthor    | landingPageSuccess | deviceOption | merchantId      | passWord   | ownershipDetails        | firstName       | surName   | eMail                         | mobileNo   | idType        | idNo          | businessStreetName     | businessPostalCode | businessSuburb | businessTown | Province | companyTypeOption | monthlyIncomeKnowledge | businessMonthlIncome | companyRegName  | companyDifferentName | companyTradingName        | companyRegNo | businessCategory          |
      | 1  | Merchant onBoard Chop-Chop Device | Positive     | SMME Merchant Login |  | smmeURL     | Itumeleng Phale |                    | Chop-Chop    | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | Itumeleng.Phale@vodacom.co.za | 0829973883 | South African | 0104041074089 | 4586 Isacholo Crescent | 0157               | Amberville     | Centurion    | Gauteng  | Company           | No                     | 150000               | IBP Testing VFS | Yes                  | Ditekong Software Testing | 123456789012 | Agricultural Cooperatives |
      #| 2  | Merchant onBoard VodaPay Tap on Phone Device | Positive     | SMME Merchant Login |  | smmeURL     | Itumeleng Phale |                    | VodaPay Tap on Phone | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | Itumeleng.Phale@vodacom.co.za | 0829973883 | Passport | 0104041074089 | 4586 Isacholo Crescent | 0157               | Amberville     | Centurion    | Gauteng  |
