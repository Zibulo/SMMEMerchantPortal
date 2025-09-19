package za.co.vodacom.web.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoff {

    public Logoff(WebDriver driver) {PageFactory.initElements(driver,this);}

    @FindBy(xpath ="//*[@id=\"root\"]/div/div[2]/div/aside/ul/li[8]/a")
    public WebElement Submitlogoff;
}
