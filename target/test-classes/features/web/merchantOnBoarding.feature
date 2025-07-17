@merchantOnBoarding

Feature: OnBoarding New Merchant Choose POS Option

  Background:
    Given The webBrowser is launched

  Scenario Outline: "<ScenarioDescription>"
    Given I am on the merchant landing page "<ScenarioDescription>""<reportName>""<landingPage>""<reportAuthor>""<landingPageSuccess>"
    And I Choose Available POS Option "<deviceOption>"
    And Submit Merchant details "<ownershipDetails>" "<firstName>" "<surName>" "<eMail>" "<mobileNo>" "<idType>" "<idNo>" "<inputBusinessStreetName>" "<businessStreetName>" "<businessPostalCode>" "<businessSuburb>" "<businessTown>" "<Province>"
    And I Then Complete Device Order
    And I populate Bank Card Details "<onceNameOnCard>" "<onceCardNo>" "<onceExpireYear>" "<onceExpiryDate>" "<onceCvv>"
    And I Populate ThreeD Secure "<threeDPassword>""<cardType>""<bankName>"
    And Start Setup Customer Account Landing Page
    And I take a selfie
    And I  upload documents "<companyTypeOption>""<idDocumentType>"
    #And I Populate ThreeD Secure "<threeDPassword>""<cardType>""<bankName>"
    #And I Provide Company Details "<companyTypeOption>" "<companyRegName>" "<companyDifferentName>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<businessCategory>" "<companyRegNo>" "<companyTradingName>"
    #And I Provide Company and Personal Details "<companyTypeOption>" "<monthlyIncomeKnowledge>" "<businessMonthlIncome>" "<companyRegName>" "<companyDifferentName>" "<companyRegNo>" "<businessCategory>" "<companyTradingName>"
    #And I Provide the Partners Details "<companyTypeOption>""<partnersID>"
    #And I Provide the Banking Details "<companyTypeOption>" "<accountName>" "<accountNumber>"
    And I take a selfie
    And I  upload documents "<companyTypeOption>""<idDocumentType>"


    Examples:
      | TC | ScenarioDescription | ScenarioType | reportName           | landingPage       | reportAuthor      | landingPageSuccess | dealer | userId  | password      | deviceOption  | merchantId      | passWord   | ownershipDetails        | firstName | surName | eMail                                  | mobileNo   | idType        | idNo          | idDocumentType | inputBusinessStreetName | businessStreetName     | businessPostalCode | businessSuburb   | businessTown | Province | deviceReceiptOption | devicePaymentOption | companyTypeOption   | companyRegName      | companyDifferentName | monthlyIncomeKnowledge | businessMonthlIncome | companyTradingName   | companyRegNo | businessCategory       | partnersID    | accountName    | accountNumber | onceNameOnCard | onceCardNo       | onceExpireYear | onceExpiryDate | onceCvv | threeDPassword | cardType | bankName      | AddressYearMonthDayStayed | account_number |
      | 1  | Makro selects Kwika | Positive     | Makro dealer journey | smmeOnboardingURL | Tebello Ntyingila |                    | Makro  | Shubham | Traderoot123! | VodaPay Kwika | VPS983577986487 | 143@Mayoga | Business owner/director | NONDIPHA  | LOUW    | needle-early@olieygik.mailosaur.net | 0833721854 | South African | 6807015897087 | green card     | 4586 Isacholo Crescent  | 4586 Isacholo Crescent | 0187               | Blue Golf Estate | Centurion    | Gauteng  | emailReceipt        | cardPayment         | Sole Proprietorship | VFS Payment Testing | Yes                  | Yes                    | 15000                | VFS Software Testing | 123456789012 | Computer Software Shop | 6508267473086 | VFS Automators | 1234567890    | NONDIPHA LOUW  | 5181030000959467 | 2029           | February       | 813     | test123        | Physical | Nedbank Debit | 2024-03-03                | 1288655444     |
      | 2  | Makro selects Max | Positive     | Makro dealer journey | smmeOnboardingURL | Tebello Ntyingila |                    | Makro  | Shubham | Traderoot123! | VodaPay Kwika | VPS983577986487 | 143@Mayoga | Business owner/director | NONDIPHA  | LOUW    | needle-early@olieygik.mailosaur.net | 0833721854 | South African | 6807015897087 | green card     | 4586 Isacholo Crescent  | 4586 Isacholo Crescent | 0187               | Blue Golf Estate | Centurion    | Gauteng  | emailReceipt        | cardPayment         | Sole Proprietorship | VFS Payment Testing | Yes                  | Yes                    | 15000                | VFS Software Testing | 123456789012 | Computer Software Shop | 6508267473086 | VFS Automators | 1234567890    | NONDIPHA LOUW  | 5181030000959467 | 2029           | February       | 813     | test123        | Physical | Nedbank Debit | 2024-03-03                | 1288655444     |
