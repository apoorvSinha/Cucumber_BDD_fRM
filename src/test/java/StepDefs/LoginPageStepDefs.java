package StepDefs;

import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjetcs.CustomerRoles;
import pageObjetcs.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginPageStepDefs extends BaseSteps{
    WebDriver driver = getWebDriver();

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {

        lp = new LoginPage(driver);

    }

    @When("User enters URL {string}")
    public void user_enters_url(String url) {
        driver.get(url);
    }

    @When("User enters emails as {string} and password as {string}")
    public void user_enters_emails_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String pageTitle) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.fail();
        }
        else{
        Assert.assertEquals(driver.getTitle(), pageTitle);
        }
    }

    @When("user clicks on Logout link")
    public void user_clicks_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }
    @Then("Page title should be {string}")
    public void page_title_should_be1(String pageTitle) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.fail();
        }
        else{
            Assert.assertEquals(driver.getTitle(), pageTitle);
        }
    }


    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
