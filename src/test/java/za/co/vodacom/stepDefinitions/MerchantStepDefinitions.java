package za.co.vodacom.stepDefinitions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import vfs.automation.core.assertions.Assertions;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.api.apiFeatures.*;
import za.co.vodacom.web.pageObjectModel.CardDetailsPom;
import za.co.vodacom.web.webFeatures.MerchantTransactions;

import static za.co.vodacom.web.webFeatures.MerchantTransactions.*;


public class MerchantStepDefinitions extends SystemUtilities {

    static WebDriver driver;
    Response response;
    String resultSet;

    MerchantTransactions merchantTransactions;
    //String testType = "";

    static ExtentTest extentTest;
    static ExtentReports extentReport;

    @After
    public void afterTest(Scenario scenario) throws Exception {
        try {
            //Screenshot at the end of the test and when there is a failure
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            String fileName = webDriverUtil.takeScreenshot(driver);

            if (scenario.isFailed()) {
                if (resultSet == null) {
                    extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(fileName));
                    extentTest.log(LogStatus.FAIL, resultSet);
                    extentTest.log(LogStatus.FAIL, "Could not retrieve response message, element not found or time out experienced");

                } else {
                    extentTest.log(LogStatus.FAIL, resultSet);
                    extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(fileName));
                    extentTest.log(LogStatus.FAIL, "Could not retrieve response message, element not found or time out experienced");

                }
            } else {
                extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(fileName));
                extentTest.log(LogStatus.INFO, resultSet);
            }
        } catch (Exception e) {
            extentTest.log(LogStatus.INFO, resultSet);
            // Assert.fail(e.getMessage());
        } finally {
            extentReport.endTest(extentTest);
            extentReport.flush();
        }
    }

    @Given("The webBrowser is launched")
    public void theWebBrowserIsLaunched() throws Exception {
        System.setProperty("Browser","Chrome");
        //System.setProperty("java.net.preferIPv4Stack", "true");
        setSystemProperty("Browser", "EDGE"); //Defaults the environment to chrome unless if it is set in the environment variables.
   /*     System.out.println("I am testing browser");
        System.out.println(getSystemProperty("Browser"));*/
        if (driver == null) {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            driver = webDriverUtil.initializeWebDriver(getSystemProperty("Browser"), Integer.parseInt(getSystemProperty("timeout")));
/*            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("permissions.default.camera", 1);*/
        }
    }

    public void initialiseTestReport(String scenarioDescription,String reportName,String reportAuthor, String landingPageSuccess) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        if (extentReport == null) {
            extentReport = new ExtentReports("target/report/extent/"+reportName+".html");
        }
        extentTest = extentReport.startTest(scenarioDescription);
        extentTest.assignAuthor(reportAuthor); //"itumeleng Phale"

        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        extentTest.log(LogStatus.PASS, landingPageSuccess); //"I am on the landing page."

    }
    @Given("I am on the merchant landing page {string}{string}{string}{string}{string}") //
    public void iAmOnMerchantLandingLoginPage(String scenarioDescription,String reportName,String landingPage,String reportAuthor,String landingPageSuccess) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        merchantTransactions = new MerchantTransactions(driver);
        merchantTransactions.selectLandingPage(landingPage);

        initialiseTestReport(scenarioDescription,reportName,reportAuthor,landingPageSuccess);
    }


    @And("I Populate Credentials {string} {string}")
    public void iPopulateCredentials(String merchantId, String password) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
       merchantTransactions.populateCredentials(merchantId,password);
        extentTest.log(LogStatus.PASS, "I populateCredentials.");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));

    }

    @And("I logoff from Merchant Portal")
    public void iAmLoggedOnSiteThenICanLogoff() throws Exception {

        merchantTransactions.Logoff();
    }

    @Then("I can View Merchant Profile {string} {string}")
    public void iCanViewMerchantProfile(String testType, String userId) throws Exception{

        MerchantProfileView merchantProfileView = new MerchantProfileView();

        response = merchantProfileView.iCanViewMerchantProfile(getSystemProperty("userId"));

        resultSet = (response.getBody().asString());
        System.out.println("Printing Resultset:"+resultSet);
        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        //Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        //extentTest.pass(prettyResponse);
        extentTest.log(LogStatus.INFO, response.getBody().prettyPrint());

    }

    @Given("I can request to reset password {string} {string}")
    public void iCanRequestToResetPassword(String testType, String userName) throws Exception {

        MerchantForgotPassword merchantForgotPassword = new MerchantForgotPassword();

        //this.testType = testType;
        //test = extent.createTest(testType);
        response = merchantForgotPassword.iCanRequestPasswordReset(userName);

        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        //Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        //extentTest.log(prettyResponse);
        extentTest.log(LogStatus.INFO, response.getBody().prettyPrint());
    }

    @And("I can change  password {string} {string} {string}")
    public void iCanChangePassword(String testType, String oldPassword, String newPassword) throws Exception {

        MerchantChangePassword merchantChangePassword = new MerchantChangePassword();

        //this.testType = testType;
        //test = extent.createTest(testType);
        response = merchantChangePassword.iCanChangePassword(getSystemProperty("userId"),oldPassword,newPassword);
        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        //Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        //test.pass(prettyResponse);
        extentTest.log(LogStatus.INFO, response.getBody().prettyPrint());

    }

    //@Then("I can View Merchant Dated Transactions {string} {string} {string} {string}")
    //public void iCanViewMerchantDatedTransactions(String testType, String userId,String fromDate,String toDate) throws Exception {

    //  MerchantDatedTransactions merchantDatedTransactions = new MerchantDatedTransactions();

    //  this.testType = testType;
    //  test = extent.createTest(testType);

    //  response = merchantDatedTransactions.iCanViewMerchantDatedTransactions(getSystemProperty("userId"),getSystemProperty("fromDate"),getSystemProperty("toDate"));

    // System.out.println("Response Message\n"+response.getBody().prettyPrint());
    // Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
    // test.pass(prettyResponse);
    // test.log(Status.INFO, response.getBody().prettyPrint());

    // }

    @Then("I can View Merchant Recent Transactions {string} {string}")
    public void iCanViewMerchantRecentTransactions(String testType, String userId) throws Exception {

        MerchantRecentTransactions merchantRecentTransactions = new MerchantRecentTransactions();

        //this.testType = testType;
        //test = extent.createTest(testType);

        response = merchantRecentTransactions.iCanViewRecentDashboard(getSystemProperty("userId"),getSystemProperty("userName"),getSystemProperty("appChannel"));
        //Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        //test.pass(prettyResponse);
        extentTest.log(LogStatus.INFO, response.getBody().prettyPrint());

    }

    @Given("I can logoff to SMME site {string} {string}")
    public void iCanLogoffToSMMESite(String testType,String userId) throws Exception {

        MerchantLogoff merchantLogoff = new MerchantLogoff();

        //this.testType = testType;
        //test = extent.createTest(testType);


        response = merchantLogoff.iCanLogoffToSMMESite(getSystemProperty("userId"));
        //System.out.println("userId\n"  +userId);

        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        //Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        //test.pass(prettyResponse);
        extentTest.log(LogStatus.INFO, response.getBody().prettyPrint());
    }

    @When("I get a valid response {string}")
    public void iGetAValidResponse(String expectedResponseCode) {
        if (response != null) {
            //System.out.println("Response results below\n" );
            System.out.println("Response:\n" + response.getBody().asString());
        }
        assert response != null;
        assertEquals("Response code", expectedResponseCode, String.valueOf(response.getStatusCode()));
    }

    @Given("I can login to SMME site {string} {string} {string} {string}")
    public void iCanLoginToSMMESite(String testType,String userName, String passWord,String appChannel) throws Exception {
        MerchantLogin merchantLogin = new MerchantLogin();

        //this.testType = testType;
        //test = extent.createTest(testType);
        response = merchantLogin.iCanLoginToSMMESite(userName, passWord,appChannel);
        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        //Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        //test.pass(prettyResponse);
        extentTest.log(LogStatus.INFO, response.getBody().prettyPrint());

        //String jasonbody = response.getBody().asString();
        //MerchantDatedTransactions.MerchantgetUserId(jasonbody);

        setSystemProperty("userId",response.getBody().path("userId"));
        System.out.println(response.getBody().path("userId").toString());
    }

    @And("I Choose Available POS Option {string}")
    public void iChooseAvalaiblePOSOption(String deviceOption) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Thread.sleep(3600);
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        merchantTransactions.choosePosOption(deviceOption);
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String filename = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(filename));
    }


    @And("Submit Merchant details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void submitMerchantDetails(String ownershipDetails, String firstName, String surName, String eMail, String mobileNo, String idType, String merchantID,
                                      String inputBusinessStreetName,String businessStreetName, String businessPostalCode,String businessSuburb,String  businessTown,String Province, String journey_name) throws Exception {

        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            merchantTransactions.submitMerchantDetails(ownershipDetails, firstName, surName, eMail, mobileNo, idType, merchantID,inputBusinessStreetName, businessStreetName, businessPostalCode, businessSuburb, businessTown, Province, journey_name);

            extentTest.log(LogStatus.PASS, "Pos Option is Selected");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }

    }

    @And("I Then Complete Device Order")
    public void iThenCompleteDeviceOrder() throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Thread.sleep(3500);
        merchantTransactions.completeDeviceOrder();
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I populate Bank Card Details {string} {string} {string} {string} {string}")
    public void ipopulateOnceOffPayment(String onceCardHolder, String onceCardNumber
            ,String onceExpireYear, String onceExpiryDate, String onceCVV) throws Exception {

        MerchantTransactions merchantTransactions = new MerchantTransactions(driver);
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Thread.sleep(1200);
        extentTest.log(LogStatus.PASS, "I populate bank card details.");
       // webDriverUtil.implicitWait(driver, 30);
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        //webDriverUtil.implicitWait(driver, 10);
        merchantTransactions.populateOnceCardDetails(onceCardHolder, onceCardNumber,onceExpireYear,onceExpiryDate, onceCVV);
        extentTest.log(LogStatus.PASS, "Bank card details successfully populated.");
        //String fileName = webDriverUtil.takeScreenshot(driver);
        //extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I populate VPG Payment Details {string}")
    public void ipopulateVPGOnceOffPayment(String devicePaymentOption) throws Exception {
        if(devicePaymentOption.equalsIgnoreCase("cardPayment") && (KwikaOnly || ficaConfirmation))
        {
            MerchantTransactions merchantTransactions = new MerchantTransactions(driver);
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();

            Thread.sleep(1200);
            extentTest.log(LogStatus.PASS, "I populate bank card details.");
            // webDriverUtil.implicitWait(driver, 30);
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
            //webDriverUtil.implicitWait(driver, 10);
            merchantTransactions.populateVPGOnceCardDetails();
            extentTest.log(LogStatus.PASS, "Bank card details successfully populated.");

        }
        //String fileName = webDriverUtil.takeScreenshot(driver);
        //extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I Populate ThreeD Secure {string}{string}{string}")
    public void iPopulateThreeDSecure(String threeDPassword, String cardType, String bankName) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            if(KwikaOnly || ficaConfirmation)
            {
                WebDriverUtilities webDriverUtil = new WebDriverUtilities();
                MerchantTransactions paymentsTransactions = new MerchantTransactions(driver);

                Thread.sleep(2000);
                String fileName = webDriverUtil.takeScreenshot(driver);
                extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
                paymentsTransactions.populateOnce3DSecure(threeDPassword, cardType, bankName);

                //webDriverUtil.implicitWait(driver, 50);
                String fileName1 = webDriverUtil.takeScreenshot(driver);
                extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName1));
                extentTest.log(LogStatus.PASS, "3D Security Succefully Authenticated");
            }
        }

    }

    @And("I select ECom Response URL and decode Bank Response URL {string}{string}")
    public String electEcommerceResURL(String fieldName, String expected) throws Exception {

        MerchantTransactions merchantTransactions = new MerchantTransactions(driver);
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Thread.sleep(6500);
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));

        resultSet = merchantTransactions.selectResURL();
        System.out.println("Printing decoded Response" + resultSet);

        Assertions assertions = new Assertions();
        assertions.assertContains(fieldName, expected, resultSet);
        extentTest.log(LogStatus.PASS, "Bank response URL successfully decoded\n" + resultSet);

        return resultSet;
    }

    @Then("I must assert card transaction message {string}{string} and report")
    public void iMustAssertCardImmediateAndReport(String fieldName, String expected) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        MerchantTransactions merchantTransactions = new MerchantTransactions(driver);

        //webDriverUtil.implicitWait(driver, 10);
        resultSet = merchantTransactions.mustAssertAndReport();
        System.out.println("This is the returning message from web page: " + resultSet);
        Assertions assertions = new Assertions();
        assertions.assertContains(fieldName, expected, resultSet);
        if (extentReport == null) {
            extentReport = new ExtentReports("target/report/extent/ExtentResults.html");
        }
        extentTest.log(LogStatus.PASS, resultSet);
    }


    @And("I Then Assign Device and Process Order {string} {string} {string}")
    public void iThenAssignDevicesForDelivery(String deviceReceiptOption, String devicePaymentOption, String journey_name) throws Exception {

        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            //webDriverUtil.implicitWait(driver, 40);
            merchantTransactions.assignDevicesAndProcessOrder(deviceReceiptOption,devicePaymentOption,journey_name);
            extentTest.log(LogStatus.PASS, "Devices delivery address assigned");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }

    }
    @And("Start Setup Customer Account Landing Page")
    public void startSetupCustomerAccountLandingPage() throws Exception {

        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            webDriverUtil.implicitWait(driver, 40);
            merchantTransactions.completeCustomerLandingPage();
            extentTest.log(LogStatus.PASS, "Setup Customer Landing page completed");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }
    }

    @And("FICA PROCESS Pages Tell Us About The Customers Business {string} {string} {string} {string} {string}")
    public void tellUsAboutTheCustomersBusiness(String companyTypeOption, String companyRegName, String businessMonthlIncome, String businessCategory, String AddressYearMonthDayStayed) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            webDriverUtil.implicitWait(driver, 40);
            extentTest.log(LogStatus.PASS, "Tell Us About Your Business Start");
            merchantTransactions.customebusinessComplete(companyTypeOption,companyRegName, businessMonthlIncome, businessCategory,AddressYearMonthDayStayed);

            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }
    }

    @And("I populate Once Card Details {string}{string}{string}{string}{string}")
    public void iPopulateOnceCardDetails(String onceNameOnCard, String onceCardNo, String onceExpireYear, String onceExpiryDate, String onceCvv) throws Exception {

        MerchantTransactions merchantTransactions = new MerchantTransactions(driver);
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        //webDriverUtil.implicitWait(driver, 40);
        merchantTransactions.populateOnceCardDetails(onceNameOnCard, onceCardNo, onceExpireYear, onceExpiryDate, onceCvv);
        //webDriverUtil.implicitWait(driver, 30);
        String fileName = webDriverUtil.takeScreenshot(driver);
        //webDriverUtil.implicitWait(driver, 40);
        if (extentReport == null) {
            extentReport = new ExtentReports("target/report/extent/ExtentResults.html");
        }
        //extentTest = extentReport.startTest(scenarioDescription);
        extentTest.log(LogStatus.PASS, "Payment Card details successfully populated and submitted");
    }

    @And("I verify Payment Request Link and complete payment {string}")
    public void iCompletePayment(String devicePaymentOption) throws Exception {

        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            if(devicePaymentOption.equalsIgnoreCase("cardPayment") && (KwikaOnly || ficaConfirmation))
            {
                WebDriverUtilities webDriverUtil = new WebDriverUtilities();
                Thread.sleep(7000);
                merchantTransactions.completePaymentRequest();
                extentTest.log(LogStatus.PASS, "Complete payment request");
                String fileName = webDriverUtil.takeScreenshot(driver);
                extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
            }
        }

    }

    @And("I select immediate payment method {string}{string}{string}{string}{string}{string}")
    public void iSelectPaymentMethod(String onceNameOnCard, String onceCardNo,
                                     String onceExpireYear, String onceExpiryDate, String onceCvv, String devicePaymentOption) throws Exception {

        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            if(devicePaymentOption.equalsIgnoreCase("cardPayment") && (KwikaOnly || ficaConfirmation)) {
                WebDriverUtilities webDriverUtil = new WebDriverUtilities();
                MerchantTransactions merchantTransactions = new MerchantTransactions(driver);

                CardDetailsPom cardDetailsPom = new CardDetailsPom(driver);
                merchantTransactions.selectPayment(onceNameOnCard, onceCardNo,
                        onceExpireYear, onceExpiryDate, onceCvv);
            }
        }
    }

        @And("I Provide Company and Personal Details {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iProvideCompanyAndPersonalDetails(String companyTypeOption,String companyRegName, String monthlyIncomeKnowledge,String businessMonthlIncome
                                                  ,String companyDifferentName,
                                                  String companyRegNo,String businessCategory,String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Thread.sleep(2400);
        merchantTransactions.provideCompanyPersonalDetails(companyTypeOption,companyRegName,monthlyIncomeKnowledge,businessMonthlIncome,
                                                companyDifferentName,companyRegNo, businessCategory,companyTradingName);
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I Provide Company Details {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iProvideCompanyDetails(String companyTypeOption,String companyRegName, String companyDifferentName,
                                       String monthlyIncomeKnowledge, String businessMonthlIncome,String businessCategory,
                                       String companyRegNo, String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Thread.sleep(3500);
        merchantTransactions.provideCompanyDetails(companyTypeOption,companyRegName,companyDifferentName,monthlyIncomeKnowledge,businessMonthlIncome,
                businessCategory,companyRegNo,companyTradingName);
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I Provide the Partners Details {string}{string}")
    public void iProvideThePartnersDetails(String companytype, String  partnersID) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        merchantTransactions.providePartnersDetails(companytype,partnersID);
        extentTest.log(LogStatus.PASS, "Partners Details Entered successfully");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }
    @And("I Provide the Banking Details {string} {string} {string}")
    public void iProvideBankingDetails(String companytype,String accountName, String accountNumber) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        merchantTransactions.provideBankingDetails(companytype,accountName, accountNumber);
        extentTest.log(LogStatus.PASS, "Banking Details Entered successfully");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I take a selfie")
    public void takeSelfie() throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();

            Thread.sleep(2400);
            merchantTransactions.takeASelfie();
            extentTest.log(LogStatus.PASS, "Selfie taken successfully");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }
    }

    @And("I  upload documents {string}{string}")
    public void iUploadDocuments(String companytype,String idType) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            //Thread.sleep(2400);
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            merchantTransactions.uploadDoc(companytype,idType);
            extentTest.log(LogStatus.PASS, "Documents uploaded successfully");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }
    }

    @And("When I select Dealer {string}{string}{string}")
    public void iSelectDealer(String dealer,String userId,String password) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Thread.sleep(4000);

        if (extentReport == null) {
            extentReport = new ExtentReports("target/report/extent/ExtentResults.html");
        }
        //String fileName = webDriverUtil.takeScreenshot(driver);
        //extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        merchantTransactions.chooseDealer(dealer,userId,password);
        extentTest.log(LogStatus.PASS, "Dealer is selected");
        String filename = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(filename));
    }

    @Given("I am on the dealer landing page {string}{string}{string}{string}{string}") //
    public void iAmOnDealerLandingLoginPage(String scenarioDescription,String reportName,String landingPage,String reportAuthor,String landingPageSuccess) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        merchantTransactions = new MerchantTransactions(driver);

        initialiseTestReport(scenarioDescription,reportName,reportAuthor,landingPageSuccess);

        merchantTransactions.selectLandingPage(landingPage);

        //initialiseTestReport(scenarioDescription,reportName,reportAuthor,landingPageSuccess);
    }


    @And("I Access email account")
    public void iAccessEmailAccount() throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.google.com");

        //merchantTransactions.chooseDealer(dealer,userId,password);
    }


    @And("I close ThreeD tab {string}{string}")
    public void iCloseThreeDTab(String devicePaymentOption, String bankName) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            if(devicePaymentOption.equalsIgnoreCase("cardPayment")
                    && bankName.equalsIgnoreCase("Nedbank Debit") && (KwikaOnly || ficaConfirmation))
            {
                WebDriverUtilities webDriverUtil = new WebDriverUtilities();

                Thread.sleep(2400);
                merchantTransactions.closeThreeDtab();
                extentTest.log(LogStatus.PASS, "Close Three Dtab");
                // String fileName = webDriverUtil.takeScreenshot(driver);
                // extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
            }
        }


    }

    @And("I Check Payment Status {string}{string}")
    public void iCheckPaymentStatus(String devicePaymentOption, String bankName) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            if(devicePaymentOption.equalsIgnoreCase("cardPayment")
                    && bankName.equalsIgnoreCase("Nedbank Debit") && (KwikaOnly || ficaConfirmation))
            {
                WebDriverUtilities webDriverUtil = new WebDriverUtilities();

                Thread.sleep(2400);
                merchantTransactions.checkPaymentStatus();
                extentTest.log(LogStatus.PASS, "Close Three Dtab");
                String fileName = webDriverUtil.takeScreenshot(driver);
                extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
            }
        }

    }

    @And("FICA PROCESS Pages Confirm the customers personal details {string} {string} {string}")
    public void ficaPROCESSPagesConfirmTheCustomersPersonalDetails(String ownershipDetails, String firstName, String surName) throws Exception {

        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            if(ficaConfirmation)
            {
                WebDriverUtilities webDriverUtil = new WebDriverUtilities();
                merchantTransactions.confirmCustomerPersonalDetails(ownershipDetails, firstName, surName);

                extentTest.log(LogStatus.PASS, "Confirm Personal Details is Selected");
                String fileName = webDriverUtil.takeScreenshot(driver);
                extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
            }
        }

    }

    @And("FICA PROCESS Pages Confirm the customers banking details {string} {string} {string} {string} {string}")
    public void ficaPROCESSPagesConfirmTheCustomersBankingDetails(String bankName, String idNo, String account_number, String firstName, String surName) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            merchantTransactions.confirmCustomerBankingDetails(bankName, idNo,account_number, firstName, surName);

            extentTest.log(LogStatus.PASS, "Confirm Personal Details is Selected");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        }
    }

    @And("Submit Barcode Information {string}")
    public void submitBarcodeInformation(String barcodeNumber) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        merchantTransactions.submitbarcodeInformation(barcodeNumber);

        extentTest.log(LogStatus.PASS, "Submit Barcode Information");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("Device Assign Name {string}")
    public void deviceAssignName(String firstName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        merchantTransactions.deviceAssignName(firstName);

        extentTest.log(LogStatus.PASS, "Submit Barcode Information");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("Access Device Activation Page")
    public void accessDeviceActivationPage() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        merchantTransactions.acccessDeviceActivationPage();

        extentTest.log(LogStatus.PASS, "Access Device Activation Page");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("Submit Merchant details SF Confirmation {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void submitMerchantDetailsSFConfirmation(String ownershipDetails, String firstName, String surName, String eMail, String mobileNo, String idType, String merchantID,
                                                    String inputBusinessStreetName,String businessStreetName, String businessPostalCode,String businessSuburb,String  businessTown,String Province, String journey_name) throws Exception {
        if(SkipForTapOnPhoneOnly)
        {
            System.out.println("Skipped because of TAP ON PHONE ONLY journey");
        }
        else
        {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            response = merchantTransactions.submitMerchantDetailsSFConfirmation();
            System.out.println("Response for token");
            System.out.println(response.prettyPrint());
/*            extentTest.log(LogStatus.PASS, "Pos Option is Selected");
            String fileName = webDriverUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));*/
        }
    }
}

