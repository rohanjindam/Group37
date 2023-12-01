package pom;

import core.TestFactory;
import org.openqa.selenium.support.PageFactory;

public class FIInfo extends TestFactory
{
    public FIInfo()
    {
        PageFactory.initElements(driver, this);
    }
}
