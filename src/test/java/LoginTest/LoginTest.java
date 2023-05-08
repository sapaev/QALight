package LoginTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import libs.Creds;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class LoginTest extends BaseTest {


    final static String COMMA = ",";

    final static String LOGIN_EMPTY_ERROR = "Введіть логін/email!";

    final static String PASSWORD_EMPTY_ERROR = "Введіть пароль!";

    final static String PASSWORD_INCORRECT_ERROR = "Пароль вказаний невірно!";



    @Test
    public void autorizationWithValidCreds() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }



    @Test
    @Parameters(method = "provideParameters")
    public void checkAutorizationErrors(String email, String password, String expectedErrors) throws InterruptedException {
        startPage.openStartPage();
        startPage.inputInLoginForm(email, password)
                .clickOnSubmitLoginButtonWithNotValidCredential();
        startPage.checkErrorsMessagesForLogin(expectedErrors);
    }



    public static Object[][] provideParameters() {
        return new Object[][]{
                new Object[]{"", "", LOGIN_EMPTY_ERROR + COMMA + PASSWORD_EMPTY_ERROR},
                new Object[]{"kamoladdin22@gmail.com", "NOT_CORRECT_PASSWORD", PASSWORD_INCORRECT_ERROR},
        };
    }

}
