package pageObjects.Categories;

import helpers.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Electronics extends ResultPage {
    @FindBy(xpath = "//input[@id='idprice1']")
    protected WebElement priceFromSelector;
    @FindBy(id = "idprice2")
    protected WebElement priceToSelector;
    @FindBy(xpath = "//div[div[text()='Location']]//div[@class='lsw']")
    protected WebElement locationBtn;
    @FindBy(xpath = "//div[div[text()='Currency']]//div[contains(@class, 'ph')]")
    protected WebElement currencyBtn;
    protected String currencySelectorText = "//div[contains(@data-name, '%s')]";
    String locationSelectorText = "//div[div[text()='Location']]//div[text()='%s']";

    public Electronics(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement findLastElement() {
        List<WebElement> notebookItems = driver.findElements(By.xpath("//div[@class = 'gl']/a[@target = '_blank']"));
        return notebookItems.get(notebookItems.size() - 1);
    }

    public boolean isLastElementClickable() {
        try {
            MyWait.waitToBeClickable(driver, findLastElement());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void selectLocation(String location) {
        locationBtn.click();
        By locationSelectorXpath = By.xpath(String.format(locationSelectorText, location));
        MyWait.waitToBeClickable(driver, locationSelectorXpath).click();
    }

    public void selectPrice(String from, String to) {
        MyWait.waitToBeClickable(driver, priceToSelector).sendKeys(to);
        MyWait.waitToBeClickable(driver, priceFromSelector).sendKeys(from);
    }

    public void selectCurrency(String currency) {
        currencyBtn.click();
        By currencySelectorXpath = By.xpath(String.format(currencySelectorText, currency));
        MyWait.waitToBeClickable(driver, currencySelectorXpath).click();
    }
}
