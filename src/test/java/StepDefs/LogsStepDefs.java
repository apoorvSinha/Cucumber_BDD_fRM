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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logs.ClickSystemMainMenu();
    }



    @Given("User cliks on log menu of SubMenu")
    public void user_cliks_on_log_menu_of_sub_menu() {
        logs.ClickLogsSubMenu();

    }
    @Then("User selects the log level with {string}")
    public void user_selects_the_log_level_with(String value) {
        logs.ClickLogLevel(value);
        logs.ClickSearchButton();
    }
    @Then("User scrolls multiple pages for all alerts")
    public void user_scrolls_multiple_pages_for_all_alerts() {
        logs.getAllMessages();
        if(BaseSteps.NextPageControl(driver.findElement(By.xpath("//*[@id=\"log-grid_info\"]")))){
            logs.ClickNextButton();
        }


    }
    @Then("User closes the browser")
    public void user_closes_the_browser() throws InterruptedException {
        Thread.sleep(4500);
        driver.quit();
    }

}
