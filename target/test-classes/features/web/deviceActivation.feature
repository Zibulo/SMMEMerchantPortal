@deviceActivation

Feature: OnBoarding New Merchant Choose POS Option

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And Submit Merchant details "<ownershipDetails>" "<firstName>" "<surName>" "<eMail>" "<mobileNo>" "<idType>" "<idNo>" "<inputBusinessStreetName>" "<businessStreetName>" "<businessPostalCode>" "<businessSuburb>" "<businessTown>" "<Province>"
#    And I Then Complete Device Order
#    And I Provide Company and Personal Details "<companyTypeOption>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<companyRegName>" "<companyDifferentName>" "<companyRegNo>" "<businessCategory>" "<companyTradingName>"
#    And I Provide the Partners Details "<companyTypeOption>""<partnersID>"
#    And I Provide the Banking Details "<companyTypeOption>" "<accountName>" "<accountNumber>"
#    And I take a selfie
#    And I  upload documents "<companyTypeOption>""<idDocumentType>"



    Examples:
      | TC | ScenarioDescription       | ScenarioType | reportName          |  | landingPage         | reportAuthor    | landingPageSuccess | deviceOption  | merchantId      | passWord   | ownershipDetails        | firstName              | surName        | eMail                            | mobileNo   | idType        | idNo          | idDocumentType | inputBusinessStreetName | businessStreetName     | businessPostalCode | businessSuburb | businessTown | Province | companyTypeOption | monthlyIncomeKnowledge | businessMonthlIncome | companyRegName  | companyDifferentName | companyTradingName        | companyRegNo | businessCategory          | partnersID    | accountName | accountNumber |
      | 1  | Device Activation Journey | Positive     | SMME Merchant Login |  | deviceActivationUrl | Akshay Deshmukh |                    | VodaPay Kwika | VPS983577986487 | 143@Mayoga | Business owner/director | Device Activation Test | SMME Automator | akshay.desmukh@vcontractor.co.za | 0829973883 | South African | 9509040030083 | green card     | 4586 Isacholo Crescent  | 4586 Isacholo Crescent | 0157               | Amberville     | Centurion    | Gauteng  | Trust             | No                     | 150000               | IBP Testing VFS | Yes                  | Ditekong Software Testing | 123456789012 | Agricultural Cooperatives | 6508267473086 | TM Ngwane   | 1234567890    |