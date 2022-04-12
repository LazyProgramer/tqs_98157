package lab4_4;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class AppTestA {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = new HtmlUnitDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void purchaseTest() throws Exception{
        driver.get("http://www.blazedemo.com/purchase.php");
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://blazedemo.com/purchase.php");
            final HtmlElement name = page.getHtmlElementById("inputName");
            name.setTextContent("test");
            final HtmlElement address = page.getHtmlElementById("address");
            address.setTextContent("test");

            assertThat(name.getTextContent(), is("test"));
            assertThat(address.getTextContent(), is("test"));
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "BlazeDemo Purchase";
        assertEquals(expectedTitle,actualTitle);
    }
}
