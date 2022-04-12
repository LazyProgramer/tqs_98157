package lab4_4;

import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

@ExtendWith(SeleniumJupiter.class)
class AppTestB {

    @Test
    void testLatestChrome(@DockerBrowser(type = CHROME, version = "latest") WebDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(),
                containsString("Selenium-Jupiter"));
    }

    @Test
    void BostonDublinTest(@DockerBrowser(type = CHROME, version = "latest") WebDriver driver) {

        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(2)")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();

        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("testName");

        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("test");

        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("test");

        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("test");

        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("test");

        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("test");

        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("testCard");

        driver.findElement(By.cssSelector(".checkbox")).click();

        assertThat(driver.findElement(By.id("inputName")).getAttribute("value"), is("testName"));
        assertThat(driver.findElement(By.id("nameOnCard")).getAttribute("value"), is("testCard"));

        driver.findElement(By.cssSelector(".btn-primary")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "BlazeDemo Confirmation";
        assertEquals(expectedTitle, actualTitle);

    }
}
