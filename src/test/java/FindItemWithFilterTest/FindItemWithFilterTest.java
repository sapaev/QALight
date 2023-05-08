package FindItemWithFilterTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;
import pages.SearchingWithFilterPage;
import java.util.List;

public class FindItemWithFilterTest extends BaseTest {

    static final String nameOfTab = "Комп'ютери";
    static final String subCategory = "Ноутбуки";

    SearchingWithFilterPage serchWithFilterPage;


    static final int countOfSelectedBrandsInFilter = 4;

    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void searchItemWithFilterBrand() {
        homePage.getHeader().hoverToTab("Гаджети");
        serchWithFilterPage = homePage.getHeader().clickOnSubcategory("Смартфони")
                .checkIsRedirectToSearchingWithFilterPage()
                .openAllListOfBrands()
                .selectCheckBoxOfBrands(countOfSelectedBrandsInFilter);
        List<String> selectedBrands = serchWithFilterPage.selectedBrandCheckBoxes();
        for (String text : selectedBrands) {
            System.out.println("Выбранные бренды " + text);
        }
        serchWithFilterPage.clickOnSearchButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithFilterInItemsList(selectedBrands);

    }


}
