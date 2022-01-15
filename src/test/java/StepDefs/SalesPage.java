package StepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObjetcs.Sales_orders;

import java.util.concurrent.TimeUnit;

public class SalesPage extends BaseSteps{
    WebDriver driver = getWebDriver();
    @Given("User Clicks on Sales Main menu")
    public void user_clicks_on_sales_main_menu() {
        so = new Sales_orders(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        so.ClickSalesMainMenu();
    }


    @Given("Click on Orders on sub menu")
    public void click_on_orders_on_sub_menu() {
        so.ClickOrderSubMenu();
    }
    @Then("User scrolls Down the page")
    public void user_scrolls_down_the_page() throws InterruptedException {
        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)","");

    }
    @Then("User looks all the PreRegistered Orders")
    public void user_looks_all_the_pre_registered_orders() throws InterruptedException {
        System.out.println("Total sum of order is: "+so.GetOrderTotal());
    }
    @Then("User Downloads the order summary in excel format")
    public void user_downloads_the_order_summary_in_excel_format() {
        js.executeScript("window.scrollTo(0,0)","");
        so.ExportDataDropDown();
        so.ExportToExcel();
    }
}
