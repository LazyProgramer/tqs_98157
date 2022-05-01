package tqs.hw1;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BehaviorCovidTests {
    private WebDriver webDriver;

    @When("I go to {string}")
    public void iNavigateTo(String url) {
        webDriver = new FirefoxDriver();
        webDriver.get(url);
    }

    @And("I choose {string} followed by {string}")
    public void iChoose(String country, String date) {
        WebElement dropdown = webDriver.findElement(By.id("countries_selected"));
        dropdown.click();
        dropdown.findElement(By.xpath("//option[. = '"+country+"']")).click();
        WebElement dateSelect = webDriver.findElement(By.id("day"));
        dateSelect.click();
        dateSelect.sendKeys(date);
    }

    @And("I click the {string} button")
    public void iClick(String btn) {
        webDriver.findElement(By.name(btn)).click();
    }

    @Then("I should be shown {string} covid info from day {string}")
    public void iShouldBeShownPage(String country, String day) {
        try {
            String countryResponse = webDriver.findElement( By.cssSelector("h1")).getText();
            assertTrue(country.contains(country));
            String dateResponse = webDriver.findElement( By.name("date")).getText();
            assertTrue(dateResponse.contains(day));

        } catch (NoSuchElementException e) {
            throw new AssertionError("Wrong page redirected");
        } finally {
            webDriver.quit();
        }
    }

}
