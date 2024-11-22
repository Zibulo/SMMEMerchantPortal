package za.co.vodacom.commonMethods;

import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonMethods {



    public String getPaymentRequestLink() throws Exception {

        Thread.sleep(3600);
        String apikey = "6XMpUegGfXfIspPgnYn2ER4rmqdHvyeZ";
        String serverid = "i7wbi0dc";
        //String server_domain = "fire-add@n9ftmnyu.mailosaur.net";

        MailosaurClient maialosaur = new MailosaurClient(apikey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverid);
        SearchCriteria criteria = new SearchCriteria();
        criteria.withSubject("Make your payment using the VodaPay Payment Gateway");
        Message msg = maialosaur.messages().get(params, criteria);
        System.out.println("Sucessfully connected to Mailosaur Application");
        Thread.sleep(10000);
        String msgbody = msg.text().body();
        System.out.println("This is the message returned\n" + msgbody);

        String regex = "https://uat[\\w.-]+(:\\d+)?(/[^\\s.]+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(msgbody);
        if (matcher.find()) {
            String url = matcher.group();
            System.out.println("Expected URL: " + url);
            return url;
        } else {
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

    public String getEmailrefNo() throws Exception {

        Thread.sleep(15000);
        String apikey = "6XMpUegGfXfIspPgnYn2ER4rmqdHvyeZ";
        String serverid = "i7wbi0dc";
        String server_domain = "fire-add@n9ftmnyu.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apikey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverid);

        Thread.sleep(1200);
        SearchCriteria criteria = new SearchCriteria();

        Thread.sleep(1200);
        criteria.withSubject("Sandbox: Continue Application");
        Message msg = mailosaur.messages().get(params, criteria);

        Thread.sleep(2400);
        String msgbody = msg.text().body();
        System.out.println("This is the message returned\n" + msgbody);

        // Search for the desired string
        String searchString = "Reference number:";
        String referenceNumber = null;
        if (msgbody.contains(searchString)) {
            System.out.println("looping inside the converted body...");
            int index = msgbody.indexOf("Reference number: ") + 18;
            referenceNumber = msgbody.substring(index);
            //System.out.println("String found!" + referenceNumber);
        } else {
            System.out.println("String not found!");
        }
        referenceNumber = getFirstTenCharacters(referenceNumber);
        return referenceNumber;
    }

    public void deleteMsg() throws Exception {

        Thread.sleep(200);
        String apikey = "6XMpUegGfXfIspPgnYn2ER4rmqdHvyeZ";
        String serverid = "i7wbi0dc";
        String server_domain = "fire-add@n9ftmnyu.mailosaur.net";
        MailosaurClient mailosaur = new MailosaurClient(apikey);

        // Delete all messages from the specified inbox
        mailosaur.messages().deleteAll("i7wbi0dc");
        System.out.println("All messages deleted successfully.");

    }

    public String getEmailContinueOTP() throws Exception {

        Thread.sleep(20000);
        String apikey = "6XMpUegGfXfIspPgnYn2ER4rmqdHvyeZ";
        String serverid = "i7wbi0dc";
        //String server_domain = "fire-add@n9ftmnyu.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apikey);
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverid);
        Thread.sleep(1200);
        SearchCriteria criteria = new SearchCriteria();

        Thread.sleep(1200);
        criteria.withSubject("Sandbox: OTP");
        Message msg = mailosaur.messages().get(params, criteria);

        Thread.sleep(3600);
        String msgbody = msg.text().body();
        System.out.println("This is OTP message body\n" + msgbody);

        // Search for the desired string
        String searchString = "Your One Time Pin";
        String oTPNo = null;
        if (msgbody.contains(searchString)) {
            int index = msgbody.indexOf("Your One Time Pin is (OTP):") + 27;
            oTPNo = msgbody.substring(index);
            System.out.println("String found!" + oTPNo);
        } else {
            System.out.println("String not found!");
        }
        return oTPNo;
    }

    public static String getFirstTenCharacters(String input) {
        // Trim the input to remove leading and trailing whitespace
        input = input.trim();
        // Return the first 10 characters or the full string if it's shorter
        return input.length() > 10 ? input.substring(0, 10) : input;
    }
}

