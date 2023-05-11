package ItemPageTest;

import baseTest.BaseTest;
import libs.Creds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ItemPageTest extends BaseTest {

    private final String nameItem="Монітор Samsung C24F390F";




    @Before
    public void autorization() {
        startPage.openStartPage();
        startPage.inputInLoginForm(Creds.MY_EMAIL, Creds.MY_PASSWORD)
                .clickOnSubmitLoginButton()
                .closeWelcomePop_up()
                .checkIsRedirectOnHomePage();
    }


    @Test
    public void openCardOfItem() throws InterruptedException {
        homePage.inputNameItemInSeachField(nameItem)
                .clickOnstartSearchingButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithTextInItemsList("Samsung")
                .openItemCard(nameItem)
                .checkIsRedirectOnItemCardPage()
        ;

    }


    @Test
    public void checkOpeningCopiedLinkOfItem() throws InterruptedException {
        String copiedText=
                homePage.inputNameItemInSeachField(nameItem)
                .clickOnstartSearchingButton()
                .checkIsRedirectOnResultsSearchingPage()
                .checkSuccessfullySearchingWithTextInItemsList("Samsung")
                .openItemCard(nameItem)
                .checkIsRedirectOnItemCardPage()
                .copyUrlOfItemPage();
        String firstURL=webDriver.getCurrentUrl();
        itemCardPage.openCopiedLink(copiedText);

        String secondURL=webDriver.getCurrentUrl();


        //WebDriver webDriverForAnotherPage=initDriver();
        //SellerAnotherPage sellerAnotherPage=new SellerAnotherPage(webDriverForAnotherPage);
        //sellerAnotherPage.openCopiedLink(copiedText);
        //String secondURL=webDriver.getCurrentUrl();


       // webDriverForAnotherPage.quit();

        Assert.assertTrue("Links do not match", firstURL.equals(secondURL));

    }

/*

    private WebDriver initDriver(){
        String browser=System.getProperty("browser");
        if ((browser==null) || (browser.equalsIgnoreCase("chrome"))){
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(ops);
        }else if (browser.equalsIgnoreCase("mozila")){
            FirefoxOptions ops=new FirefoxOptions();
            ops.addArguments("--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().setup();
            webDriver=new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            EdgeOptions ops=new EdgeOptions();
            ops.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            webDriver=new EdgeDriver();
        }
        return webDriver;
    }


 */
}
