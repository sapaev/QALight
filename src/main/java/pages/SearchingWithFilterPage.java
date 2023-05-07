package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchingWithFilterPage extends ParentPage {


    @FindBy(xpath = "//div[@class='rm-div div-match-form open']")
    private WebElement filtersForm;

    @FindBy(xpath = "//input[@id='match_submit']")
    private WebElement submitFiletButton;


    @FindBy(xpath = "//span[@id='br_all']")
    private WebElement openListOfBrandsButton;


    private String itemOnFilterForm = "//div[@id='manufacturers_presets']/ul/li[%s]/label";

    private String checkBoxForBrand="//div[@id='manufacturers_presets']/ul/li[%s]/input";


    @FindBy(xpath = "//div[@id='manufacturers_presets']/ul/li")
    private List<WebElement> listOfBrandCheckboxes;


    @FindBy(xpath = "//input[@id=\"match_submit\" and @class=\"submit-button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@href='#']/span[text()='Запитання і побажання по підбору (пошуку) товару']")
    private WebElement answerForSearchingLink;

    @FindBy(xpath = "//span[text()='Рейтинг брендів']")
    private WebElement ratingOfBrandsButton;



    @FindBy(xpath = "//div[@class=\"all-link\"]/a")
    private WebElement showAllItemsButton;

    Actions actions = new Actions(webDriver);

    public SearchingWithFilterPage(WebDriver webDriver) {
        super(webDriver);
    }


    public SearchingWithFilterPage checkIsRedirectToSearchingWithFilterPage() {
        Assert.assertTrue(elementIsDisplayed(filtersForm));
        Assert.assertTrue(elementIsDisplayed(submitFiletButton));
        return this;
    }


    public SearchingWithFilterPage openAllListOfBrands() {
        elementIsDisplayed(openListOfBrandsButton);
        actions.moveToElement(openListOfBrandsButton).build().perform();


        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,100)", "");
        clickOnElement(openListOfBrandsButton);
        return this;
    }

    public WebElement getElements(String locator) {
        elementIsDisplayed(locator);
        WebElement element = webDriver.findElement(By.xpath(locator));
        return element;
    }

    public SearchingWithFilterPage selectCheckBoxOfBrands(int countOfSelectedBrands) {

        for (int i = 0, j = 0; i < listOfBrandCheckboxes.size(); i++) {
            elementIsDisplayed(listOfBrandCheckboxes.get(i));
            elementIsDisplayed(String.format(itemOnFilterForm, i + 1));
            WebElement element = getElements(String.format(itemOnFilterForm, i + 1));
            if (element.isEnabled() && !element.isSelected() && j < countOfSelectedBrands && j < listOfBrandCheckboxes.size()) {
                actions.moveToElement(ratingOfBrandsButton).build().perform();
                actions.moveToElement(element).build().perform();
                element.click();
                j++;
            }
        }
        return this;
    }


    public ResultsSearchingPage clickOnSearchButton() {
        elementIsDisplayed(searchButton);
        elementIsDisplayed(answerForSearchingLink);

        actions.moveToElement(answerForSearchingLink).build().perform();
        clickOnElement(searchButton);
        return new ResultsSearchingPage(webDriver);
    }


    public List<String> selectedBrandCheckBoxes() {

        List<String> selectedBrand = new ArrayList();

        for (int i = 0; i < listOfBrandCheckboxes.size(); i++) {
            elementIsDisplayed(String.format(itemOnFilterForm, i + 1));
            WebElement element = getElements(String.format(checkBoxForBrand, i + 1));

            if (element.isSelected()) {
                actions.moveToElement(ratingOfBrandsButton).build().perform();
                actions.moveToElement(listOfBrandCheckboxes.get(i)).build().perform();

                String selectedCheckBox = listOfBrandCheckboxes.get(i).getText();
                selectedBrand.add(selectedCheckBox);


                //webDriver.findElement(By.xpath("item")).findElement(By.xpath("sub-item"));
            }
        }

        return selectedBrand;
    }


    public ResultsSearchingPage clickOnShowAllItemsButton() {
       elementIsDisplayed(showAllItemsButton);
       clickOnElement(showAllItemsButton);
       return new ResultsSearchingPage(webDriver);
    }
}
