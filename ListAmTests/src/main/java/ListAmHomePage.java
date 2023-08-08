import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListAmHomePage extends ListAM {

    private String HOME_PAGE_URL = "https://www.list.am/";
    private String englishBtnSelectorXpath = "//div[@id='dlgLangSel']//a[@href='/en/']//div";
    private String electronicsBtnSelectorXpath = "//div[@id='menu']//div[@data-c='4']";
    private String notebookBtnSelector = "Notebooks";


    ListAmHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(HOME_PAGE_URL);
    }

    public void selectEnglish(WebDriverWait wait) {
        By englishBtnLocator = By.xpath(englishBtnSelectorXpath);
        wait.until(ExpectedConditions.elementToBeClickable(englishBtnLocator)).click();
    }

    public void maximisePage(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void hoverToElectronics(Actions action) {
        WebElement electronicsBtnLocator = driver.findElement(By.xpath(electronicsBtnSelectorXpath));
        action.moveToElement(electronicsBtnLocator).perform();
    }

    public void selectNotebooks(WebDriverWait wait) {
        By notebookBtnLocator = By.linkText(notebookBtnSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(notebookBtnLocator)).click();
    }


}