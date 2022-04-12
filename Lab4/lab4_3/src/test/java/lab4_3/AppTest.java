package lab4_3;

import lab4_3.Pages.HomePage;
import lab4_3.Pages.PurchaseFlightPage;
import lab4_3.Pages.SelectFlightPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.MatcherAssert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void PhiladelphiaRomeTest() {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        HomePage home = PageFactory.initElements(driver, HomePage.class);

        home.ChooseDeparture_Philadelphia();
        home.ChooseDestination_Rome();
        home.findFlights();

        driver.get("https://blazedemo.com/reserve.php");

        SelectFlightPage selectFlight = PageFactory.initElements(driver, SelectFlightPage.class);

        selectFlight.chooseFlight();

        driver.get("https://blazedemo.com/purchase.php");

        PurchaseFlightPage purchasePage = PageFactory.initElements(driver, PurchaseFlightPage.class);

        purchasePage.FillInDetails("test", "test", "test", "test", "test", "test", "test");
        purchasePage.checkCheckbox();
        purchasePage.submit();

        String actualTitle = driver.getTitle();
        String expectedTitle = "BlazeDemo Confirmation";
        assertEquals(expectedTitle,actualTitle);

    }
}
