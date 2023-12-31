package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pom.Payments;

public class PaymentsSteps
{
    Payments objPayments = new Payments();
    @Then("Navigate to Payment Screen")
    public void paymentScreenNavigation() throws Exception {
        objPayments.paymentPage();
        System.out.println("Payment Page is loaded");
    }
    @And("Enter the details of Payment")
    public void PaymentDetail(){
        objPayments.paymentDetail();
    }

    @Then("Navigate to Cool Off Screen")
    public void coolOffScreenNavigation() throws Exception {
        objPayments.coolOffPage();
        System.out.println("Cool Off Page is loaded");
    }
    @And("Enter the details of Cool Off")
    public void coolOffDetail(){
        objPayments.coolOffPageDetail();
    }

    @Then("Submit the details")
    public void submitDetails()
    {
        objPayments.submitCoolOffPageDetails();
    }

}
