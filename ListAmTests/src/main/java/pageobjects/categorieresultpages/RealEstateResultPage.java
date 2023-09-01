package pageobjects.categorieresultpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RealEstateResultPage extends ResultPage {
    @FindBy(xpath = "//label[text()='Agency']")
    protected WebElement labelBtnLct;
    @FindBy(xpath = "//div[@id ='contentr']//div[@class = 'clabel']")
    protected List<WebElement> itemsForChangingAgencySign;
    @FindBy(xpath = "//div[@class = 'gl']/a[@target = '_blank']/div[text()='Agency']")
    protected List<WebElement> itemsWithAgencySign;

    public RealEstateResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void chooseAgencyLabel() {
        labelBtnLct.click();
    }

    public void changeAgencySignToPrivate() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var ele = arguments[0]; ele.innerHTML = 'Private';", itemsForChangingAgencySign.get(55));
    }

    public int getItemsWithAgencySign() {
        changeAgencySignToPrivate();
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
                break;
            }
        }
        return message;
    }
}
