package LogOutTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;

public class LogOutTest extends BaseTest {

    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void logOutTest(){
        homePage.logOutFromHomePage()
                .checkIsRedirectOnStartPage();
    }
}
