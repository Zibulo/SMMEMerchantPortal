package za.co.vodacom.web.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="merchantId")
    public WebElement merchantId;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Chop_Chop_Plus']")
    public WebElement addPosOptionChopChop;


    @FindBy(xpath= "//*[@id=\"root\"]/main/div/main/section/article/div/article/section[3]/section/button/span[2]")
    public WebElement addPosOptionKwika;

    @FindBy(xpath= "//button[@data-automationid='undefined_Plus']")
    public WebElement addMoreProducts;

    @FindBy(xpath= "//h3/button[contains(text(),'Rent')]/ancestor::*[2]")
    public WebElement rentSection;

    @FindBy(xpath= "//h3/button[contains(text(),'Buy')]/ancestor::*[2]")
    public WebElement buySection;

    @FindBy(xpath= "//button[@data-automationid='undefined_Plus'][2]")
    public WebElement addMoreProducts_two;

    @FindBy(xpath= "//*[@id='radix-53']/div/section/article[1]/section[1]/section/div/h2")
    public WebElement addMoreProductsText_one;

    @FindBy(xpath= "//*[@id='radix-53']/div/section/article[2]/section[1]/section/div/h2")
    public WebElement addMoreProductsText_two;

    @FindBy(xpath= "//*[@id='radix-53']/div/section/article/section[1]/section/div/h2")
    public WebElement addMoreProductsText;

    @FindBy(xpath= "//span[text()='Add to cart']")
    public WebElement addMaxToCart;

    @FindBy(xpath= "//label[@for='Rent']")
    public WebElement rent_rad;

    @FindBy(xpath= "//button[@id='Buy']")
    public WebElement buy_rad;

    @FindBy(xpath= "//*[@id='radix-9']/section/section[1]/button")
    public WebElement posCloseBtn;

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Max_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosOptionMax;

//    @FindBy(xpath="//*[@id=\"radix-:rm:\"]/button/svg")
//    public WebElement closeCart;

    @FindBy(css = "#radix-«rn» > button > svg")
    public WebElement closeCart;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/button/img")
    public WebElement tool;
    @FindBy(xpath = "//*[@id=\"radix-«r0»\"]/section/div[2]/form/ul/li[50]/label/p")
    public WebElement dev2;
    @FindBy(xpath = "//*[@id=\"radix-«r0»\"]/section/div[2]/form/ul/li[51]/label/p")
    public WebElement ni;
    @FindBy(xpath = "//*[@id=\"radix-«r0»\"]/section/div[2]/form/ul/li[47]/label")
    public WebElement niSelection;
    @FindBy(xpath ="//*[@id=\"radix-«r0»\"]/section/div[2]/form/div[2]/button[2]")
    public WebElement niSubmit;

   @FindBy(xpath="//div[contains(@class, 'ns-cart-container')]")
   public WebElement openCart;


     @FindBy(xpath=" //*[@id=\"root\"]/div/div[1]/div/section[1]/section/article/div/article/section[3]/section/button/span[2]")
    public WebElement addToCart;

    @FindBy(xpath="//button[text()='More VodaPay payment solutions']")
    public WebElement paymentSolution_btn;

    @FindBy(xpath=" //*[@id=\"radix-3\"]/div/div/div/div/div[1]/article")
    public WebElement posOptionMaxSelection;
    @FindBy(xpath="//*[@id='carousel']/div[4]/section/button")
    public WebElement addPosOptionPaymentGateway;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/section/form/section[3]/article/img[2]")
    public WebElement addPosOptionScrollBar;

    @FindBy(xpath="//*[@id='radix-4']")
    public WebElement moreVodaPosPaySolutions;
    @FindBy(xpath="//button[@type='button' and @class='sc-fHekdT fbFaKr']")
    public WebElement addPosOptionTapOnPhone;

    @FindBy(xpath="//*[@id=\"radix-3\"]/div/div[1]/div/div/div[3]/article/figure/img")
    public WebElement OptionTapOnPhone;

    @FindBy(xpath="//*[@id='radix-3']/div/div[1]/div/div/div[2]/article/figure/img")
    public WebElement OptionVodaPaymentGateway;

    @FindBy(xpath="//*[@id=\"radix-«ru»\"]/div/div[1]/div/div/div[1]/article/figcaption/p[1]")
    public WebElement Option_img1;

    @FindBy(xpath="//*[@id=\"radix-«ru»\"]/div/div[1]/div/div/div[2]/article/figcaption/p")
    public WebElement Option_img2;

    @FindBy(xpath="//*[@id=\"radix-«ru»\"]/div/div[1]/div/div/div[3]/article/figcaption/p[1]")
    public WebElement Option_img3;

    @FindBy(xpath="//*[@id=\"radix-«ru»\"]/div/div[1]/div/div/div[4]/article/figcaption/p[1]")
    public WebElement Option_img4;

    @FindBy(xpath="//*[@id=\"radix-«ru»\"]/div/div[1]/div/div/div[5]/article/figcaption/p[1]")
    public WebElement Option_img5;

 @FindBy(xpath = "//*[@id=\"radix-«ru»\"]/div/div[1]/div/div/div[6]/article/figcaption/p[1]")
 public WebElement Option_img6;

    //@FindBy(xpath="//*[@id=\"radix-:rt:\"]/div/div[2]/button[3]")
    @FindBy(xpath = "//*[@id=\"radix-«ru»\"]/div/div[2]/button[3]")
    public WebElement radio_solution_third;

    @FindBy(xpath ="//*[@id=\"radix-«ru»\"]/div/div[2]/button[4]")
    public WebElement radio_solution_fourth;

    @FindBy(xpath = "//*[@id=\"radix-«ru»\"]/div/div[2]/button[1]")
    public WebElement radio_solution_first;



 @FindBy(xpath = "//input[@type='text']")
 public WebElement input_number_threeD;

 @FindBy(xpath = "//input[@type='submit' and @value='Submit']")
 public WebElement submit_threeD;

    //*[@id="radix-3"]/div/div[1]/div/div/div[1]/article/figure/img
    @FindBy(xpath="//img[@alt='VodaPay Kwika']")
    public WebElement OptionKwika;

    @FindBy(tagName="img")
    public List<WebElement> solutionImages;

    @FindBy(xpath="//*[@id=\"carousel\"]/div[6]/section/button")
    public WebElement addPosOptionPayRequest;

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Max_2_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosoptionMax2;
    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Chop_Chop_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosoption;

   @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[1]/button")
   public WebElement ownershipDetails;
   @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/fieldset/div/label[2]/div")
   public WebElement registered_Type;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/fieldset/div/label[1]/div")
    public WebElement unregistered_Type;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[5]/div[4]/input")
    public WebElement regitrationNumber;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div/section/button[2]")
   public WebElement nextButton;

    @FindBy(xpath=" //*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/select[1]/option[1]")
    public WebElement businessOwnerOption;
    //*[@id="root"]/main/div/main/section/div[2]/div/form/div/div/div[1]/button/p
    //*[@id="root"]/div/div/main/main/article/section/form/div[1]/div/select[1]/option[1]

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[2]")
    public WebElement businessBehalfOption;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[2]/div/button")
    public WebElement title_input;


    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[2]/select/option[3]")
    public WebElement title_select;


    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[2]/select/option[1]")
    public WebElement mrOption;
    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[2]/select/option[2]")
    public WebElement mrsOption;
    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[2]/select/option[3]")
    public WebElement missOption;
    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[2]/select/option[4]")
    public WebElement drOption;


    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/button")
    public WebElement business_type_input;
    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[5]/select/option[1]")
    public WebElement close_corp_selection;
    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[5]/select/option[2]")
    public WebElement company_selection;


    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[2]/div[2]/input")
    public WebElement initials;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[4]/button")
    public WebElement marital_status_input;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/select[2]/option[2]")
    public WebElement marital_status_select;

    @FindBy(xpath="//button[contains(text(),'Next')]")
    public WebElement confirmPersonaldetailsNext;

    @FindBy(xpath="//input[@automationid='Revamp_Bank_Details_Account_Holder_Full_Name']")
    public WebElement accountHolder_input;

    @FindBy(xpath="//input[@automationid='Revamp_Bank_Details_Bank_Name']")
    public WebElement bank_input;

    @FindBy(xpath="//*[@id='float-label']/div/div/div[2]/div[2]")
    public WebElement bank_select;

    @FindBy(xpath="//input[@automationid='Revamp_Bank_Details_Account_Number']")
    public WebElement accountNumber_input;

    @FindBy(xpath="//div[automationid='undefined_Field_Item_Street_Current_Cheque_Account_undefined']")
    public WebElement accountNumber_select;

    @FindBy(xpath="//input[@automationid='Revamp_Bank_Details_Account_Type']")
    public WebElement accountType_input;

    @FindBy(xpath="/html/body/div[1]/div/div[1]/div/section[1]/article/div[2]/div/div/div/form/div[5]/div[1]/div/div/div[2]/div[1]")
    public WebElement accountType_select;

    @FindBy(xpath="//button[contains(text(), 'Enter barcode manually')]")
    public WebElement selectBarcode_btn;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/div[1]/form/div/input")
    public WebElement enterbarcode_input;  //*[@id="root"]/div/div/main/main/article/div[1]/form/div/input

    @FindBy(xpath="//input[@automationid='DA_Confirm_Barcode']")
    public WebElement enterbarcode_input_confirm;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/div[1]/form/button/p")
    public WebElement addbarcode;


    //*[@id="root"]/div/div/main/main/article/div[1]/form/button/p

    @FindBy(xpath="//button[contains(@class, 'ns-bg-red-600') and contains(@class, 'ns-text-white') and text()='Next']")
    public WebElement assignDevice_btn;

    @FindBy(xpath="//input[@id='cardMachines.0.name']")
    public WebElement card_machine_name_input;

    @FindBy(xpath="//span[contains(@class, 'content-normal') and contains(@class, 'font-bold') and text()='Register here']")
    public WebElement deviceActivationLandingPage;

    @FindBy(xpath="//button[contains(@class, 'dev-tools-button')]")
    public WebElement SMMEDevTool_btn;

    @FindBy(xpath="//input[@name='miniAppBuyOnlineJourney']")
    public WebElement miniAppBuyOnlineJourney_CB;

    @FindBy(xpath="//label[@for='proofOfLife']")
    public WebElement proofOfLife_input_CB;

    @FindBy(xpath="//button[contains(text(), 'Submit')]")
    public WebElement devTool_submit_btn;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/div[1]/div/section/button[2]")
    public WebElement barcode_submit_btn;

    @FindBy(xpath="//div[text()='Current Cheque Account']")
    public WebElement accountType_select_kwikaOnly;

    @FindBy(xpath="//input[@automationid='Revamp_Bank_Details_Bank_Account_Open_Since_Month']")
    public WebElement bank_AccountOpenMonth_input;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[1]")
    public WebElement bank_AccountOpenMonth_select;

    @FindBy(xpath="//input[@automationid='Revamp_Bank_Details_Bank_Account_Open_Since_Year']")
    public WebElement bank_AccountOpenYear_input;

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div[2]/div[1]")
    public WebElement bank_AccountOpenYear_select;

    @FindBy(xpath="//button[contains(text(),'Next')]")
    public WebElement confirmBankingDetails_btn;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/form/select/option[2]")
    public WebElement idSAOption;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/form/select/option[1]")
    public WebElement SAIDOption;




 @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/form/select/option[3]")
    public WebElement idPassportOption;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/form/select/option[4]")
    public WebElement idRefugeeOption;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/div/form/select/option[5]")
    public WebElement idAsylumSeekerOption;

   // @FindBy(name="name")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/article/section/form/div/div/div[1]/input")
    public WebElement firstName;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/article/section/form/div/div/div[2]/input")
    public WebElement surName;

    @FindBy(xpath="(//*[@id=\"float-label\"]/div/div/div[1]/input)")
    public WebElement ownershipdrpdwn;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/main/main/article/article/section/form/div/div/div[3]/input")
    public WebElement eMail;

    @FindBy(name="mobileNumber")
    public WebElement mobileNo;

    //@FindBy(xpath="//button[@data-automationid='Your_Details_Identity_Type']")
    @FindBy(xpath="//*[@id=\"root\"]/div[1]/main/div/div/form/div/button")
    public WebElement idType;


    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/main/article/section/form/div[1]/div/div[3]/input")
    public WebElement idNumber;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[4]/input")
    public WebElement IDNumber;


    @FindBy(xpath = "//*[@id=\"registeredName\"]")
    public WebElement businessName;

    //*[@id="root"]/div/main/main/article/section/form/div[1]/div/div[6]/div[2]/input
    @FindBy(xpath = "//*[@id=\"businessWebsiteURL\"]")
   public  WebElement businessUrl;
    @FindBy(xpath = "//*[@id=\"radix-«r2k»\"]")
    public WebElement businessCategry;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div[2]/section/button[2]")
    public WebElement nextButn;

    @FindBy(xpath="/html/body/div[5]/section/button") //Absolute xpath used to locate elements
    public WebElement checkoutProceedBtn;

    @FindBy(xpath="//*[@id=\"radix-«rn»\"]/section[3]/button") //Absolute xpath used to locate elements
    public WebElement solutionCheckoutProceedBtn;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/h3[1]") //Absolute xpath used to locate elements
    public WebElement paymentMethodVPG;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[1]/div/div/div[1]/section/button") //Absolute xpath used to locate elements
    public WebElement VPGVisaCard;
    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[1]/div/div/div[2]/section/button") //Absolute xpath used to locate elements
    public WebElement VPGamericanExpress;
    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[1]/div/div/div[3]/section/button") //Absolute xpath used to locate elements
    public WebElement VPG_qrCard;
    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[2]/button[2]") //Absolute xpath used to locate elements
    public WebElement VPG_second_radioBtn;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[1]/div/div/div[4]/section/button") //Absolute xpath used to locate elements
    public WebElement instant_ozow;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/h3[2]") //Absolute xpath used to locate elements
    public WebElement paymentMethodVPR;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[2]/div/div/div[1]/div/div/div[1]/section/button") //Absolute xpath used to locate elements
    public WebElement VPRVisaCard;


    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[1]/div/div/div[1]/section/button") //Absolute xpath used to locate elements
    public WebElement VPRVisaCard_falseVpg;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[1]/div/div/div[1]/div/div/div[2]/section/button") //Absolute xpath used to locate elements
    public WebElement instant_eft_falseVpg;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/main/article/div[2]/div/div/div[1]/div/div/div[2]/section/button") //Absolute xpath used to locate elements
    public WebElement VPRamericanExpress;

    @FindBy(xpath="//input[@type='checkbox' and @name='instantEFT.0']") //Absolute xpath used to locate elements
    public WebElement ozow;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[2]/div/div[1]/div[2]/button") //Absolute xpath used to locate elements
    public WebElement Vpgvpt_proceedBtn;

    @FindBy(xpath="//button[normalize-space(text())='Continue to payment']")
    public WebElement orderContinueBtn;

    @FindBy(xpath="//button[normalize-space(text())='Pay now']")
    public WebElement payNowBtn;

    @FindBy(xpath="//button[@type='button' and @data-automationid='undefined_Plus' and contains(@class, 'ns-text-grey-600') and contains(@class, 'ns-cursor-pointer')]")
    public WebElement addDeviceBtn;
    @FindBy(xpath="//button[contains(text(),'Next')]")
    public WebElement assignDeviceNxtBtn;



    @FindBy(xpath="//button[contains(text(),'Check Payment Status')]")
    public WebElement checkPaymentStatusBtn;

    @FindBy(xpath="//label[@for='cash-/-other' and @id='cash-/-other']")
    public WebElement devicePaymentOption;

    @FindBy(xpath="//label[@for='Payment Link']")
    public WebElement deviceCardPaymentOption;

    @FindBy(xpath ="//*[@id='root']/div/div[1]/div/section[1]/main/div[2]")
    public WebElement randomClick;

    @FindBy(xpath ="//*[@id='root']/div/div[1]/div/section[2]/div/div[1]/div[2]")
    public WebElement continueApplicationBtn;
    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/section[1]/main/div[2]/dialog[1]/div/button[2]")
    public  WebElement readyToSubmitBtn;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/section/div[1]/form/div/div/div/p")
    public WebElement onlinePaymentOptionBtn;
    @FindBy(xpath="//button[contains(text(),'Continue to payment')]")
    public WebElement assignDeviceContinueBtn;

    @FindBy(xpath="//button[contains(text(),'Complete application')]")
    public WebElement completeApplicationBtn;

    @FindBy(xpath="//button[contains(text(),'Submit')]")
    public WebElement submitBtn;

    @FindBy(xpath="//button[contains(text(),'Reserve funds')]")
    public WebElement reserveFundsBtn;
    @FindBy(xpath="//input[@name='receiptOption' and @type='radio' and @value='sms']")
    public WebElement smsRadioOption;

    @FindBy(xpath="//button[@id='email']")
    public WebElement emailRadioOption;

    @FindBy(xpath="//button[text()='Send Payment Request']")
    public WebElement sendPaymentRequestBtn;
    @FindBy(xpath="//main//div//button[contains(text(), \"Get started\")]")
    public WebElement acctSetUpGetStartedBtn;
    @FindBy(xpath = "//section[contains(@class, 'modal-body')]//section[3]//button")
    public WebElement accSetUpBtn;
    //*[@id="radix-«r0»"]/section/section[3]/button

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[1]/button")
    public WebElement buildingType;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[7]/div[2]/div/button")
    public WebElement buildingTyp;
    @FindBy(xpath = " //*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[7]/div[2]/select/option[1]")
    public WebElement buildTypeSelection;

   @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/select[1]/option[1]")
    public WebElement buildTypeSelction;


    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Company_Type']")
    public WebElement companyType;
    @FindBy(xpath="//div[@automationid='undefined_Field_Item_Street_Sole_Proprietorship_Unregistered_Business_undefined']")
    public WebElement soleProTypeOption;

    @FindBy(xpath="//div[@automationid='undefined_Field_Item_Street_Partnership_undefined' and contains(@class, 'autocomplete-item')]")
    public WebElement partnershipTypeOption;
    @FindBy(xpath="//div[@automationid='undefined_Field_Item_Street_Company_undefined' and contains(@class, 'autocomplete-item')]")
    public WebElement companyTypeOption;
    @FindBy(xpath=" //*[@id='float-label']/div/div/div[2]/div[4]")
    public WebElement npoTypeOption;
    @FindBy(xpath=" //*[@id='float-label']/div/div/div[2]/div[6]")
    public WebElement trustTypeOption;
    @FindBy(xpath=" //div[@automationid='undefined_Field_Item_Street_Close_Corporation_undefined' and contains(@class, 'autocomplete-item')]")
    public WebElement closeTypeOption;
    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Estimated_Amount']")
    public WebElement businessMonthlIncome;
    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[3]/div/label/img\n")
    public WebElement incomeKnowledgeCheckBox;
    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Registered_Name']")
    public WebElement companyRegName;
    @FindBy(xpath="/html/body/div[1]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[3]/div/label/img")
    public WebElement companydiffrentNameCheckBtn;
    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Company_Name']")
    public WebElement companyTradingName;

    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Company_Registration_Number']")
    public WebElement companyRegNo;

    @FindBy(xpath="//*[@id=\"radix-«r26»\"]")
    public WebElement businessCategory;

   // @FindBy(xpath="//input[@name='businessCategory.name']")
    @FindBy(xpath="//input[@data-automationid='Business_Details_Category_Search']")
    public WebElement businessCategoryInput;

    //WebElement businessCategoryInput = driver.findElement(By.xpath("//input[@name='businessCategory.name']"));


    @FindBy(className = "search-results-container")
    public WebElement businessCategorySearchResults;
    @FindBy(xpath = "//li[@class='search-results-container']")
    public WebElement selBusinessCat;
    @FindBy(xpath="//input[@name='businessCategory.name' and @class='search-box false' and contains(text(), 'Agricultural Cooperatives')]\n")
    public WebElement businessCategoryClick;
    @FindBy(xpath="//article[class='search-results-container' and contains(text(), 'Agricultural Cooperatives')]")
    public WebElement businessCategoryClick1;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[2]/div/div[2]/div/div/div[2]/button")
    public WebElement completeSubmitBtn;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[2]/div/div[2]/div/div/div[2]/button")
    public WebElement orderProceedBtn;

    @FindBy(xpath="//*[@id=\"radix-«rk6»\"]")
    public WebElement inputBusinessStreetName;
    @FindBy(xpath="//*[@id=\"radix-«r37»\"]")
    public WebElement inputBusinessStreetName2;
    @FindBy(xpath="//*[@id=\"radix-«r32»\"]")
    public WebElement inputBusinessStreetName3;


    //*[@id="radix-«rlg»"]
    @FindBy(xpath="//*[@id=\"complex\"]")
    public WebElement complexName;

    @FindBy(xpath="//*[@id=\"radix-«r29»\"]")
    public WebElement inputBusinessStreetNam3;
    @FindBy(xpath="//*[@id=\"radix-«rj1»\"]")
    public WebElement inputBusinessStreetName4;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/article/div/article/section[3]/section/fieldset/div/label[2]")
    public WebElement rental;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[3]/div/input")
    public WebElement date;
    @FindBy(xpath = " //*[@id=\"radix-«r48»\"]/p")
    public WebElement selectBusinessAdress;
    @FindBy(xpath = "//*[@id=\"radix-«rj4»\"]/p")
    public WebElement selectAddress;
    @FindBy(xpath = "//*[@id=\"radix-«r4d»\"]/p")
    public WebElement address;






    //*[@id="radix-«r48»"]/p



    //@FindBy(xpath="//div[contains(@class, 'autocomplete-item') and contains(text(), '4586 Isacholo Crescent, Blue Valley Golf & Country Estate, Centurion, Gauteng, 0187')]")
    //@FindBy(xpath = "//p[text()='4586 Isacholo Crescent, Blue Valley Golf & Country Estate, Centurion, Gauteng, 0187']")
    @FindBy(xpath ="//*[@id=\"radix-«rtu»\"]/p")
    public WebElement businessStreetName;

   @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[11]/div/div[3]/button")
   public  WebElement tradeAddress;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/div[11]/div/select/option[1]")
    public  WebElement tradeAddressSelection;



 //*[@id="root"]/div/main/main/article/section/form/div[2]/section/button[2]
   @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div[2]/section/button[2]")
    public  WebElement next;

 @FindBy(xpath = "//*[@id=\"root\"]/div/main/main/article/section/form/div/div/div[2]/section/button[2]")
 public  WebElement next2;


 @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/div[1]/input")
    public WebElement businessPostalCode;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/div[2]/button")
    public WebElement businessSuburb;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/select[1]/option[2]")
    public WebElement businessSuburbOption;

    @FindBy(xpath="//*[@id='float-label']/div/div/div/span")
    public WebElement businessSuburbInput;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/div[3]/input")
    public WebElement businessTown;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/div[4]/button")
    public WebElement businessProvince;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/select[2]/option[1]]")
    public WebElement businessProvEasternCape;

    @FindBy(xpath="//*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/select[2]/option[2]")
    public WebElement businessProvFreeState;

    @FindBy(xpath=" //*[@id=\"root\"]/div/main/main/article/section/form/div[1]/div/div[5]/div[2]/div[2]/div/select[2]/option[3]")
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

    @FindBy(xpath="//input[@id='termsAndConditions']")
    public WebElement mercgantAgreement_CB;

    @FindBy(xpath="//input[@automationid='Revamp_Your_Details_Business_Address_Street_Address']")
    public WebElement businessAddress;

    @FindBy(xpath=("//button[contains(text(),'Checkout')]"))
    public WebElement checkoutBtn;

    @FindBy(xpath=("//button[contains(text(),'Next')]"))
    public WebElement nextSubmitMerchantBtn;

    @FindBy(xpath="//div[text()='Show business address details']")
    public WebElement businessAddressExpand;

    //*[@id="root"]/div/div[1]/div/section[1]/section/div[1]/form/div[2]/div/div[9]/div/div/div[2]/div

    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginSubmit;

    @FindBy(xpath="")
    public WebElement logout;

    @FindBy(xpath="")
    public WebElement merchantWeb;

    @FindBy(className = "drop-down-closed-right-icon icon-drop-down-arrow-reskin")
    public WebElement partnersIdTypeFld;
    @FindBy(className ="drop-down-closed-right-icon icon-drop-down-arrow-reskin")
    public  WebElement partnersIdType;

    @FindBy(name = "directors[0].idNumber")
    public WebElement partnerID;


    @FindBy(xpath ="//label[@for='consentToggle']")
    public WebElement consent_CK;

    @FindBy(xpath ="//button[contains(text(),'Next')]")
    public WebElement nextBtn;

    @FindBy(xpath ="//*[@id=\"root\"]/div/div/main/div/form/button")
    public WebElement nextB;
    //*[@id="root"]/div/main/div/form/button


    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[6]/div/input")
    public WebElement urlText_input;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement confirmBtn;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[1]/div/label/img")
    public WebElement residential_address;

    @FindBy(xpath = "//*[@id=\"float-label\"]/div/div/div[1]/input")
    public WebElement typeOfResidence;

    @FindBy(xpath = "//div[contains(text(),'Owner')]")
    public WebElement selectOwner;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement clickResidentialNextBtn;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[2]/div/div/button/img")
    public WebElement dateTimePicker_input;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[2]/div/span/div/div/div[1]/button[3]/span")
    public WebElement displayedMonthYearText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[2]/div/span/div/div/div[1]/button[2]")
    public WebElement previousDate;

    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement ficaConfirmBtn;

    @FindBy(name = "accountHolderFullName")
    public WebElement accountNme;
    @FindBy(xpath = "//*[@id='float-label']/div/div/div/input")
    public  WebElement bankNameFld;
    @FindBy(xpath = "//*[@automationid='undefined_Field_Item_Street_Nedbank_undefined']")
    public WebElement selBankName;
    @FindBy(xpath = "//*[@automationid='Revamp_Bank_Details_Account_Number']")
    public WebElement accountNum;
    @FindBy(xpath = "//*[@automationid='Revamp_Bank_Details_Account_Type']")
    public WebElement accountTypeFld;
    @FindBy(xpath = "//*[@automationid='undefined_Field_Item_Street_Current_Cheque_Account_undefined']")
    public WebElement selAccountType;
    @FindBy(xpath ="//button[@automationid='Revamp_Personal_Selfie_Open_Camera']")//*[@id="root"]/div/div[1]/div/section[2]/div/div[1]/div[2]/button
    public WebElement openCamDiv;


    @FindBy(xpath ="//span[text()='Open camera']")
    public WebElement openBankingCamDiv;
    @FindBy(xpath ="//button[contains(text(),'Retake')]")
    public WebElement retakePic;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div/button")
    public WebElement takePic;
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement confirmTakePhotoBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/div[1]/div[2]/button")
    public WebElement takSelfie;  //*[@id="root"]/div/div/main/main/div[1]/div[2]/button/div
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div/div/form/section[2]/button[1]/span")
    public WebElement takeSelfie;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/main/div[1]/div[2]/button")
    public WebElement takePicture;
   @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/section/button[1]")
   public WebElement confirmSelfie; //*[@id="root"]/div/div/main/main/section/button[1]




    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/section[2]/button")
    public WebElement uploadID; //*[@id="root"]/div/div/main/div/section[2]/button


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/form/div/button")
    public WebElement idTypeInput; //*[@id="root"]/div/div/main/div/form/div/button

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/div/form/section/label")
    public WebElement idUpload;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main/main/article/section/form/div[1]/div/section/label")
    public WebElement uploadResolution;




    @FindBy(xpath = "//input[@role='combobox']")
    public WebElement selectIdType;
    @FindBy(xpath = "//div[text()='Smart ID Card']")
    public WebElement smartCard;

    @FindBy(xpath = "//div[text()='Green Barcoded ID Book']")
    public WebElement greenCard;

    @FindBy(xpath = "//div[text()='Passport']")
    public WebElement passport;

    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement confirmPhoto;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement uploadIdType;
    @FindBy(xpath = "//button[@type='button']")
    public WebElement uploadPhoto;
    @FindBy(xpath ="//*[@id=\"root\"]/div/div[1]/div/section[1]/div/section[2]/div[2]/div[2]/section/div[1]/div/section[1]")
    public WebElement uploadBanking;

    @FindBy(xpath = "//h4[text()='Drag and Drop']")
    public WebElement dragDropBankingDoc;
    @FindBy(xpath = " //h3[contains(text(), '3. Resolution letter')]")
    public WebElement resolutionLetter;
    @FindBy(xpath = "  //h3[contains(text(), '3. Trust Resolution letter')]")
    public WebElement trustResolutionLetter;
    @FindBy(xpath = "//button[@automationid='Revamp_Upload_Documents_File_Upload_ID_Passport_Upload_Button']")
    public WebElement uploadbutton;

    @FindBy(xpath = "//input[@value='']")
    public WebElement selectIdNo;
    @FindBy(xpath = "  //div[contains(@automationid, 'undefined_Field_Item_Street_') and contains(@automationid, '_undefined') and contains(@class, 'autocomplete-item') and contains(@class, 'has-padding-x-5') and contains(@class, 'has-padding-y-7') and contains(@class, 'light')][1]")
    public WebElement ID1;
    @FindBy(xpath = "  //div[contains(@automationid, 'undefined_Field_Item_Street_') and contains(@automationid, '_undefined') and contains(@class, 'autocomplete-item') and contains(@class, 'has-padding-x-5') and contains(@class, 'has-padding-y-7') and contains(@class, 'light')][2]")
    public WebElement ID2;
    @FindBy(xpath = " //h3[contains(text(), '4. NPO founding documentation')]")
    public WebElement uploadnpofund;
    @FindBy(xpath = " //h3[contains(text(), '4. Trust deed')]")
    public WebElement uploadtrustdeed;
    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/section[1]/div/section[2]/div[1]/div/section/h3")
    public WebElement uploadIDT;

    //3PO Login Journey xpaths
    @FindBy(xpath ="//h4[normalize-space()='Log in to your account']")
    public WebElement loginLabel;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/section/div/div[2]/div/div/div[3]/div[1]/div/div/form/div[1]/div[1]/button")
    public WebElement selectDealerDrpdwn;

    @FindBy(xpath = "//div[normalize-space()='Makro']")
   public WebElement makroDrpdwnOption;

    @FindBy(xpath = "//*[@id='float-label']/div/div/div[2]/div[1]")
    public WebElement gameDrpdwnOption;

    @FindBy(xpath = "//*[@id='float-labe']/div/div/div[2]/div[3]")
    public WebElement oneSourceDirectOption;
    @FindBy(xpath = "//*[@id='float-label']/div/div/div[2]/div[4]")
    public WebElement smmeOnboardingOption;

    @FindBy(xpath = "//*[@id=\"float-label\"]/div/div/div[2]/div[5]")
    public WebElement vodacomStoreAgentOption;

    @FindBy(xpath="merchantId")
    public WebElement userId;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/section/div/div[2]/div/div/div[3]/div[1]/div/div/form/div[1]/div[2]/div[1]/input")
    public WebElement thirdPartyId;
    @FindBy(xpath="//*[@id=\"root\"]/div/div/section/div/div[2]/div/div/div[3]/div[1]/div/div/form/div[1]/div[2]/div[2]/input")
    public WebElement makroPassword;
    @FindBy(xpath="//*[@id=\"root\"]/div/div/section/div/div[2]/div/div/div[3]/div[1]/div/div/form/button[1]")
    public WebElement brk_loginBtn;

   // @FindBy(xpath="//*[@id='root']/div/div[1]/div/section/article/div[1]/div/div/button")
    @FindBy(xpath="//button[contains(@class, 'ns-bg-red-600') and text()='Get started']")
    public WebElement setupCustomerCompletePage_btn;

   @FindBy(xpath="//*[@id=\"root\"]/main/div/main/div[1]/form/div/div/div[1]/button")
    public WebElement describeYourBusinessposition_dropDown;



 @FindBy(xpath="//p[contains(text(), 'Sole Proprietorship/Unregistered business')]")
    public WebElement describeYourBusiness_dropDown;

    @FindBy(xpath="//input[@id='registeredName']")
    public WebElement businesName_txt;

    //@FindBy(xpath="/html/body/div[1]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[4]/div[1]/input")
    @FindBy(xpath="//input[@name='estimatedAmount']")
    public WebElement businessMonthlIncome_text;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/article/section/input")
    public WebElement businessCategory_text;

    @FindBy(xpath = "//input[@name='email' and @automationid='Onboarding_POS_Revamp_Login_Request_OTP_Field_Email']")
    public WebElement continueEmailAddress;

    @FindBy(xpath = "//input[@name='referenceNumber' and @automationid='Onboarding_POS_Revamp_Login_Request_OTP_Field_Reference_Number']")
    public WebElement continueRefNumber;

    @FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']"
            )
    public WebElement oTPNo1;

    @FindBy
            (xpath =
                    "//input[@aria-label='Digit 2']"
            )
    public WebElement oTPNo2;

    @FindBy
            (xpath =
                    "//input[@aria-label='Digit 3']"
            )
    public WebElement oTPNo3;

    @FindBy
            (xpath =
                    "//input[@aria-label='Digit 4']"
            )
    public WebElement oTPNo4;

    @FindBy
            (xpath =
                    "//input[@aria-label='Digit 5']"
            )
    public WebElement oTPNo5;

    @FindBy
            (xpath =
                    "//input[@aria-label='Digit 6']"
            )
    public WebElement oTPNo6;

}
