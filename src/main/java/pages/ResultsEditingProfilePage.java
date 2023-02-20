package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsEditingProfilePage extends ParentPage{

    @FindBy(xpath = "//div[@class='user-profile-edit']")
    private WebElement editedProfileInformation;


    @FindBy(xpath = "//div[@class='user-menu__name']/a[@class='info-nick']")
    private WebElement updatedUserName;


    public ResultsEditingProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultsEditingProfilePage checkIsRedirectToResultsEditingProfilePage(){
        elementIsDisplayed(editedProfileInformation);
        return this;
    }


    public ResultsEditingProfilePage checkEditingProfileName(String newName){
        String updatedName=updatedUserName.getText();
        Assert.assertEquals("UserName was updated",newName, updatedName );
        return this;
    }

}
