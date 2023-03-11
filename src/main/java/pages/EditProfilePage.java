package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends ParentPage{

    @FindBy(xpath = "//a[@class='ek-form-btn orange-border' and text()='ВИДАЛИТИ ОБЛІКОВИЙ ЗАПИС']")
    private WebElement deleteProfileButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveChangeButton;

    @FindBy(xpath = "//input[@class='ek-form-control' and @type='text']")
    private WebElement nickNameField;

    String genderRadioButton="//label[@class='no-select' and text()='%s']";

    public EditProfilePage(WebDriver webDriver) {
        super(webDriver);
    }


    public EditProfilePage checkIsRedirectToEditProfilePage(){
        Assert.assertTrue(elementIsDisplayed(deleteProfileButton));
        Assert.assertTrue(elementIsDisplayed(saveChangeButton));
        return this;
    }


    public EditProfilePage enterTextOnNickNameField(String name){
        enterTextInField(nickNameField, name);
        return this;
    }

    public EditProfilePage editGenredOfProfile(String gender){
        elementIsDisplayed(String.format(genderRadioButton,gender));
        selectRadioButton(String.format(genderRadioButton,gender));
        return this;
    }




    public ResultsEditingProfilePage saveChanges() {
        clickOnElement(saveChangeButton);
        return new ResultsEditingProfilePage(webDriver);
    }
}
