package utils;

import core.TestFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import static java.time.Duration.*;

public class PageWaitClass extends TestFactory
{
    public static void waitForPageLoad()
    {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            @Override
            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        try
        {
            //Thread.sleep(2500);
            wait = new WebDriverWait(driver, ofSeconds(10));
            wait.until(expectation);
        }
        catch (Throwable error)
        {
            System.out.println("Timeout waiting for Page Load Request to complete.");
            //SoftAssert a = new SoftAssert();
        }
    }
}
