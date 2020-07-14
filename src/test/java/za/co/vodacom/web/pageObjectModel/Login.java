package za.co.vodacom.web.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="merchantId")
    public WebElement merchantId;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginSubmit;

    @FindBy(xpath="")
    public WebElement logout;

    //@FindBy(xpath="//*[@class='has-text-danger']")
   // public WebElement errorMessage;

    @FindBy(xpath="")
    public WebElement merchantWeb;

}
