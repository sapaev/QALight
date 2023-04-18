package checkLocalizationLink;

import baseTest.BaseTest;
import libs.LinksProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Before;
import org.junit.Test;

public class LocalizationLinkTest extends BaseTest {

    public static LinksProperties linksProperties= ConfigFactory.create(LinksProperties.class);


    @Before
    public void openStartPage_UkraineLocalisation(){
        startPage.openStartPage();
    }


    @Test
    public void checkLocalizationLink(){
        startPage.getFooter().checkLocalisationLink_UK();
    }
}
