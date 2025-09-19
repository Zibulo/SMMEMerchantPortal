@posRevamp

Feature: OnBoarding New Merchant Choose POS Option

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I Choose Avalaible POS Option "<deviceOption>"
    And Submit Merchant details "<ownershipDetails>" "<firstName>" "<surName>" "<eMail>" "<mobileNo>" "<idType>" "<idNo>" "<businessStreetName>" "<businessPostalCode>" "<businessSuburb>" "<businessTown>" "<Province>"
    And I Then Complete Device Order
    And I Provide Company and Personal Details "<companyTypeOption>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<companyRegName>" "<companyDifferentName>" "<companyRegNo>" "<businessCategory>" "<companyTradingName>"
    And I Provide the Partners Details "<companyTypeOption>""<partnersID>"
    And I Provide the Banking Details "<companyTypeOption>" "<accountName>" "<accountNumber>"
    And I take a selfie
    And I  upload documents "<companyTypeOption>""<idDocumentType>"
      #And I tell about partners
    #And I logoff from Merchant Portal


    Examples:
      | TC | ScenarioDescription               | ScenarioType | reportName          |  | landingPage | reportAuthor       | landingPageSuccess | deviceOption | merchantId      | passWord   | ownershipDetails        | firstName       | surName   | eMail                                | mobileNo   | idType        | idNo          | idDocumentType | businessStreetName     | businessPostalCode | businessSuburb | businessTown | Province | companyTypeOption | monthlyIncomeKnowledge | businessMonthlIncome | companyRegName  | companyDifferentName | companyTradingName        | companyRegNo | businessCategory          | partnersID    | accountName | accountNumber |
      | 1  | Merchant onBoard Chop-Chop Device | Positive     | SMME Merchant Login |  | smmeOnboardingURL    | Livhuwani Mutshafa |                    | VodaPay Kwika    | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | livhuwani.mutshafa@vcontractor.co.za | 0829973883 | South African | 9509040030083 | green card     | 4586 Isacholo Crescent | 0157               | Amberville     | Centurion    | Gauteng  | Trust       | No                     | 150000               | IBP Testing VFS | Yes                  | Ditekong Software Testing | 123456789012 | Agricultural Cooperatives | 6508267473086 | TM Ngwane   | 1234567890    |
      #| 2  | Merchant onBoard VodaPay Tap on Phone Device | Positive     | SMME Merchant Login |  | smmeURL     | Itumeleng Phale |                    | VodaPay Tap on Phone | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | Itumeleng.Phale@vodacom.co.za | 0829973883 | Passport | 0104041074089 | 4586 Isacholo Crescent | 0157               | Amberville     | Centurion    | Gauteng  |
