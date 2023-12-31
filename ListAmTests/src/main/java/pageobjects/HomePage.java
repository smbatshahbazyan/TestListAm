package pageobjects;

import helpers.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final String categoryBtnTxt = "//div[@id='menu']//a[text()='%s']";
    private final String subCategoryBtnTxt = "//a[text()='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void hoverToCategory(String category) {
        WebElement categoryBtnElement = driver.findElement(By.xpath(String.format(categoryBtnTxt, category)));
        hoverToElement(categoryBtnElement);
    }

    public void selectSubCategory(String subCategory) {
        WebElement subCategoryElement = driver.findElement(By.xpath(String.format(subCategoryBtnTxt, subCategory)));
        MyWait.waitVisibilityOf(driver, subCategoryElement).click();
    }
}