package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Elements.Header;
import pages.ParentPage;

public class ItemCardPage extends ParentPage {


    private Header header = new Header(webDriver);

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement titleOfItem;


    @FindBy(xpath ="//div[@class='goto-price-charts']")
    private WebElement priceChartsButton;

    public ItemCardPage(WebDriver webDriver) {
        super(webDriver);
    }


    public ItemCardPage checkIsRedirectOnItemCardPage(){
        Assert.assertTrue("Title of Item is displayed", elementIsDisplayed("//h1[@itemprop='name']"));
        Assert.assertTrue("Price charts button is displayed", elementIsDisplayed("//div[@class='item-block']") || elementIsDisplayed("//div[@class='conf-desc-ai-title']"));
        return this;
    }


    public MyProfile redirectOnMyProfilePageFromItemCardPage(){
        clickOnElement(header.getProfileButton());
        return new MyProfile(webDriver);
    }


}
