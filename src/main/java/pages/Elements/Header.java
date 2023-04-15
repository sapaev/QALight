package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.CommonActios;
import pages.HomePage;
import pages.SearchingWithFilterPage;

public class Header extends CommonActios {



    @FindBy(xpath = ".//em[text()='Увійти']")
    private WebElement loginButton;


    @FindBy(xpath = "//a[@class='info-nick']")
    private WebElement profileButton;


    @FindBy(xpath = ".//a[@jtype='click']/em[@title='Вийти']")
    private WebElement logOutButton;



    @FindBy(xpath = "//input[@id='ek-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@name='search_but_']")
    private WebElement searchButton;



    private String navigationTab=".//a[contains(text(),\"%s\")]\n";

    private String subCategory="//div[@class='mainmenu-sublist']//span[text()='%s']";

    Actions actions=new Actions(webDriver);

/*
    @FindBy(xpath = ".//div[@class='ib h']")
    private WebElement changeLocalizationButton;


    @FindBy(xpath = ".//div[@class='ek-form-group ek-form-group-sm posr ib']")
    private WebElement countryDropDownList;
*/

    public Header(WebDriver webDriver, Actions actions) {
        super(webDriver);
        this.actions = actions;
    }

    public Header(WebDriver webDriver) {

        super(webDriver);
    }

    public WebElement getProfileButton() {
        return profileButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }




    public WebElement getLogOutButton() {
        return logOutButton;
    }


    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }


    public Header hoverToTab(String nameOfTab){
        elementIsDisplayed(String.format(navigationTab,nameOfTab));
        WebElement tab= webDriver.findElement(By.xpath(String.format(navigationTab,nameOfTab)));
        actions.moveToElement(tab).build().perform();
        return this;
    }

    public SearchingWithFilterPage clickOnSubcategory(String nameOfSubcategory){
        elementIsDisplayed(String.format(subCategory,nameOfSubcategory));
        clickOnElement(String.format(subCategory,nameOfSubcategory));
        return new SearchingWithFilterPage(webDriver);
    }


}



