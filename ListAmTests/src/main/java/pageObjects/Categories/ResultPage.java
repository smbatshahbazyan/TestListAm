package pageObjects.Categories;

import helpers.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePage;

import java.util.List;

public class ResultPage extends BasePage {
    protected ResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected By itemsSelector = By.xpath("//div[@class = 'gl']/a[@target = '_blank']");
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']/div[@class='at'][1]")
    WebElement firstItemBtn;
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']")
    List<WebElement> items;
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']/div[@class='p']")
    List<WebElement> allItemsInCurrency;
    //protected By allItemsInCurrency = By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='p']");
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']/div[@class='at']")
    List<WebElement> allItemsInLocation;
    //protected By allItemsInLocation = By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='at']");
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']/div[@class='p']")
    List<WebElement> allItemsInPriceRange;
    //protected By allItemsInPriceRange = By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[@class='p']");

    public int getItemsSize() {
        MyWait.waitPresenceOfAllElementLocatedBy(driver, itemsSelector);
        return items.size();
    }

    public String AreAllItemsInCurrency(String currency) {
        String message = "True";
        MyWait.waitToBeClickable(driver, firstItemBtn);
        //List<WebElement> itemsWithAmdPrice = driver.findElements(allItemsInCurrency);
        for (WebElement webElement : allItemsInCurrency) {
            if (webElement.getText().contains(currency)) {
                continue;
            } else {
                message = webElement.getText();
                System.out.println(message);
                break;
            }
        }
        return message;
    }

    public String AreAllItemsInLocation(String location) {
        String message = "True";
       // List<WebElement> itemsWithAmdPrice = driver.findElements(allItemsInLocation);
        for (WebElement webElement : allItemsInLocation) {
            if (webElement.getText().contains(location)) {
                continue;
            } else {
                message = webElement.getText();
                System.out.println(message);
                break;
            }
        }
        return message;
    }

    public String AreAllItemsPriceRange(int from, int to) {
        String message = "True";
       // List<WebElement> itemsWithAmdPrice = driver.findElements(allItemsInPriceRange);
        for (WebElement webElement : allItemsInPriceRange) {
            if (parseToInt(webElement.getText()) >= from && parseToInt(webElement.getText()) <= to) {
                continue;
            } else {
                message = webElement.getText();
                System.out.println(message);
                break;
            }
        }
        return message;
    }

    private int parseToInt(String price) {
        return Integer.parseInt(price.replaceAll("\\D", ""));
    }
}
