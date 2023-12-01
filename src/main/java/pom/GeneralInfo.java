package pom;

import core.TestFactory;
import org.openqa.selenium.support.PageFactory;

public class GeneralInfo extends TestFactory
{
    public GeneralInfo()
    {
        PageFactory.initElements(driver, this);
    }
}
