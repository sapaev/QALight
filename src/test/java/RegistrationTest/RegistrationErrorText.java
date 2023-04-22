package RegistrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class RegistrationErrorText extends BaseTest {


    final static String ERROR_USERNAME = "Заповніть поле \"Ім'я\"";
    final static String ERROR_EMAIL = "Поле \"e-mail\" введено некоректно";
    final static String ERROR_EMPTY_EMAIL = "Заповніть поле \"email\"";
    final static String ERROR_EMAIL_INVALID_VALUE = "Поле \"e-mail\" містить неприпустимі символи";


    final static String COMMA = ",";

    final static String ERROR_PASSWORD = "Заповніть поле \"Пароль\"";
    final static String ERROR_PASSWORD_INVALID_VALUE = "Поле \"Пароль\" містить неприпустимі символи";



    @Test
    @Parameters(method = "provideParameters")
    @TestCaseName("registrationErrors : login = {0}, email = {1}, password = {2}")
    public void registrationErrorText(String userName, String email, String password, String expectedErrors) throws InterruptedException {
        startPage.openStartPage();
        startPage.inputInRegistrationForm(userName, email, password)
                .clickOnsumbitRegistrationButton()
                .checkErrorsMessagesForRegistration(expectedErrors)
                ;
    }


    public static Object[][] provideParameters() {
        return new Object[][]{
                new Object[]{"", "123", "", ERROR_USERNAME + COMMA + ERROR_EMAIL + COMMA + ERROR_PASSWORD},
                new Object[]{"", "", "", ERROR_USERNAME + COMMA + ERROR_EMPTY_EMAIL + COMMA + ERROR_PASSWORD},
                new Object[]{"", "1@!com.ua", "1!!", ERROR_USERNAME + COMMA + ERROR_EMAIL_INVALID_VALUE + COMMA + ERROR_PASSWORD_INVALID_VALUE},

        };
    }

}
