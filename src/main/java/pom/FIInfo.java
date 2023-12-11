package pom;

import core.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageWaitClass;
import utils.TestConfig;

public class FIInfo extends TestFactory
{
    public FIInfo()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='FI Info']")
    public static WebElement tab_FiInfo;

    @FindBy(xpath = "//h4[text()='Financial Institution Details']")
    public static WebElement label_FiInfo_options;
    @FindBy(xpath = "//input[@placeholder='Enter Client Company Name']")
    public static WebElement txt_Client_Company_Name;
    @FindBy(xpath = "//input[@placeholder='Enter Institution Name']")
    public static WebElement txt_Institution_Name;

    @FindBy(xpath = "//textarea[@placeholder='Enter Street 1']")
    public static WebElement txt_Street1;

    @FindBy(xpath = "//textarea[@placeholder='Enter Street 2']")
    public static WebElement txt_Street2;

    @FindBy(xpath = "//input[@placeholder='Enter FI Operating System']")
    public static WebElement txt_FI_OperatingSystem;

    @FindBy(xpath = "//input[@placeholder='Enter SQL Server']")
    public static WebElement txt_SQLServer;

    @FindBy(xpath = "//input[@placeholder='Enter city name']")
    public static WebElement txt_CityName;

    @FindBy(xpath = "//input[@placeholder='Enter State name']")
    public static WebElement txt_StateName;

    @FindBy(xpath = "//textarea[@placeholder='Input File Transformation']")
    public static WebElement txt_InputFileTransformation;

    @FindBy(xpath = "//input[@placeholder='Enter Zip Code']")
    public static WebElement txt_Zipcode;

    @FindBy(xpath = "//input[@placeholder='Enter Website URL']")
    public static WebElement txt_WebsiteURL;

    @FindBy(xpath = "//input[@placeholder='Enter Credit Counseling Services']")
    public static WebElement txt_CounsellingServices;

    @FindBy(xpath = "(//input[@placeholder='Enter Email Address'])[1]")
    public static WebElement txt_Email_CustomerServiceInfo;

    @FindBy(xpath = "//input[@placeholder='Monday - Friday']")
    public static WebElement txt_MondayFriday;

    @FindBy(xpath = "//input[@placeholder='Enter Local Branch']")
    public static WebElement txt_LocalBranch;

    @FindBy(xpath = "//input[@placeholder='Saturday']")
    public static WebElement txt_Saturday;

    @FindBy(xpath = "//input[@placeholder='Sunday']")
    public static WebElement txt_Sunday;

    @FindBy(xpath = "(//input[@placeholder='Enter Full Name'])[1]")
    public static WebElement txt_FullName_Primary;

    @FindBy(xpath = "(//input[@placeholder='Enter Full Name'])[2]")
    public static WebElement txt_FullName_Secondary;

    @FindBy(xpath = "(//input[@placeholder='Enter Email Address'])[2]")
    public static WebElement txt_Email_Primary;

    @FindBy(xpath = "(//input[@placeholder='Enter Email Address'])[3]")
    public static WebElement txt_Email_Secondary;

    @FindBy(xpath = "(//input[@placeholder='Enter Title/Role'])[1]")
    public static WebElement txt_Tile_Primary;

    @FindBy(xpath = "(//input[@placeholder='Enter Title/Role'])[2]")
    public static WebElement txt_Title_Secondary;

    @FindBy(xpath = "//input[@placeholder='Enter FI Code']")
    public static WebElement txt_FiCode;
    @FindBy(xpath = "//input[@placeholder='Enter FI RTN Code']")
    public static WebElement txt_FiRTNCode;
    @FindBy(xpath = "//input[@placeholder='Enter Core DDA System']")
    public static WebElement txt_CoreDDASystem;
    @FindBy(xpath = "//input[@placeholder='Enter LOB Code']")
    public static WebElement txt_LOBCode;
    @FindBy(xpath = "//input[@placeholder='Enter Processing Group Code']")
    public static WebElement txt_ProcessingGroupCode;
    @FindBy(xpath = "//input[@placeholder='Enter Institution Name']")
    public static WebElement txt_InstitutionName;
    @FindBy(xpath = "(//input[@placeholder='Enter Phone Number'])[1]")
    public static WebElement txt_PhoneNumber1;
    @FindBy(xpath = "(//input[@placeholder='Enter Phone Number'])[2]")
    public static WebElement txt_PhoneNumber2;
    @FindBy(xpath = "(//input[@placeholder='Enter Phone Number'])[3]")
    public static WebElement txt_PhoneNumber3;

    String ClientCompanyName = TestConfig.getConfigDetails().get("clientCompanyName");
    String InstitutionName = TestConfig.getConfigDetails().get("institutionName");
    String FiCode = TestConfig.getConfigDetails().get("fiCode");
    String RtnCode = TestConfig.getConfigDetails().get("rtnCode");
    String CoreDDASystem = TestConfig.getConfigDetails().get("coreDDAsystem");
    String LobCode = TestConfig.getConfigDetails().get("lobCode");
    String ProcessingGroupCode = TestConfig.getConfigDetails().get("processingGroupCode");
    String PhoneNumber1 = TestConfig.getConfigDetails().get("phoneNumber1");
    String PhoneNumber2 = TestConfig.getConfigDetails().get("phoneNumber2");
    String PhoneNumber3 = TestConfig.getConfigDetails().get("phoneNumber3");
    String street1 = TestConfig.getConfigDetails().get("Street1");
    String street2 = TestConfig.getConfigDetails().get("Street2");
    String fiOperatingSystem = TestConfig.getConfigDetails().get("FIOperatingSystem");
    String sqlServer = TestConfig.getConfigDetails().get("SQLServer");
    String city = TestConfig.getConfigDetails().get("City");
    String state = TestConfig.getConfigDetails().get("State");
    String inputFileTransformation = TestConfig.getConfigDetails().get("InputFileTransformation");
    String zipCode = TestConfig.getConfigDetails().get("ZipCode");
    String websiteURL = TestConfig.getConfigDetails().get("WebsiteURL");
    String creditCounsellingService = TestConfig.getConfigDetails().get("CreditCounsellingService");
    String emailAddress1 = TestConfig.getConfigDetails().get("EmailAddress1");
    String mondayfriday = TestConfig.getConfigDetails().get("MondayFriday");
    String localBranch = TestConfig.getConfigDetails().get("LocalBranch");
    String saturday = TestConfig.getConfigDetails().get("Saturday");
    String sunday = TestConfig.getConfigDetails().get("Sunday");
    String fullNamePrimary = TestConfig.getConfigDetails().get("FullNamePrimary");
    String fullNameSecondary = TestConfig.getConfigDetails().get("FullNameSecondary");
    String emailAddress2 = TestConfig.getConfigDetails().get("EmailAddress2");
    String emailAddress3 = TestConfig.getConfigDetails().get("EmailAddress3");
    String tilerole1 = TestConfig.getConfigDetails().get("Tile/Role1");
    String tilerole2 = TestConfig.getConfigDetails().get("Tile/Role2");

    public void fiInfoPage() {
        PageWaitClass.waitForPageLoad();
        System.out.println("Click on the Fi-Info screen");
        tab_FiInfo.click();
        System.out.println("Clicked");
    }
    public void enterMandatoryFields(){
        txt_Client_Company_Name.clear();
        txt_Client_Company_Name.sendKeys(ClientCompanyName);

        txt_Institution_Name.clear();
        txt_Institution_Name.sendKeys(InstitutionName);

        txt_FiCode.clear();
        txt_FiCode.sendKeys(FiCode);

        txt_FiRTNCode.clear();
        txt_FiRTNCode.sendKeys(RtnCode);

        txt_CoreDDASystem.clear();
        txt_CoreDDASystem.sendKeys(CoreDDASystem);

        txt_LOBCode.clear();
        txt_LOBCode.sendKeys(LobCode);

        txt_ProcessingGroupCode.clear();
        txt_ProcessingGroupCode.sendKeys(ProcessingGroupCode);

        txt_PhoneNumber1.clear();
        txt_PhoneNumber1.sendKeys(PhoneNumber1);

        txt_PhoneNumber2.clear();
        txt_PhoneNumber2.sendKeys(PhoneNumber2);

        txt_PhoneNumber3.clear();
        txt_PhoneNumber3.sendKeys(PhoneNumber3);
    }


}
