package pageObjects;

import helpers.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    private final static String HOME_PAGE_URL = "https://www.list.am/";
    protected String languageSelector = "//div[@id='dlgLangSel']//div[text()='%s']";

    public BasePage(WebDriver driver) {
        this.driver = driver;
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
        By languageBtn = By.xpath(String.format(languageSelector, language));
        MyWait.waitToBeClickable(driver, languageBtn).click();
    }
}
