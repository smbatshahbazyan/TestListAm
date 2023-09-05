package pageobjects.categorieresultpages;

import components.Item;
import helpers.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends BasePage {
    protected ResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    protected By itemsSelector = By.xpath("//div[@class = 'gl']/a[@target = '_blank']");
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']")
    List<WebElement> items;

    public int getItemsSize() {
        MyWait.waitPresenceOfAllElementLocatedBy(driver, itemsSelector);
        return items.size();
    }

    public List<Item> items() {
        List<Item> itemsList = new ArrayList<>();

        for (WebElement item : driver.findElements(itemsSelector)) {
            itemsList.add(new Item(item));
        }
        return itemsList;
    }
}
