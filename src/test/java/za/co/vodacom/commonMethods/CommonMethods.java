package za.co.vodacom.commonMethods;

import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;


public class CommonMethods {

    public String getPaymentRequestLink() throws Exception{

        Thread.sleep(3600);
        String apikey = "mAlUb1vW2pkUn8AmGhwrxP5ef3os2gqL";
        String serverid = "2mk3aglp";
        String server_domain = "2mk3aglp.mailosaur.net";

        MailosaurClient maialosaur = new MailosaurClient(apikey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverid);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSubject("Make your payment using the VodaPay Payment Gateway");
        Message msg = maialosaur.messages().get(params,criteria);
        System.out.println("Sucessfully connected to Mailosaur Application");
        Thread.sleep(10000);
        String msgbody = msg.text().body();
        System.out.println("This is the message returned\n"+msgbody);

        String regex = "https://uat[\\w\\.-]+(:\\d+)?(/[^\\s\\.]+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(msgbody);
        if(matcher.find()){
            String url = matcher.group();
            System.out.println("Expected URL: "+url);
            return url;
        }
        else{
            System.out.println("URL Not Found");
            return null;
        }
    }

    public String openLinkInNewTab(String url, WebDriver driver) {
        // Open a new empty tab
        // Cast driver to JavascriptExecutor
         JavascriptExecutor js = (JavascriptExecutor) driver;
        // Open a new tab using JavaScript
         js.executeScript("window.open()");

        // Get the current window handles
        Set<String> windowsHandleIDs = driver.getWindowHandles();
        Iterator<String> itr = windowsHandleIDs.iterator();

        // Iterate through the handles and switch to the new tab
        String parentWindow = itr.next();
        String newTab = itr.next();

        driver.switchTo().window(newTab);

        // Navigate to the provided URL in the new tab
        driver.get(url);
        return parentWindow;

        // If needed, you can switch back to the parent window later
        // driver.switchTo().window(parentWindow);
    }

}
