package test.StepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import test.Hooks;
import test.PageObjRefs;


public class StepObjRefs extends PageObjRefs {
    public WebDriver driver;
    
   
    public StepObjRefs()
    {
    	driver = Hooks.driver;
    }

    @Given("^user logs in to the application$")
    public void userIsOnLoginPage() {
        landingpage.login();
        Assert.assertTrue(landingpage.validateSignIn());
    }


    @When("^user orders a teshirt$")
    public void userOrdersATeshirt() {
        landingpage.clickOnTshirtMenuButton();
        orderPage.orderTShirt();
        Assert.assertTrue(landingpage.validateOrderHistory());
    }

    @When("^user edits user account details$")
    public void userAccountDetails() {
        personalInformationPage.enterAccountDetails();
        Assert.assertTrue(personalInformationPage.validateSuccessMessage());
    }


    @Then("^orderId is displayed in order history$")
    public void orderidIsDisplayedInOrderHistory(){
        orderPage.getOrderIdFromOrderHistory();
        Assert.assertTrue(orderPage.matchOrderId());
    }

    @Then("^user details are updated$")
    public void updatedDetails(){
        personalInformationPage.getSuccessMessageForUpdatingDetails();
        Assert.assertTrue(personalInformationPage.validateSuccessMessage());
    }




}