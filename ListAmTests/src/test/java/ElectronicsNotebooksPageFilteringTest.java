import components.Item;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.HomePage;
import pageobjects.categorieresultpages.ElectronicsResultPage;

import java.util.List;
import java.util.Objects;

public class ElectronicsNotebooksPageFilteringTest extends BaseTest {

    @Test
    public void notebooksPageFilterByCurrencyAndLocationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Electronics");
        homePage.selectSubCategory("Notebooks");
        ElectronicsResultPage notebooksResultPage = new ElectronicsResultPage(driver);
        notebooksResultPage.selectLocation("Kentron");
        notebooksResultPage.selectPrice("200000", "500000");
        notebooksResultPage.selectCurrency("AMD");
        notebooksResultPage.getItemsSize();
        List<Item> searchResultItems = notebooksResultPage.items();
        SoftAssert softAssert = new SoftAssert();
        for (Item item : searchResultItems) {
            softAssert.assertTrue(Objects.equals(item.getCurrency(), "֏"),
                    String.format("The currency for %s item is not ֏", item.getTitle()));
            softAssert.assertTrue(Objects.equals(item.getLocation(), "Kentron"),
                    String.format("The location for %s item is not Kentron", item.getTitle()));
            softAssert.assertTrue(item.getPrice() >= 200000 && item.getPrice() <= 500000,
                    String.format("The price of %s item isn't in 200000-500000 range", item.getTitle()));
        }
        softAssert.assertAll();
    }
}
