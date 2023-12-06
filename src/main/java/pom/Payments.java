package pom;

import core.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PageWaitClass;
import utils.TestConfig;

import java.util.List;

public class Payments extends TestFactory
{

    @FindBy(xpath = "//a[@href='/app/config-tool/payments']")
    public static WebElement tab_Payment;
    @FindBy(xpath ="(//input[@role='combobox'])[1]")
    public static WebElement  EnableAutoPayment;

    @FindBy(xpath ="//label[contains(text(),'Auto-Payment Processing Time? ')]/../input")
    public static WebElement PaymentProcessingTime ;

    @FindBy(xpath ="//input[@placeholder='Enter Your Installments']")
    public static WebElement Installment ;

    @FindBy(xpath = "//input[@placeholder='Enter DDA Account Balance']")
    public static WebElement  DAAAccountBalance;

    @FindBy(xpath = "(//input[@role='combobox'])[2]")
    public static WebElement EnableFeature;

    @FindBy(xpath ="//input[@placeholder='Enter Your Payment']")
    public static WebElement TriggerPaymentRetry ;


//Force Payment Feature

    @FindBy(xpath = "(//input[@role='combobox'])[3]")
    public static WebElement LoanAccountBalance;

    @FindBy(xpath = "//input[@placeholder='Enter Specify Numbers of Days']")
    public static WebElement DatePastDue_LoanAccount;

    @FindBy(xpath = "(//input[@role='combobox'])[4]")
    public static WebElement  DAAAccountCDOD;

    @FindBy(xpath = "//input[@placeholder='Enter Specify Numbers']")
    public static WebElement DatePastDue_DDAAccount;

    @FindBy(xpath = "(//input[@role='combobox'])[5]")
    public static WebElement  DAAAccountBalance_Status;

    @FindBy(xpath = "//label[contains(text(),'Specify the STVL SDEK Value(s) that represent Closed in DDA ')]/../input")
    public static WebElement ClosedinDDA;

    //Charge-Off Feature

    @FindBy(xpath = "(//input[@role='combobox'])[6]")
    public static WebElement LaonSystem;

    @FindBy(xpath = "(//input[@role='combobox'])[7]")
    public static WebElement  Purgetiming;

    @FindBy(xpath = "//input[@placeholder='Enter account status']")
    public static WebElement ChargeoffStatus;

    // cool-ff soniya
    @FindBy(xpath = "//a[@href='/app/config-tool/cool-off']")
    private WebElement WE_coolOffTab;

    @FindBy(xpath = "//ul[@class='breadcrumb']/li[2]")
    private WebElement WE_TitleCoolOffTab;

    @FindBy(xpath = "//div[1]/div[2]//ng-select/div/span[@class='ng-arrow-wrapper']")
    private WebElement WE_dropDownIsCooledOff;

    @FindBy(xpath = "//div[4]/div[1]//ng-select/div/span[@class='ng-arrow-wrapper']")
    private WebElement WE_dropDownIsCounterEnabled;

    @FindBy(xpath = "//div[4]/div[2]/ui-form-component/div/input[@type='text']")
    private WebElement WE_implNotesCounterEnable;

    @FindBy(xpath = "//div[5]/div[1]/ui-form-component/div/input[@type='text']")
    private WebElement WE_maxCycleForEnableCounter;

    @FindBy(xpath = "//div[5]/div[2]/ui-form-component/div/input[@type='text']")
    private WebElement WE_implNotesMaxCycleEnableCounter;

    @FindBy(xpath = "//div[7]/div[1]//ng-select/div/span[@class='ng-arrow-wrapper']")
    private WebElement WE_dropDownEnableCounter_RACC;

    @FindBy(xpath = "//div[10]/div[1]//ng-select/div/span[@class='ng-arrow-wrapper']")
    private WebElement WE_dropDownCoolOff_forcePayment;

    @FindBy(xpath = "//*[@id=\"submit-button\"]")
    private WebElement WE_buttonSubmit;
    @FindBy(xpath = "//div[@class=\"toast-body\"]")
    private WebElement WE_alertPopUp;

    @FindBy(xpath = "//*[@id='a65927ba5bf2']")
    private WebElement WE_isAccountCooledOff;


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

    // cool-off soniya


    String pageTitle = TestConfig.getConfigDetails().get("pageTitle");
    String isCooledOffOption = TestConfig.getConfigDetails().get("isCooledOff");
    String isCounterEnableOption = TestConfig.getConfigDetails().get("isCounterEnabled");
    String Notes_CounterEnable = TestConfig.getConfigDetails().get("counterEnableNotes");
    String maxCycle_CounterEnable = TestConfig.getConfigDetails().get("maxCycleForEnableCounter");
    String Notes_maxCycleEnableCounter = TestConfig.getConfigDetails().get("maxCycleImplementationNotes");
    String isCounterEnableOption_RACC = TestConfig.getConfigDetails().get("isCounterEnabled_RACC");
    String getIsCounterEnableOption_forcePayment = TestConfig.getConfigDetails().get("isCounterEnabled_ForcePayment");



    public void paymentPage() {
        PageWaitClass.waitForPageLoad();
        System.out.println("Click on the payment screen");
        tab_Payment.click();
        System.out.println("Clicked");
    }

    public void paymentDetail(){
        System.out.println("Enter Payment Detail - Continuous Usage Treatment Options");

        EnableAutoPayment.sendKeys(AutoPayment);
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
        PaymentProcessingTime.sendKeys(PaymentProcessTime);

        System.out.println("Payment Design ");
        Installment.sendKeys(PaymentInstallment);
        DAAAccountBalance.sendKeys(PaymentDAAAccountBalance);


        System.out.println("Auto-Payment Retry Feature");
        EnableFeature.sendKeys(PaymentEnableFeature);
        System.out.println(" PaymentEnableFeature Value configured ");
        List<WebElement> PaymentEnableFeatureList = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : PaymentEnableFeatureList){
            if(b.getText().contains(PaymentEnableFeature)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Auto-Payment Retry Feature : Enable Feature Option is selected ");
        TriggerPaymentRetry.sendKeys(PaymentTriggerPaymentRetry);


        System.out.println("Force Payment Feature");
        LoanAccountBalance.sendKeys(PaymentLoanAccountBalance);
        System.out.println("PaymentLoanAccountBalance Value configured ");
        List<WebElement> FP1 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : FP1){
            if(b.getText().contains(PaymentLoanAccountBalance)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP1 Option is selected ");
        DatePastDue_LoanAccount.sendKeys(PaymentDatePastDue_LoanAccount);

        DAAAccountCDOD.sendKeys(PaymentDAAAccountCDOD);
        System.out.println("PaymentDAAAccountCDOD Value configured ");
        List<WebElement> FP2 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : FP2){
            if(b.getText().contains(PaymentDAAAccountCDOD)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP2 Option is selected ");
        DatePastDue_DDAAccount.sendKeys(PaymentDatePastDue_DDAAccount);

        DAAAccountBalance_Status.sendKeys(PaymentDAAAccountBalance_Status);
        System.out.println("PaymentDAAAccountBalance_Status Value configured ");
        List<WebElement> FP3 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : FP3){
            if(b.getText().contains(PaymentDAAAccountBalance_Status)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("FP3 Option is selected ");
        ClosedinDDA.sendKeys(PaymentClosedinDDA);

        System.out.println("Charge-Off Feature");

        LaonSystem.sendKeys(ChargeoffLaonSystem);
        System.out.println("ChargeoffLaonSystem Value configured ");
        List<WebElement> ChargeOff1 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : ChargeOff1){
            if(b.getText().contains(ChargeoffLaonSystem)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }


        Purgetiming.sendKeys(ChargeoffPurgetiming);
        System.out.println("ChargeoffPurgetiming Value configured ");
        List<WebElement> ChargeOff2 = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for(WebElement b : ChargeOff2){
            if(b.getText().contains(ChargeoffPurgetiming)) {
                b.click();
                PageWaitClass.waitForPageLoad();
                break;
            }
        }

        ChargeoffStatus.sendKeys(PaymentChargeoffStatus);
        driver.findElement(By.xpath("//input[@id='manual-forcepay']")).click();
        driver.findElement(By.xpath("//input[@id='manual-payment']")).click();
        driver.findElement(By.xpath("//button[@id='submit-button']")).click();

    }


    //Cool off soniya
    public void coolOffPage ()
    {
        PageWaitClass.waitForPageLoad();
        WE_coolOffTab.click();
        System.out.println("Clicked on the Cool Off tab");
        String actualPageTitle = WE_TitleCoolOffTab.getText();
        if (actualPageTitle.equals(pageTitle)) {
            System.out.println("Navigated to desired page");
            System.out.println("Actual page title is : " + actualPageTitle);
        } else
            System.out.println("Page title not matched, navigated to wrong page");
    }

    public void coolOffPageDetail ()
    {
        System.out.println("Enter Cool Off Detail - Continuous Usage Treatment Options");
        WE_dropDownIsCooledOff.click();
        System.out.println("Is Cooled Off dropdown clicked");
        PageWaitClass.waitForPageLoad();

        List<WebElement> listCooledOffOptions = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for (WebElement we : listCooledOffOptions) {
            System.out.println("Dropdown Options : " + we.getText());
            if (we.getText().contains(isCooledOffOption)) {
                we.click();
                //System.out.println("Selected Option : " + we.getText());
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Is Cooled Off Option Selected");

        System.out.println("Enter Cool Off Detail - Continuous Cycles of Usage Parameters (RACU)");
        WE_dropDownIsCounterEnabled.click();
        System.out.println("Counter Enable dropdown clicked");
        PageWaitClass.waitForPageLoad();

        List<WebElement> listCounterEnableOptions = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for (WebElement we : listCounterEnableOptions) {
            System.out.println("Dropdown Options : " + we.getText());
            if (we.getText().contains(isCounterEnableOption)) {
                we.click();
                //System.out.println("Selected Option : " + we.getText());
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Enable Counter Option (RACU) Selected");
        PageWaitClass.waitForPageLoad();

        WE_implNotesCounterEnable.clear();
        WE_implNotesCounterEnable.sendKeys(Notes_CounterEnable);
        PageWaitClass.waitForPageLoad();
        System.out.println("Entered Notes for Counter Enable");

        WE_maxCycleForEnableCounter.clear();
        WE_maxCycleForEnableCounter.sendKeys(maxCycle_CounterEnable);
        PageWaitClass.waitForPageLoad();
        System.out.println("Entered value of Max Cycle of usage for Counter Enable");

        WE_implNotesMaxCycleEnableCounter.clear();
        WE_implNotesMaxCycleEnableCounter.sendKeys(Notes_maxCycleEnableCounter);
        PageWaitClass.waitForPageLoad();
        System.out.println("Entered Notes for Max Cycle Counter Enable");

        System.out.println("Enter Cool Off Detail - Continuous Cycles of Max Line Usage Parameters (RACC)");
        WE_dropDownEnableCounter_RACC.click();
        PageWaitClass.waitForPageLoad();
        System.out.println("Counter Enable dropdown (RACC) clicked");

        List<WebElement> listCounterEnableOptions_RACC = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for (WebElement we : listCounterEnableOptions_RACC)
        {
            System.out.println("Dropdown Options : " + we.getText());
            if (we.getText().contains(isCounterEnableOption_RACC))
            {
                we.click();
                //System.out.println("Selected Option : " + we.getText());
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Counter Enable Option (RACC) Selected");

        System.out.println("Enter Cool Off Detail - Cool-Off due to Force Payment being Triggered?");
        WE_dropDownCoolOff_forcePayment.click();
        System.out.println("Counter Enable dropdown (ForcePayment) clicked");
        PageWaitClass.waitForPageLoad();
        List<WebElement> listCounterEnableOptions_forcePayment = driver.findElements(By.xpath("//span[@class='ng-option-label']"));
        for (WebElement we : listCounterEnableOptions_forcePayment)
        {
            System.out.println("Dropdown Options : " + we.getText());
            if (we.getText().contains(getIsCounterEnableOption_forcePayment))
            {
                we.click();
                //System.out.println("Selected Option : " + we.getText());
                PageWaitClass.waitForPageLoad();
                break;
            }
        }
        System.out.println("Counter Enable Option (ForcePayment) Selected");
    }

    public void submitCoolOffPageDetails()
    {
        PageWaitClass.waitForPageLoad();
        WE_buttonSubmit.click();
        System.out.println("Submit button clicked");
        PageWaitClass.waitForPageLoad();

        wait.until(ExpectedConditions.visibilityOf(WE_alertPopUp));
        if (WE_alertPopUp.isDisplayed())
        {
            System.out.println("Alert PopUp displayed with message : " + WE_alertPopUp.getText());
        } else
            System.out.println("Alert PopUp not displayed");
    }
}
