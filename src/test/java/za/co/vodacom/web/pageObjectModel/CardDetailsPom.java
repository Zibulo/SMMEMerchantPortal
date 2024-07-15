package za.co.vodacom.web.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetailsPom {


    private final WebDriver driver;

    public CardDetailsPom(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]")
    public WebElement saveCardSelected;
    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[1]/h3")
    public WebElement selectPaymentMethod;
    @FindBy(xpath = "//*[@id=\"nextForm\"]/h1")
    public WebElement AuthenticateNedbank;

    @FindBy(xpath = "//*[@id=\"authform\"]/div/h1")
    public WebElement AuthenticateAbsa;

    @FindBy(xpath = "//*[@id='singlePaymentBtn']")
    public WebElement singlePayment;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[2]")
    public WebElement saveCard1;


    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/div/button")
    public WebElement saveCard1BtnContinue;

    @FindBy(xpath = "//*[text()='Credit / debit card']//parent::div")
    public WebElement oncecardSelected;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[4]")
    public WebElement QRCodeOption;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/div/button")
    public WebElement QRCodeContinueBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/div/button")
    public WebElement QRCodePayBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[2]/p")
    public WebElement splitSavedCard1;

    @FindBy(xpath = "//*[@id='page-method-id-0']/div[4]/div[1]/input")
    public WebElement splitAmount1;

    @FindBy(xpath = "//*[@id='page-method-id-0']/div[4]/div[2]/input")
    public WebElement splitCard1Cvv;

    @FindBy(xpath = "//*[@id='page-method-id-0']/div[4]/div[4]/span[2]")
    public WebElement splitCard1SaveButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[3]/div[2]/div[1]/div[4]/div[2]/p")
    public WebElement splitSavedCard2;

    @FindBy(xpath = "//*[@id='page-method-id-1']/div[4]/div[1]/input")
    public WebElement splitAmount2;

    @FindBy(xpath = "//*[@id='page-method-id-1']/div[4]/div[2]/input")
    public WebElement splitCard2Cvv;

    @FindBy(xpath = "//*[@id='page-method-id-1']/div[4]/div[4]/span[2]")
    public WebElement splitCard2SaveButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/div[1]/span")
    public WebElement splitCard1RemoveOption;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/btn")
    public WebElement splitCard1RemoveBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/div/button[2]")
    public WebElement savedCardsContinuBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[2]/div[1]") ///html/body/div/div[2]/div[1]/div/div[2]/div[1]
    public WebElement singlePaymentSelected;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[3]/div") ///html/body/div/div[2]/div[1]/div/div[2]/div[1]
    public WebElement recurringPaymentSelected;

    @FindBy(xpath = "//*[@id='splitPaymentBtn']")
    public WebElement splitPaymentSelected;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/div[2]/p")  //html/body/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/div[2]/p
    public WebElement ozowOption;
    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/div/button")
    public WebElement ozowOptionSubmit;
    @FindBy(xpath = "//*[@id='reskin-content']/div[3]/div/div/div[5]/div[1]")
    public WebElement ozowDemoBankOption;
    @FindBy(xpath = "//*[@id='reskin-content']/div[3]/div/div/div[2]/div[3]/div[1]/div/div/input")
    public WebElement ozowUserName;

    @FindBy(xpath = "//*[@id='reskin-content']/div[3]/div/div/div[2]/div[3]/div[2]/div/div/input") //*[@id="dynamic-display-form"]/div[2]/div[2]/input
    public WebElement ozowUserPassword;
    @FindBy(xpath = "//*[@id='next-button']")
    public WebElement ozowCredentialSubmit;
    @FindBy(xpath = "//*[@id='radio-group-selectedAccount']/label[2]")
    public WebElement ozowPayOption;
    @FindBy(xpath = "//*[@id='next-button']")
    public WebElement ozowPayOptionContinueBtn;
    @FindBy(xpath = "//*[@id='reskin-content']/div[3]/div/div/div[2]/div/div[2]/div/div/div/input")
    public WebElement ozowOTP;
    @FindBy(xpath = "//*[@id='NewCard_NameOnCard']")
    public WebElement onceCardHolder;

    @FindBy(xpath = "//*[@id='NewCard_CardNumber']")
    public WebElement onceCardNo;

    @FindBy(xpath="//*[@id='cardExpiryYear']")
    public WebElement onceCardExpiry;
    @FindBy(xpath ="//*[@id=\"NewCard_ExpiryDate\"]")
    public WebElement onceCvv;

    @FindBy(xpath = "//*[@id='cardExpiryYear']")
    public WebElement onceExpireYear;

    @FindBy(xpath = "//*[@id='NewCard_ExpiryDate']")
    public WebElement onceExpiryDate;
    @FindBy(xpath = "//*[@id='SubmitButton']")
    public WebElement onceNewPayButton;
    @FindBy(xpath = "//*[@id='saveCardCheckbox']")
    public WebElement saveCardCheck;
    @FindBy(xpath = "//*[@id='cardAlias']")
    public WebElement onceCardDescript;

    @FindBy(name = "password")
    public WebElement threeDSecurePassword;

    @FindBy(xpath = "//*[@id='btnContinue']")
    public WebElement nedConfirm;

    @FindBy(xpath = "//*[@id='code']")
    public WebElement threeDPassword;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(xpath = "//*[@id='btn_confirm']") //*[@id="btn_confirm"]
    public WebElement ecomNedbankContinue;

    @FindBy(xpath = "//*[@id='btnContinue']")
    public WebElement mRecNedbankContinue;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td/table/tbody/tr[11]/td[2]")
    public WebElement recurringResponseMessage;

    @FindBy(xpath = "/html/body/div/div[2]/div/h1")
    public WebElement immediateResponseMessage;


















}
