package pageObjetcs;

import StepDefs.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sales_orders {
    public WebDriver ldriver;

    public Sales_orders(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }
    @FindBy(xpath = "//li//a//p[contains(text(),'Sales')]")
    WebElement SalesMainMenu;
    @FindBy(xpath = "//li//a//p[contains(text(),'Orders')]")
    WebElement OrderSubMenu;
    @FindBy(xpath = "//table//tbody//tr//td[9]")
    List<WebElement> OrderTotal;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/div[1]/button[2]")
    WebElement ExportData;
    @FindBy(xpath = "//button//i[@class='far fa-file-excel']")
    WebElement ExportToExcel;

    public void ClickSalesMainMenu(){
        SalesMainMenu.click();
    }
    public void ClickOrderSubMenu(){
        OrderSubMenu.click();
    }
    public double GetOrderTotal() throws InterruptedException {

        double sum = 0;
        for(WebElement order_value: OrderTotal){
//            BaseSteps.getExplicitWait(order_value, 2);
            String value = order_value.getText();
            double sum_val =Double.parseDouble(BaseSteps.getNumberFromString(value));
            sum += sum_val;
        }
        return sum/100;
    }

    public void ExportDataDropDown(){
//        BaseSteps.getExplicitWait(ExportData, 4);
        ExportData.click();
    }
    public void ExportToExcel(){
//        BaseSteps.getExplicitWait(ExportToExcel, 5);
        ExportToExcel.click();
    }

}
