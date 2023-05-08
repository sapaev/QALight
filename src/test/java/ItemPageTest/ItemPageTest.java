package ItemPageTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;

public class ItemPageTest extends BaseTest {

    private final String nameItem="Монітор Samsung C24F390F";

    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void openCardOfItem() throws InterruptedException {
        homePage.inputNameItemInSeachField(nameItem)
                .clickOnstartSearchingButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithTextInItemsList("Samsung")
                .openItemCard(nameItem)
                .checkIsRedirectOnItemCardPage()
        ;

    }
}
