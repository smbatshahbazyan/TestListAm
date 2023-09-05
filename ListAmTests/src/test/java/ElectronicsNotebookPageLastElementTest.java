import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.categorieresultpages.ElectronicsResultPage;

public class ElectronicsNotebookPageLastElementTest extends BaseTest {
    @Test()
    public void notebooksPageLastElementTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Electronics");
        homePage.selectSubCategory("Notebooks");
        ElectronicsResultPage notebooksResultPage = new ElectronicsResultPage(driver);
        boolean lastElementIsClickable = notebooksResultPage.isLastElementClickable();
        Assert.assertTrue(lastElementIsClickable, "Last element in Notebooks page isn't clickable");
    }
}
