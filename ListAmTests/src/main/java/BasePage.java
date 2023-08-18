import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver;
    private final static String HOME_PAGE_URL = "https://www.list.am/";

    public WebDriverWait myWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public Actions actions() {
        return new Actions(driver);
    }

    void openHelp() {
        driver.findElement(By.linkText("Terms of Service")).click();
    }

    void openContactUs() {
        driver.findElement(By.linkText("ContactUs")).click();
    }

    void openTermsOfService() {
        driver.findElement(By.linkText("TermsOfService")).click();
    }

    public static void openHomePage(WebDriver driver) {
        driver.get(HOME_PAGE_URL);
    }

    public void selectLanguage(String language) {
        By languageBtn = By.xpath(String.format("//div[@id='dlgLangSel']//div[text()='%s']", language));
        myWait().until(ExpectedConditions.elementToBeClickable(languageBtn)).click();
    }
}
