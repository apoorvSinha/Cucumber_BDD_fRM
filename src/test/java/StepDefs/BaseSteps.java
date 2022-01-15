package StepDefs;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjetcs.CustomerRoles;
import pageObjetcs.LoginPage;
import pageObjetcs.Sales_orders;


public class BaseSteps {
    protected static WebDriver driver;
    public LoginPage lp;
    public CustomerRoles cr;
    public Sales_orders so;
    public JavascriptExecutor js;

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
    public static String getNumberFromString(String num_string){
        String sum = "";
        for(int i = 0; i<num_string.length(); i++){
            boolean flag = Character.isDigit(num_string.charAt(i));
            if(flag){
                sum = sum + (num_string.charAt(i));
            }
        }
        return sum;
    }

}
