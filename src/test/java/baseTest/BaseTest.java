package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.HomePage;
import pages.ItemCardPage;
import pages.StartPage;


import java.time.Duration;


public class BaseTest {
    protected WebDriver webDriver;


    Logger logger = Logger.getLogger(getClass());
    protected StartPage startPage;
    protected HomePage homePage;

    protected ItemCardPage itemCardPage;





    @Before
    public void setUp() {
        logger.info("----------"+testName.getMethodName()+" was started----------");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        webDriver=initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        startPage = new StartPage(webDriver);
        homePage=new HomePage(webDriver);
        itemCardPage=new ItemCardPage(webDriver);


    }

    @Rule
    public TestName testName=new TestName();


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


   // @After
    public void tearDown() {
    logger.info("----------"+testName.getMethodName()+" was ended----------");
    webDriver.quit();
    logger.info("Browser was closed");
    }

}

