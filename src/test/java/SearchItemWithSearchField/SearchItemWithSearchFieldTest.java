package SearchItemWithSearchField;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;

public class SearchItemWithSearchFieldTest extends BaseTest {


    private final String nameItem="Монітор Samsung C24F390F";



    private final String validNameItem="Монітор Samsung";


    private final String validNameItem2="Ноутбук Apple";
    private final String invalidNameItem="not valid name of item";

    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }

    @Test
    public void searchItemWithInValidValue() throws InterruptedException {
        homePage.inputNameItemInSeachField(invalidNameItem)
                .clickOnstartSearchingButton()
                .checkIsRedirectOnResultsSearchingWithInputFieldPageAfterNegativeCase();

    }

    @Test
    public void searchItemWithValidValueWithTypeOfItemAndBrand() throws InterruptedException {
        homePage.inputNameItemInSeachField(validNameItem2)
                .clickOnstartSearchingButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithTextInItemsList("Apple")
        ;
    }

    @Test
    public void searchItemWithValidValueWithNameOfItem() throws InterruptedException {
        homePage.inputNameItemInSeachField(nameItem)
                .clickOnstartSearchingButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithTextInItemsList("Samsung")
        ;
    }


}
