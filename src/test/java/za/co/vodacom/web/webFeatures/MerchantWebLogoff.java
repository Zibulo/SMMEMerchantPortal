package za.co.vodacom.web.webFeatures;

import org.openqa.selenium.WebDriver;
import vfs.automation.core.utilities.SystemUtilities;
import vfs.automation.core.utilities.WebDriverUtilities;
import za.co.vodacom.web.pageObjectModel.Login;
import za.co.vodacom.web.pageObjectModel.Logoff;

public class MerchantWebLogoff extends SystemUtilities {

    WebDriver driver;

    public MerchantWebLogoff(WebDriver driver) {this.driver = driver;}

    public void Logoff() throws Exception {
        WebDriverUtilities webDriverUtil = new WebDriverUtilities();
        Logoff logoff = new Logoff(driver);

        webDriverUtil.clickElement(logoff.logout);
    }

}
