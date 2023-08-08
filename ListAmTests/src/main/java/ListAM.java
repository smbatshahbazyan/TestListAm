import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListAM {
    protected WebDriver driver;

    public static boolean isClickable(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }
}
