package za.co.vodacom.web.webFeatures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.fileUploadHandler.fileupload;
import za.co.vodacom.web.pageObjectModel.Login;
import za.co.vodacom.web.pageObjectModel.Logoff;

import java.util.Arrays;

public class MerchantTransactions extends SystemUtilities {

     public WebDriver driver;

    public  MerchantTransactions(WebDriver driver) { this.driver = driver; }

    public void selectLandingPage(String landingPage) throws Exception {
        driver.get(getPropertyValue("Environment", landingPage));//.replace("env", getSystemProperty("env")));
        driver.manage().window().maximize();
    }

    public void populateCredentials(String merchantId,String password) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.enterText(login.merchantId, merchantId);
        webDriverUtil.implicitWait(driver, 05);
        webDriverUtil.enterText(login.password, password);
        webDriverUtil.clickElement(login.loginSubmit);
        webDriverUtil.implicitWait(driver, 05);

    }

    public void choosePosOption(String deviceOption) throws Exception {
       WebDriverUtilities webDriverUtil = new WebDriverUtilities();
       Login login = new Login(driver);

       if (deviceOption.equalsIgnoreCase("Chop-Chop")) {

           ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.addPosOptionChopChop);

        } else if (deviceOption.equalsIgnoreCase("VodaPay Kwika")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.addPosOptionKwika);

        } else if (deviceOption.equalsIgnoreCase("VodaPay Max")) {
        webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.addPosOptionMax);
    }
        else if (deviceOption.equalsIgnoreCase("VodaPay Payment Gateway")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.addPosOptionPaymentGateway);
        }

        else if (deviceOption.equalsIgnoreCase("VodaPay Tap on Phone")) {
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            Thread.sleep(600);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            Thread.sleep(600);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.addPosOptionTapOnPhone);

        } else if (deviceOption.equalsIgnoreCase("VodaPay Payment Request")) {

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            Thread.sleep(600);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            Thread.sleep(600);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            Thread.sleep(600);
            webDriverUtil.clickElement(login.addPosOptionScrollBar);
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.addPosOptionPayRequest);
        }
        else if (deviceOption.equalsIgnoreCase("VodaPay Max2")) {

           webDriverUtil.implicitWait(driver, 20);
           webDriverUtil.clickElement(login.addPosOptionScrollBar);
           Thread.sleep(600);
           webDriverUtil.clickElement(login.addPosOptionScrollBar);
           Thread.sleep(600);
           webDriverUtil.clickElement(login.addPosOptionScrollBar);
           Thread.sleep(600);
           webDriverUtil.clickElement(login.addPosOptionScrollBar);
           Thread.sleep(600);;
           webDriverUtil.clickElement(login.addPosOptionScrollBar);
           webDriverUtil.implicitWait(driver, 20);
           webDriverUtil.clickElement(login.addPosoptionMax2);
        }

       webDriverUtil.implicitWait(driver, 30);
       webDriverUtil.clickElement(login.checkoutProceedBtn);
    }
    public void completeDeviceOrder() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.completeOrderBtn);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.completeSubmitBtn);
     }
    public void provideCompanyPersonalDetails(String companyType, String monthlyIncomeKnowledge, String businessMonthlIncome,
                                              String companyRegName, String companyDifferentName, String companyRegNo,
                                              String businessCategory, String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        Actions act = new Actions(driver);

        Thread.sleep(4000);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.acctSetUpGetStartedBtn);
        webDriverUtil.implicitWait(driver, 20);
        if(companyType.equalsIgnoreCase("Sole Proprietorship")) {

            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.soleProTypeOption);
        } else if (companyType.equalsIgnoreCase("Partnership")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.partnershipTypeOption);

        }
        else if (companyType.equalsIgnoreCase("Trust")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.trustTypeOption);

        }
        else if (companyType.equalsIgnoreCase("company")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.companyTypeOption);

        }
        else if (companyType.equalsIgnoreCase("Close Corporation")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.closeTypeOption);

        }
        else {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.npoTypeOption);
        }

        //webDriverUtil.enterText(login.companyType, companyType);
//        webDriverUtil.implicitWait(driver, 20);
//        webDriverUtil.clickElement(login.companyTypeOption);

        if (monthlyIncomeKnowledge.equalsIgnoreCase("Yes")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.enterText(login.businessMonthlIncome, businessMonthlIncome);
            //webDriverUtil.implicitWait(driver, 20);
            //webDriverUtil.enterText(login.companyRegNo, companyRegNo);
            //webDriverUtil.implicitWait(driver, 30);
            //webDriverUtil.enterText(login.businessCategory,businessCategory);
        } else if (monthlyIncomeKnowledge.equalsIgnoreCase("No")) {
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.incomeKnowledgeCheckBox);
        }
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.companyRegName, companyRegName);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(800);
        if (companyDifferentName.equalsIgnoreCase("Yes")) {
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.companydiffrentNameCheckBtn);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyTradingName, companyTradingName);
        } else {
            System.out.println("This company is unknown, does not belong to me.");

        }
        if(companyType.equalsIgnoreCase("Sole Proprietorship")) {
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.businessCategory, businessCategory);
            Thread.sleep(2400);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            Thread.sleep(1000);
            webDriverUtil.waitUntilVisible(driver, login.businessCategorySearchResults, 30);
            webDriverUtil.clickElement(login.businessCategorySearchResults);

        }
        else {
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyRegNo, companyRegNo);
            //webDriverUtil.implicitWait(driver, 30);
            //webDriverUtil.enterText(login.businessCategory,businessCategory);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.businessCategory, businessCategory);
            Thread.sleep(2400);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            Thread.sleep(1000);
            webDriverUtil.waitUntilVisible(driver, login.businessCategorySearchResults, 30);
            webDriverUtil.clickElement(login.businessCategorySearchResults);
        }
        webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        webDriverUtil.clickElement(login.nextBtn);
        Thread.sleep(1000);
        // webDriverUtil.waitUntilElementClickable(driver,login.confirmBtn,30);
        //webDriverUtil.clickElement(login.confirmBtn);
        //WebElement inputElement = driver.findElement(By.xpath("//input[@name='businessCategory.name' and @class='search-box false'] and Text('Agricultural Cooperatives')"));

        //String hiddenValue = inputElement.getAttribute("Agricultural Cooperatives");
        //System.out.println("Hidden Value: " + hiddenValue);

        //act.sendKeys(Keys.TAB).build().perform();
        //act.sendKeys(Keys.TAB).build().perform();
        //Thread.sleep(2400);
        //act.sendKeys(Keys.ENTER).build().perform();
        //webDriverUtil.implicitWait(driver, 30);
        //webDriverUtil.clickElement(login.detailsNextBtn);
    }

    public void providePartnersDetails(String companytype, String partnersID) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        Actions act = new Actions(driver);
        if (!companytype.equalsIgnoreCase("Sole Proprietorship")) {
            Thread.sleep(800);
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.clickElement(login.partnerID);
            webDriverUtil.enterText(login.partnerID, partnersID);
            Thread.sleep(500);
            webDriverUtil.isElementVisible(login.nextBtn);
            webDriverUtil.clickElement(login.nextBtn);
        }
        Thread.sleep(500);
        webDriverUtil.waitUntilElementClickable(driver, login.confirmBtn, 30);
        webDriverUtil.clickElement(login.confirmBtn);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        webDriverUtil.clickElement(login.nextBtn);
    }
    public void provideBankingDetails(String CompanyType ,String accountName, String accountNumber) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        Thread.sleep(800);
        webDriverUtil.clickElement(login.accountNme);
        webDriverUtil.enterText(login.accountNme, accountName);
        Thread.sleep(800);
        webDriverUtil.clickElement(login.bankNameFld);
        webDriverUtil.clickElement(login.selBankName);
        webDriverUtil.clickElement(login.accountNum);
        webDriverUtil.enterText(login.accountNum, accountNumber);
        Thread.sleep(800);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriverUtil.clickElement(login.accountTypeFld);
        webDriverUtil.clickElement(login.selAccountType);
        Thread.sleep(800);
        webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        webDriverUtil.clickElement(login.nextBtn);
        Thread.sleep(800);
    }

    public void takeASelfie() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        Thread.sleep(800);
        //    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriverUtil.waitUntilVisible(driver, login.openCamDiv, 30);
        //Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ChromeOptions optionsC = new ChromeOptions();
        optionsC.addArguments("use-fake-ui-for-media-stream");
        //optionsC.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized", "use-fake-ui-for-media-stream"));

        webDriverUtil.explicitWait(driver, login.openCamera, 60);
        webDriverUtil.clickElement(login.openCamera);
        Thread.sleep(500);


        optionsC.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized", "use-fake-ui-for-media-stream"));
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.takeSelfie);
        Thread.sleep(500);
        //  webDriverUtil.waitUntilElementClickable(driver,login.openCamDiv,30);
        //  Thread.sleep(500);
        //webDriverUtil.waitUntilEnabled(driver, login.takePhoto, 30);
        // webDriverUtil.clickElement(login.takePhoto);

        //  Thread.sleep(800);
        webDriverUtil.clickElement(login.nextBtn);
    }


    public void uploadDoc(String companytype) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        fileupload up = new fileupload();

        if (companytype.equalsIgnoreCase("Sole Proprietorship")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadID);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.uploadbutton);

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");

        }
        else if(companytype.equalsIgnoreCase("NPO")){

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadID);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.idFIELD);
            webDriverUtil.clickElement(login.ID1);
            webDriverUtil.clickElement(login.uploadbutton);

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadID);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.idFIELD);
            webDriverUtil.clickElement(login.ID2);
            webDriverUtil.clickElement(login.uploadbutton);

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.resolutionLetter);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\Resolution.pdf");

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.uploadnpofund);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\Resolution.pdf");
        }

        else if(companytype.equalsIgnoreCase("Trust")){

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadIDT);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.idFIELD);
            webDriverUtil.clickElement(login.ID1);
            webDriverUtil.clickElement(login.uploadbutton);

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadID);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.idFIELD);
            webDriverUtil.clickElement(login.ID2);
            webDriverUtil.clickElement(login.uploadbutton);

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.trustResolutionLetter);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\Resolution.pdf");

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.uploadtrustdeed);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\Resolution.pdf");
        }

        else {

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadID);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.idFIELD);
            webDriverUtil.clickElement(login.ID1);
            webDriverUtil.clickElement(login.uploadbutton);

            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadID);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\identity.jpg");
            webDriverUtil.clickElement(login.idFIELD);
            webDriverUtil.clickElement(login.ID2);
            webDriverUtil.clickElement(login.uploadbutton);

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.resolutionLetter);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");




        }
        Thread.sleep(2500);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.nextBtn);

    }

    public void submitMerchantDetails(String ownershipDetails, String firstName, String surName, String eMail,
                                      String mobileNo, String idType, String idNumber, String businessStreetName, String businessPostalCode, String businessSuburb, String businessTown, String businessProvince) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.clickElement(login.ownershipDetails);
        if (ownershipDetails.equalsIgnoreCase("Business owner/director")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessOwnerOption);

        } else if (ownershipDetails.equalsIgnoreCase("Assistant on behalf of the business owner/director")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessBehalfOption);
        }

        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.firstName, firstName);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.surName, surName);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.eMail, eMail);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.mobileNo, mobileNo);
        //webDriverUtil.implicitWait(driver, 20);

        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.clickElement(login.idType);
        if (idType.equalsIgnoreCase("South African")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.idSAOption);
        } else if (idType.equalsIgnoreCase("Passport")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.idPassportOption);
        } else if (idType.equalsIgnoreCase("Refugee")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.idRefugeeOption);
        } else {
            webDriverUtil.clickElement(login.idAsylumSeekerOption);
        }

        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.idNumber, idNumber);
        webDriverUtil.implicitWait(driver, 30);
        Actions act = new Actions(driver);
        webDriverUtil.enterText(login.businessStreetName, businessStreetName);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(800);
        webDriverUtil.clickElement(login.businessAddressExpand);
        Thread.sleep(1200);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.businessPostalCode, businessPostalCode);
        Thread.sleep(800);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(800);
        webDriverUtil.clickElement(login.businessSuburb);

        if (businessSuburb.equalsIgnoreCase("Amberville")) {
            Thread.sleep(2400);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessSuburb);
            act.sendKeys(Keys.ENTER).build().perform();
            webDriverUtil.clickElement(login.businessSuburbOption);

        } else if (idType.equalsIgnoreCase("Kosmosdal")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessSuburbOption);
        }

        webDriverUtil.enterText(login.businessTown, businessTown);
        webDriverUtil.implicitWait(driver, 30);

        //webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.clickElement(login.businessProvince);
        if (businessProvince.equalsIgnoreCase("Eastern Cape")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvEasternCape);
        } else if (businessProvince.equalsIgnoreCase("Free State")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvFreeState);
        } else if (businessProvince.equalsIgnoreCase("Gauteng")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvGauteng);
        } else if (businessProvince.equalsIgnoreCase("KwaZulu Natal")) {
            webDriverUtil.clickElement(login.businessKwaZulu);
        } else if (businessProvince.equalsIgnoreCase("Limpopo")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvLimpopo);
        } else if (businessProvince.equalsIgnoreCase("Mpumalanga")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvMpumalanga);
        } else if (businessProvince.equalsIgnoreCase("Northen Cape")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvNorthCape);
        } else if (businessProvince.equalsIgnoreCase("North West")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvNorthWest);
        } else if (businessProvince.equalsIgnoreCase("Western Cape")) {
            webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessProvWesternCape);
        }

        webDriverUtil.clickElement(login.checkoutBtn);
        Thread.sleep(2400);

    }

    public void tellAboutPartners() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.completeOrderBtn);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.completeSubmitBtn);
    }
    public void Logoff() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Logoff logoff = new Logoff(driver);

        webDriverUtil.implicitWait(driver,60);
        //driver.quit();
        webDriverUtil.clickElement(logoff.Submitlogoff);
    }

    private String getOwnershipDetails (String ownershipDetails) throws Exception {
        switch (ownershipDetails) {
            case "Instalments for a fixed period scheduled by merchant":
                return "01";
            case "Instalment for a fixed period scheduled by TEP":
                return "02";
            case "Ongoing fixed regular payments scheduled by merchant":
                return "06";
            case "Ongoing fixed regular payments scheduled by TEP":
                return "07";
            case "Ongoing variable regular payments scheduled by merchant":
                return "11";
            default:
                return "";
        }
    }
}
