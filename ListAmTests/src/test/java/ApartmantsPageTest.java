import org.testng.Assert;
import org.testng.annotations.Test;

public class ApartmantsPageTest extends BaseTest {
    @Test()
    public void AgencyTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        ApartmentsPage apartmentsPage = new ApartmentsPage(driver);
        apartmentsPage.chooseApartmentsFromRealEstate();
        apartmentsPage.chooseAgencyLabel();
        apartmentsPage.getItemsSize();
        apartmentsPage.getItemsWithAgencySign();
        Assert.assertEquals(apartmentsPage.getItemsSize(), apartmentsPage.getItemsWithAgencySign(), "Item without Agency sign ` " + apartmentsPage.itemNameWithoutAgencySign());
    }
}
