package web_automation.util.driver;

import org.openqa.selenium.WebDriver;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;

public class Driver {
    public static WebDriver driver;

    @BeforeSuite
    public void initializeDriver(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }
}
