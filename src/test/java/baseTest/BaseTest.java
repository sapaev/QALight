package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.StartPage;


import java.time.Duration;


public class BaseTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected StartPage startPage;
    protected HomePage homePage;





    @Before
    public void setUp() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(ops);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        startPage = new StartPage(webDriver);
        homePage=new HomePage(webDriver);


    }

/*
    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }*/


}

