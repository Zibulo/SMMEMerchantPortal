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
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.api.apiFeatures.*;
import za.co.vodacom.web.webFeatures.MerchantTransactions;


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

        setSystemProperty("Browser", "CHROME"); //Defaults the environment to chrome unless if it is set in the environment variables.
        if (driver == null) {
            WebDriverUtilities webDriverUtil = new WebDriverUtilities();
            driver = webDriverUtil.initializeWebDriver(getSystemProperty("Browser"), Integer.parseInt(getSystemProperty("timeout")));
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

    @And("I Choose Avalaible POS Option {string}")
    public void iChooseAvalaiblePOSOption(String deviceOption) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Thread.sleep(2400);
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
        merchantTransactions.choosePosOption(deviceOption);
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String filename = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(filename));


    }

    @And("Submit Merchant details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void submitMerchantDetails(String ownershipDetails, String firstName, String surName, String eMail, String mobileNo, String idType, String merchantID,
                                      String businessStreetName, String businessPostalCode,String businessSuburb,String  businessTown,String Province) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        merchantTransactions.submitMerchantDetails(ownershipDetails, firstName, surName, eMail, mobileNo, idType, merchantID, businessStreetName, businessPostalCode, businessSuburb, businessTown, Province);

        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));

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

    @And("I Provide Company and Personal Details {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iProvideCompanyAndPersonalDetails(String companyTypeOption, String monthlyIncomeKnowledge,String businessMonthlIncome,
                                                  String companyRegName,String companyDifferentName,
                                                  String companyRegNo,String businessCategory,String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Thread.sleep(3500);
        merchantTransactions.provideCompanyPersonalDetails(companyTypeOption,monthlyIncomeKnowledge,businessMonthlIncome,
                                                companyRegName,companyDifferentName,companyRegNo, businessCategory,companyTradingName);
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }

    @And("I tell about partners")
    public void iTellAboutPartners() throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Thread.sleep(3500);
        merchantTransactions.tellAboutPartners();
        extentTest.log(LogStatus.PASS, "Pos Option is Selected");
        String fileName = webDriverUtil.takeScreenshot(driver);
        extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(fileName));
    }
}

