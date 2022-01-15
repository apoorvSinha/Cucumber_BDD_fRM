package StepDefs;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjetcs.CustomerRoles;

import java.util.concurrent.TimeUnit;

public class CustomerPageStepDefs extends BaseSteps {
    WebDriver driver = getWebDriver();

    @Given("User clicks on customer main menu item")
    public void user_clicks_on_customer_main_menu_item() throws InterruptedException {
        cr = new CustomerRoles(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        cr.getPageTitle();
        cr.ClickCustomerMenu();

    }

    @Given("User clicks on Customer roles")
    public void user_clicks_on_customer_roles() {
        cr.ClickCustomerSubMenu();
    }
    @Then("Pre registered customer roles are displayed")
    public void pre_registered_customer_roles_are_displayed() {
        cr.GetPreRegisteredRoles();
    }
    @Then("User clicks on add new Item")
    public void user_clicks_on_add_new_item() {
        cr.AddNewCustomerRole();
    }
    @Then("User enters customer roles details")
    public void user_enters_customer_roles_details() throws InterruptedException {
        cr.AddNewName("Raju");
        cr.CheckBoxActiveYes();
        cr.CheckBoxFreeShippingYes();
        cr.CheckTaxExemptYes();
        cr.CheckBoxOverrideDefaultTaxYes("Including tax");
        cr.EnablePasswordLifeTimeYes();
        cr.EnterSystemName("AMD");
    }
    @When("User clicks on save button")
    public void user_clicks_on_save_button() {
        cr.SaveCustomerRole();
    }
    @Then("User gets a message {string}")
    public void user_gets_a_message(String msg) {

    }
    @After
    public void TearDown(){
        driver.quit();
    }
}

