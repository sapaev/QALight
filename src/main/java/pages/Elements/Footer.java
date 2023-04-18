package pages.Elements;

import libs.LinksProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonActios;
import pages.StartPage;

import java.time.Duration;


public class Footer extends CommonActios {

    public static LinksProperties linksProperties = ConfigFactory.create(LinksProperties.class);
    Logger logger = Logger.getLogger(getClass());

    private String linkForAnotherCountry = "//ul[@class='footer-links-list']/li/a[@href='%s']";


    public Footer(WebDriver webDriver) {
        super(webDriver);
    }


    public String getLinkForAnotherCountry() {
        return linkForAnotherCountry;
    }

    public void setLinkForAnotherCountry(String linkForAnotherCountry) {
        this.linkForAnotherCountry = linkForAnotherCountry;
    }


    public StartPage checkLocalisationLink_UK() {

        elementIsDisplayed(String.format(linkForAnotherCountry, linksProperties.UK()));
        WebElement linkLocalisation = webDriver.findElement(By.xpath(String.format(linkForAnotherCountry, linksProperties.UK())));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(linkLocalisation).build().perform();
        clickOnElement(linkLocalisation);

        Assert.assertTrue("Links don`t match", webDriver.getCurrentUrl().contains(linksProperties.UK()));
        return new StartPage(webDriver);
    }

}
