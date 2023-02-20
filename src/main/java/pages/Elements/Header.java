package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActios;

public class Header extends CommonActios {



    @FindBy(xpath = ".//em[text()='Увійти']")
    private WebElement loginButton;


    @FindBy(xpath = "//a[@class='info-nick']")
    private WebElement profileButton;


    @FindBy(xpath = ".//a[@jtype='click']/em[@title='Вийти']")
    private WebElement logOutButton;

/*
    @FindBy(xpath = ".//div[@class='ib h']")
    private WebElement changeLocalizationButton;


    @FindBy(xpath = ".//div[@class='ek-form-group ek-form-group-sm posr ib']")
    private WebElement countryDropDownList;
*/

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








}



