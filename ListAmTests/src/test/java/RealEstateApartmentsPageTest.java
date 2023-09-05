import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.categorieresultpages.RealEstateResultPage;
import pageobjects.HomePage;

public class RealEstateApartmentsPageTest extends BaseTest {
    @Test(groups="pageFilter")
    public void AgencyTest() {
        HomePage homePage = new HomePage(driver);
        homePage.selectLanguage("English");
        homePage.hoverToCategory("Real Estate");
        homePage.selectSubCategory("Apartments");
        RealEstateResultPage apartmentsPage = new RealEstateResultPage(driver);
        apartmentsPage.chooseAgencyLabel();
        apartmentsPage.getItemsSize();
        apartmentsPage.getItemsWithAgencySign();
        Assert.assertEquals(apartmentsPage.getItemsSize(), apartmentsPage.getItemsWithAgencySign(), "Item without Agency sign ` " + apartmentsPage.itemNameWithoutAgencySign());
    }
}
