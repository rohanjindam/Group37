package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pom.FIInfo;

public class FIInfoSteps
{
    FIInfo objFIInfo = new FIInfo();
    @When("User navigates to FI-Info screen")
    public void FIinfoScreenNavigation() {
        objFIInfo.fiInfoPage();
    }
    @And("User has entered Client Company Name")
    public void FIinfoMandatoryFields(){
        objFIInfo.enterMandatoryFields();
    }

}
