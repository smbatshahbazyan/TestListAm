import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    private final By electronicBtnSelector = By.xpath("//div[@id='menu']//a[text()='Electronics']");
    private final By notebookBtnSelector = By.linkText("Notebooks");


    HomePage(WebDriver driver) {
        BasePage.driver = driver;
    }


    public void hoverToElectronics() {
        WebElement electronicsBtnLocator = driver.findElement(electronicBtnSelector);
        actions().moveToElement(electronicsBtnLocator).perform();
    }

    public void selectNotebooks() {
        myWait().until(ExpectedConditions.elementToBeClickable(notebookBtnSelector)).click();
    }
}