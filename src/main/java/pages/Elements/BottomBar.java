package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActios;

import java.util.ArrayList;
import java.util.List;

public class BottomBar  extends CommonActios {

    @FindBy(xpath = "//span[@id='name_bm_visited']")
    private WebElement historyButton;

    @FindBy(xpath = "//div[@id='mask_bm_visited']")
    private WebElement visitedItemsBar;

    @FindBy(xpath = "//div[@id='stripe_bm_visited']/a/div[3]")
    private List<WebElement> listOfVisitedItems;

    @FindBy(xpath = "//div[@id='stripe_bm_visited']/a/div[@class='panel-item-close']")
    private List<WebElement> closeButtonOfVisitedItems;



    @FindBy(xpath = "//span[@id='name_bm_marked']")
    private WebElement likedItemsButton;

    @FindBy(xpath = "//div[@id='stripe_bm_marked']")
    private WebElement likedItemsBar;

    @FindBy(xpath = "//div[@id='stripe_bm_marked']/a/div[3]")
    private List<WebElement> listOfLikedItems;

    @FindBy(xpath = "//div[@id='stripe_bm_marked']/a/div[@class='panel-item-close']")
    private List<WebElement> closeButtonOfLikedItems;





    @FindBy(xpath = "//span[@id='name_bm_compared']")
    private WebElement comparedItemsButton;

    @FindBy(xpath = "//div[@id='stripe_bm_compared']")
    private WebElement comparedItemsBar;

    @FindBy(xpath = "//div[@id='stripe_bm_compared']/a/div[3]")
    private List<WebElement> listOfComparedItems;

    @FindBy(xpath = "//div[@id='stripe_bm_compared']/a/div[@class='panel-item-close']")
    private List<WebElement> closeButtonOfComparedItems;





    public BottomBar(WebDriver webDriver) {
        super(webDriver);
    }


    public List<String> getListOflistOfComparedItems(){
        List<String> listOfComparedItems=new ArrayList<>();
        for (int i = 0; i < listOfLikedItems.size(); i++) {
            elementIsDisplayed(listOfLikedItems.get(i));
            listOfComparedItems.add(listOfLikedItems.get(i).getText());
        }
        return listOfComparedItems ;
    }








    public WebElement getHistoryButton() {
        return historyButton;
    }

    public void setHistoryButton(WebElement historyButton) {
        this.historyButton = historyButton;
    }

    public WebElement getVisitedItemsBar() {
        return visitedItemsBar;
    }

    public void setVisitedItemsBar(WebElement visitedItemsBar) {
        this.visitedItemsBar = visitedItemsBar;
    }

    public List<WebElement> getListOfVisitedItems() {
        return listOfVisitedItems;
    }

    public void setListOfVisitedItems(List<WebElement> listOfVisitedItems) {
        this.listOfVisitedItems = listOfVisitedItems;
    }

    public List<WebElement> getCloseButtonOfVisitedItems() {
        return closeButtonOfVisitedItems;
    }

    public void setCloseButtonOfVisitedItems(List<WebElement> closeButtonOfVisitedItems) {
        this.closeButtonOfVisitedItems = closeButtonOfVisitedItems;
    }

    public WebElement getLikedItemsButton() {
        return likedItemsButton;
    }

    public void setLikedItemsButton(WebElement likedItemsButton) {
        this.likedItemsButton = likedItemsButton;
    }

    public WebElement getLikedItemsBar() {
        return likedItemsBar;
    }

    public void setLikedItemsBar(WebElement likedItemsBar) {
        this.likedItemsBar = likedItemsBar;
    }

    public List<WebElement> getListOfLikedItems() {
        return listOfLikedItems;
    }

    public void setListOfLikedItems(List<WebElement> listOfLikedItems) {
        this.listOfLikedItems = listOfLikedItems;
    }

    public List<WebElement> getCloseButtonOfLikedItems() {
        return closeButtonOfLikedItems;
    }

    public void setCloseButtonOfLikedItems(List<WebElement> closeButtonOfLikedItems) {
        this.closeButtonOfLikedItems = closeButtonOfLikedItems;
    }

    public WebElement getComparedItemsButton() {
        return comparedItemsButton;
    }

    public void setComparedItemsButton(WebElement comparedItemsButton) {
        this.comparedItemsButton = comparedItemsButton;
    }

    public WebElement getComparedItemsBar() {
        return comparedItemsBar;
    }

    public void setComparedItemsBar(WebElement comparedItemsBar) {
        this.comparedItemsBar = comparedItemsBar;
    }

    public List<WebElement> getListOfComparedItems() {
        return listOfComparedItems;
    }

    public void setListOfComparedItems(List<WebElement> listOfComparedItems) {
        this.listOfComparedItems = listOfComparedItems;
    }

    public List<WebElement> getCloseButtonOfComparedItems() {
        return closeButtonOfComparedItems;
    }

    public void setCloseButtonOfComparedItems(List<WebElement> closeButtonOfComparedItems) {
        this.closeButtonOfComparedItems = closeButtonOfComparedItems;
    }
}
