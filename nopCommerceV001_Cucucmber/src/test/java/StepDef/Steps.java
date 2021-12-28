package StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


@SuppressWarnings("unused")
public class Steps extends BaseClass {
    @Before
	public void setup() throws IOException {
    	configProp = new Properties();
    	FileInputStream configPropFile = new FileInputStream("config.properties");
    	configProp.load(configPropFile);
    	String br = configProp.getProperty("browser");
    	if(br.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    	}
    	else if(br.equalsIgnoreCase("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	}
    	else if(br.equalsIgnoreCase("opera")) {
    		WebDriverManager.operadriver().setup();
    	}
        
    }
	
    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
    
        lp = new LoginPage(driver);
    }

    @When("user enters URL {string}")
    public void user_enters_url(String url) {
        driver.get(url);
    }

    @When("user enters emails as {string} and password as {string}")
    public void user_enters_emails_as_and_password_as(String email, String password) {
    	lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on login")
    public void click_on_login() throws InterruptedException {
        lp.clickLogin();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String pageTitle) {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp.clickLogout();
    }
    

	@Then("Page title should be {string}")
	public void page_title_should_be1(String pageTitle) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 if(driver.getPageSource().contains("Login was unsuccessful")){
	            driver.close();
	            Assert.fail();
	        }
	        else{
	        Assert.assertEquals(driver.getTitle(), pageTitle);
	        }
	}

	//customer features

		@Then("User can view Dashboard")
		public void user_can_view_dashboard() {
			acp =new AddCustomerPage(driver); 	//created the object
			Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@When("User click on customers menu")
		public void user_click_on_customers_menu() {
			acp.clickOnCustomerMenu();
		}
		@When("click on customers menu item")
		public void click_on_customers_menu_item() {
			acp.clickOnCustomerMenuItem();
		}
		@When("clcik on add new button")
		public void clcik_on_add_new_button() {
			acp.clickOnAddnew();
		}
		@Then("User can view Add new customer page")
		public void user_can_view_add_new_customer_page() {
			Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
		}
		@When("User enters customer info")
		public void user_enters_customer_info() {
			String email = randomString()+"@gmail.com";
			acp.setEmail(email);
			acp.setPassword("test123");
			acp.setCustomerRoles("Guests");
			acp.setManagerOfVendor("Vendor 2");
			acp.setGender("Male");
			acp.setFirstName("Narendra");
			acp.setLastName("Modi");
			acp.setDob("07/01/1985");
			acp.setCompanyName("busyQA");
			acp.setAdminName("This is for testing ....");
			
			
		}
		@When("click on save button")
		public void click_on_save_button() {
			acp.clickOnSave();
		}
		@Then("User can view confirmation message {string}")
		public void user_can_view_confirmation_message(String msg) {
			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
		}
		
		//searching by email id

		@When("Enter customer Email")
		public void enter_customer_email() {
			searchCust = new SearchCustomerPage(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			searchCust.setEmail("victoria_victoria@nopCommerce.com");
		}



		@When("click on search button")
		public void click_on_search_button() {
			searchCust.clickOnSearch();
			acp.js = (JavascriptExecutor)driver;
			acp.js.executeScript("window.scrollBy(0,500)");
			
		}
		@Then("User should find Email in the search table")
		public void user_should_find_email_in_the_search_table() {
			boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
			Assert.assertTrue(status);
		}
		
		//searching by Name
		

		@When("Enter customer FirstName")
		public void enter_customer_first_name() {
			searchCust = new SearchCustomerPage(driver);
			searchCust.setFirstName("Victoria");
		}


		@When("Enter customer LastName")
		public void enter_customer_last_name() {
			searchCust.setLastName("Terces");
			
		}
		@Then("User should find Name in the search table")
		public void user_should_find_name_in_the_search_table() {
			Boolean status = searchCust.searchCustomerByName("Victoria Terces");
			Assert.assertTrue(status);
		}



		

		@Then("Close the browser")
		public void close_the_browser() {
			driver.quit();
		}







}