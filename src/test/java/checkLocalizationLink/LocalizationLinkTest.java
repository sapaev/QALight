package checkLocalizationLink;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import libs.LinksProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class LocalizationLinkTest extends BaseTest {

    public static LinksProperties linksProperties= ConfigFactory.create(LinksProperties.class);

    private final String nameOfUK="UK";
    private final String nameOfUKRAINE="UKRAINE";
    private final String nameOfUSA="USA";
    private final String nameOfPOLAND="POLAND";
    private final String nameOfKAZAKHSTAN="KAZAKHSTAN";

    @Before
    public void openStartPage_UkraineLocalisation(){
        startPage.openStartPage();
    }


    @Test
    public void checkLocalizationLink_UK(){
        startPage.getFooter()
                .checkLocalisationLink_UK(nameOfUK);
    }

    @Test
    public void checkLocalizationLink_UKRAINE(){
        startPage.getFooter()
                .checkLocalisationLink_UK(nameOfUKRAINE);
    }

    @Test
    public void checkLocalizationLink_USA(){
        startPage.getFooter()
                .checkLocalisationLink_UK(nameOfUSA);
    }

    @Test
    public void checkLocalizationLink_POLAND(){
        startPage.getFooter()
                .checkLocalisationLink_UK(nameOfPOLAND);
    }

    @Test
    public void checkLocalizationLink_KAZAKHSTAN(){
        startPage.getFooter()
                .checkLocalisationLink_UK(nameOfKAZAKHSTAN);
    }


    @Parameters(method = "provideParameters")
    @TestCaseName("nameOfCountry : nameOfCountry = {0}")
    @Test
    public void checkLocalizationLink(String nameOfCountry){
        startPage.getFooter()
                .checkLocalisationLink_UK(nameOfCountry);
    }

    public static Object[][] provideParameters() {
        return new Object[][] {
                new Object[] {"UK"},
                new Object[] {"UKRAINE"},
                new Object[] {"USA"},
                new Object[] {"POLAND"},
                new Object[] {"KAZAKHSTAN"},
        };
    }




}
