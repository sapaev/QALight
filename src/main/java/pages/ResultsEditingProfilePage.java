package pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsEditingProfilePage extends ParentPage{

    @FindBy(xpath = "//div[@class='user-profile-edit']")
    private WebElement editedProfileInformation;

    @FindBy(xpath = "//div[@class='user-menu__name']/a[@class='info-nick']")
    private WebElement updatedUserName;

    private String genderInformation="//div[@class='ph-reg' and text()=' %s']";

    private String ageInformation="//div[@class=\"ph-reg\" and contains(text(),'%d')]";


    public ResultsEditingProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultsEditingProfilePage checkIsRedirectToResultsEditingProfilePage(){
        Assert.assertTrue(elementIsDisplayed(editedProfileInformation));
        return this;
    }


    public ResultsEditingProfilePage checkEditingProfileName(String newName){
        String updatedName=updatedUserName.getText();
        Assert.assertEquals("UserName was updated",newName, updatedName );
        return this;
    }

    public ResultsEditingProfilePage checkEditingGender(String gender) {
        Assert.assertTrue(elementIsDisplayed(String.format(genderInformation,gender)));
        return this;
    }


    public ResultsEditingProfilePage checkEditingAgeOfUser(int earOfBirth){
        Assert.assertTrue(elementIsDisplayed(String.format(ageInformation,earOfBirth)));
        return this;
    }
}
