package za.co.vodacom.web.webFeatures;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.web.pageObjectModel.Login;
import za.co.vodacom.web.pageObjectModel.Logoff;

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
    public void provideCompanyPersonalDetails(String companyType,String monthlyIncomeKnowledge,String businessMonthlIncome,
                                              String companyRegName,String companyDifferentName,String companyRegNo,
                                              String businessCategory,String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        Actions act = new Actions(driver);

        Thread.sleep(4000);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.acctSetUpGetStartedBtn);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.clickElement(login.companyType);
        //webDriverUtil.enterText(login.companyType, companyType);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.clickElement(login.companyTypeOption);

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

        if (companyDifferentName.equalsIgnoreCase("Yes")) {
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.companydiffrentNameCheckBtn);
            webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyTradingName, companyTradingName);
        } else {
            System.out.println("This company is unknown, does not belong to me.");

        }
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.companyRegNo, companyRegNo);
        //webDriverUtil.implicitWait(driver, 30);
        //webDriverUtil.enterText(login.businessCategory,businessCategory);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.businessCategory);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.businessCategory,businessCategory);
        Thread.sleep(1200);
        //webDriverUtil.implicitWait(driver, 30);
        //webDriverUtil.clickElement(login.businessCategoryClick);
        //act.sendKeys(Keys.ENTER).build().perform();
        //Thread.sleep(2400);
        //String hiddenValue = inputElement.getAttribute("Agricultural Cooperatives");
        //webDriverUtil.clickElement(login.detailsNextBtn);
    }

    public void submitMerchantDetails(String ownershipDetails, String firstName, String surName, String eMail,
                                      String mobileNo, String idType, String idNumber, String businessStreetName, String businessPostalCode,String businessSuburb,String  businessTown,String businessProvince)  throws Exception {
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
        webDriverUtil.clickElement(login.businessAddressExpand);
        Thread.sleep(1200);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.businessPostalCode,businessPostalCode);
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

        webDriverUtil.enterText(login.businessTown,businessTown);
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
