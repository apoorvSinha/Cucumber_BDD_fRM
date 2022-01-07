package StepDefs;
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

}
//
//  cr.GetPreRegisteredRoles();
// cr.AddNewCustomerRole();
// cr.AddNewName("Rajesh");
//        cr.CheckBoxActiveYes();
//        cr.CheckBoxFreeShippingYes();
//        cr.CheckBoxOverrideDefaultTaxYes("Included");
//        cr.EnablePasswordLifeTimeYes();
//        cr.EnterSystemName("Nvidia");
//        cr.EnterPurachsedWithProducts("Lenovo IdeaCentre 600 All-in-One PC");
// cr.SaveCustomerRole();

