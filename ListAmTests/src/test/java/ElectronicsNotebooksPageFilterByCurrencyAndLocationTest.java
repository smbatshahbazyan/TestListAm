import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Categories.HomePage;
import pageObjects.Categories.Electronics;

public class ElectronicsNotebooksPageFilterByCurrencyAndLocationTest extends BaseTest {

    @Test
    public void notebooksPageFilterByCurrencyAndLocationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Electronics");
        homePage.selectSubCategory("Notebooks");
        Electronics notebooksPage = new Electronics(driver);
        notebooksPage.selectLocation("Kentron");
        notebooksPage.selectPrice("200000", "500000");
        notebooksPage.selectCurrency("AMD");
        notebooksPage.AreAllItemsInCurrency("֏");
        notebooksPage.AreAllItemsInLocation("Kentron");
        notebooksPage.AreAllItemsPriceRange(200000, 500000);
        Assert.assertEquals(notebooksPage.AreAllItemsInCurrency("֏"), "True");
        Assert.assertEquals(notebooksPage.AreAllItemsInLocation("Kentron"), "True");
        Assert.assertEquals(notebooksPage.AreAllItemsPriceRange(200000, 500000), "True");
    }
}
