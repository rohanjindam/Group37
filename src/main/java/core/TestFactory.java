package core;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.CapabilityType;
import utils.PageWaitClass;
import utils.TestConfig;
import java.io.IOException;
import java.time.Duration;

public class TestFactory
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static final long MAX_TIME_OUT_IN_SECS = 120L;
    public static String browserName = TestConfig.getConfigDetails().get("browser");
    public static String DLUI_URL = TestConfig.getConfigDetails().get("url");
    public static String userType = TestConfig.getConfigDetails().get("userType");
    public static String userID = TestConfig.getConfigDetails().get("userID");
    public static String firstName = TestConfig.getConfigDetails().get("firstName");
    public static String lastName = TestConfig.getConfigDetails().get("lastName");
    public static String selectBankName = TestConfig.getConfigDetails().get("selectBankName");
    public static String bankTitle = TestConfig.getConfigDetails().get("bankTitle");

    @FindBy (xpath = "//input[@placeholder='userId']")
    public static WebElement WE_userID;
    @FindBy (xpath = "//input[@placeholder='firstName']")
    public static WebElement WE_firstName;
    @FindBy (xpath = "//input[@placeholder='lastName']")
    public static WebElement WE_lastName;
    @FindBy (xpath = "//button[@data-qa='login-button']")
    public static WebElement WE_loginButton;
    @FindBy (xpath = "//select[@id='roleList']")
    public static WebElement WE_userType;
    @FindBy (xpath = "//a[@class='prefillText'][contains(.,'Pre-fill BBT')]")
    public static WebElement WE_preFillBBTText;
    @FindBy (xpath = "//div[@class='modal-content']//input[@type='search']")
    public static WebElement WE_searchBank;
    @FindBy (xpath = "//tbody/tr/td[2]")
    public static WebElement WE_selectSearchedBank;
    @FindBy (xpath = "//ul[@class='breadcrumb']/li[1]")
    public static WebElement WE_actualBankTitle;

    public TestFactory()
    {
        PageFactory.initElements(driver, this);
    }
    public static void launchApplication(String browserName)
    {
        ChromeOptions options = new ChromeOptions();
        //String path = System.getProperty("user.dir");


        switch(browserName)
        {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver.exe");
                ChromeOptions capability = new ChromeOptions();
                //capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

                driver = new ChromeDriver(capability);
                System.out.println("Chrome Browser is Launched");
                break;

            case "firefox":
                //System.setProperty("webdriver.gecko.driver","<<provide geckodriver.exe path here>>");
                driver = new FirefoxDriver();
                System.out.println("Firefox Browser is Launched");
                break;

            case "edge":
                //System.setProperty("webdriver.edge.driver", "<<provide edge driver path here>>");
                driver = new EdgeDriver();
                System.out.println("Edge Browser is Launched");
                break;

            default:
                System.out.println("Invalid or Non-Supported browser name");
        }
        options.addArguments("enable-automation");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("disable-features=NetworkService");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");

        try
        {
            TestFactory objTestFactory = new TestFactory();
            driver.manage().window().maximize();
            System.out.println("Browser windows maximized.");
            System.out.println("getting URL");
            driver.get(DLUI_URL);
            System.out.println("URL fetched and entered in URL address bar");
            PageWaitClass.waitForPageLoad();

            Select select = new Select(WE_userType);
            if(WE_userType.isDisplayed())
            {
                select.selectByVisibleText(userType);
                PageWaitClass.waitForPageLoad();
                System.out.println("User Type is selected from Dropdown");
            }
            else
                System.out.println("Select User Type Dropdown is not displayed");

            WE_preFillBBTText.click();
            PageWaitClass.waitForPageLoad();
            WE_userID.sendKeys(userID);
            PageWaitClass.waitForPageLoad();
            WE_firstName.sendKeys(firstName);
            PageWaitClass.waitForPageLoad();
            WE_lastName.sendKeys(lastName);
            PageWaitClass.waitForPageLoad();

            if(WE_loginButton.isDisplayed())
            {
                WE_loginButton.click();
                System.out.println("Login button clicked");
                PageWaitClass.waitForPageLoad();
            }
            else
                System.out.println("Login button is not displayed");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

            String title = driver.getTitle();
            if(title.equalsIgnoreCase("Deposit Line"))
            {
                System.out.println("Page Title is : " + title);
                System.out.println("User Login Successful");
            }
            else
                System.out.println("Page Title is not matching, Login Fails");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)) ;

            if(!WE_searchBank.isDisplayed())
            {
                wait.until(ExpectedConditions.visibilityOf(WE_searchBank));
                System.out.println("Select Bank page displayed");
                WE_searchBank.clear();
                PageWaitClass.waitForPageLoad();
                WE_searchBank.sendKeys(selectBankName);
                PageWaitClass.waitForPageLoad();
                System.out.println("Entered Bank Name in Search bar");
            }
            else
                System.out.println("Select Bank Page / Search bar not displayed");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

            if(WE_selectSearchedBank.getText().equalsIgnoreCase(selectBankName))
            {
                WE_selectSearchedBank.click();
                PageWaitClass.waitForPageLoad();
                System.out.println("Bank Selected from the list");

                String actualBankName = WE_actualBankTitle.getText();
                if(actualBankName.equals(bankTitle))
                {
                    System.out.println("Desired Bank Selected");
                    System.out.println("Selected Bank is : " + actualBankName);
                }
                else
                    System.out.println("Wrong Bank Selected");
            }
            else
                System.out.println("Searched Bank Name is not in the List, Please Check..");
        }
        catch (Exception e)
        {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
