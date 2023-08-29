import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Categories.RealEstate;
import pageObjects.Categories.HomePage;

public class RealEstateApartmentsPageTest extends BaseTest {
    @Test()
    public void AgencyTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Real Estate");
        homePage.selectSubCategory("Apartments");
        RealEstate apartmentsPage = new RealEstate(driver);
        apartmentsPage.chooseAgencyLabel();
        apartmentsPage.getItemsSize();
        apartmentsPage.getItemsWithAgencySign();
        Assert.assertEquals(apartmentsPage.getItemsSize(), apartmentsPage.getItemsWithAgencySign(), "Item without Agency sign ` " + apartmentsPage.itemNameWithoutAgencySign());
    }
}
