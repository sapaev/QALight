package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CommonActios {
    protected WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());

    WebDriverWait webDriverWait10;
    WebDriverWait webDriverWait15;

    public CommonActios(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.logger = logger;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    protected void enterTextInField(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text+ "entered in input field");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    protected void clickOnElement(WebElement webElement){
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }



    protected void clickOnCheckBoxEnable(WebElement webElement){
        try {
            if(!webElement.isSelected()){
                webElement.click();
            }else {
                logger.info("Checkbox "+webElement.getText()+"is already selected");
            }
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }



    protected void clickOnCheckBoxDisable(WebElement webElement){
        try {
            if(webElement.isSelected()){
                webElement.click();
            }else {
                logger.info("Checkbox "+webElement.getText()+"is not already selected");
            }
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    protected void selectRadioButton(WebElement webElement){
        if (!webElement.isSelected()){
            clickOnElement(webElement);
        }else {
            logger.info("Radiobutton is already selected");
        }
    }



    protected void selectRadioButton(String radio){
        WebElement radiobutton=webDriver.findElement(By.xpath(radio));
        selectRadioButton(radiobutton);
    }




    protected void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }


    protected boolean elementIsDisplayed(WebElement webElement){
        try{
            boolean state=webElement.isDisplayed();
            String message;
            if(state){
                message=webElement.getText()+"  is Displayed";
            }else {
                message=webElement.getText()+" is not Displayed";
            }
            logger.info(message);
            return state;
        }catch (Exception e){
            logger.error("Element is not Displayed");
            return false;
        }
    }






    protected void selectTextInDropdown(WebElement dropDown, String vivibleText){
        try {
            Select select=new Select(dropDown);
            select.selectByVisibleText(vivibleText);
            logger.info(vivibleText+" was selected in Dropdown");

        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }



    protected void selectValueInDropdown(WebElement dropDown, String value){
        try {
            Select select=new Select(dropDown);
            select.selectByValue(value);
            logger.info(value+" was selected in Dropdown");

        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }


    protected void clickOnElement(String xPath){
        try {
            clickOnElement(webDriver.findElement(By.xpath(xPath)));
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }


    protected boolean elementIsDisplayed(String text){
        try{
            WebElement webElement=webDriver.findElement(By.xpath(text));
            return elementIsDisplayed(webElement);
        }catch (Exception e){
            return false;
        }

    }

















}
