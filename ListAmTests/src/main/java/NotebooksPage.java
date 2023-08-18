import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NotebooksPage extends CategoryPage {
    private final By priceFromSelector = By.xpath("//input[@id='idprice1']");
    private final By priceToSelector = By.id("idprice2");
    private final By locationSelector = By.xpath("//div[div[text()='Location']]//div[@class='lsw']");
    private final By kentronLocationSelector = By.xpath("//div[div[text()='Location']]//div[text()='Kentron']");

    NotebooksPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public WebElement findLastElement() {
        List<WebElement> notebookItems = driver.findElements(By.xpath("//div[@class = 'gl']/a[@target = '_blank']"));
        return notebookItems.get(notebookItems.size() - 1);
    }

    public boolean isLastElementClickable() {
        try {
            myWait().until(ExpectedConditions.elementToBeClickable(findLastElement()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void selectLocation() {
        driver.findElement(locationSelector).click();
        myWait().until(ExpectedConditions.elementToBeClickable(kentronLocationSelector)).click();
    }

    public void selectPrice(String from, String to) {
        myWait().until(ExpectedConditions.elementToBeClickable(priceFromSelector)).sendKeys(from);
        myWait().until(ExpectedConditions.elementToBeClickable(priceToSelector)).sendKeys(to);
    }

    public void openCurrencyBtnAndSelectAMD() {
        By currencyBtn = By.xpath("//div[div[text()='Currency']]//div[contains(@class, 'ph')]");
        WebElement amdBtn = driver.findElement(By.xpath("//div[@data-name='֏ (AMD)']"));
        driver.findElement(currencyBtn).click();
        myWait().until(ExpectedConditions.elementToBeClickable(amdBtn)).click();
    }

    public boolean isAllItemInAmd() {
        boolean isAllItemInAmd = true;
        By firstItemBtn = By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='at'][1]");
        myWait().until(ExpectedConditions.elementToBeClickable(firstItemBtn));
        List<WebElement> itemsWithAmdPrice = driver.findElements(By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='p']"));
        for (WebElement webElement : itemsWithAmdPrice) {
            if (webElement.getText().contains("֏")) {
                continue;
            } else {
                isAllItemInAmd = false;
            }
        }
        return isAllItemInAmd;
    }

    public boolean isAllItemInKentronLocation() {
        boolean isAllItemInKentronLocation = true;
        List<WebElement> itemsWithAmdPrice = driver.findElements(By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='at']"));
        for (WebElement webElement : itemsWithAmdPrice) {
            if (webElement.getText().contains("Kentron")) {
                continue;
            } else {
                isAllItemInKentronLocation = false;
            }
        }
        return isAllItemInKentronLocation;
    }

    public boolean isAllItemPriceInRightRange() {
        boolean isAllItemPriceInRightRange = true;
        List<WebElement> itemsWithAmdPrice = driver.findElements(By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='p']"));
        for (WebElement webElement : itemsWithAmdPrice) {
            if (parseToInt(webElement.getText()) >= 200000 && parseToInt(webElement.getText()) <= 500000) {
                continue;
            } else {
                isAllItemPriceInRightRange = false;
            }
        }
        return isAllItemPriceInRightRange;
    }

    private int parseToInt(String price) {
        String[] priceInfo = price.split(",");
        return (Integer.parseInt(priceInfo[0]) * 1000);
    }
}
