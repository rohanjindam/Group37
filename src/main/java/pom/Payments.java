package pom;

import core.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.PageWaitClass;
import utils.TestConfig;

import java.util.List;

public class Payments extends TestFactory
{

    @FindBy(xpath ="//input[@placeholder='Enter Your Installments']")
    public static WebElement Installment ;

    @FindBy(xpath = "//input[@placeholder='Enter DDA Account Balance']")
    public static WebElement  DAAAccountBalance;

    @FindBy(xpath = "//label[contains(text(),'Enable Feature?')]/../ng-select")
    public static WebElement EnableFeature;

    @FindBy(xpath ="//input[@placeholder='Enter Your Payment']")
    public static WebElement TriggerPaymentRetry ;


    public Payments()
    {
        PageFactory.initElements(driver, this);
    }



    String AutoPayment = TestConfig.getConfigDetails().get("AutoPayment");
    String PaymentProcessTime=TestConfig.getConfigDetails().get("PaymentProcessTime");
    String PaymentInstallment =TestConfig.getConfigDetails().get("PaymentInstallment");
    String PaymentDAAAccountBalance=TestConfig.getConfigDetails().get("PaymentDAAAccountBalance");
    String PaymentEnableFeature=TestConfig.getConfigDetails().get("PaymentEnableFeature");
    String PaymentTriggerPaymentRetry=TestConfig.getConfigDetails().get("PaymentTriggerPaymentRetry");
    String PaymentLoanAccountBalance=TestConfig.getConfigDetails().get("PaymentLoanAccountBalance");
    String PaymentDatePastDue_LoanAccount =TestConfig.getConfigDetails().get("PaymentDatePastDue_LoanAccount");
    String PaymentDAAAccountCDOD=TestConfig.getConfigDetails().get("PaymentDAAAccountCDOD");
    String PaymentDatePastDue_DDAAccount=TestConfig.getConfigDetails().get("PaymentDatePastDue_DDAAccount");
    String PaymentDAAAccountBalance_Status=TestConfig.getConfigDetails().get("PaymentDAAAccountBalance_Status");
    String PaymentClosedinDDA=TestConfig.getConfigDetails().get("PaymentClosedinDDA");
    String ChargeoffLaonSystem = TestConfig.getConfigDetails().get("ChargeoffLaonSystem");
    String ChargeoffPurgetiming = TestConfig.getConfigDetails().get("ChargeoffPurgetiming");
    String PaymentChargeoffStatus = TestConfig.getConfigDetails().get("PaymentChargeoffStatus");

    public void paymentPage() {
        PageWaitClass.waitForPageLoad();
        System.out.println("Click on the payment screen");
        //tab_Payment.click();

        driver.findElement(By.xpath("//a[@href='/app/config-tool/payments']")).click();
        System.out.println("Clicked");
    }

    public void paymentDetail(){
        System.out.println("Enter Payment Detail - Continuous Usage Treatment Options");

        driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).sendKeys(AutoPayment);
        System.out.println("Yes Value configured ");
        List<WebElement> AutoPaymentList = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : AutoPaymentList){

            if(b.getText().contains(AutoPayment)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }

        }
        System.out.println("Auto Payment : Option is selected ");
        driver.findElement(By.xpath("//label[contains(text(),'Auto-Payment Processing Time? ')]/../input")).sendKeys(PaymentProcessTime);

        System.out.println("Payment Design ");
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Installments']")).sendKeys(PaymentInstallment);
        driver.findElement(By.xpath("//input[@placeholder='Enter DDA Account Balance']")).sendKeys(PaymentDAAAccountBalance);

        System.out.println("Auto-Payment Retry Feature");
        driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys(PaymentEnableFeature);
        System.out.println("Yes Value configured ");
        List<WebElement> PaymentEnableFeatureList = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : PaymentEnableFeatureList){
            if(b.getText().contains(PaymentEnableFeature)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Auto-Payment Retry Feature : Enable Feature Option is selected ");
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Payment']")).sendKeys(PaymentTriggerPaymentRetry);

        System.out.println("Force Payment Feature");
        driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys(PaymentLoanAccountBalance);
        System.out.println("Yes Value configured ");
        List<WebElement> FP1 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : FP1){
            if(b.getText().contains(PaymentLoanAccountBalance)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP1 Option is selected ");
        driver.findElement(By.xpath("//input[@placeholder='Enter Specify Numbers of Days']")).sendKeys(PaymentDatePastDue_LoanAccount);


        driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys(PaymentDAAAccountCDOD);
        System.out.println("Yes Value configured ");
        List<WebElement> FP2 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : FP2){
            if(b.getText().contains(PaymentDAAAccountCDOD)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP2 Option is selected ");
        driver.findElement(By.xpath("//input[@placeholder='Enter Specify Numbers']")).sendKeys(PaymentDatePastDue_DDAAccount);


        driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).sendKeys(PaymentDAAAccountBalance_Status);
        System.out.println("Yes Value configured ");
        List<WebElement> FP3 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : FP3){
            if(b.getText().contains(PaymentDAAAccountBalance_Status)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP3 Option is selected ");
        driver.findElement(By.xpath("//label[contains(text(),'Specify the STVL SDEK Value(s) that represent Closed in DDA ')]/../input")).sendKeys(PaymentClosedinDDA);

        System.out.println("Charge-Off Feature");

        driver.findElement(By.xpath("(//input[@role='combobox'])[6]")).sendKeys(ChargeoffLaonSystem);
        System.out.println("Yes Value configured ");
        List<WebElement> ChargeOff1 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : ChargeOff1){
            if(b.getText().contains(ChargeoffLaonSystem)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Charge-Off Feature: ");

        driver.findElement(By.xpath("(//input[@role='combobox'])[7]")).sendKeys(ChargeoffPurgetiming);
        System.out.println("Yes Value configured ");
        List<WebElement> ChargeOff2 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : ChargeOff2){
            if(b.getText().contains(ChargeoffPurgetiming)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP3 Option is selected ");
        driver.findElement(By.xpath("//input[@placeholder='Enter account status']")).sendKeys(PaymentChargeoffStatus);
        driver.findElement(By.xpath("//input[@id='manual-forcepay']")).click();
        driver.findElement(By.xpath("//input[@id='manual-payment']")).click();

        driver.findElement(By.xpath("//button[@id='submit-button']")).click();

    }
}
