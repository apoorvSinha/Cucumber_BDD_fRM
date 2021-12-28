package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver =driver;
	}
	
	//explicitly wait
	public void WaitForElement(WebElement element, long timeUnitInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeUnitInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
