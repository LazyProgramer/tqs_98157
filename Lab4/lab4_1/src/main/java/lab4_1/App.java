package lab4_1;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App 
{
    public static void main( String[] args )
    {
        FirefoxDriver driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
      
        driver.quit();
    }
}
