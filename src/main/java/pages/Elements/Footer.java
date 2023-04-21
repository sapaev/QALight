package pages.Elements;

import libs.LinksProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CommonActios;
import pages.StartPage;


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


    public StartPage checkLocalisationLink(String nameOfCountry) {
        if(nameOfCountry.equalsIgnoreCase("UK")) {
            elementIsDisplayed(String.format(linkForAnotherCountry, linksProperties.UK()));
            WebElement linkLocalisation = webDriver.findElement(By.xpath(String.format(linkForAnotherCountry, linksProperties.UK())));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(linkLocalisation).build().perform();
            clickOnElement(linkLocalisation);
            Assert.assertTrue("Links don`t match", webDriver
                    .getCurrentUrl().contains(linksProperties.UK()));
        } else if (nameOfCountry.equalsIgnoreCase("UKRAINE")) {
            elementIsDisplayed(String.format(linkForAnotherCountry, linksProperties.UKRAINE()));
            WebElement linkLocalisation = webDriver.findElement(By.xpath(String.format(linkForAnotherCountry, linksProperties.UKRAINE())));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(linkLocalisation).build().perform();
            clickOnElement(linkLocalisation);
            Assert.assertTrue("Links don`t match", webDriver
                    .getCurrentUrl().contains(linksProperties.UKRAINE()));
        } else if (nameOfCountry.equalsIgnoreCase("USA")) {
            elementIsDisplayed(String.format(linkForAnotherCountry, linksProperties.USA()));
            WebElement linkLocalisation = webDriver.findElement(By.xpath(String.format(linkForAnotherCountry, linksProperties.USA())));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(linkLocalisation).build().perform();
            clickOnElement(linkLocalisation);
            Assert.assertTrue("Links don`t match", webDriver
                    .getCurrentUrl().contains(linksProperties.USA()));
        } else if (nameOfCountry.equalsIgnoreCase("POLAND")) {
            elementIsDisplayed(String.format(linkForAnotherCountry, linksProperties.POLAND()));
            WebElement linkLocalisation = webDriver
                    .findElement(By.xpath(String.format(linkForAnotherCountry, linksProperties.POLAND())));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(linkLocalisation).build().perform();
            clickOnElement(linkLocalisation);
            Assert.assertTrue("Links don`t match", webDriver
                    .getCurrentUrl().contains(linksProperties.POLAND()));
        }else if (nameOfCountry.equalsIgnoreCase("KAZAKHSTAN")) {
            elementIsDisplayed(String.format(linkForAnotherCountry, linksProperties.KAZAKHSTAN()));
            WebElement linkLocalisation = webDriver
                    .findElement(By.xpath(String.format(linkForAnotherCountry, linksProperties.KAZAKHSTAN())));
            Actions actions = new Actions(webDriver);
            actions.moveToElement(linkLocalisation).build().perform();
            clickOnElement(linkLocalisation);
            Assert.assertTrue("Links don`t match", webDriver
                    .getCurrentUrl().contains(linksProperties.KAZAKHSTAN()));
        }


        return new StartPage(webDriver);
    }

}
