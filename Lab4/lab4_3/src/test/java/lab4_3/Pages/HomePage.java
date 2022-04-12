package lab4_3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://blazedemo.com/";

    //Locators

    //Apply for flight
    @FindBy(name = "fromPort")
    private WebElement fromPort;
    @FindBy(name = "toPort")
    private WebElement toPort;
    @FindBy(css = ".btn-primary")
    private WebElement findFlightButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void ChooseDeparture_Philadelphia() {
        fromPort.click();
        {
            WebElement dropdown = fromPort;
            dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
        }
        fromPort.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(2)")).click();
    }

    public void ChooseDestination_Rome() {
        toPort.click();
        {
            WebElement dropdown = toPort;
            dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        toPort.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
    }

    public void findFlights() {
        findFlightButton.click();
    }
}
