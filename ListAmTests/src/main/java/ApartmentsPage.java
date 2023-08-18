import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ApartmentsPage extends CategoryPage {
    ApartmentsPage(WebDriver driver) {
        BasePage.driver = driver;

    }

    public void chooseApartmentsFromRealEstate() {
        WebElement categoryElem = driver.findElement(By.xpath("//div[@id='menu']//a[text()='Real Estate']"));
        By subCategoryElem = By.xpath("//div[@id='menu']//div[./b[text()='For Rent']]//a[text()='Apartments']");
        actions().moveToElement(categoryElem).perform();
        myWait().until(ExpectedConditions.elementToBeClickable(subCategoryElem)).click();
    }

    public void chooseAgencyLabel() {
        By labelBtnLct = By.xpath("//label[text()='Agency']");
        driver.findElement(labelBtnLct).click();
    }

    public void changeAgencySignToPrivate() {
        List<WebElement> itemsForChangingAgencySign = driver.findElements(By.xpath("//div[@id ='contentr']//div[@class = 'clabel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var ele = arguments[0]; ele.innerHTML = 'Private';", itemsForChangingAgencySign.get(55));
    }

    public int getItemsWithAgencySign() {
        changeAgencySignToPrivate();
        List<WebElement> itemsWithAgencySign = driver.findElements(By.xpath("//div[@class = 'gl']/a[@target = '_blank']/div[text()='Agency']"));
        return itemsWithAgencySign.size();
    }

    public String itemNameWithoutAgencySign() {
        List<WebElement> items = driver.findElements(itemsSelector);
        String message = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().contains("Agency")) {
                continue;
            } else {
                WebElement itemWithoutAgency = driver.findElement(By.xpath("//div[@class = 'gl']/a[@target = '_blank'][" + i + "]/div[@class='l']"));
                message = itemWithoutAgency.getText();
            }
            break;
        }
        return message;
    }


}
