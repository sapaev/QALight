package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class ItemCardPage extends ParentPage {

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement titleOfItem;


    @FindBy(xpath ="//div[@class='goto-price-charts']")
    private WebElement priceChartsButton;

    public ItemCardPage(WebDriver webDriver) {
        super(webDriver);
    }


    public ItemCardPage checkIsRedirectOnItemCardPage(){
        Assert.assertTrue("Title of Item is displayed", elementIsDisplayed("//h1[@itemprop='name']"));
        Assert.assertTrue("Price charts button is displayed", elementIsDisplayed("//div[@class='item-block']"));
        return this;
    }


}
