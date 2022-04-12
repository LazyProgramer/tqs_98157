package lab4_3.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {
    private WebDriver driver;

    @FindBy(css = ".btn-small")
    private WebElement chooseFlightButton;

    //Constructor
    public SelectFlightPage (WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void chooseFlight(){
        chooseFlightButton.click();
    }
}