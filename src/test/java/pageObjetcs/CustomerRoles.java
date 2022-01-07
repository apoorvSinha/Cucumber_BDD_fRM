package pageObjetcs;

import StepDefs.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerRoles {
    public WebDriver ldriver;

    public CustomerRoles(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }
    By lnkCustomerMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
    By lnkCustomerSubMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[2]/a/p");
    By PreRegRoles = By.xpath("//table//tbody//tr//td[1]");
    By AddNewRole = By.xpath("//a[@href='/Admin/CustomerRole/Create']");
    By AddNewName = By.xpath("//input[@id='Name']");
    By ActiveChkBox = By.xpath("//input[@id='Active']");
    By FreeShippingChkBox = By.xpath("//input[@id='FreeShipping']");
    By TaxExempt = By.xpath("//input[@id='TaxExempt']");
    By OverRideTaxDefaultType = By.xpath("//input[@id='OverrideTaxDisplayType']");
    By SelectTaxType = By.xpath("//Select[@id='DefaultTaxDisplayTypeId']");
    By EnablePwdLifeTime = By.xpath("//input[@id='EnablePasswordLifetime']");
    By SystemName = By.xpath("//input[@id='SystemName']");
    By SaveBtn = By.xpath("//button[@name='save']");




    public void getPageTitle(){
        System.out.println(ldriver.getTitle());
    }

    public void ClickCustomerMenu(){
        ldriver.findElement(lnkCustomerMenu).click();
    }
    public void ClickCustomerSubMenu(){
        ldriver.findElement(lnkCustomerSubMenu).click();
    }
    public void GetPreRegisteredRoles(){
        List<WebElement> roles = ldriver.findElements(PreRegRoles);
        for (WebElement role: roles){
            System.out.println(role);
        }
    }
    public void AddNewCustomerRole(){
        ldriver.findElement(AddNewRole).click();
    }
    public void AddNewName(String name){
        ldriver.findElement(AddNewName).sendKeys(name);
    }
    public void CheckBoxActiveYes(){
        ldriver.findElement(ActiveChkBox).click();
    }
    public void CheckBoxFreeShippingYes(){
        ldriver.findElement(FreeShippingChkBox).click();
    }
    public void CheckTaxExemptYes(){
        ldriver.findElement(TaxExempt).click();
    }
    public void CheckBoxOverrideDefaultTaxYes(String value){
        ldriver.findElement(OverRideTaxDefaultType).click();
        WebElement TaxType = ldriver.findElement(SelectTaxType);
        BaseSteps.getExplicitWait(TaxType, 10);
        Select dp = new Select(TaxType);
        dp.selectByVisibleText(value);
    }
    public void EnablePasswordLifeTimeYes(){
        ldriver.findElement(EnablePwdLifeTime).click();
    }
    public void EnterSystemName(String value){
        ldriver.findElement(SystemName).sendKeys(value);
    }
    public void SaveCustomerRole(){
        ldriver.findElement(SaveBtn).click();
    }


}
