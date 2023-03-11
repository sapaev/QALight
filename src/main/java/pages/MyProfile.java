package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Elements.Header;

public class MyProfile extends ParentPage {


    @FindBy(xpath = "//div[@class='user-menu user-menu--yel']")
    private WebElement profileInfo;

    @FindBy(xpath = "//a[@class='user-menu__section wu_isaw']")
    private WebElement lookedItemsActiveButton;

    @FindBy(xpath = "//a[@class='user-menu__edit']")
    private WebElement editProfileButton;


    private Header header = new Header(webDriver);

    public MyProfile(WebDriver webDriver) {
        super(webDriver);
    }


    public Header getHeader() {
        return header;
    }

    public MyProfile checkIsRedirectToMyProfilePage() {
        Assert.assertTrue(elementIsDisplayed(profileInfo));
        return this;
    }


    public EditProfilePage openEditProfilePage(){
        clickOnElement(editProfileButton);
        return new EditProfilePage(webDriver);
    }





}
