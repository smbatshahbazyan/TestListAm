import org.testng.Assert;
import org.testng.annotations.Test;

public class ListAmTest extends BaseTest {
    @Test
    public void NotebooksPageLastElementTest() {
        ListAmHomePage homePage = new ListAmHomePage(driver);
        homePage.open();
        homePage.maximisePage(driver);
        homePage.selectEnglish(wait);
        homePage.hoverToElectronics(action);
        homePage.selectNotebooks(wait);
        boolean lastElementIsClickable = ListAM.isClickable(homePage.findLastElement(), wait);
        Assert.assertTrue(lastElementIsClickable, "Last element in Notebooks page isn't clickable");
    }
}
