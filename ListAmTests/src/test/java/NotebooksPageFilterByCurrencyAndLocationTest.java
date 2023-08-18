import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class NotebooksPageFilterByCurrencyAndLocationTest extends BaseTest {

    @Test
    public void notebooksPageFilterByCurrencyAndLocationTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToElectronics();
        homePage.selectNotebooks();
        NotebooksPage notebooksPage = new NotebooksPage(driver);
        notebooksPage.selectLocation();
        notebooksPage.selectPrice("200000", "500000");
        notebooksPage.openCurrencyBtnAndSelectAMD();
        Assert.assertTrue(notebooksPage.isAllItemInAmd(), "There is item that isn't in AMD");
        Assert.assertTrue(notebooksPage.isAllItemInKentronLocation(), "There is item that isn't in Kentron Location");
        Assert.assertTrue(notebooksPage.isAllItemPriceInRightRange(), "There is item that isn't from 200000 to 500000 price range");
    }
}
