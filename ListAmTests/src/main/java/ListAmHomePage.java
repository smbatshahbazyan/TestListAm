import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListAmHomePage extends ListAM {

    private final static String HOME_PAGE_URL = "https://www.list.am/";
    private final static String ENGLISH_BTN_SELECTOR_XPATH = "//div[@id='dlgLangSel']//a[@href='/en/']//div[text()='English']";
    private final static String ELECTRONIC_BTN_SELECTOR_XPATH = "//div[@id='menu']//a[text()='Electronics']";
    private final static String NOTEBOOK_BTN_SELECTOR_TXT = "Notebooks";


    ListAmHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(HOME_PAGE_URL);
    }

    public void selectEnglish(WebDriverWait wait) {
        By englishBtnLocator = By.xpath(ENGLISH_BTN_SELECTOR_XPATH);
        wait.until(ExpectedConditions.elementToBeClickable(englishBtnLocator)).click();
    }

    public void maximisePage(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void hoverToElectronics(Actions action) {
        WebElement electronicsBtnLocator = driver.findElement(By.xpath(ELECTRONIC_BTN_SELECTOR_XPATH));
        action.moveToElement(electronicsBtnLocator).perform();
    }

    public void selectNotebooks(WebDriverWait wait) {
        By notebookBtnLocator = By.linkText(NOTEBOOK_BTN_SELECTOR_TXT);
        wait.until(ExpectedConditions.presenceOfElementLocated(notebookBtnLocator)).click();
    }
    public WebElement findLastElement() {
        String lastElementText = "Terms of Service";
        return driver.findElement(By.linkText(lastElementText));
    }

}