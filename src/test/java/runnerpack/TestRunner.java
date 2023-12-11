package runnerpack;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static core.TestFactory.driver;

@CucumberOptions(
        tags = "@DLUIApplication",
        features = "src/test/resources/features",
        glue = "stepdefinition",
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        dryRun = false
        )

    public class TestRunner extends AbstractTestNGCucumberTests {
        @AfterClass
        public static void cleanup() throws InterruptedException {
            Thread.sleep(5000);
            driver.quit();
            System.out.println("--- Execution Completed ---");

        }

    }

