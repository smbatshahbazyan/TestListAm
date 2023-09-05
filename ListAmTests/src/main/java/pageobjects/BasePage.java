package pageobjects;

import helpers.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage{
    protected WebDriver driver;
    private final static String HOME_PAGE_URL = "https://www.list.am/";
    protected String languageSelector = "//div[@id='dlgLangSel']//div[text()='%s']";
    @FindBy(linkText = "Terms of Service")
    protected WebElement openHelpElement;
    @FindBy(linkText = "ContactUs")
    protected WebElement openContactUsElement;
    @FindBy(linkText = "TermsOfService")
    protected WebElement openTermsOfServiceElement;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHelp() {
        openHelpElement.click();
    }

    public void openContactUs() {
        openContactUsElement.click();
    }

    public void openTermsOfService() {
        openTermsOfServiceElement.click();
    }

    public static void openHomePage(WebDriver driver) {
        driver.get(HOME_PAGE_URL);
    }

    public void selectLanguage(String language) {
        By languageBtn = By.xpath(String.format(languageSelector, language));
        MyWait.waitToBeClickable(driver, languageBtn).click();
    }

    public void hoverToElement(WebElement element) {
        Actions myActions = new Actions(driver);
        myActions.moveToElement(element).perform();
    }
}
