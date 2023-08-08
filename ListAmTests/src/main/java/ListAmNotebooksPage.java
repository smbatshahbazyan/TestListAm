import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListAmNotebooksPage extends ListAM {
    ListAmNotebooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findLastElement() {
        String lastElementText = "Terms of Service";
        return driver.findElement(By.linkText(lastElementText));
    }

}
