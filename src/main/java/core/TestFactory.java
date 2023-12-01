package core;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    @FindBy (xpath = "//*[@id=\"dlui-app-root\"]//ul[@class='breadcrumb']/li[1]")
    public static WebElement WE_bankTitle;

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
            driver.manage().window().maximize();
            System.out.println("Browser windows maximized.");
            System.out.println("getting URL");
            driver.get(DLUI_URL);
            System.out.println("URL fetched and entered in URL address bar");
            PageWaitClass.waitForPageLoad();

            /*Select select = new Select(WE_userType);
            if(WE_userType.isDisplayed())
            {
                select.selectByVisibleText(userType);
                System.out.println("User Type is selected from Dropdown");
            }
            else
                System.out.println("Select User Type Dropdown is not displayed");

            WE_userID.sendKeys(userID);
            WE_firstName.sendKeys(firstName);
            WE_lastName.sendKeys(lastName);*/

            Select select = new Select(driver.findElement(By.xpath("//select[@id='roleList']")));
            if(driver.findElement(By.xpath("//select[@id='roleList']")).isDisplayed()){
                select.selectByVisibleText(userType);
                System.out.println("User Type is selected");
            }
            else
                System.out.println("Dropdown is not displayed to select user type");

            PageWaitClass.waitForPageLoad();
            driver.findElement(By.xpath("//a[@class='prefillText'][contains(.,'Pre-fill BBT')]")).click();
            PageWaitClass.waitForPageLoad();

            driver.findElement(By.xpath("//input[@placeholder='userId']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='userId']")).sendKeys(userID);
            PageWaitClass.waitForPageLoad();

            driver.findElement(By.xpath("//input[@placeholder='firstName']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='firstName']")).sendKeys(firstName);
            PageWaitClass.waitForPageLoad();

            driver.findElement(By.xpath("//input[@placeholder='lastName']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='lastName']")).sendKeys(lastName);
            PageWaitClass.waitForPageLoad();

            if(driver.findElement(By.xpath("//button[@data-qa='login-button']")).isDisplayed())
            {
                driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
                System.out.println("Login button clicked");
                PageWaitClass.waitForPageLoad();
            }
            else
                System.out.println("Login button is not displayed");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

            String title = driver.getTitle();
            if(title.equalsIgnoreCase("Deposit Line")){
                System.out.println("Page Title is : " + title);
                System.out.println("User Login Successful");
            }
            else {
                System.out.println("Page Title is not matching, Login Fails");
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)) ;

            if(!driver.findElement(By.xpath("//div[@class='modal-content']//input[@type='search']")).isDisplayed())
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//input[@type='search']")));
                System.out.println("Select Bank page displayed");
                driver.findElement(By.xpath("//div[@class='modal-content']//input[@type='search']")).clear();
                driver.findElement(By.xpath("//div[@class='modal-content']//input[@type='search']")).sendKeys(selectBankName);
                System.out.println("Entered Bank Name in Search bar");
            }
            else
                System.out.println("Select Bank Page / Search bar not displayed");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
            if(driver.findElement(By.xpath("//tbody/tr/td[2]")).getText().equalsIgnoreCase(selectBankName))
            {
                driver.findElement(By.xpath("//tbody/tr/td[2]")).click();
                System.out.println("Bank Selected from the list");

                String actualBankName = driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[1]")).getText();
                if(actualBankName.equals(bankTitle))
                {
                    System.out.println("Desired Bank Selected");
                    System.out.println("Selected Bank is : " + bankTitle);
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
