package StepDefs;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjetcs.CustomerRoles;
import pageObjetcs.LoginPage;


public class BaseSteps {
    protected static WebDriver driver;
    public LoginPage lp;
    public CustomerRoles cr;


    protected WebDriver getWebDriver(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void getExplicitWait(WebElement elem, int Wait_time){
        WebDriverWait wait = new WebDriverWait(driver, Wait_time);
        wait.until(ExpectedConditions.visibilityOf(elem));
    }

}
