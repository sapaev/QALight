package CheckOfItemCounterInItemHistoryTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.ItemCardPage;
import pages.MyProfile;
import pages.ResultsSearchingPage;
import pages.SearchingWithFilterPage;

public class CheckOfItemCounterInItemHistoryTest extends BaseTest {

    static final String nameOfTab = "Комп'ютери";
    static final String subCategory1 = "ПК";

    ResultsSearchingPage resultsSearchingPage;
    ItemCardPage itemCardPage;




    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void testOfCounter() {
        int valueBeforeTesting=homePage.openMyProfilePage().checkIsSizeOfHistoryItem();
        int valueAfterTesting=homePage.getHeader().hoverToTab(nameOfTab).clickOnSubcategory(subCategory1)
                .checkIsRedirectToSearchingWithFilterPage()
                .clickOnShowAllItemsButton()
                .checkIsRedirectOnResultsSearchingPage()
                .openTheFirstItemOfList()
                .checkIsRedirectOnItemCardPage()
                .redirectOnMyProfilePageFromItemCardPage()
                .checkIsSizeOfHistoryItem();
       // Assert.assertTrue("", valueAfterTesting-valueBeforeTesting==1);
        System.out.println(valueBeforeTesting);
        System.out.println(valueAfterTesting);

    }

    @After
    public void deleteViewedItem(){
    homePage.openMyProfilePage().deleteTheLastViewedItem();
    }


}
