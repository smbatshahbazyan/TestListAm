import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.BasePage;

public class BaseTest {
    protected WebDriver driver;
    @BeforeSuite
    public void setupChromeDriverTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
