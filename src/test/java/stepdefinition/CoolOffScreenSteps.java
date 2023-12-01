package stepdefinition;

import core.TestFactory;
import io.cucumber.java.en.Given;
import pom.CoolOffScreen;
import utils.TestConfig;
import java.io.IOException;

public class CoolOffScreenSteps
{
    CoolOffScreen objCoolOffScreen = new CoolOffScreen();
    TestFactory objTestFactory = new TestFactory();

    @Given("User should login by launching DL-UI application")
    public void launchDLUIApp()
    {
        TestFactory.launchApplication(TestFactory.browserName);
    }
}
