package EditProfileTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Before;
import org.junit.Test;

public class EditProfileTest extends BaseTest {

    private final String newNickMame="Камал Сапаев Тестер";

    private final String genderMale="Ч";
    private final String genderFemale="Ж";

    private final String checkGenderMale="чоловіча";
    private final String checkGenderFemale="женский";

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
        @Test
        public void editGenderInProfile() {
            homePage.openMyProfilePage()
                    .checkIsRedirectToMyProfilePage()
                    .openEditProfilePage()
                    .checkIsRedirectToEditProfilePage()
                    .editGenredOfProfile(genderMale)
                    .saveChanges()
                    .checkIsRedirectToResultsEditingProfilePage()
                    .checkEditingGender(checkGenderMale)
            ;

    }

    @Test
    public void editAgeForUser(){
        homePage.openMyProfilePage()
                .checkIsRedirectToMyProfilePage()
                .openEditProfilePage()
                .checkIsRedirectToEditProfilePage()
                .editAgeOfUser(1993)
                .saveChanges()
                .checkIsRedirectToResultsEditingProfilePage()
                .checkEditingAgeOfUser(1993)
        ;
    }


    //баг
    @Test
    public void editPhotoOfProfile(){
        homePage.openMyProfilePage()
                .checkIsRedirectToMyProfilePage()
                .openEditProfilePage()
                .checkIsRedirectToEditProfilePage()
                .changePhoto("C:\\Users\\qasap\\Downloads\\photo1660565969.jpeg")
                .saveChanges()
                .checkIsRedirectToResultsEditingProfilePage()

        ;
    }




}
