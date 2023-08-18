import org.testng.Assert;
import org.testng.annotations.Test;

public class NotebookPageTest extends BaseTest {
    @Test()
    public void notebooksPageLastElementTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToElectronics();
        homePage.selectNotebooks();
        NotebooksPage notebooksPage = new NotebooksPage(driver);
        boolean lastElementIsClickable = notebooksPage.isLastElementClickable();
        Assert.assertTrue(lastElementIsClickable, "Last element in Notebooks page isn't clickable");
    }

}
