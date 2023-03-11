package pages;

import libs.Creds;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Elements.Header;

import java.time.Duration;

public class StartPage extends ParentPage {

    Header header = new Header(webDriver);
    @FindBy(xpath = ".//div[@id='mui_user_login_window']")
    private WebElement registrationForm;
    @FindBy(xpath = ".//div[text()='Або зареєструйтеся']")
    private WebElement registrationButton;
    @FindBy(xpath = ".//input[@name='p_[NikName]']")
    private WebElement nameField;
    @FindBy(xpath = ".//input[@name='p_[EMail]']")
    private WebElement emailField;
    @FindBy(xpath = ".//input[@name='p_[PW0]']")
    private WebElement passwordField;
    @FindBy(xpath = ".//button[text()='ЗАРЕЄСТРУВАТИСЯ']")
    private WebElement sumbitRegistrationButton;
    @FindBy(xpath = ".//input[@type='checkbox' and @name='rules_accepted_']")
    private WebElement privacyPolicyCheckBox;
    @FindBy(xpath = ".//button[text()=\"Підтвердити\"]")
    private WebElement submitPop_apAfterRegistration;


    @FindBy(xpath = ".//div[text()='E-mail']")
    private WebElement loginButton;
    @FindBy(xpath = ".//input[@placeholder='E-Mail або Логін']")
    private WebElement nameFieldForLogin;
    @FindBy(xpath = ".//input[@placeholder='Пароль' and @autocomplete='current-password']")
    private WebElement passwordFieldForLogin;
    @FindBy(xpath = ".//button[text()='УВІЙТИ']")
    private WebElement submitLoginButton;


    WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openStartPage() {
        try {
            webDriver.get("https://ek.ua/ua/");
            logger.info("StartPage was opened");
        } catch (Exception c) {
            logger.error("Can not open StartPage " + c);
            Assert.fail("Can not open StartPage " + c);
        }
    }

    public void enterUserNameForRegistration(String name) {
        enterTextInField(nameField, name);
    }

    public void enterEmailForRegistration(String email) {
        enterTextInField(emailField, email);
    }

    public void enterPasswordForRegistration(String password) {
        enterTextInField(passwordField, password);
    }

    public void clickOnPrivacyPolicyCheckBoxForRegistration() {
        clickOnCheckBoxEnable(privacyPolicyCheckBox);
    }

    public StartPage inputInRegistrationForm(String name, String email, String password) {
        clickOnElement(header.getLoginButton());
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationForm));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        clickOnElement(registrationButton);
        webDriverWait.until(ExpectedConditions.visibilityOf(sumbitRegistrationButton));
        enterUserNameForRegistration(name);
        enterEmailForRegistration(email);
        enterPasswordForRegistration(password);
        clickOnPrivacyPolicyCheckBoxForRegistration();
        return this;
    }

    public StartPage clickOnsumbitRegistrationButton() {
        clickOnElement(sumbitRegistrationButton);
        return this;
    }

    public HomePage submitRegistration() {
        clickOnElement(submitPop_apAfterRegistration);
        return new HomePage(webDriver);
    }


    public void enterEmailForLogin(String email) {
        enterTextInField(nameFieldForLogin, email);
    }

    public void enterPasswordForLogin(String password) {
        enterTextInField(passwordFieldForLogin, password);
    }

    public StartPage inputInLoginForm(String email, String password) {
        clickOnElement(header.getLoginButton());
        webDriverWait.until(ExpectedConditions.visibilityOf(registrationForm));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clickOnElement(loginButton);
        webDriverWait.until(ExpectedConditions.visibilityOf(submitLoginButton));
        enterEmailForLogin(email);
        enterPasswordForLogin(password);
        return this;
    }

    public HomePage clickOnSubmitLoginButton() {
        clickOnElement(submitLoginButton);
        return new HomePage(webDriver);
    }


    public StartPage checkIsRedirectOnStartPage(){
       Assert.assertTrue(elementIsDisplayed(header.getLoginButton()));
        return this;
    }





}
