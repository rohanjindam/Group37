package pom;

import core.TestFactory;
import org.openqa.selenium.support.PageFactory;

public class CoolOffScreen extends TestFactory
{
    public CoolOffScreen()
    {
        PageFactory.initElements(driver, this);
    }
}
