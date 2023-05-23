package pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Elements.Header;
import java.time.Duration;
public class HomePage extends ParentPage {


    @FindBy(xpath = "//div[@role='dialog' and @aria-live='assertive']")
    private WebElement welcomePop_up;
    @FindBy(xpath = "//button[text()='×']")
    private WebElement closePop_upButton;
    @FindBy(xpath = "//p[@class='help-and-share-text']")
    private WebElement textInWelcomePop_up;
    private Header header = new Header(webDriver);
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public Header getHeader() {
        return header;
    }

    public HomePage checkIsRedirectOnHomePage() {
        Assert.assertTrue("User is authorized", elementIsDisplayed(header.getProfileButton()));
        Assert.assertTrue("Log out button is displayed", elementIsDisplayed(header.getLogOutButton()));
        return this;
    }

    public MyProfile openMyProfilePage() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(header.getProfileButton()));
        clickOnElement(header.getProfileButton());
        return new MyProfile(webDriver);
    }

    public HomePage closeWelcomePop_up() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            webDriverWait.until(ExpectedConditions.visibilityOf(textInWelcomePop_up));
            clickOnElement(closePop_upButton);
            return this;
        } catch (Exception e) {
            return this;
        }
    }

    public HomePage inputNameItemInSeachField(String text) {
        enterTextInField(header.getSearchField(), text);
        return this;
    }

    public ResultsSearchingPage clickOnstartSearchingButton() {
        clickOnElement(header.getSearchButton());
        return new ResultsSearchingPage(webDriver);
    }

    public StartPage logOutFromHomePage(){
        clickOnElement(header.getLogOutButton());
        return new StartPage(webDriver);
    }
}
