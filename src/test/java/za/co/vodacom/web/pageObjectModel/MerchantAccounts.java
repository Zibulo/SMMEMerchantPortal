package za.co.vodacom.web.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantAccounts {
    public MerchantAccounts(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="merchantId")
    public WebElement merchantId;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="//span[@automationid=\"Revamp_Choose_Solution_Carousel_Card_Vodapay_Chop_Chop_Plus\" and contains(@class, \"icon-add-utility\")]")  //*[@id="carousel"]/div[1]/section/div/div/span[2]
    public WebElement addPosoption;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div/span")
    public WebElement ownershipDetails;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[1]")
    public WebElement businessOwnerOption;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[2]")
    public WebElement businessBehalfOption;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[1]")
    public WebElement idSAOption;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[2]")
    public WebElement idPassportOption;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[3]")
    public WebElement idRefugeeOption;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[4]")
    public WebElement idAsylumSeekerOption;

    @FindBy(name="name")
    public WebElement firstName;

    @FindBy(name="surname")
    public WebElement surName;

    @FindBy(name="emailAddress")
    public WebElement eMail;

    @FindBy(name="mobileNumber")
    public WebElement mobileNo;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div/span") //*[@id="float-label"]/div/div/div[1]/input
    public WebElement idType;
    @FindBy(name="idNumber")
    public WebElement idNumber;
    @FindBy(xpath="//button[@automationid='Revamp_Footer_Proceed to checkout_Button']")
    public WebElement checkoutProceedBtn;
    @FindBy(xpath="//button[@automationid='Revamp_Footer_Complete application_Button']")
    public WebElement completeOrderBtn;
    @FindBy(xpath="//button[@automationid='Revamp_Order_Summary_Confirm_Submission_Submit_Button']")
    public WebElement completeSubmitBtn;
    @FindBy(xpath="//input[@automationid='Revamp_Your_Details_Business_Address_Street_Address']")
    public WebElement businessStreetName;
    @FindBy(xpath="//input[@name='address.postalCode']")
    public WebElement businessPostalCode;
    @FindBy(xpath="//input[@automationid='Revamp_Your_Details_Business_Address_Suburb']")
    public WebElement businessSuburb;
    @FindBy(xpath="//*[@id='float-label']/div/div/div/span")
    public WebElement businessSuburbInput;
    @FindBy(xpath="//*[@id='float-label']/div/div/div[2]/div[1]")
    public WebElement businessSuburbOption;
    @FindBy(xpath="//input[@name='address.city']")
    public WebElement businessTown;
    @FindBy(xpath="//input[@automationid='Revamp_Your_Details_Business_Address_Province']")
    public WebElement businessProvince;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[1]")
    public WebElement businessProvEasternCape;
    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[2]")
    public WebElement businessProvFreeState;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[3]")
    public WebElement businessProvGauteng;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[4]")
    public WebElement businessKwaZulu;
    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[5]")
    public WebElement businessProvLimpopo;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[6]")
    public WebElement businessProvMpumalanga;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[7]")
    public WebElement businessProvNorthCape;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[8]")
    public WebElement businessProvNorthWest;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[9]")  //*[@id="float-label"]/div/div/div[2]/div[9]
    public WebElement businessProvWesternCape;
    @FindBy(xpath="//input[@automationid='Revamp_Your_Details_Business_Address_Street_Address']")
    public WebElement businessAddress;

    @FindBy(xpath="//button[@automationid='Revamp_Footer_Checkout_Button']")
    public WebElement checkoutBtn;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/section/div[1]/form/div[2]/div/div[9]/div/div/div[2]/div")
    public WebElement businessAddressExpand;


    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginSubmit;

    @FindBy(xpath="")
    public WebElement logout;

    @FindBy(xpath="")
    public WebElement merchantWeb;

}
