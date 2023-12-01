package pom;

import core.TestFactory;
import org.openqa.selenium.support.PageFactory;

public class CreditLine extends TestFactory
{
    public CreditLine()
    {
        PageFactory.initElements(driver, this);
    }
}
