import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CategoryPage extends BasePage {
    By itemsSelector = By.xpath("//div[@class = 'gl']/a[@target = '_blank']");

    CategoryPage() {
    }

    CategoryPage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public int getItemsSize() {
        myWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemsSelector));
        List<WebElement> items = driver.findElements(itemsSelector);
        return items.size();
    }


}
