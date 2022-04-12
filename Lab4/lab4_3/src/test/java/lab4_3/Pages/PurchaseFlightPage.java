package lab4_3.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseFlightPage {
    private WebDriver driver;

    @FindBy(id = "inputName")
    private WebElement inputName;
    @FindBy(id = "address")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "zipCode")
    private WebElement zipCode;
    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumber;
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCard;

    @FindBy(css = ".checkbox")
    private WebElement checkbox;

    @FindBy(css = ".btn-primary")
    private WebElement submit;

    public void FillInDetails(String i_name, String i_address, String i_city, String i_state, String i_zipCode, String i_creditCardNumber, String i_nameOnCard){
        inputName.click();
        inputName.sendKeys(i_name);

        address.click();
        address.sendKeys(i_address);

        city.click();
        city.sendKeys(i_city);

        state.click();
        state.sendKeys(i_state);

        zipCode.click();
        zipCode.sendKeys(i_zipCode);

        creditCardNumber.click();
        creditCardNumber.sendKeys(i_creditCardNumber);

        nameOnCard.click();
        nameOnCard.sendKeys(i_nameOnCard);
    }

    public void checkCheckbox(){
        checkbox.click();
    }

    public void submit(){
        submit.click();
    }
}
