package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	public WaitHelper waithelper;

	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(how = How.ID, using = "search-customers")
	WebElement seacrhBtn;

	@FindBy(how = How.ID, using = "SearchEmail")
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "SearchLastName")
	WebElement txtLastName;

	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	WebElement drpDobMonth;

	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	WebElement drpDobDay;

	@FindBy(how = How.ID, using = "SearchCompany")
	WebElement txtCompany;

	@FindBy(how = How.CLASS_NAME, using = "k-multiselect-wrap k-floatwrap")
	WebElement txtCustomerRoles;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	WebElement lstitemAdministrators;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
	WebElement lstitemForumModerators;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	WebElement lstitemGuests;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	WebElement lstitemVendors;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody//tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody//tr//td")
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		waithelper.WaitForElement(txtEmail, 15);
		txtEmail.sendKeys(email);

	}

	public void setFirstName(String fname) {
		waithelper.WaitForElement(txtFirstName, 15);
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		waithelper.WaitForElement(txtLastName, 15);
		txtLastName.sendKeys(lname);
	}

	public void clickOnSearch() {
		seacrhBtn.click();
	}

	public int getNoOfRows() {
		return tableRows.size();
	}

	public int getNoOfColumns() {
		return tableColumns.size();
	}

	public boolean searchCustomerByEmail(String email) {

		boolean flag = false;
		for (int i = 1; i <= tableRows.size(); i++) {
			String email_search = ldriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[" + i + "]//td[2]")).getText();
			if (email_search.equals(email)) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean searchCustomerByName(String Name) {

		boolean flag = false;
		for (int i = 1; i <= tableRows.size(); i++) {
			String name_search = ldriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr[" + i + "]//td[3]")).getText();
			String names[] = name_search.split(" ");
			if (names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag = true;
			}
		}
		return flag;
	}

}
