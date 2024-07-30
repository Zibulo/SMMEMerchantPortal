package za.co.vodacom.web.webFeatures;

import org.openqa.selenium.WebDriver;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.web.pageObjectModel.Login;


public class ThirdPartyLogin1 extends SystemUtilities {
    public WebDriver driver;

    public ThirdPartyLogin1(WebDriver driver) {

        this.driver = driver;
    }

    public void thirdPartyLandingPage(String landingPage) throws Exception {

        driver.get(getPropertyValue("Environment", landingPage));
        driver.manage().window().maximize();


    }

    public void enteredValidCredentials(String dealerId,String userId, String password) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();

        Login login = new Login(driver);

        webDriverUtil.clickElement(login.selectDealerDrpdwn);
        //webDriverUtil.implicitWait(driver, 05);
        webDriverUtil.clickElement(login.makroDrpdwnOption);
        //webDriverUtil.implicitWait(driver, 05);

        webDriverUtil.enterText(login.userId, userId);
        //webDriverUtil.implicitWait(driver, 05);
        webDriverUtil.enterText(login.makroPassword, password);
        webDriverUtil.clickElement(login.brk_loginBtn);
        //webDriverUtil.implicitWait(driver, 05);

    }
}
