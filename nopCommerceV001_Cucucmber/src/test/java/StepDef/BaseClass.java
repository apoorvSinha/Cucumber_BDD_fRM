package StepDef;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
    public LoginPage lp ;
    public AddCustomerPage acp;
    public SearchCustomerPage searchCust;
    public Properties configProp;
    
    //generating random string values
    public static String randomString() {
    	String generatedString1 = RandomStringUtils.randomAlphabetic(5);
    	return generatedString1;
    }
    
    
}
