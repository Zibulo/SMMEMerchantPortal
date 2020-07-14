package za.co.vodacom.web.webFeatures;

import org.openqa.selenium.WebDriver;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.web.pageObjectModel.Login;

public class MerchantWebLogin extends SystemUtilities{

     WebDriver driver;

    public MerchantWebLogin(WebDriver driver) {
        this.driver = driver;
    }


    public void populateCredentials(String merchantId,String password) throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Login login = new Login(driver);

        webDriverUtil.enterText(login.merchantId, merchantId);
        webDriverUtil.implicitWait(driver, 05);
        webDriverUtil.enterText(login.password, password);
        webDriverUtil.clickElement(login.loginSubmit);

    }
}
