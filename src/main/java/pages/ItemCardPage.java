package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Elements.BottomBar;
import pages.Elements.Header;
import pages.ParentPage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.List;

public class ItemCardPage extends ParentPage {


    private Header header = new Header(webDriver);

    private BottomBar bottomBar=new BottomBar(webDriver);

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement titleOfItem;


    @FindBy(xpath = "//div[@class='goto-price-charts']")
    private WebElement priceChartsButton;


    @FindBy(xpath = "//div[@class='share-btn']")
    private WebElement shareButton;

    @FindBy(xpath = "//div[@class='share__link__input-wrap']/button[@type='button']")
    private WebElement copyLinkOfPageButton;




    @FindBy(xpath = "//div[@class='conf-table-container']")
    private WebElement tableOfDifferentVersions;

    @FindBy(xpath = "//div[@class='conf-table-container']/table/tbody/tr/td/a[@class='conf-name']")
    private List<WebElement> listOfLinkVersionsPage;

    //@FindBy(xpath = "//div[@class='toggle-off']/input[@class='custom-checkbox']")
    @FindBy(xpath = "//div[@class='toggle-off']")
    private WebElement checkBoxForAddingToComparableBar;



    @FindBy(xpath = "//h1[@itemprop='name']/span[@class='item-conf-name ib nobr']")
    private WebElement codeOfItem;


    public ItemCardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BottomBar getBottomBar() {
        return bottomBar;
    }

    public void setBottomBar(BottomBar bottomBar) {
        this.bottomBar = bottomBar;
    }

    public ItemCardPage checkIsRedirectOnItemCardPage() {
        Assert.assertTrue("Title of Item is displayed", elementIsDisplayed("//h1[@itemprop='name']")
                || elementIsDisplayed("//div[@class='conf-desc-ai-title']")
                || elementIsDisplayed("//div[@class='item-block']")
                || elementIsDisplayed("//div[@class='conf-table-container']"));

        return this;
    }








    public MyProfile redirectOnMyProfilePageFromItemCardPage() {
        clickOnElement(header.getProfileButton());
        return new MyProfile(webDriver);
    }


    public String copyUrlOfItemPage() {
        elementIsDisplayed(shareButton);
        clickOnElement(shareButton);

        webDriverWait10.until(ExpectedConditions.elementToBeClickable(copyLinkOfPageButton));
        clickOnElement(copyLinkOfPageButton);


        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Получаем содержимое буфера обмена в виде объекта Transferable
        Transferable contents = clipboard.getContents(null);

        String text = "";

        // Проверяем, поддерживает ли буфер обмена формат строки
        if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                // Получаем содержимое буфера обмена в виде строки
                text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                System.out.println("Скопированный текст: " + text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return text;
    }


    public void openCopiedLink(String copiedURL) {
        webDriver.get(copiedURL);
    }


    public ItemCardPage addToComparableList(){
       if(elementIsDisplayed(tableOfDifferentVersions)){
           clickOnElement(listOfLinkVersionsPage.get(1));
           webDriverWait10.until(ExpectedConditions.visibilityOf(checkBoxForAddingToComparableBar));
           clickOnElement(checkBoxForAddingToComparableBar);
           return new ItemCardPage(webDriver);
       }
        webDriverWait10.until(ExpectedConditions.visibilityOf(checkBoxForAddingToComparableBar));
        clickOnElement(checkBoxForAddingToComparableBar);
        return this;
    }


    public String getCodeOfItem(){
        elementIsDisplayed(codeOfItem);
        String code=codeOfItem.getText();
        return code;
    }








}
