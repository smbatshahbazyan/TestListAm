import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    @BeforeSuite
    public void setupChromeDriverTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        action = new Actions(driver);
    }

    @BeforeMethod
    public void openBaseUrl() {
        BasePage.openHomePage(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeChromeBrowser() {
        driver.close();
    }

    @AfterSuite
    public void driverNull() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
