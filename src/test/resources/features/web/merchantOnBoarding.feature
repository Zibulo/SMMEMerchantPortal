@merchantOnBoarding

Feature: OnBoarding New Merchant Choose POS Option

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I Choose Available POS Option "<deviceOption>"
    And Submit Merchant details "<ownershipDetails>" "<firstName>" "<surName>" "<eMail>" "<mobileNo>" "<idType>" "<idNo>" "<inputBusinessStreetName>" "<businessStreetName>" "<businessPostalCode>" "<businessSuburb>" "<businessTown>" "<Province>"
    And I Then Complete Device Order
    And I populate Bank Card Details "<onceCardHolder>" "<onceCardNumber>" "<onceCardExpiryDate>" "<onceCvv>"
    And I Populate ThreeD Secure "<threeDPassword>""<cardType>""<bankName>"
    #And I Provide Company Details "<companyTypeOption>" "<companyRegName>" "<companyDifferentName>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<businessCategory>" "<companyRegNo>" "<companyTradingName>"
    #And I Provide Company and Personal Details "<companyTypeOption>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<companyRegName>" "<companyDifferentName>" "<companyRegNo>" "<businessCategory>" "<companyTradingName>"
    #And I Provide the Partners Details "<companyTypeOption>""<partnersID>"
    #And I Provide the Banking Details "<companyTypeOption>" "<accountName>" "<accountNumber>"
    #And I take a selfie
    #And I  upload documents "<companyTypeOption>""<idDocumentType>"


    Examples:
      | TC | ScenarioDescription                       | ScenarioType | reportName          |  | landingPage       | reportAuthor    | landingPageSuccess | deviceOption  | merchantId      | passWord   | ownershipDetails        | firstName       | surName   | eMail                              | mobileNo   | idType        | idNo          | idDocumentType | inputBusinessStreetName | businessStreetName     | businessPostalCode | businessSuburb | businessTown | Province | companyTypeOption | monthlyIncomeKnowledge | businessMonthlIncome | companyRegName  | companyDifferentName | companyTradingName        | companyRegNo | businessCategory          | partnersID    | accountName | accountNumber |  | onceCardHolder             | onceCardNumber   | onceCardExpiryDate | onceCvv | threeDPassword |
      | 1  | Merchant onBoard Device Selection Journey | Positive     | SMME Merchant Login |  | smmeOnboardingURL | Itumeleng Phale |                    | VodaPay Kwika | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | out-himself@n9ftmnyu.mailosaur.net | 0829973883 | South African | 9509040030083 | green card     | 4586 Isacholo Crescent  | 4586 Isacholo Crescent | 0157               | Amberville     |              | Gauteng  | Trust             | No                     | 150000               | IBP Testing VFS | Yes                  | Ditekong Software Testing | 123456789012 | Agricultural Cooperatives | 6508267473086 | TM Ngwane   | 1234567890    |  | Itumeleng Testing Tradepay | 5413330089010483 | 0924               | 946     | test123        |
      #| 2  | Merchant onBoard VodaPay Tap on Phone Device | Positive     | SMME Merchant Login |  | smmeURL     | Itumeleng Phale |                    | VodaPay Tap on Phone | VPS983577986487 | 143@Mayoga | Business owner/director | Ecomm Automator | VFS Ecomm | Itumeleng.Phale@vodacom.co.za | 0829973883 | Passport | 0104041074089 | 4586 Isacholo Crescent | 0157               | Amberville     | Centurion    | Gauteng  |
