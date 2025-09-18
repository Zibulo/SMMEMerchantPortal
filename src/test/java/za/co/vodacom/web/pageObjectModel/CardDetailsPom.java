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

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[4]/div/div/div[1]/div[2]/div/div/div/button")
    public WebElement tradePaymentSubmit;

    @FindBy(xpath = "//*[@id='reskin-content']/div[3]/div/div/div[2]/div/div[2]/div/div/div/input")
    public WebElement ozowOTP;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/div[3]/div[1]/div[2]/p")
    public WebElement paymentmethod_btn;

    @FindBy(xpath="//button[contains(text(),'Continue')]")
    public WebElement paymentmethod_continue_btn;

    @FindBy(xpath = "//*[@id='NewCard_NameOnCard']")
    public WebElement onceCardHolder;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/main/article/section/form/div/div/div[1]/button")
    public WebElement bankName;



    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div/div/div[5]/div[2]/div/input")
    public WebElement openDate;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div/div/section/section/label")
    public WebElement proofOfBank;

    @FindBy(xpath ="//*[@id=\"root\"]/div/div/main/main/article/section/form/div/div/div[3]/input")
    public WebElement accountNo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div/div/select[1]/option[2]")
    public WebElement nedBankSelection;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div/div/div[5]/section/button[2]")
    public WebElement nextBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div/div/div[2]/section/button[2]")
    public WebElement nextBtn3;
    @FindBy(xpath="//p[text()='Proof of banking upload']")
    public WebElement proofText;
    @FindBy(xpath = " //*[@id=\"root\"]/div/main/main/article/section/form/div/div/div[6]/section/button[2]")
    public WebElement nextBtn2;


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div/div/select[2]/option[1]")
    public WebElement typeSelection;

    @FindBy(xpath = "//*[@id='nameOfCard']")
    public WebElement VPG_onceCardHolder;

    @FindBy(xpath = "//*[@id=\"CARD_NUMBER\"]")
    public WebElement onceCardNo;
    //*[@id="CARD_NUMBER"]

    @FindBy(xpath = "//*[@id=\"CARD_NUMBER\"]")
    public WebElement onceCardNo_ten;

    @FindBy(xpath="//*[@id='cardExpiryYear']")
    public WebElement onceCardExpiry;
    @FindBy(xpath ="//*[@id=\"CVV\"]")
    public WebElement onceCvv;

    @FindBy(xpath ="//*[@id=\"NewCard_Cvv\"]")
    public WebElement new_onceCvv;

    @FindBy(xpath = "//*[@id=\"EXPIRY_YEAR\"]")
    public WebElement onceExpireYear;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div[3]/div[1]/div/button")
    public WebElement OncepaymentSubmit;

    @FindBy(xpath = "//*[@id=\"CARD_HOLDER_NAME\"]")
    public WebElement onceNameOnCard;

    //*[@id="CARD_HOLDER_NAME\]
    @FindBy(xpath = "//*[@id=\"EXPIRY_MONTH\"]")
    public WebElement onceExpiryDate;

    @FindBy(xpath = "//*[@id=\"EXPIRY_MONTH\"]")
    public WebElement onceExpiryDate_ten;

    @FindBy(xpath = "//*[@id=\"EXPIRY_MONTH\"]")
    public WebElement onceExpireMonth;
      @FindBy(xpath = "//*[@id=\"EXPIRY_YEAR\"]")
     public WebElement onceExpiryYear;

    //*[@id="EXPIRY_YEAR"]


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
