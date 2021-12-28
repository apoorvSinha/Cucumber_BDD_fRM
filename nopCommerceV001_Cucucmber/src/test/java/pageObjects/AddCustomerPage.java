package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;
	public JavascriptExecutor js;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By lnk_Customers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnk_Customers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddnew = By.xpath("//a[@href='/Admin/Customer/Create']");
	By txtEmail = By.xpath("//input[@name='Email']");
	By txtPassword = By.xpath("//input[@name='Password']");
	
	By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstItemRegistered = By.xpath("//ul[@class='k-list k-reset']//li[contains(text(),'Registered')]");
	By lstItemAdministrators = By.xpath("//ul[@class='k-list k-reset']//li[contains(text(),'Administrators')]");
	By lstItemGuests = By.xpath("//ul[@class='k-list k-reset']//li[contains(text(),'Guests')]");
	By lstItemModerators = By.xpath("//ul[@class='k-list k-reset']//li[contains(text(),'Forum Moderators')]");
	
	By drpmgrOfVendor = By.id("VendorId");
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDateOfBirth = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.id("Company");
	By txtAdminName = By.xpath("//textarea");
	By txtSave = By.xpath("//button[@name = 'save']");
	
	//Action methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		ldriver.findElement(lnk_Customers_menu).click();
	}
	
	public void clickOnCustomerMenuItem() {
		ldriver.findElement(lnk_Customers_menuitem).click();
	}
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setCustomerRoles(String role) {
		WebElement listitem=null;
		
		if(!role.equalsIgnoreCase("Registered")) {
			
			listitem =  ldriver.findElement(By.xpath("//span[@class='k-select']//span[@class='k-icon k-i-close']"));
			js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click()", listitem);
			
			if(role.equalsIgnoreCase("Administrators")) {
				listitem = ldriver.findElement(lstItemAdministrators);
			}
			else if (role.equalsIgnoreCase("Guests")) {
				listitem = ldriver.findElement(lstItemGuests);
			}
			else if(role.equalsIgnoreCase("Forum Moderators")) {
				listitem = ldriver.findElement(lstItemModerators);
			}
			//listitem.click();
			js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click()", listitem);
			
		}
	}
	public void setManagerOfVendor(String value) {
		Select drp  = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
		
	}
	public void setGender(String gender) {		
		if(gender.equals("Female")) {
			ldriver.findElement(rdFeMaleGender).click();
		}
		else {
			ldriver.findElement(rdMaleGender).click();
		}
	}
	
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	public void setDob(String dateob) {
		ldriver.findElement(txtDateOfBirth).sendKeys(dateob);
	}
	public void setCompanyName(String cpnyname) {
		ldriver.findElement(txtCompanyName).sendKeys(cpnyname);
	}
	public void setAdminName(String adminName) {
		ldriver.findElement(txtAdminName).sendKeys(adminName);
	}
	public void clickOnSave() {
		ldriver.findElement(txtSave).click();
	}
	
	

	
}
