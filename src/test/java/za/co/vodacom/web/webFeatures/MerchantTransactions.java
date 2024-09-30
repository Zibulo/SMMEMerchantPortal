package za.co.vodacom.web.webFeatures;

import com.relevantcodes.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.api.apiFeatures.SFTokenManage;
import za.co.vodacom.commonMethods.CommonMethods;
import za.co.vodacom.fileUploadHandler.fileupload;
import za.co.vodacom.web.pageObjectModel.CardDetailsPom;
import za.co.vodacom.web.pageObjectModel.Login;
import za.co.vodacom.web.pageObjectModel.Logoff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MerchantTransactions extends SystemUtilities {

    public WebDriver driver;
    public static boolean ficaConfirmation = false;
    public static boolean KwikaOnly = false;
    public static boolean assignDeviceActivation;
    public static boolean SkipForTapOnPhoneOnly;
    Boolean runPaymentMethod = false;
    Boolean runVPGCheck = false;
    Boolean runVPRCheck = false;
    Boolean tapOnPhone = false;


    public MerchantTransactions(WebDriver driver) {
        this.driver = driver;
    }

    public void selectLandingPage(String landingPage) throws Exception {

        driver.get(getPropertyValue("Environment", landingPage));//.replace("env", getSystemProperty("env")));
        driver.manage().window().maximize();
    }

    public String mustAssertAndReport() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        CardDetailsPom cardDetailsPom = new CardDetailsPom(driver);

        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.explicitWait(driver, cardDetailsPom.immediateResponseMessage, 60);
        return webDriverUtil.getText(cardDetailsPom.immediateResponseMessage);
    }

    public void populateCredentials(String merchantId, String password) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.enterText(login.merchantId, merchantId);
        webDriverUtil.implicitWait(driver, 05);
        webDriverUtil.enterText(login.password, password);
        Thread.sleep(1200);
        webDriverUtil.clickElement(login.loginSubmit);
        ////webDriverUtil.implicitWait(driver, 05);
    }

    public void choosePosOption(String deviceOption) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        WebDriverWait wait = new WebDriverWait(driver, 120L);

        // Wait for the page title to be the expected value
        wait.until(ExpectedConditions.titleIs("VodaPay SMME Portal"));
        Thread.sleep(6000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.)));

        String[] stringArray = deviceOption.split(",");

        for (String s : stringArray) {

            if (s.equalsIgnoreCase("VodaPay Kwika")) {
                KwikaOnly = true;
                webDriverUtil.implicitWait(driver, 100);
                Actions actions = new Actions(driver);
                Thread.sleep(7000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                // Create an instance of JavascriptExecutor
                JavascriptExecutor js = (JavascriptExecutor) driver;
                ///Thread.sleep(10000);
                // Scroll to the bottom of the page
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                //Thread.sleep(3000);
                webDriverUtil.waitUntilElementClickable(driver,login.paymentSolution_btn, 60);
                if(login.paymentSolution_btn.getAttribute("data-state").
                        equalsIgnoreCase("closed"))
                {
                    webDriverUtil.implicitWait(driver,30);
                    actions.sendKeys(Keys.PAGE_DOWN).perform();
                    webDriverUtil.waitUntilElementClickable(driver,login.paymentSolution_btn, 120);
                    login.paymentSolution_btn.click();
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
                System.out.println("Payment Solution BTN Expanded");
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                webDriverUtil.implicitWait(driver,30);
                webDriverUtil.implicitWait(driver,30);

                Thread.sleep(2000);

                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                Thread.sleep(1000);
                webDriverUtil.implicitWait(driver,30);
                webDriverUtil.implicitWait(driver,30);

                if(login.Option_img1.getText().equalsIgnoreCase("VodaPay Kwika"))
                {
                    login.radio_solution_first.click();
                    //Thread.sleep(2000);
                    webDriverUtil.implicitWait(driver,30);
                    webDriverUtil.implicitWait(driver,30);
                    login.Option_img1.click();
                }else if(login.Option_img2.getText().equalsIgnoreCase("VodaPay Kwika"))
                {
                    login.radio_solution_first.click();
                    ///Thread.sleep(2000);
                    webDriverUtil.implicitWait(driver,30);
                    webDriverUtil.implicitWait(driver,30);
                    login.Option_img2.click();
                }else if(login.Option_img3.getText().equalsIgnoreCase("VodaPay Kwika"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img3.click();
                }
                else if(login.Option_img4.getText().equalsIgnoreCase("VodaPay Kwika"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img4.click();
                }
                else
                {
                    webDriverUtil.implicitWait(driver,30);
                    webDriverUtil.waitUntilElementClickable(driver,login.radio_solution_third, 120);
                    login.radio_solution_third.click();
                    Thread.sleep(2000);
                    login.Option_img5.click();
                }
                webDriverUtil.waitUntilElementClickable(driver,login.addPosOptionKwika, 120);
                Thread.sleep(2000);
                webDriverUtil.clickElement(login.addPosOptionKwika);
                //Thread.sleep(3000);
                webDriverUtil.implicitWait(driver,30);
                webDriverUtil.implicitWait(driver,30);
                webDriverUtil.waitUntilElementClickable(driver,login.closeCart, 60);
                webDriverUtil.clickElement(login.closeCart);
                System.out.println("Product Selected: "+s);
            }else if (s.equalsIgnoreCase("VodaPay Max")) {
                ficaConfirmation= true;
                System.out.println("Fica Confirmation is true");
                System.out.println(String.valueOf(ficaConfirmation));
                Thread.sleep(15000);
                webDriverUtil.implicitWait(driver, 30);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();actions.sendKeys(Keys.PAGE_DOWN).perform();actions.sendKeys(Keys.PAGE_DOWN).perform();actions.sendKeys(Keys.PAGE_DOWN).perform();



                // Create an instance of JavascriptExecutor
                JavascriptExecutor js = (JavascriptExecutor) driver;
                Thread.sleep(2000);
                // Scroll to the bottom of the page
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);
                if(login.paymentSolution_btn.getAttribute("data-state").
                        equalsIgnoreCase("closed"))
                {
                    login.paymentSolution_btn.click();
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
                System.out.println("Payment Solution BTN Expanded");
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                Thread.sleep(5000);

                if(login.Option_img1.getText().equalsIgnoreCase("VodaPay Max"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img1.click();
                }else if(login.Option_img2.getText().equalsIgnoreCase("VodaPay Max"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img2.click();
                }else if(login.Option_img3.getText().equalsIgnoreCase("VodaPay Max"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img3.click();
                }else if(login.Option_img4.getText().equalsIgnoreCase("VodaPay Max"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img4.click();
                }else
                {
                    login.radio_solution_third.click();
                    Thread.sleep(2000);
                    login.Option_img5.click();
                }

                Thread.sleep(2000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(2000);
                webDriverUtil.waitUntilElementClickable(driver,login.addMaxToCart, 120);
                webDriverUtil.clickElement(login.addMaxToCart);
                //Thread.sleep(6000);
                webDriverUtil.waitUntilElementClickable(driver,login.closeCart, 60);
                webDriverUtil.clickElement(login.closeCart);
                System.out.println("Product Selected: "+s);

            } else if (s.equalsIgnoreCase("VodaPay Payment Gateway")) {
                Thread.sleep(8000);
                runPaymentMethod=true;
                runVPGCheck=true;
                webDriverUtil.implicitWait(driver, 30);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                // Create an instance of JavascriptExecutor
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Scroll to the bottom of the page
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(3000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                webDriverUtil.waitUntilElementClickable(driver,login.paymentSolution_btn, 60);
                if(login.paymentSolution_btn.getAttribute("data-state").
                        equalsIgnoreCase("closed"))
                {
                    actions.sendKeys(Keys.PAGE_DOWN).perform();
                    actions.sendKeys(Keys.PAGE_DOWN).perform();
                    login.paymentSolution_btn.click();
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
                System.out.println("Payment Solution BTN Expanded");
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                Thread.sleep(5000);

                if(login.Option_img1.getText().equalsIgnoreCase("VodaPay Payment Gateway"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img1.click();
                }else if(login.Option_img2.getText().equalsIgnoreCase("VodaPay Payment Gateway"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img2.click();
                }else if(login.Option_img3.getText().equalsIgnoreCase("VodaPay Payment Gateway"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img3.click();
                }else if(login.Option_img4.getText().equalsIgnoreCase("VodaPay Payment Gateway"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img4.click();
                }else
                {
                    login.radio_solution_third.click();
                    Thread.sleep(2000);
                    login.Option_img5.click();
                }

                webDriverUtil.clickElement(login.addPosOptionKwika);
                Thread.sleep(6000);
                webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.closeCart);
                System.out.println("Product Selected: "+s);

            } else if (s.equalsIgnoreCase("VodaPay Tap on Phone")) {
                runPaymentMethod = true;
                Thread.sleep(15000);
                webDriverUtil.implicitWait(driver, 30);
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                // Create an instance of JavascriptExecutor
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Scroll to the bottom of the page
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(7000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                if(login.paymentSolution_btn.getAttribute("data-state").
                        equalsIgnoreCase("closed"))
                {
                    login.paymentSolution_btn.click();
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
                System.out.println("Payment Solution BTN Expanded");
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                Thread.sleep(5000);

                if(login.Option_img1.getText().equalsIgnoreCase("VodaPay Tap on Phone"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img1.click();
                }else if(login.Option_img2.getText().equalsIgnoreCase("VodaPay Tap on Phone"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img2.click();
                }else if(login.Option_img3.getText().equalsIgnoreCase("VodaPay Tap on Phone"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img3.click();
                }else if(login.Option_img4.getText().equalsIgnoreCase("VodaPay Tap on Phone"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img4.click();
                }else
                {
                    login.radio_solution_third.click();
                    Thread.sleep(2000);
                    login.Option_img5.click();
                }
                Thread.sleep(2000);
                tapOnPhone = true;
                webDriverUtil.waitUntilElementClickable(driver,login.addPosOptionKwika, 120);
                webDriverUtil.clickElement(login.addPosOptionKwika);
                Thread.sleep(6000);
                webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.waitUntilElementClickable(driver,login.closeCart, 120);
                webDriverUtil.clickElement(login.closeCart);
                System.out.println("Product Selected: "+s);

            } else if (s.equalsIgnoreCase("VodaPay Payment Request")) {
                runPaymentMethod=true;
                runVPRCheck=true;
                webDriverUtil.implicitWait(driver, 30);
                Actions actions = new Actions(driver);
                Thread.sleep(7000);
                Thread.sleep(6000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                // Create an instance of JavascriptExecutor
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Scroll to the bottom of the page
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

                if(login.paymentSolution_btn.getAttribute("data-state").
                        equalsIgnoreCase("closed"))
                {
                    login.paymentSolution_btn.click();
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
                System.out.println("Payment Solution BTN Expanded");
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();

                Thread.sleep(5000);

                if(login.Option_img1.getText().equalsIgnoreCase("VodaPay Payment Request"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img1.click();
                }else if(login.Option_img2.getText().equalsIgnoreCase("VodaPay Payment Request"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img2.click();
                }else if(login.Option_img3.getText().equalsIgnoreCase("VodaPay Payment Request"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img3.click();
                }else if(login.Option_img4.getText().equalsIgnoreCase("VodaPay Payment Request"))
                {
                    login.radio_solution_first.click();
                    Thread.sleep(2000);
                    login.Option_img4.click();
                }else
                {
                    login.radio_solution_third.click();
                    Thread.sleep(2000);
                    login.Option_img5.click();
                }
                Thread.sleep(3000);
                webDriverUtil.clickElement(login.addPosOptionKwika);
                Thread.sleep(6000);
                webDriverUtil.clickElement(login.closeCart);
                System.out.println("Product Selected: "+s);

            } else if (s.equalsIgnoreCase("VodaPay Max2")) {

/*                //webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.addPosOptionScrollBar);
                Thread.sleep(600);
                webDriverUtil.clickElement(login.addPosOptionScrollBar);
                Thread.sleep(600);
                webDriverUtil.clickElement(login.addPosOptionScrollBar);
                Thread.sleep(600);
                webDriverUtil.clickElement(login.addPosOptionScrollBar);
                Thread.sleep(600);
                ;
                webDriverUtil.clickElement(login.addPosOptionScrollBar);
                //webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.addPosoptionMax2);
                Thread.sleep(6000);
                webDriverUtil.clickElement(login.closeCart);
                System.out.println("Product Selected: "+s);*/
            }


        }


        Thread.sleep(2400);
        //webDriverUtil.implicitWait(driver, 30);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(10000);
        webDriverUtil.clickElement(login.solutionCheckoutProceedBtn);

        if(runPaymentMethod)
        {
            if(runVPGCheck)
            {
                Thread.sleep(5000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                System.out.println("Show Payment MTH");
                System.out.println(login.paymentMethodVPG.getText());
                if(login.VPGVisaCard.getText().equalsIgnoreCase("select"))
                {
                    login.VPGVisaCard.click();
                }
                Thread.sleep(2000);
                if(login.VPGamericanExpress.getText().equalsIgnoreCase("select"))
                {
                    login.VPGamericanExpress.click();
                }
                Thread.sleep(2000);
                if(login.VPG_qrCard.getText().equalsIgnoreCase("select"))
                {
                    login.VPG_qrCard.click();
                }


                login.VPG_second_radioBtn.click();
                Thread.sleep(2000);
                if(login.instant_ozow.getText().equalsIgnoreCase("select"))
                {

                    Thread.sleep(2000);
                    login.instant_ozow.click();
                }
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                actions.sendKeys(Keys.PAGE_DOWN).perform();



            }

/*            // Check if an element exists using WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.valueOf(login.paymentMethodVPR))));
                System.out.println("Element exists.");
            } catch (TimeoutException e) {
                System.out.println("Element does not exist.");
            }*/

            if(runVPRCheck) {
                Thread.sleep(5000);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(3000);
                if(runVPGCheck)
                {
                    if(login.VPRVisaCard.getText().equalsIgnoreCase("select"))
                    {
                        login.VPRVisaCard.click();
                    }
                    Thread.sleep(2000);
                    if(login.VPRamericanExpress.getText().equalsIgnoreCase("select"))
                    {
                        login.VPRamericanExpress.click();
                    }
                }else
                {
                    if(login.VPRVisaCard_falseVpg.getText().equalsIgnoreCase("select"))
                    {
                        login.VPRVisaCard_falseVpg.click();
                    }
                    Thread.sleep(2000);
                    if(login.instant_eft_falseVpg.getText().equalsIgnoreCase("select"))
                    {
                        login.instant_eft_falseVpg.click();
                    }
                }



            }

            Thread.sleep(3000);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(1000);

            if(tapOnPhone && !runVPRCheck  &&
                    !runVPGCheck && !ficaConfirmation && !KwikaOnly)
            {
                SkipForTapOnPhoneOnly =true;
            }
            else
            {
                webDriverUtil.clickElement(login.Vpgvpt_proceedBtn);
            }


        }




    }

    public void completeDeviceOrder() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.waitUntilElementClickable(driver,login.addDeviceBtn, 120);
        webDriverUtil.clickElement(login.addDeviceBtn);
        ////webDriverUtil.implicitWait(driver, 60);
        Thread.sleep(600);
        webDriverUtil.waitUntilElementClickable(driver,login.orderContinueBtn, 120);
        webDriverUtil.clickElement(login.orderContinueBtn);
        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.waitUntilElementClickable(driver,login.reserveFundsBtn, 120);
        webDriverUtil.clickElement(login.reserveFundsBtn);
        Thread.sleep(1200);
        //webDriverUtil.clickElement(login.completeOrderBtn);
    }

    public void populateOnceCardDetails(String onceCardHolder, String onceCardNo,String onceExpireYear,String onceExpiryDate,String onceCvv) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        CardDetailsPom cardDetailsPom = new CardDetailsPom(driver);

        Thread.sleep(10000);
        //Card details to be populated
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.waitUntilElementClickable(driver,cardDetailsPom.onceCardHolder, 120);
        webDriverUtil.enterText(cardDetailsPom.onceCardHolder, onceCardHolder);
        webDriverUtil.enterText(cardDetailsPom.onceCardNo, onceCardNo);
        //webDriverUtil.selectByVisibleText(cardDetailsPom.onceExpireYear, getCardExpiryYear(onceExpireYear));
        //webDriverUtil.implicitWait(driver, 10);
        //webDriverUtil.selectByVisibleText(cardDetailsPom.onceExpiryDate, getCardExpireDate(onceExpiryDate));
        webDriverUtil.waitUntilElementClickable(driver,cardDetailsPom.onceExpiryDate, 120);
        // Convert month to numeric format
        String monthNumber = getMonthNumber(onceExpiryDate);

        // Extract last two digits of the year
        String yearLastTwoDigits = onceExpireYear.substring(onceExpireYear.length() - 2);

        // Concatenate month and last two digits of the year
        String result = monthNumber + yearLastTwoDigits;

        webDriverUtil.enterText(cardDetailsPom.onceExpiryDate, result);
       // webDriverUtil.enterText(cardDetailsPom.onceCardExpiry, onceExpireYear);
       // webDriverUtil.enterText(cardDetailsPom.onceExpiryDate, onceExpiryDate);
        webDriverUtil.waitUntilElementClickable(driver,cardDetailsPom.new_onceCvv, 120);
        webDriverUtil.enterText(cardDetailsPom.new_onceCvv, onceCvv);
        //webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(cardDetailsPom.onceNewPayButton);

    }

    public void populateVPGOnceCardDetails() throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        CardDetailsPom cardDetailsPom = new CardDetailsPom(driver);

        Thread.sleep(10000);

        //Select Payment Method
        webDriverUtil.waitUntilElementClickable(driver,cardDetailsPom.paymentmethod_btn, 120);
        webDriverUtil.clickElement(cardDetailsPom.paymentmethod_btn);

        webDriverUtil.waitUntilElementClickable(driver,cardDetailsPom.paymentmethod_continue_btn, 120);
        webDriverUtil.clickElement(cardDetailsPom.paymentmethod_continue_btn);


    }

    public void populate3DSecure(String cardType, String bankName, String threeDPassword) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        CardDetailsPom cardDetailsPom = new CardDetailsPom(driver);

        if (cardType.equalsIgnoreCase("virtual")) {
            System.out.println("This is a virtual card, no 3D secured required");
        } else {
            if (bankName.equalsIgnoreCase("Nedbank Debit")) {
                //webDriverUtil.implicitWait(driver, 350);
                Thread.sleep(2400);
                webDriverUtil.clickElement(cardDetailsPom.ecomNedbankContinue);
                Thread.sleep(2400);
                //System.out.println("Nedbank Continue Button Submitted");
            } else {
                if (bankName.equalsIgnoreCase("Nedbank Credit")) {
                    //webDriverUtil.implicitWait(driver, 20);
                    webDriverUtil.clickElement(cardDetailsPom.nedConfirm);
                    //webDriverUtil.implicitWait(driver, 60);
                    webDriverUtil.clickElement(cardDetailsPom.mRecNedbankContinue);

                } else {
                    if (bankName.equalsIgnoreCase("Absa")) {
                        //webDriverUtil.implicitWait(driver, 20);
                        webDriverUtil.enterText(cardDetailsPom.threeDPassword, threeDPassword);
                        //webDriverUtil.implicitWait(driver, 20);
                        webDriverUtil.clickElement(cardDetailsPom.submit);
                    } else {
                        //webDriverUtil.implicitWait(driver, 20);
                        webDriverUtil.enterText(cardDetailsPom.threeDPassword, threeDPassword);
                        //webDriverUtil.implicitWait(driver, 20);
                        webDriverUtil.clickElement(cardDetailsPom.submit);
                    }
                }
            }
        }
    }

    public String selectResURL() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        //String newUrl;
        String bankRequesUrl;
        String bankResUrl;

        Thread.sleep(4000);
        String bankresUrl = driver.getCurrentUrl();
        String truncatedUrl = null;
        System.out.println("Printing bank response message:\n" + bankresUrl);
        String finaldecodedURL = null;
        String finalBankRes = null;
        Thread.sleep(2000);
        int index = bankresUrl.indexOf("?data=") + 6;
        truncatedUrl = bankresUrl.substring(index);

        //finalBankRes = "eyJlY2hvRGF0YSI6ImluaXRpYXRlaXNzdWV0b2tlblJlcXVlc3Q4YTUzMDVhYi01YTgwLTRmYjQtOWQyMS05ZDVhZTRlZTM0ZTAiLCJzZXNzaW9uSWQiOiI0OWUwYThhYS04MzUzLTRmMGItODM3Ny1mODRhMGI4ZDUxNjEiLCJyZXNwb25zZUNvZGUiOiIwNiIsInJlc3BvbnNlTWVzc2FnZSI6IkludmFsaWQgQVJlcyBmcm9tIERTIChodHRwczovL2Fjc2FidGVzdC5iYW5rc2Vydi5jby56YS9hcmVxX2lhdCkgKGVycklkPTMxMjI4NTI3NzE5MCkifQ%3D%3D";
        System.out.println("Printing trancated URL:\n" + truncatedUrl);
        Thread.sleep(5000);
        byte[] newdecoded = Base64.decodeBase64(truncatedUrl);
        System.out.printf("Itu testing decoded bytes response message from bank URL:\n%s%n", (Object) newdecoded);

        String originalSimpleText = new String(newdecoded);
        //String originalSimpleText= new String(b64DecodedByteArray);

        System.out.println("Itu testing decoded bytes response message from bank URL:\n" + (originalSimpleText));
        return (originalSimpleText);
    }


    public void assignDevicesAndProcessOrder(String deviceReceiptOption, String devicePaymentOption, String journey_name) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        //Assign device If statement code
        if((KwikaOnly || ficaConfirmation) &&journey_name.equalsIgnoreCase("Three PO"))
        {
            Thread.sleep(800);
            webDriverUtil.implicitWait(driver, 30);
            Thread.sleep(5000);
            webDriverUtil.waitUntilElementClickable(driver,login.assignDeviceNxtBtn, 120);
            webDriverUtil.clickElement(login.assignDeviceNxtBtn);
            //webDriverUtil.implicitWait(driver, 30)
        }
;

       if (devicePaymentOption.equalsIgnoreCase("Payflex"))
       {
           //webDriverUtil.implicitWait(driver, 30);
           webDriverUtil.waitUntilElementClickable(driver,login.devicePaymentOption, 120);
           webDriverUtil.clickElement(login.devicePaymentOption);
           //webDriverUtil.implicitWait(driver, 30);
           webDriverUtil.waitUntilElementClickable(driver,login.assignDeviceContinueBtn, 120);
           webDriverUtil.clickElement(login.assignDeviceContinueBtn);
           //webDriverUtil.implicitWait(driver, 30);
           webDriverUtil.waitUntilElementClickable(driver,login.reserveFundsBtn, 120);
           webDriverUtil.clickElement(login.reserveFundsBtn);

       }
       else if (journey_name.equalsIgnoreCase("Self Onboarding"))
       {
           if(KwikaOnly || ficaConfirmation)
           {
               webDriverUtil.waitUntilElementClickable(driver,login.assignDeviceContinueBtn, 120);
               webDriverUtil.clickElement(login.assignDeviceContinueBtn);
           }else
           {
               webDriverUtil.waitUntilElementClickable(driver,login.completeApplicationBtn, 120);
               webDriverUtil.clickElement(login.completeApplicationBtn);
           }


           webDriverUtil.waitUntilElementClickable(driver,login.readyToSubmitBtn, 120);
           webDriverUtil.clickElement(login.readyToSubmitBtn);

       }
       else if(devicePaymentOption.equalsIgnoreCase("cash"))
       {
           webDriverUtil.implicitWait(driver, 30);
           //webDriverUtil.clickElement(login.devicePaymentOption);
          // //webDriverUtil.implicitWait(driver, 30)
          // webDriverUtil.clickElement(log);
           //webDriverUtil.clickElement(login.randomClick);
           //webDriverUtil.implicitWait(driver, 30);
           Thread.sleep(1000);
           webDriverUtil.clickElement(login.continueApplicationBtn);
           //webDriverUtil.implicitWait(driver, 30);
           webDriverUtil.clickElement(login.readyToSubmitBtn);
       }
       else
       {
           webDriverUtil.implicitWait(driver, 30);
           //Thread.sleep(10000);
           if(KwikaOnly)
           {
               webDriverUtil.waitUntilVisible(driver,login.deviceCardPaymentOption,30);
               webDriverUtil.clickElement(login.deviceCardPaymentOption);


               ////webDriverUtil.implicitWait(driver, 30);
               webDriverUtil.waitUntilVisible(driver,login.orderContinueBtn,30);
               webDriverUtil.clickElement(login.orderContinueBtn);
               webDriverUtil.implicitWait(driver, 30);
               webDriverUtil.clickElement(login.reserveFundsBtn);

               if (deviceReceiptOption.equalsIgnoreCase("smsReceipt")) {
                   ////webDriverUtil.implicitWait(driver, 30);
                   webDriverUtil.clickElement(login.smsRadioOption);
               }
               else
               {
                   //webDriverUtil.implicitWait(driver, 20);
                   //Thread.sleep(10000);
                   webDriverUtil.waitUntilVisible(driver,login.emailRadioOption,30);
                   webDriverUtil.clickElement(login.emailRadioOption);
                   System.out.println("The email option has been selected");
               }

               //////webDriverUtil.implicitWait(driver, 30);
               //webDriverUtil.clickElement(login.addDeviceBtn);
               //////webDriverUtil.implicitWait(driver, 60);
               //Thread.sleep(600);
               //webDriverUtil.clickElement(login.orderContinueBtn);
               //////webDriverUtil.implicitWait(driver, 30);

               ////webDriverUtil.implicitWait(driver, 60);
               webDriverUtil.clickElement(login.sendPaymentRequestBtn);
           }
           else if (ficaConfirmation && !KwikaOnly)
           {
               Thread.sleep(3000);
               webDriverUtil.implicitWait(driver, 60);
               webDriverUtil.waitUntilElementClickable(driver,login.deviceCardPaymentOption, 120);
               webDriverUtil.clickElement(login.deviceCardPaymentOption);
               webDriverUtil.waitUntilElementClickable(driver,login.assignDeviceContinueBtn, 120);
               webDriverUtil.clickElement(login.assignDeviceContinueBtn);

               Thread.sleep(3000);
               webDriverUtil.implicitWait(driver, 60);
               webDriverUtil.waitUntilElementClickable(driver,login.submitBtn, 120);
               webDriverUtil.clickElement(login.submitBtn);

               if (deviceReceiptOption.equalsIgnoreCase("smsReceipt")) {
                   ////webDriverUtil.implicitWait(driver, 30);
                   webDriverUtil.clickElement(login.smsRadioOption);
               }
               else
               {
                   //webDriverUtil.implicitWait(driver, 20);
                   //Thread.sleep(10000);
                   webDriverUtil.waitUntilVisible(driver,login.emailRadioOption,30);
                   webDriverUtil.clickElement(login.emailRadioOption);
                   System.out.println("The email option has been selected");
               }

               webDriverUtil.clickElement(login.sendPaymentRequestBtn);
           }
           else if (!ficaConfirmation && !KwikaOnly)
           {
               Thread.sleep(3000);
               webDriverUtil.implicitWait(driver, 60);
               webDriverUtil.waitUntilElementClickable(driver,login.completeApplicationBtn, 120);
               webDriverUtil.clickElement(login.completeApplicationBtn);

               Thread.sleep(3000);
               webDriverUtil.implicitWait(driver, 60);
               webDriverUtil.waitUntilElementClickable(driver,login.submitBtn, 120);
               webDriverUtil.clickElement(login.submitBtn);
           }

       }

    }

      public void completeCustomerLandingPage() throws Exception {
          WebDriverUtilities webDriverUtil = new WebDriverUtilities();
          Login login = new Login(driver);
          Thread.sleep(30000);
          webDriverUtil.implicitWait(driver, 30);
          JavascriptExecutor js = (JavascriptExecutor) driver;

          // Scroll to the bottom of the page
          js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
          webDriverUtil.implicitWait(driver, 100);
          Thread.sleep(2000);
          webDriverUtil.waitUntilElementClickable(driver,login.setupCustomerCompletePage_btn, 120);
          webDriverUtil.clickElement(login.setupCustomerCompletePage_btn);
      }

      public void customebusinessComplete(String companyTypeOption, String companyRegName,
                                          String businessMonthlIncome, String businessCategory, String AddressYearMonthDayStayed) throws Exception {
          WebDriverUtilities webDriverUtil = new WebDriverUtilities();
          Login login = new Login(driver);
          webDriverUtil.implicitWait(driver, 30);

          webDriverUtil.clickElement(login.describeYourBusinessposition_dropDown);
          String businessDescription = "Sole Proprietorship";
          if (companyTypeOption.equalsIgnoreCase("Sole Proprietorship") ||
                  companyTypeOption.equalsIgnoreCase("Unregistered business")) {
              webDriverUtil.implicitWait(driver, 5);
              webDriverUtil.clickElement(login.describeYourBusiness_dropDown);
              System.out.println("I see drop down");
              webDriverUtil.implicitWait(driver, 5);

          } else if (companyTypeOption.equalsIgnoreCase("Close Corporation")) {
              webDriverUtil.implicitWait(driver, 5);
              webDriverUtil.clickElement(login.gameDrpdwnOption);

          } else if (companyTypeOption.equalsIgnoreCase("Company")) {
              // webDriverUtil.clickElement(login.selectDealerDrpdwn);
              webDriverUtil.implicitWait(driver, 5);
              webDriverUtil.clickElement(login.oneSourceDirectOption);
          }
          webDriverUtil.implicitWait(driver, 5);
          webDriverUtil.enterText(login.businesName_txt,companyRegName);

          webDriverUtil.implicitWait(driver, 30);
          webDriverUtil.enterText(login.businessMonthlIncome_text,businessMonthlIncome);


          ////webDriverUtil.implicitWait(driver, 30);
/*          webDriverUtil.clickElement(login.businessCategory_text);
          webDriverUtil.enterText(login.businessCategory_text,businessCategory);*/

/*          WebDriverWait wait = new WebDriverWait(driver, 10);
          List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("search-box")));

          // Iterate through the suggestions and select the one that matches or contains the text
          for (WebElement suggestion : suggestions) {
              if (suggestion.getText().contains(businessCategory)) {
                  suggestion.click();
                  break;
              }
          }*/

          webDriverUtil.implicitWait(driver, 30);
          webDriverUtil.enterText(login.businessCategory,businessCategory);

          //Actions builder = new Actions(driver);
          //builder.sendKeys(login.businessCategory);
          //builder.sendKeys(Keys.TAB);
          //builder.release().perform();
          //Thread.sleep(2400);

          // Locate the input element using XPath
          WebElement businessCategoryInput = driver.findElement(By.xpath("//input[@name='businessCategory.name']"));

          // Perform actions on the input element, e.g., get the value or set a new value
          String currentValue = businessCategoryInput.getAttribute("value");

          //webDriverUtil.clickElement(login.businessCategoryInput);
          System.out.println("Current value: " + currentValue);

          webDriverUtil.waitUntilVisible(driver, login.businessCategorySearchResults, 120);
          webDriverUtil.clickElement(login.businessCategorySearchResults);
          Thread.sleep(3000);
          //businessCategoryInput.clear();  // Clear the existing value if necessary
          //businessCategoryInput.sendKeys("");
          System.out.println("I am waiting for category to finish selecting");
          System.out.println(3000);

          //webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
          //webDriverUtil.clickElement(login.nextBtn);

          JavascriptExecutor js = (JavascriptExecutor) driver;

          // Scroll to the bottom of the page
          js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
/*          if(runVPRCheck || runVPGCheck)
          {
              webDriverUtil.waitUntilElementClickable(driver,login.urlText_input, 120);
              Thread.sleep(5000);
              //webDriverUtil.clickElement(login.urlText_input);
              //Thread.sleep(2000);
              webDriverUtil.enterText(login.urlText_input,"https://www.google.com");
              System.out.println("Investigate");
             // Thread.sleep(30000);
          }*/


          //webDriverUtil.waitUntilElementClickable(driver, login.confirmBtn, 30);
        if(runVPGCheck || runVPRCheck)
          {

              webDriverUtil.waitUntilElementClickable(driver,login.urlText_input, 120);
              webDriverUtil.enterText(login.urlText_input,"https://www.google.com");
          }

          //webDriverUtil.waitUntilElementClickable(driver, login.confirmBtn, 30);
          //This code needs to run if you selected VodaPay Max
          if(ficaConfirmation)
          {
              Thread.sleep(3000);
              webDriverUtil.waitUntilElementClickable(driver, login.ficaConfirmBtn, 120);
              webDriverUtil.clickElement(login.ficaConfirmBtn);

              webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 120);
              webDriverUtil.clickElement(login.nextBtn);
          }else
          {
              webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 120);
              webDriverUtil.clickElement(login.nextBtn);
          }



          Thread.sleep(3000);
          webDriverUtil.implicitWait(driver,30);
          webDriverUtil.waitUntilElementClickable(driver, login.confirmBtn, 30);
          webDriverUtil.clickElement(login.confirmBtn);

          Thread.sleep(3000);
          webDriverUtil.implicitWait(driver, 30);
          if(ficaConfirmation)
          {
              webDriverUtil.waitUntilElementClickable(driver, login.residential_address, 120);
              webDriverUtil.clickElement(login.residential_address);

              // convertAddressYearMonthDayStayedDate(2024-03-16) data passed format
              int[] dateParts =   convertAddressYearMonthDayStayedDate(AddressYearMonthDayStayed);
              //String.valueOf(2024),String.valueOf(03),String.valueOf(16) format type ///Year = 2024 //Month = 03 Day //Day
              clickTateTimeInput(String.valueOf(dateParts[0]),String.valueOf(dateParts[1]),String.valueOf(dateParts[2]));

              Actions actions = new Actions(driver);
              Thread.sleep(5000);
              actions.sendKeys(Keys.PAGE_DOWN);
              ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
              webDriverUtil.waitUntilElementClickable(driver,login.typeOfResidence, 120);
              Thread.sleep(1000);
              webDriverUtil.clickElement(login.typeOfResidence);
              Thread.sleep(1000);
              webDriverUtil.waitUntilElementClickable(driver,login.selectOwner, 120);
              webDriverUtil.clickElement(login.selectOwner);
          }


          webDriverUtil.waitUntilElementClickable(driver,login.clickResidentialNextBtn, 120);
          webDriverUtil.clickElement(login.clickResidentialNextBtn);


      }

      public void clickTateTimeInput(String year, String month, String day) throws Exception {
          WebDriverUtilities webDriverUtil = new WebDriverUtilities();
          Login login = new Login(driver);
          webDriverUtil.implicitWait(driver, 30);
          Thread.sleep(3000);
          // Locate the date picker input field
          webDriverUtil.waitUntilElementClickable(driver,login.dateTimePicker_input, 120);

          webDriverUtil.clickElement(login.dateTimePicker_input);
          //WebElement datePickerInput = driver.findElement(By.className("react-date-picker__calendar-button react-date-picker__button"));

          // Wait for the date picker to be visible
          WebDriverWait wait = new WebDriverWait(driver, 30);
          // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("CSS_SELECTOR_FOR_DATE_PICKER")));

          // Define the desired date
          String desiredDate = year+"-"+month+"-"+day; // Format: yyyy-MM-dd
          System.out.println("desiredDate: "+desiredDate);
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
          LocalDate targetDate = LocalDate.parse(desiredDate,formatter);
          DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");

          DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
          DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

          String desiredMonth = targetDate.format(monthFormatter); // e.g., "February"
          String desiredDay = String.valueOf(targetDate.getDayOfMonth()); // e.g., "1"
          String desiredYear = targetDate.format(yearFormatter); // e.g., "2024"

          while (true) {
              // Locate the month and year displayed in the date picker
              //WebElement displayedMonthYear = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[2]/div/span/div/div/div[1]/button[3]/span"));
              String displayedMonthYearText = login.displayedMonthYearText.getText();

              // Check if the displayed month and year match the target date
              if (displayedMonthYearText.equals(targetDate.format(monthYearFormatter))) {
                  break;
              }

              // Locate the next button in the date picker and click it
              webDriverUtil.clickElement(login.previousDate);

              // Wait for the date picker to update
              Thread.sleep(1000);
              //wait.until(ExpectedConditions.stalenessOf(login.displayedMonthYearText));
          }
          // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("CSS_SELECTOR_FOR_DATE_PICKER")));

          // Locate and select the desired date
          // Example for selecting a specific date (e.g., 15th of the current month)
          WebDriverWait wait1 = new WebDriverWait(driver, 120L);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='"+desiredMonth +" "+desiredDay+", " + desiredYear+"']")));
          webDriverUtil.waitUntilElementClickable(driver,login.dateTimePicker_input, 120);
          WebElement dateElement = driver.findElement(By.xpath("//*[@aria-label='"+desiredMonth +" "+desiredDay+", " + desiredYear+"']"));
          Thread.sleep(3000);
          dateElement.click();
      }
    public static int[] convertAddressYearMonthDayStayedDate(String dateString) {
        // Parse the date string to LocalDate
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        // Extract year, month, and day
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        // Return them in an array
        return new int[]{year, month, day};
    }
    public void completePaymentRequest() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        CommonMethods commonMethods = new CommonMethods();



        Login login = new Login(driver);

        Thread.sleep(10000);

        String link = commonMethods.getPaymentRequestLink();
        String parent = commonMethods.openLinkInNewTab(link,driver);



        //entering credit card details
    /*    webDriverUtil.enterText(login.nameOnCardInput, nameOnCard);
        ////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.cardNumInput, cardNum);
        ////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.selectByVisibleText(login.expiryYearDrpdwn ,"2029");
        ////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.selectByVisibleText(login.expirymonthDrpdwn, "February");
        ////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.cvvInput, cvv);
        ////webDriverUtil.implicitWait(driver, 20);

     */
      //  webDriverUtil.clickElement(login.paymentGatewayContinueBtn);
      //  Thread.sleep(10000);
      //  webDriverUtil.clickElement(login.paymentConfirmContinueBtn);
      //  Thread.sleep(20000);
        //closing payment window and switching control to previous window
        //driver.close();
        //driver.switchTo().window(parent);
     //   System.out.println(driver.getCurrentUrl());
     //   webDriverUtil.clickElement(login.checkPaymentStatusBtn);
     //   Thread.sleep(10000);

            }

    public void provideCompanyPersonalDetails(String companyType, String companyRegName,String monthlyIncomeKnowledge, String businessMonthlIncome,
                                               String companyDifferentName, String companyRegNo,
                                              String businessCategory, String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        Actions act = new Actions(driver);

        Thread.sleep(4000);
        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.waitUntilElementClickable(driver,login.acctSetUpGetStartedBtn, 120);
        webDriverUtil.clickElement(login.acctSetUpGetStartedBtn);
        ////webDriverUtil.implicitWait(driver, 30);

        webDriverUtil.clickElement(login.companyType);
        if (companyType.equalsIgnoreCase("Sole Proprietorship")) {
            webDriverUtil.clickElement(login.soleProTypeOption);
        } else if (companyType.equalsIgnoreCase("Partnership")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.partnershipTypeOption);

        } else if (companyType.equalsIgnoreCase("Trust")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.trustTypeOption);

        } else if (companyType.equalsIgnoreCase("company")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.companyTypeOption);

        } else if (companyType.equalsIgnoreCase("Close Corporation")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.closeTypeOption);

        } else {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.npoTypeOption);
        }

        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.companyRegName, companyRegName);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if (companyDifferentName.equalsIgnoreCase("Yes")) {

            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.companydiffrentNameCheckBtn);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyTradingName, companyTradingName);
        } else {
            System.out.println("This company is unknown, does not belong to me.");
        }
    /*    if (monthlyIncomeKnowledge.equalsIgnoreCase("Yes")) {
            ////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.enterText(login.businessMonthlIncome, businessMonthlIncome);
            //////webDriverUtil.implicitWait(driver, 20);
            //webDriverUtil.enterText(login.companyRegNo, companyRegNo);
            //////webDriverUtil.implicitWait(driver, 30);
            //webDriverUtil.enterText(login.businessCategory,businessCategory);
        } else if (monthlyIncomeKnowledge.equalsIgnoreCase("No")) {
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.incomeKnowledgeCheckBox);
        }
        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.companyRegName, companyRegName);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(800);
        if (companyDifferentName.equalsIgnoreCase("Yes")) {
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.companydiffrentNameCheckBtn);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyTradingName, companyTradingName);
        } else {
            System.out.println("This company is unknown, does not belong to me.");

        }
        if (companyType.equalsIgnoreCase("Sole Proprietorship")) {
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.businessCategory, businessCategory);
            Thread.sleep(2400);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            Thread.sleep(1000);
            webDriverUtil.waitUntilVisible(driver, login.businessCategorySearchResults, 30);
            webDriverUtil.clickElement(login.businessCategorySearchResults);

        } else {
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyRegNo, companyRegNo);
            //////webDriverUtil.implicitWait(driver, 30);
            //webDriverUtil.enterText(login.businessCategory,businessCategory);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.businessCategory, businessCategory);
            Thread.sleep(2400);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.businessCategory);
            Thread.sleep(1000);
            webDriverUtil.waitUntilVisible(driver, login.businessCategorySearchResults, 30);
            webDriverUtil.clickElement(login.businessCategorySearchResults);
        } */

        //webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        //webDriverUtil.clickElement(login.nextBtn);
        //Thread.sleep(1000);
        // webDriverUtil.waitUntilElementClickable(driver,login.confirmBtn,30);
        //webDriverUtil.clickElement(login.confirmBtn);
        //WebElement inputElement = driver.findElement(By.xpath("//input[@name='businessCategory.name' and @class='search-box false'] and Text('Agricultural Cooperatives')"));

        //String hiddenValue = inputElement.getAttribute("Agricultural Cooperatives");
        //System.out.println("Hidden Value: " + hiddenValue);

        //act.sendKeys(Keys.TAB).build().perform();
        //act.sendKeys(Keys.TAB).build().perform();
        //Thread.sleep(2400);
        //act.sendKeys(Keys.ENTER).build().perform();
        //////webDriverUtil.implicitWait(driver, 30);
        //webDriverUtil.clickElement(login.detailsNextBtn);
    }

    public void provideCompanyDetails(String companyType, String companyRegName,String companyDifferentName,
                                      String monthlyIncomeKnowledge, String businessMonthlIncome,
                                      String businessCategory,String companyRegNo, String companyTradingName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        Actions act = new Actions(driver);
        Thread.sleep(4000);
        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.acctSetUpGetStartedBtn);
        ////webDriverUtil.implicitWait(driver, 30);

        webDriverUtil.clickElement(login.companyType);
        if (companyType.equalsIgnoreCase("Sole Proprietorship")) {
            webDriverUtil.clickElement(login.soleProTypeOption);
        } else if (companyType.equalsIgnoreCase("Partnership")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.partnershipTypeOption);

        } else if (companyType.equalsIgnoreCase("Trust")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.trustTypeOption);

        } else if (companyType.equalsIgnoreCase("company")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.companyTypeOption);

        } else if (companyType.equalsIgnoreCase("Close Corporation")) {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.closeTypeOption);

        } else {
            webDriverUtil.clickElement(login.companyType);
            webDriverUtil.clickElement(login.npoTypeOption);
        }

        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.companyRegName, companyRegName);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if (companyDifferentName.equalsIgnoreCase("Yes")) {

            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.companydiffrentNameCheckBtn);
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.companyTradingName, companyTradingName);
        } else {
            System.out.println("This company is unknown, does not belong to me.");
        }

        if (monthlyIncomeKnowledge.equalsIgnoreCase("Yes")) {
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(login.businessMonthlIncome, businessMonthlIncome);

        } else if (monthlyIncomeKnowledge.equalsIgnoreCase("No")) {
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.incomeKnowledgeCheckBox);
        }
        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.businessCategory,businessCategory);

        //Actions builder = new Actions(driver);
        //builder.sendKeys(login.businessCategory);
        //builder.sendKeys(Keys.TAB);
        //builder.release().perform();
        //Thread.sleep(2400);

        // Locate the input element using XPath
        WebElement businessCategoryInput = driver.findElement(By.xpath("//input[@name='businessCategory.name']"));

        // Perform actions on the input element, e.g., get the value or set a new value
        String currentValue = businessCategoryInput.getAttribute("value");

        //webDriverUtil.clickElement(login.businessCategoryInput);
        System.out.println("Current value: " + currentValue);

        webDriverUtil.waitUntilVisible(driver, login.businessCategorySearchResults, 30);
        webDriverUtil.clickElement(login.businessCategorySearchResults);
        //businessCategoryInput.clear();  // Clear the existing value if necessary
        businessCategoryInput.sendKeys("");

        webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        webDriverUtil.clickElement(login.nextBtn);

        webDriverUtil.waitUntilElementClickable(driver, login.confirmBtn, 30);
        webDriverUtil.clickElement(login.confirmBtn);

        webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        webDriverUtil.clickElement(login.nextBtn);


    /*





        } */

        //webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);
        //webDriverUtil.clickElement(login.nextBtn);
        //Thread.sleep(1000);
        // webDriverUtil.waitUntilElementClickable(driver,login.confirmBtn,30);
        //webDriverUtil.clickElement(login.confirmBtn);
        //WebElement inputElement = driver.findElement(By.xpath("//input[@name='businessCategory.name' and @class='search-box false'] and Text('Agricultural Cooperatives')"));

        //String hiddenValue = inputElement.getAttribute("Agricultural Cooperatives");
        //System.out.println("Hidden Value: " + hiddenValue);

        //act.sendKeys(Keys.TAB).build().perform();
        //act.sendKeys(Keys.TAB).build().perform();
        //Thread.sleep(2400);
        //act.sendKeys(Keys.ENTER).build().perform();
        //////webDriverUtil.implicitWait(driver, 30);
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

    public void provideBankingDetails(String CompanyType, String accountName, String accountNumber) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        Thread.sleep(800);
        webDriverUtil.clickElement(login.accountNme);
        webDriverUtil.enterText(login.accountNme, accountName);
        Thread.sleep(800);
        webDriverUtil.clickElement(login.bankNameFld);
        webDriverUtil.clickElement(login.selBankName);
        //webDriverUtil.clickElement(login.accountNum);
        webDriverUtil.enterText(login.accountNum, accountNumber);
        Thread.sleep(800);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriverUtil.clickElement(login.accountTypeFld);
        webDriverUtil.clickElement(login.selAccountType);
        Thread.sleep(800);
        webDriverUtil.waitUntilElementClickable(driver, login.nextBtn, 30);

        //driver.get("https://vodapayqa.vodacom.co.za/onboarding/pos/personal-selfie");
        //Thread.sleep(2400);
        //driver.close();
        webDriverUtil.clickElement(login.nextBtn);
        Thread.sleep(800);
    }

    public void     takeASelfie() throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Login login = new Login(driver);
        Thread.sleep(2400);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        ChromeOptions optionsC = new ChromeOptions();

        optionsC.addArguments("--use-fake-device-for-media-stream");
        optionsC.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized", "use-fake-ui-for-media-stream"));

        Thread.sleep(1200);
        webDriverUtil.clickElement(login.openCamDiv);
        Thread.sleep(5000);
        //optionsC.addArguments("profile.default_content_setting_values.media_stream_camera", "1");
        optionsC.addArguments("--use-fake-ui-for-media-stream");

        Thread.sleep(800);
        webDriverUtil.clickElement(login.takeSelfie);
        optionsC.addArguments("--use-fake-device-for-media-stream");

        Thread.sleep(1200);
        webDriverUtil.clickElement(login.confirmTakePhotoBtn);
        Thread.sleep(800);
        webDriverUtil.clickElement(login.nextBtn);

        //  webDriverUtil.waitUntilElementClickable(driver,login.openCamDiv,30);
        //  Thread.sleep(500);
        //webDriverUtil.waitUntilEnabled(driver, login.takePhoto, 30);
    }


    public void uploadDoc(String companytype, String idDocumentType) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        fileupload up = new fileupload();

        Thread.sleep(800);
        webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.waitUntilElementClickable(driver,login.uploadID, 120);
        webDriverUtil.clickElement(login.uploadID);

        if (companytype.equalsIgnoreCase("Sole Proprietorship")) {
            if (idDocumentType.equalsIgnoreCase("smart card")) {
                System.out.println("I see myself here smart card");
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                webDriverUtil.clickElement(login.uploadIdType);
                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

            } else if (idDocumentType.equalsIgnoreCase("green card")) {
                System.out.println("I see myself here green card");
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\ntyit001\\IdeaProjects\\SMMEMerchantPortal\\ID\\6807015897087.jpeg");
                webDriverUtil.waitUntilElementClickable(driver,login.confirmPhoto, 120);
                webDriverUtil.clickElement(login.confirmPhoto);
                Thread.sleep(30000);

            } else {
                System.out.println("I see myself here another card");
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.uploadID);
                webDriverUtil.clickElement(login.confirmPhoto);

                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.uploadID);

            }
            Thread.sleep(7000);
            webDriverUtil.clickElement(login.uploadBanking);
            System.out.println("New Clicked upload by Itu");
            Thread.sleep(7500);
            up.handleFileDialog("C:\\Users\\ntyit001\\IdeaProjects\\SMMEMerchantPortal\\ID\\banking.pdf");

            Thread.sleep(2400);
            webDriverUtil.clickElement(login.nextBtn);
        /*
           // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//            ////webDriverUtil.implicitWait(driver,120);
            Thread.sleep(10000);

            Thread.sleep(2400);
            ////webDriverUtil.implicitWait(driver, 30);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            //Thread.sleep(2400);

            //ChromeOptions optionsC = new ChromeOptions();
            Thread.sleep(5000);
            webDriverUtil.clickElement(login.openBankingCamDiv);
            Thread.sleep(5000);
            //optionsC.addArguments("profile.default_content_setting_values.media_stream_camera", "1");
            //optionsC.addArguments("--use-fake-ui-for-media-stream");

            Thread.sleep(800);
            webDriverUtil.clickElement(login.takeSelfie);
            //optionsC.addArguments("--use-fake-device-for-media-stream");

            Thread.sleep(1200);
            webDriverUtil.clickElement(login.confirmTakePhotoBtn);

            Thread.sleep(800);
            webDriverUtil.clickElement(login.nextBtn);

    //
    //        try {

    //          WebElement uploadButton = driver.findElement(By.xpath("//span[text()='Upload']"));
    //          System.out.println("uploadButton");

    //          uploadButton.click();
    //          WebElement fileInput = driver.findElement(By.id("banking.pdf']"));

    //         String filePath = "C://Users/Phaleitu/IdeaProjects/SMME Merchant Portal/ID/banking.pdf";
    //         fileInput.sendKeys(filePath);
    //         Thread.sleep(5000);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();

        }
          String uploadMethod = "upload";
            if (uploadMethod.equalsIgnoreCase("Upload")) {
                webDriverUtil.clickElement(login.uploadBanking);
                System.out.println("New Clicked upload by Itu");
                Thread.sleep(20000);
                //up.handleFileDialog("C://Users/Phaleitu/IdeaProjects/SMME Merchant Portal/ID/banking.pdf");  
            } else if (uploadMethod.equalsIgnoreCase("dragandDrop")) {
                webDriverUtil.clickElement(login.uploadBanking);
                System.out.println("New Clicked upload by Itu");
                Thread.sleep(20000);
                //dragDrop Method here
            } else if (uploadMethod.equalsIgnoreCase("openCamera")) {

                ChromeOptions optionsC = new ChromeOptions();
                Thread.sleep(1200);
                webDriverUtil.clickElement(login.openCamDiv);
                Thread.sleep(5000);
                optionsC.addArguments("profile.default_content_setting_values.media_stream_camera", "1");
                optionsC.addArguments("--use-fake-ui-for-media-stream");

                Thread.sleep(800);
                webDriverUtil.clickElement(login.takeSelfie);
                optionsC.addArguments("--use-fake-device-for-media-stream");

                Thread.sleep(1200);
                webDriverUtil.clickElement(login.confirmTakePhotoBtn);

                Thread.sleep(800);
                webDriverUtil.clickElement(login.nextBtn);


            }
            webDriverUtil.clickElement(login.uploadBanking);
            System.out.println("New Clicked upload by Itu");
            Thread.sleep(20000);
            //up.handleFileDialog("C://Users/Phaleitu/IdeaProjects/SMME Merchant Portal/ID/banking.pdf");
        */

        } else if (companytype.equalsIgnoreCase("NPO")) {

            if (idDocumentType.equalsIgnoreCase("smart card")) {

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

                //submit partnersID
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

            } else if (idDocumentType.equalsIgnoreCase("green card")) {

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

                //upload partner Id
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

//                ////webDriverUtil.implicitWait(driver, 30);
//                webDriverUtil.clickElement(login.selectIdType);
//                Thread.sleep(300);
//                ////webDriverUtil.implicitWait(driver, 20);
//                webDriverUtil.clickElement(login.passport);
//                webDriverUtil.clickElement(login.uploadIdType);
//
//                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//                webDriverUtil.clickElement(login.uploadPhoto);
//                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
//                webDriverUtil.clickElement(login.confirmPhoto);

            } else {
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

                //upload partners ID
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("ID/idd.jpeg");


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.resolutionLetter);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\Resolution.pdf");

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.uploadnpofund);
            up.handleFileDialog("ID/idd.jpeg");

        } else if (companytype.equalsIgnoreCase("Trust")) {

            if (idDocumentType.equalsIgnoreCase("smart card")) {

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

                //submit partnersID
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

            } else if (idDocumentType.equalsIgnoreCase("green card")) {

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

                //upload partner Id
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

            } else {
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

                //upload partners ID
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                //////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                //////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                //////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("ID/idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
            }

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("ID/banking.pdf");


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.trustResolutionLetter);
            up.handleFileDialog("ID/banking.pdf");

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.uploadtrustdeed);
            up.handleFileDialog("ID/banking.pdf");
        } else {

            if (idDocumentType.equalsIgnoreCase("smart card")) {

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

                //submit partnersID
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.smartCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

            } else if (idDocumentType.equalsIgnoreCase("green card")) {

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

                //upload partner Id
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.greenCard);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                webDriverUtil.clickElement(login.uploadIdType);

                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);

            } else {
                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID1);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);

                //upload partners ID
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.uploadID);

                ////webDriverUtil.implicitWait(driver, 30);
                webDriverUtil.clickElement(login.selectIdType);
                Thread.sleep(300);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.passport);
                ////webDriverUtil.implicitWait(driver, 20);
                webDriverUtil.clickElement(login.selectIdNo);
                webDriverUtil.clickElement(login.ID2);
                webDriverUtil.clickElement(login.uploadIdType);

                //upload front part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
                //upload back part
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                webDriverUtil.clickElement(login.uploadPhoto);
                up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\idd.jpeg");
                webDriverUtil.clickElement(login.confirmPhoto);
                webDriverUtil.clickElement(login.uploadID);
            }

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.uploadBanking);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");


            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ////webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(login.resolutionLetter);
            up.handleFileDialog("C:\\Users\\mutsl001\\Desktop\\banking.pdf");


        }

       // Thread.sleep(4000);
       // ////webDriverUtil.implicitWait(driver, 30);
       // webDriverUtil.clickElement(login.nextBtn);

    }

    public void submitMerchantDetails(String ownershipDetails, String firstName, String surName, String eMail,
                                      String mobileNo, String idType, String idNumber,String inputBusinessStreetName,String businessStreetName, String businessPostalCode, String businessSuburb, String businessTown, String businessProvince, String journey_name) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        //Thread.sleep(10000);
        webDriverUtil.waitUntilElementClickable(driver,login.ownershipDetails, 120);
        Thread.sleep(10000);
        webDriverUtil.clickElement(login.ownershipDetails);
        if (ownershipDetails.equalsIgnoreCase("Business owner/director")) {
            ////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessOwnerOption);

        } else if (ownershipDetails.equalsIgnoreCase("Assistant on behalf of the business owner/director")) {
            //////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.businessBehalfOption);
        }

        //////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.firstName, firstName);
        //////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.surName, surName);
        //////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.eMail, eMail);
        //////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.enterText(login.mobileNo, mobileNo);
        //////webDriverUtil.implicitWait(driver, 20);

        //////webDriverUtil.implicitWait(driver, 20);
        webDriverUtil.clickElement(login.idType);
        if (idType.equalsIgnoreCase("South African")) {
            //////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.idSAOption);
        } else if (idType.equalsIgnoreCase("Passport")) {
            //////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.idPassportOption);
        } else if (idType.equalsIgnoreCase("Refugee")) {
            ////webDriverUtil.implicitWait(driver, 20);
            webDriverUtil.clickElement(login.idRefugeeOption);
        } else {
            webDriverUtil.clickElement(login.idAsylumSeekerOption);
        }

        ////webDriverUtil.implicitWait(driver, 60);
        webDriverUtil.enterText(login.idNumber, idNumber);

        ////webDriverUtil.implicitWait(driver, 60);
        Actions act = new Actions(driver);
        ////webDriverUtil.implicitWait(driver, 60);
        webDriverUtil.enterText(login.inputBusinessStreetName, inputBusinessStreetName);

        webDriverUtil.implicitWait(driver, 24000);
        //Thread.sleep(12000);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        ///Uncomment for business if the function is working
        webDriverUtil.waitUntilElementClickable(driver,login.businessStreetName, 120);
        webDriverUtil.clickElement(login.businessStreetName);

        //webDriverUtil.enterText(login.businessStreetName, businessStreetName);
        Thread.sleep(800);
       // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
       // Thread.sleep(2400);
       // webDriverUtil.clickElement(login.businessAddressExpand);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriverUtil.implicitWait(driver, 60);
        webDriverUtil.waitUntilElementClickable(driver,login.businessPostalCode, 120);
        webDriverUtil.enterText(login.businessPostalCode, businessPostalCode);
        Thread.sleep(800);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(800);
        webDriverUtil.waitUntilElementClickable(driver,login.businessSuburb, 120);
        webDriverUtil.clickElement(login.businessSuburb);
        webDriverUtil.implicitWait(driver, 60);
        webDriverUtil.waitUntilElementClickable(driver,login.businessSuburbOption, 120);
        webDriverUtil.clickElement(login.businessSuburbOption);

        webDriverUtil.enterText(login.businessTown, businessTown);
        webDriverUtil.implicitWait(driver, 30);

        webDriverUtil.implicitWait(driver, 20);
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

        if(journey_name.equalsIgnoreCase("Device Activation"))
        {
            webDriverUtil.waitUntilElementClickable(driver,login.nextSubmitMerchantBtn, 120);
            //webDriverUtil.clickElement(login.checkoutBtn);
            webDriverUtil.clickElement(login.nextSubmitMerchantBtn);
        }else
        {
            webDriverUtil.waitUntilElementClickable(driver,login.checkoutBtn, 120);
            webDriverUtil.clickElement(login.checkoutBtn);
        }

        Thread.sleep(2400);

    }

    public Response submitMerchantDetailsSFConfirmation() throws Exception {
        // Create an instance of the RestClient
        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();
        String endpoint="https://vodapayapiqa.vodacom.co.za/cloud/public-services/financial-services/v1/smme/salesforce/token?isbeUser=true";
        Map<String,String> headers = new HashMap<>();
        headers.put("isbeUser","true");

        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.request(Method.GET, endpoint);

        return restInteractionPoint.get(headers, endpoint);

    }

    public void confirmCustomerPersonalDetails(String ownershipDetails, String firstName, String surName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        Thread.sleep(10000);
        //////webDriverUtil.implicitWait(driver, 18000);

       webDriverUtil.waitUntilElementClickable(driver,login.title_input, 120);
       webDriverUtil.clickElement(login.title_input);
       webDriverUtil.waitUntilElementClickable(driver,login.title_select, 120);
       webDriverUtil.clickElement(login.title_select);

       webDriverUtil.waitUntilElementClickable(driver,login.initials, 120);
       webDriverUtil.clickElement(login.initials);
       webDriverUtil.enterText(login.initials,extractInitials(firstName));

       Thread.sleep(1000);
       // Create an instance of JavascriptExecutor
       JavascriptExecutor js = (JavascriptExecutor) driver;

       // Scroll down by 1000 pixels
       js.executeScript("window.scrollBy(0, 1000)");
       Thread.sleep(1000);

       webDriverUtil.waitUntilElementClickable(driver,login.marital_status_input, 120);
       webDriverUtil.clickElement(login.marital_status_input);
       webDriverUtil.clickElement(login.marital_status_select);
       Thread.sleep(2000);
       webDriverUtil.waitUntilElementClickable(driver,login.confirmPersonaldetailsNext, 120);
       webDriverUtil.clickElement(login.confirmPersonaldetailsNext);
    }

   public void confirmCustomerBankingDetails(String bankName, String idNo, String account_number,String firstName, String surName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        Thread.sleep(10000);
        //////webDriverUtil.implicitWait(driver, 18000);

       //Run this code if kwika is selected and max not selected to input account holder name manually
       if((KwikaOnly && !ficaConfirmation) || assignDeviceActivation || runVPGCheck || runVPRCheck || tapOnPhone)
       {
           webDriverUtil.waitUntilElementClickable(driver,login.accountHolder_input, 120);
           webDriverUtil.enterText(login.accountHolder_input,firstName+" "+surName);
       }

       Actions actions = new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN).perform();

       Thread.sleep(4000);
       System.out.println("B Select Bank input w");
        webDriverUtil.waitUntilElementClickable(driver,login.bank_input, 120);
       System.out.println("A Select Bank input w");
       System.out.println("B Select Bank input");
        webDriverUtil.clickElement(login.bank_input);
       System.out.println("A Select Bank input");
       System.out.println("B Select Bank select w");
       Thread.sleep(2000);
        webDriverUtil.waitUntilElementClickable(driver,login.bank_select, 120);
       System.out.println("A Select Bank select w");
       System.out.println("B Select Bank select");
        webDriverUtil.clickElement(login.bank_select);
       System.out.println("A Select Bank select");

       Thread.sleep(2000);
       webDriverUtil.waitUntilElementClickable(driver,login.accountNumber_input, 120);
       webDriverUtil.clickElement(login.accountNumber_input);
       webDriverUtil.enterText(login.accountNumber_input,account_number);

       Thread.sleep(2000);
       webDriverUtil.waitUntilElementClickable(driver,login.accountType_input, 120);
       webDriverUtil.clickElement(login.accountType_input);
       Thread.sleep(2000);
       if(ficaConfirmation)
       {
           webDriverUtil.waitUntilElementClickable(driver,login.accountType_select, 120);
           webDriverUtil.clickElement(login.accountType_select);
       }else
       {
           webDriverUtil.waitUntilElementClickable(driver,login.accountType_select_kwikaOnly, 120);
           webDriverUtil.clickElement(login.accountType_select_kwikaOnly);
       }


        if(ficaConfirmation)
        {
            Thread.sleep(2000);
            webDriverUtil.waitUntilElementClickable(driver,login.bank_AccountOpenMonth_input, 120);
            webDriverUtil.clickElement(login.bank_AccountOpenMonth_input);
            Thread.sleep(2000);
            webDriverUtil.waitUntilElementClickable(driver,login.bank_AccountOpenMonth_select, 120);
            webDriverUtil.clickElement(login.bank_AccountOpenMonth_select);

            Thread.sleep(2000);
            webDriverUtil.waitUntilElementClickable(driver,login.bank_AccountOpenYear_input, 120);
            webDriverUtil.clickElement(login.bank_AccountOpenYear_input);
            Thread.sleep(2000);
            webDriverUtil.waitUntilElementClickable(driver,login.bank_AccountOpenYear_select, 120);
            webDriverUtil.clickElement(login.bank_AccountOpenYear_select);
        }

       Thread.sleep(2000);
       webDriverUtil.waitUntilElementClickable(driver,login.confirmBankingDetails_btn, 120);
       webDriverUtil.clickElement(login.confirmBankingDetails_btn);
       Thread.sleep(15000);
    }
   public String extractInitials(String firstName) {
        // Split the name into words
        String[] words = firstName.split(" ");

        // Initialize a StringBuilder to hold the initials
        StringBuilder initials = new StringBuilder();

        // Iterate over each word and append the first character to the initials
        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.charAt(0));
            }
        }

        return initials.toString().toUpperCase(); // Convert to uppercase if needed

    }
   public void tellAboutPartners() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        ////webDriverUtil.implicitWait(driver, 30);
        //webDriverUtil.clickElement(login.completeOrderBtn);
        ////webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.clickElement(login.completeSubmitBtn);
    }

   public void Logoff() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Logoff logoff = new Logoff(driver);

        ////webDriverUtil.implicitWait(driver, 60);
        //driver.quit();
        webDriverUtil.clickElement(logoff.Submitlogoff);
    }
    private String getCardExpireDate (String expireDate){
        switch (expireDate) {
            case "January":
                return "January";
            case "February":
                return "February";
            case "March":
                return "March";
            case "April":
                return "April";
            case "May":
                return "May";
            case "June":
                return "June";
            case "July":
                return "July";
            case "August":
                return "August";
            case "September":
                return "September";
            case "October":
                return "October";
            case "November":
                return "November";
            case "December":
                return "December";
            default:
                return "";
        }
    }

    private String getCardExpiryYear (String expireYear){
        switch (expireYear) {
            case "2021":
                return "2021";
            case "2022":
                return "2022";
            case "2023":
                return "2023";
            case "2024":
                return "2024";
            case "2025":
                return "2025";
            case "2026":
                return "2026";
            case "2027":
                return "2027";
            case "2028":
                return "2028";
            case "2029":
                return "2029";
            case "2030":
                return "2030";
            default:
                return "";
        }
    }


    private String getOwnershipDetails(String ownershipDetails) throws Exception {
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

    public void chooseDealer(String dealer,String userId,String password) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        Thread.sleep(6000);
        webDriverUtil.clickElement(login.selectDealerDrpdwn);
        if (dealer.equalsIgnoreCase("Makro")) {
            webDriverUtil.implicitWait(driver, 05);
            webDriverUtil.waitUntilElementClickable(driver,login.makroDrpdwnOption, 120);
            webDriverUtil.clickElement(login.makroDrpdwnOption);
            ////webDriverUtil.implicitWait(driver, 05);

         } else if (dealer.equalsIgnoreCase("Game")) {
            ////webDriverUtil.implicitWait(driver, 05);
            webDriverUtil.waitUntilElementClickable(driver,login.gameDrpdwnOption, 120);
            webDriverUtil.clickElement(login.gameDrpdwnOption);

         } else if (dealer.equalsIgnoreCase("One Source Direct")) {
           // webDriverUtil.clickElement(login.selectDealerDrpdwn);
            ////webDriverUtil.implicitWait(driver, 05);
            webDriverUtil.clickElement(login.oneSourceDirectOption);


        } else if (dealer.equalsIgnoreCase("SMME Onboarding")) {
        //webDriverUtil.clickElement(login.selectDealerDrpdwn);
        ////webDriverUtil.implicitWait(driver, 05);
        webDriverUtil.clickElement(login.smmeOnboardingOption);

        } else if (dealer.equalsIgnoreCase("Vodacom Store Agent")) {
        //webDriverUtil.clickElement(login.selectDealerDrpdwn);
        ////webDriverUtil.implicitWait(driver, 60);
        Thread.sleep(2400);
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"float-label\"]/div/div/div[2]/div[5]"));
        Thread.sleep(2400);

        // Scroll to the target element using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
        Thread.sleep(1200);
        webDriverUtil.clickElement(login.vodacomStoreAgentOption);

    }
        webDriverUtil.enterText(login.thirdPartyId, userId);
        webDriverUtil.implicitWait(driver, 30);
        webDriverUtil.enterText(login.makroPassword, password);
        webDriverUtil.implicitWait(driver, 30);
        Thread.sleep(5000);
        webDriverUtil.clickElement(login.brk_loginBtn);
        ////webDriverUtil.implicitWait(driver, 30);
    }

    public void selectPayment(String onceNameOnCard, String onceCardNo,
                                  String onceExpireYear, String onceExpiryDate, String onceCvv) throws Exception {

        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        CardDetailsPom cardDetailsPom = new CardDetailsPom(driver);

        String ozowUserName = "dev@i-pay.co.za";
        String ozowUserPassword = "T3mpP@ssw0rd";
        String ozowOTP = "12345";



            //Card details to be populated
            Thread.sleep(300);
            //webDriverUtil.implicitWait(driver, 30);
/*            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", cardDetailsPom.oncecardSelected);
            JavascriptExecutor jsa = (JavascriptExecutor) driver;
            jsa.executeScript("arguments[0].click()", cardDetailsPom.OncepaymentSubmit);*/

            //Thread.sleep(300);
            webDriverUtil.waitUntilElementClickable(driver,cardDetailsPom.onceNameOnCard, 120);
            webDriverUtil.implicitWait(driver, 50);
            webDriverUtil.enterText(cardDetailsPom.onceNameOnCard, onceNameOnCard);
            //Thread.sleep(300);
            webDriverUtil.implicitWait(driver, 50);
            webDriverUtil.enterText(cardDetailsPom.onceCardNo_ten, onceCardNo);
            //Thread.sleep(300);
            webDriverUtil.implicitWait(driver, 50);
            webDriverUtil.selectByVisibleText(cardDetailsPom.onceExpireYear, getCardExpiryYear(onceExpireYear));
            //Thread.sleep(300);
            webDriverUtil.implicitWait(driver, 50);
            webDriverUtil.selectByVisibleText(cardDetailsPom.onceExpiryDate_ten, getCardExpireDate(onceExpiryDate));
            webDriverUtil.enterText(cardDetailsPom.onceCvv, onceCvv);
            Thread.sleep(300);
            //webDriverUtil.implicitWait(driver, 30);
            JavascriptExecutor jsS = (JavascriptExecutor) driver;
            Thread.sleep(1000);


            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.tradePaymentSubmit);
            //webDriverUtil.implicitWait(driver, 30);
            //webDriverUtil.clickElement(cardDetailsPom.ozowOptionSubmit);

/*            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.ozowOptionSubmit);
            Thread.sleep(300);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.ozowDemoBankOption);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(cardDetailsPom.ozowUserName, ozowUserName);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(cardDetailsPom.ozowUserPassword, ozowUserPassword);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.ozowCredentialSubmit);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.enterText(cardDetailsPom.ozowOTP, ozowOTP);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.ozowPayOptionContinueBtn);             //jsa.executeScript("arguments[0].click()", transactionsPom.ozowOption);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.ozowPayOption);
            //webDriverUtil.implicitWait(driver, 30);
            webDriverUtil.clickElement(cardDetailsPom.ozowPayOptionContinueBtn); */            //jsa.executeScript("arguments[0].click()", transactionsPom.ozowOption);
            Thread.sleep(3000);

    }

    public void populateOnce3DSecure(String threeDPassword, String cardType, String bankName) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        CardDetailsPom transactionsPom = new CardDetailsPom(driver);
        if (cardType.equalsIgnoreCase("virtual")) {
            System.out.println("This is a virtual card, no 3D secured required");
            Thread.sleep(4500);
        } else {
            if (bankName.equalsIgnoreCase("Nedbank Debit")) {
                Thread.sleep(4000);
                webDriverUtil.clickElement(transactionsPom.ecomNedbankContinue);
                Thread.sleep(2400);
                System.out.println("Nedbank Continue Button Submitted");


            } else {
                if (bankName.equalsIgnoreCase("Nedbank Credit")) {
                    //webDriverUtil.implicitWait(driver, 35);
                    //webDriverUtil.clickElement(transactionsPom.mRecNedbankContinue);
                    Thread.sleep(300);
                    //webDriverUtil.implicitWait(driver, 20);
                    webDriverUtil.clickElement(transactionsPom.nedConfirm);
                    Thread.sleep(300);
                    //webDriverUtil.implicitWait(driver, 60);
                    webDriverUtil.clickElement(transactionsPom.mRecNedbankContinue);

                } else {
                    if (bankName.equalsIgnoreCase("Absa")) {
                        Thread.sleep(300);
                        //webDriverUtil.implicitWait(driver, 20);
                        webDriverUtil.enterText(transactionsPom.threeDPassword, threeDPassword);
                        //webDriverUtil.implicitWait(driver, 20);
                        Thread.sleep(300);
                        webDriverUtil.clickElement(transactionsPom.submit);
                    } else {
                        if (bankName.equalsIgnoreCase("Amexcard")) {
                            Thread.sleep(300);
                            //webDriverUtil.implicitWait(driver, 20);
                            webDriverUtil.clickElement(transactionsPom.nedConfirm);
                        } else {
                            if (bankName.equalsIgnoreCase("RCS")) {
                                Thread.sleep(300);
                                //webDriverUtil.implicitWait(driver, 20);
                                System.out.println("This is RCS Card Payment No 3Ds required.");
                                //webDriverUtil.clickElement(transactionsPom.nedConfirm);
                            } else {
                                //webDriverUtil.implicitWait(driver, 20);
                                Thread.sleep(300);
                                webDriverUtil.enterText(transactionsPom.threeDPassword, threeDPassword);
                                Thread.sleep(300);
                                //webDriverUtil.implicitWait(driver, 20);
                                webDriverUtil.clickElement(transactionsPom.submit);

                            }
                        }
                    }
                }
            }
        }
        ///Close 3D tab
    }

    public void closeThreeDtab() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    public void checkPaymentStatus() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        webDriverUtil.implicitWait(driver, 20);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        webDriverUtil.implicitWait(driver, 20);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        webDriverUtil.implicitWait(driver, 20);
        Thread.sleep(2000);
        webDriverUtil.clickElement(login.checkPaymentStatusBtn);
        webDriverUtil.implicitWait(driver, 20);
    }

    public static String getMonthNumber(String month) {
        switch (month) {
            case "January":
                return "01";
            case "February":
                return "02";
            case "March":
                return "03";
            case "April":
                return "04";
            case "May":
                return "05";
            case "June":
                return "06";
            case "July":
                return "07";
            case "August":
                return "08";
            case "September":
                return "09";
            case "October":
                return "10";
            case "November":
                return "11";
            case "December":
                return "12";
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    public void submitbarcodeInformation(String barcodeNumber) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        webDriverUtil.waitUntilElementClickable(driver,login.selectBarcode_btn, 120);
        webDriverUtil.clickElement(login.selectBarcode_btn);

        webDriverUtil.waitUntilElementClickable(driver,login.enterbarcode_input, 120);
        System.out.println(barcodeNumber);
        System.out.println("barcode");
        Thread.sleep(2000);
        webDriverUtil.enterText(login.enterbarcode_input,barcodeNumber);

        webDriverUtil.waitUntilElementClickable(driver,login.enterbarcode_input_confirm, 120);
        Thread.sleep(2000);
        webDriverUtil.enterText(login.enterbarcode_input_confirm,barcodeNumber);

        webDriverUtil.waitUntilElementClickable(driver,login.barcode_submit_btn, 120);
        webDriverUtil.clickElement(login.barcode_submit_btn);


    }

    public void deviceAssignName(String firstname) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);
        assignDeviceActivation =true;
        Thread.sleep(5000);
        // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(1000);

        webDriverUtil.waitUntilElementClickable(driver,login.card_machine_name_input, 120);
        webDriverUtil.enterText(login.card_machine_name_input,firstname+" device");

        webDriverUtil.waitUntilElementClickable(driver,login.assignDevice_btn, 120);
        webDriverUtil.clickElement(login.assignDevice_btn);
    }

    public void acccessDeviceActivationPage() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.waitUntilElementClickable(driver,login.deviceActivationLandingPage, 120);
        webDriverUtil.clickElement(login.deviceActivationLandingPage);

    }

}