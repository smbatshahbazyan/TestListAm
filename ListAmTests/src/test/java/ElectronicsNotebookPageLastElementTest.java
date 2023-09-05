import components.Item;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.categorieresultpages.ElectronicsResultPage;

import java.util.List;

public class ElectronicsNotebookPageLastElementTest extends BaseTest {
    @Test(groups = "clickableTest")
    public void notebooksPageLastElementTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Electronics");
        homePage.selectSubCategory("Notebooks");
        ElectronicsResultPage notebooksResultPage = new ElectronicsResultPage(driver);
        Assert.assertTrue(notebooksResultPage.isElementClickable(notebooksResultPage.findLastElement()), "Last element in Notebooks page isn't clickable");
    }
}
