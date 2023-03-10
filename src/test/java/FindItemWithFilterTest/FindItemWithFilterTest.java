package FindItemWithFilterTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonActios;
import pages.SearchingWithFilterPage;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void searchItemWithFilter() {
        homePage.getHeader().hoverToTab(nameOfTab);
        serchWithFilterPage = homePage.getHeader().clickOnSubcategory(subCategory)
                .checkIsRedirectToSearchingWithFilterPage()
                .openAllListOfBrands()
                .selectCheckBox(countOfSelectedBrandsInFilter);
        List<String> selectedBrands = serchWithFilterPage.selectedBrandCheckBoxes();
        for (String text : selectedBrands) {
            System.out.println("Выбранные бренды " + text);
        }
        serchWithFilterPage.clickOnSearchButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithFilterInItemsList(selectedBrands);


    }


}
