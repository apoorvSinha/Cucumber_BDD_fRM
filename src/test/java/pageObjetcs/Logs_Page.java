package pageObjetcs;

import StepDefs.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Logs_Page {
    WebDriver ldriver;
    public Logs_Page(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }
    @FindBy(xpath = "//li//a//p[contains(text(),'System')]")
    WebElement SystemMainMenu;
    @FindBy(xpath = "//a//p[contains(text(),'Log')]")
    WebElement LogSubMenu;
    @FindBy(xpath = "//*[@id=\"LogLevelId\"]")
    WebElement SelectLoglevel;
    @FindBy(xpath = "//*[@id=\"search-log\"]")
    WebElement SearchButton;
    @FindBy(xpath = "//*[@id=\"log-grid_next\"]/a/i")
    WebElement NextButton;
    @FindBy(xpath = "//table//tr//td[3]")
    List<WebElement> logMessages;


    public void ClickSystemMainMenu(){
        SystemMainMenu.click();
    }
    public void ClickLogsSubMenu(){
        LogSubMenu.click();
    }
    public void ClickLogLevel(String lg_level){
        Select slc = new Select(SelectLoglevel);
        if(lg_level.equalsIgnoreCase("warning")){
            slc.selectByVisibleText("Warning");
        }
        else if(lg_level.equalsIgnoreCase("Debug")){
            slc.selectByVisibleText("Debug");
        }
        else if(lg_level.equalsIgnoreCase("Information")){
            slc.selectByVisibleText("Information");
        }
        else if(lg_level.equalsIgnoreCase("Error")){
            slc.selectByVisibleText("Error");
        }
        else if(lg_level.equalsIgnoreCase("Fatal")){
            slc.selectByVisibleText("Fatal");
        }

    }
    public void getAllMessages(){
        int msg_number = 1;
        for(WebElement logMessage : logMessages){
            System.out.println("message is: "+msg_number+logMessage.getText());
            msg_number++;
        }
    }


    public void ClickSearchButton(){
        SearchButton.click();
    }
    public void ClickNextButton(){
        while(BaseSteps.NextPageControl(ldriver.findElement(By.xpath("//div[@class='dataTables_info']")))){
            NextButton.click();
            getAllMessages();
        }
    }
}
