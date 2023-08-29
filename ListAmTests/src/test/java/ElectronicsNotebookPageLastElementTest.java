import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Categories.HomePage;
import pageObjects.Categories.Electronics;

public class ElectronicsNotebookPageLastElementTest extends BaseTest {
    @Test()
    public void notebooksPageLastElementTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Electronics");
        homePage.selectSubCategory("Notebooks");
        Electronics notebooksPage = new Electronics(driver);
        boolean lastElementIsClickable = notebooksPage.isLastElementClickable();
        Assert.assertTrue(lastElementIsClickable, "Last element in Notebooks page isn't clickable");
    }
}
