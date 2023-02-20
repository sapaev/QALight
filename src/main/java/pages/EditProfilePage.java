package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends ParentPage{

    @FindBy(xpath = "//a[@class='ek-form-btn orange-border' and @jid='mui_delete_user_window']")
    private WebElement deleteProfileButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveChangeButton;

    @FindBy(xpath = "//input[@class='ek-form-control' and @type='text']")
    private WebElement nickNameField;

    public EditProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EditProfilePage checkIsRedirectToEditProfilePage(){
        elementIsDisplayed(deleteProfileButton);
        elementIsDisplayed(saveChangeButton);
        return this;
    }


    public EditProfilePage enterTextOnNickNameField(String name){
        enterTextInField(nickNameField, name);
        return this;
    }


    public ResultsEditingProfilePage saveChanges() {
        clickOnElement(saveChangeButton);
        return new ResultsEditingProfilePage(webDriver);
    }
}
