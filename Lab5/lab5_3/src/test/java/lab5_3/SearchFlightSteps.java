package lab5_3;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFlightSteps {

    private WebDriver webDriver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get(url);
    }

    @And("I choose {string} followed by {string}")
    public void iChoose(String from, String to) {
        webDriver.findElement(By.name("fromPort")).click();
        webDriver.findElement(By.cssSelector("option[value="+from+"]")).click();
        webDriver.findElement(By.name("toPort")).click();
        webDriver.findElement(By.cssSelector("option[value="+to+"]")).click();
        webDriver.findElement(By.name("toPort")).click();
    }

    @And("I click {string} button")
    public void iClick(String btn) {
        webDriver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("I should be shown {string} page")
    public void iShouldBeShownPage(String title) {
        try {
            String header = webDriver.findElement( By.cssSelector("h3")).getText();
            assertTrue(header.contains(title));

        } catch (NoSuchElementException e) {
            throw new AssertionError("Wrong page redirected");
        } finally {
            webDriver.quit();
        }
    }

}
