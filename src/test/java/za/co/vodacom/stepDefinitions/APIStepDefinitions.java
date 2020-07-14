package za.co.vodacom.stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.api.apiFeatures.*;
import za.co.vodacom.web.webFeatures.MerchantWebLogin;
import za.co.vodacom.web.webFeatures.MerchantWebLogoff;


public class APIStepDefinitions extends SystemUtilities {
    Response response;

    String testType = "";

    static ExtentTest extentTest;
    static ExtentReports extentReport;

    ExtentReports extent = new ExtentReports();

    ExtentTest test;

    WebDriver driver;


    @Given("I can login to SMME site {string} {string} {string} {string}")
    public void iCanLoginToSMMESite(String testType,String userName, String passWord,String appChannel) throws Exception {
        MerchantLogin merchantLogin = new MerchantLogin();

        this.testType = testType;
        test = extent.createTest(testType);
        response = merchantLogin.iCanLoginToSMMESite(userName, passWord,appChannel);
        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());

        //String jasonbody = response.getBody().asString();
        //MerchantDatedTransactions.MerchantgetUserId(jasonbody);

        setSystemProperty("userId",response.getBody().path("userId"));
        System.out.println(response.getBody().path("userId").toString());

    }

    @When("I get a valid response {string}")
    public void iGetAValidResponse(String expectedResponseCode) {
        if (response != null) {
            //System.out.println("Response results below\n" );
          System.out.println("Response:\n" + response.getBody().asString());
        }
        //assert response != null;
        assertEquals("Response code", expectedResponseCode, String.valueOf(response.getStatusCode()));
    }

    @Given("I can logoff to SMME site {string} {string}")
    public void iCanLogoffToSMMESite(String testType,String userId) throws Exception {

        MerchantLogoff merchantLogoff = new MerchantLogoff();

        this.testType = testType;
        test = extent.createTest(testType);


        response = merchantLogoff.iCanLogoffToSMMESite(getSystemProperty("userId"));
        //System.out.println("userId\n"  +userId);

        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());
    }

    @Then("I can View Merchant Profile {string} {string}")
    public void iCanViewMerchantProfile(String testType, String userId) throws Exception{

        MerchantProfileView merchantProfileView = new MerchantProfileView();

        this.testType = testType;
        test = extent.createTest(testType);

        response = merchantProfileView.iCanViewMerchantProfile(getSystemProperty("userId"));

        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());

    }

    @Then("I can View Merchant Recent Transactions {string} {string}")
    public void iCanViewMerchantRecentTransactions(String testType, String userId) throws Exception {

        MerchantRecentTransactions merchantRecentTransactions = new MerchantRecentTransactions();

        this.testType = testType;
        test = extent.createTest(testType);

        response = merchantRecentTransactions.iCanViewRecentDashboard(getSystemProperty("userId"),getSystemProperty("userName"),getSystemProperty("appChannel"));
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());

    }

    @Then("I can View Merchant Dated Transactions {string} {string} {string} {string}")
    public void iCanViewMerchantDatedTransactions(String testType, String userId,String fromDate,String toDate) throws Exception {

        MerchantDatedTransactions merchantDatedTransactions = new MerchantDatedTransactions();

        this.testType = testType;
        test = extent.createTest(testType);

        response = merchantDatedTransactions.iCanViewMerchantDatedTransactions(getSystemProperty("userId"),getSystemProperty("fromDate"),getSystemProperty("toDate"));

        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());

    }

    @And("I can change  password {string} {string} {string}")
    public void iCanChangePassword(String testType, String oldPassword, String newPassword) throws Exception {
        MerchantChangePassword merchantChangePassword = new MerchantChangePassword();

        this.testType = testType;
        test = extent.createTest(testType);
        response = merchantChangePassword.iCanChangePassword(getSystemProperty("userId"),oldPassword,newPassword);
        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());

    }

    @Given("I can request to reset password {string} {string}")
    public void iCanRequestToResetPassword(String testType, String userName) throws Exception {
        MerchantForgotPassword merchantForgotPassword = new MerchantForgotPassword();

        this.testType = testType;
        test = extent.createTest(testType);
        response = merchantForgotPassword.iCanRequestPasswordReset(userName);

        // System.out.println("Response Message\n"+response.getBody().prettyPrint());
        Markup prettyResponse = MarkupHelper.createCodeBlock(response.getBody().asString(), CodeLanguage.JSON);
        test.pass(prettyResponse);
        test.log(Status.INFO, response.getBody().prettyPrint());
    }

    @Given("The webBrowser is launched")
    public void theWebBrowserIsLaunched() throws  Exception {
        //System.setProperty("webdriver.chrome.driver", "C://Users//phaleitu//IdeaProjects//VFS_TradeRoot//src//test//resources//drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C://Users//phaleitu//IdeaProjects//SMME Merchant Portal//src//test//resources//drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://merchantportal.s3-website-eu-west-1.amazonaws.com/");
        this.driver = driver;
        //setSystemProperty("Browser", "CHROME"); //Defaults the environment to chrome unless if it is set in the environment variables.

        //if(driver==null){
          //  WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        //    driver = webDriverUtil.initializeWebDriver(System.getProperty("Browser"));
         //   driver.manage().window().maximize();

        //WebDriverUtilities webDriverUtil = new WebDriverUtilities();


           // extentReport = new ExtentReports("target/report/extent/ExtentReportResults.html");
           //extentReport = new ExtentReports(filepath:"target/report/extentReportResults.html");
           //extentTest = extentReport.startTest(this.getClass().getSimpleName());
        //System.setProperty("webdriver.chrome.driver","C://Users//phaleitu//IdeaProjects//SMME Merchant Portal//src//test//resources//drivers/chromedriver.exe");

        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.get("http://merchantportal.s3-website-eu-west-1.amazonaws.com");
        //this.driver = driver;
    }

   // }

    //@Given("I am on merchant landing login page {string} {string}")
    //public void iAmOnMerchantLoginPage() throws Exception {
     //   WebDriver driver = new ChromeDriver();
     //   driver.manage().window().maximize();
     //   driver.get("http://merchantportal.s3-website-eu-west-1.amazonaws.com/");
      //  this.driver = driver;

   // }

    @And("I Populate Credentials {string} {string}")
    public void iPopulateCredentials(String merchantId, String password) throws Exception {
        MerchantWebLogin merchantWebLogin = new MerchantWebLogin(driver);
        merchantWebLogin.populateCredentials(merchantId,password);
    }

    @Given("I am logged on site then I can logoff")
    public void iAmLoggedOnSiteThenICanLogoff() throws Exception {
        MerchantWebLogoff merchantWebLogoff = new MerchantWebLogoff(driver);
        merchantWebLogoff.Logoff();
    }
}

