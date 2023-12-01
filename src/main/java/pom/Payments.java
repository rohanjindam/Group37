package pom;

import core.TestFactory;
import org.openqa.selenium.support.PageFactory;

public class Payments extends TestFactory
{
    public Payments()
    {
        PageFactory.initElements(driver, this);
    }
}
