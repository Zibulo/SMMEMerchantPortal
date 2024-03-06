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

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Chop_Chop_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosOptionChopChop;

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Kwika_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosOptionKwika;

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Max_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosOptionMax;

    @FindBy(xpath="//*[@id='carousel']/div[4]/section/button")
    public WebElement addPosOptionPaymentGateway;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/section/form/section[3]/article/img[2]")
    public WebElement addPosOptionScrollBar;

    @FindBy(xpath="//button[@type='button' and @class='sc-fHekdT fbFaKr']")
    public WebElement addPosOptionTapOnPhone;

    @FindBy(xpath="//*[@id=\"carousel\"]/div[6]/section/button")
    public WebElement addPosOptionPayRequest;

    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Max_2_Plus' and contains(@class, 'icon-add-utility')]")
    public WebElement addPosoptionMax2;
    @FindBy(xpath="//span[@automationid='Revamp_Choose_Solution_Carousel_Card_Vodapay_Chop_Chop_Plus' and contains(@class, 'icon-add-utility')]")
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

    @FindBy(xpath="//*[@id=\"float-label\"]/div/div/div/span")
    public WebElement idType;
    @FindBy(name="idNumber")
    public WebElement idNumber;
    @FindBy(xpath="//button[@automationid='Revamp_Footer_Proceed to checkout_Button']")
    public WebElement checkoutProceedBtn;
    @FindBy(xpath="//button[@automationid='Revamp_Footer_Complete application_Button']")
    public WebElement completeOrderBtn;
    @FindBy(xpath="//button[@automationid='Revamp_Setup_Your_Account_Get_Started_Button']")
    public WebElement acctSetUpGetStartedBtn;
    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Company_Type']")
    public WebElement companyType;


    @FindBy(xpath="//div[@automationid='undefined_Field_Item_Street_Sole_Proprietorship_undefined' and contains(@class, 'autocomplete-item')]")
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
    @FindBy(xpath="//button[@automationid='Revamp_Setup_Your_Account_Get_Started_Button']")
    public WebElement businessMonthlIncome;

    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[3]/div/label/img\n")
    public WebElement incomeKnowledgeCheckBox;
    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Registered_Name']")
    public WebElement companyRegName;
    @FindBy(xpath="//*[@id='root']/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/div[5]/div/label/img")
    public WebElement companydiffrentNameCheckBtn;
    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Company_Name']")
    public WebElement companyTradingName;

    @FindBy(xpath="//input[@automationid='Revamp_Business_Details_Company_Registration_Number']")
    public WebElement companyRegNo;
    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/section[1]/article/div[1]/div/div/div/form/article/section/input")
    public WebElement businessCategory;

    @FindBy(className = "search-results-container")
    public WebElement businessCategorySearchResults;
    @FindBy(xpath = "//li[@class='search-results-container']")
    public WebElement selBusinessCat;
    @FindBy(xpath="//input[@name='businessCategory.name' and @class='search-box false' and contains(text(), 'Agricultural Cooperatives')]\n")
    public WebElement businessCategoryClick;
    @FindBy(xpath="//article[class='search-results-container' and contains(text(), 'Agricultural Cooperatives')]")
    public WebElement businessCategoryClick1;

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

    @FindBy(className = "drop-down-closed-right-icon icon-drop-down-arrow-reskin")
    public WebElement partnersIdTypeFld;
    @FindBy(className ="drop-down-closed-right-icon icon-drop-down-arrow-reskin")
    public  WebElement partnersIdType;

    @FindBy(name = "directors[0].idNumber")
    public WebElement partnerID;

    @FindBy(xpath ="//button[@automationid='Revamp_Footer_Next_Button']")
    public WebElement nextBtn;
    @FindBy(xpath = "//button[@automationid='Revamp_Footer_Confirm_Button']")
    public WebElement confirmBtn;
    @FindBy(name = "accountHolderFullName")
    public WebElement accountNme;
    @FindBy(xpath = "//*[@id='float-label']/div/div/div/input")
    public  WebElement bankNameFld;
    @FindBy(xpath = "//*[@automationid='undefined_Field_Item_Street_Nedbank_undefined']")
    public WebElement selBankName;
    @FindBy(name = "accountNumber")
    public WebElement accountNum;
    @FindBy(xpath = "//*[@automationid='Revamp_Bank_Details_Account_Type']")
    public WebElement accountTypeFld;
    @FindBy(xpath = "//*[@automationid='undefined_Field_Item_Street_Current_Cheque_Account_undefined']")
    public WebElement selAccountType;
    @FindBy(className = "selfie-container")
    public WebElement openCamDiv;
    @FindBy(xpath ="//button[contains(@class, 'open-webcam-button')]")
    public WebElement openCamera;
    @FindBy(xpath = "//*[@id='root']/div/div[1]/div/section[1]/article/div[1]/div[1]/div[2]/div[1]/div[3]/div/div/div/button")
    public WebElement takePhoto;
    @FindBy(xpath = "//*[@automationid='Revamp_Personal_Selfie_Image_Capture_Capture_Button']")
    public WebElement takeSelfie;
    @FindBy(xpath = "//h3[text()='1. SA ID / Passport']")
    public WebElement uploadID;

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

    @FindBy(xpath = "//h4[contains(text(), 'Upload')]")
    public WebElement uploadBanking;
    @FindBy(xpath = " //h3[contains(text(), '3. Resolution letter')]")
    public WebElement resolutionLetter;
    @FindBy(xpath = "  //h3[contains(text(), '3. Trust Resolution letter')]")
    public WebElement trustResolutionLetter;

    @FindBy(xpath = "//h4[@class='text-base md:text-3xl !font-normal  text-center']//span[@class='underline md:no-underline' and text()='Upload']")
    public WebElement uploadbutton;

    @FindBy(xpath = "//*[@id='float-label']/div/div/div/input")
    public WebElement idFIELD;
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





}
