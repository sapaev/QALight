package RegistrationTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Test;

public class RegistrationTest extends BaseTest {



    @Test
    public void registrationCheckWithValidValues(){
        startPage.openStartPage();
        startPage.inputInRegistrationForm(Creds.VALID_NAME, Creds.VALID_EMAIL, Creds.VALID_PASSWORD)
                .clickOnsumbitRegistrationButton()
                .submitRegistration()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void loginCheckWithValidValues(){
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }

}
