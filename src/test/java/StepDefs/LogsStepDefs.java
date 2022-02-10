package StepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjetcs.Logs_Page;

import java.util.concurrent.TimeUnit;

public class LogsStepDefs extends BaseSteps {
    WebDriver driver = getWebDriver();

    @Given("User clicks on System on main menu")
    public void user_clicks_on_system_on_main_menu() {
        logs = new Logs_Page(driver);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        logs.ClickSystemMainMenu();
    }



    @And("User clicks on log menu of SubMenu")
    public void user_cliks_on_log_menu_of_sub_menu() {
        logs.ClickLogsSubMenu();
        driver.manage().window().maximize();

    }
    @Then("User selects the log level with {string}")
    public void user_selects_the_log_level_with(String value) throws InterruptedException {
        Thread.sleep(3000);
        logs.ClickLogLevel(value);
        logs.ClickSearchButton();
    }
    @And("User scrolls multiple pages for all alerts")
    public void user_scrolls_multiple_pages_for_all_alerts() {
        logs.getAllMessages();
        logs.ClickNextButton();

    }

}
