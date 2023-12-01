package pom;

import core.TestFactory;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSetting extends TestFactory
{
    public AdvanceSetting()
    {
        PageFactory.initElements(driver, this);
    }
}
