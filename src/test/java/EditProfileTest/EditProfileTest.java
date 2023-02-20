package EditProfileTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;

public class EditProfileTest extends BaseTest {

    private final String newNickMame="Камал Сапаев";

    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void editNickNameInProfile() {
        homePage.openMyProfilePage()
                .checkIsRedirectToMyProfilePage()
                .openEditProfilePage()
                .checkIsRedirectToEditProfilePage()
                .enterTextOnNickNameField(newNickMame)
                .saveChanges()
                .checkIsRedirectToResultsEditingProfilePage()
                .checkEditingProfileName(newNickMame)
        ;



    }




}
