package pages;

import org.assertj.core.api.SoftAssertions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultsSearchingPage extends ParentPage{



    @FindBy(xpath = "//div[@class='page-title']/h1[contains(text(),'За запитом ')]")
    private WebElement titleResultText;

    @FindBy(xpath = "//div[@class='model-short-div list-item--goods   ']")
    private WebElement itemFromResultList;

    @FindBy(xpath = "//a[@class='model-short-title no-u']")
    private List<WebElement> listOfResults;


    private String itemCard="//a[@class='model-short-title no-u' and contains(@title,'%s')]";


    @FindBy(xpath = "//div[@class='model-short-div list-item--goods-group ms-grp ']")
    private WebElement extentedlistOfResults;

    @FindBy(xpath = "//span[@class='u']")
    private List<WebElement> listOfResultsFromExtentedList;



    Actions actions=new Actions(webDriver);




    public ResultsSearchingPage(WebDriver webDriver) {
        super(webDriver);
    }


    public ResultsSearchingPage checkIsRedirectOnResultsSearchingPage(){
        try {
            Assert.assertTrue("Searching is successfully",elementIsDisplayed(itemFromResultList));
        }catch (Exception e){
            Assert.assertTrue("Searching is successfully", elementIsDisplayed(extentedlistOfResults));
        }
        return this;
    }

        //Assert.assertTrue("Searching is successfully",elementIsDisplayed(itemFromResultList) || elementIsDisplayed(extentedlistOfResults));


    public ResultsSearchingPage checkIsRedirectOnResultsSearchingWithInputFieldPageAfterNegativeCase() throws InterruptedException {
        Thread.sleep(5000);
        webDriverWait10.until(ExpectedConditions.invisibilityOf(itemFromResultList));
        Assert.assertFalse(elementIsDisplayed("//a[@class='model-short-title no-u']"));
        return this;
    }




public ResultsSearchingPage checkSuccessfullySearchingWithTextInItemsList(String itemName){
    for (int i=0; i<listOfResults.size(); i++){
        elementIsDisplayed(listOfResults.get(i));
        Assert.assertThat("",listOfResults.get(i).getText(), CoreMatchers.containsString(itemName));
        if(i<listOfResults.size()-1){
            actions.moveToElement(listOfResults.get(i+1)).build().perform();
        }
    }
    return this;
}



    public ResultsSearchingPage checkSuccessfullySearchingWithFilterInItemsList(List<String> array){
        for (int i=0; i<listOfResultsFromExtentedList.size(); i++){
            elementIsDisplayed(listOfResultsFromExtentedList.get(i));
            String itemName=listOfResultsFromExtentedList.get(i).getText();
              for(int a=0; a<array.size(); a++){
                  if(itemName.contains(array.get(a))){
                      Assert.assertThat("Бренды не совпадают",  itemName,CoreMatchers.containsString(array.get(a)));
                      System.out.println("бренды совпали: чекбокс "+array.get(a)+" нашел товар "+itemName);
                  }

              }
            if(i<listOfResultsFromExtentedList.size()-1){
                actions.moveToElement(listOfResultsFromExtentedList.get(i+1)).build().perform();
            }
        }
        return this;
    }






public ResultsSearchingPage cardOfItemIsDisplayed(String nameOfItem){
        elementIsDisplayed(String.format(itemCard,nameOfItem));
        return this;
}


public ItemCardPage openItemCard(String nameOfItem){
       cardOfItemIsDisplayed(String.format(itemCard,nameOfItem));
       clickOnElement(String.format(itemCard,nameOfItem));
        return new ItemCardPage(webDriver);
}


}

