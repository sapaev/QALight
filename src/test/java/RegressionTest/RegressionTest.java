package RegressionTest;

import CheckOfItemCounterInItemHistoryTest.CheckOfItemCounterInItemHistoryTest;
import EditProfileTest.EditProfileTest;
import FindItemWithFilterTest.FindItemWithFilterTest;
import ItemPageTest.ItemPageTest;
import LogOutTest.LogOutTest;
import LoginTest.LoginTest;
import RegistrationTest.RegistrationErrorText;
import RegistrationTest.RegistrationTest;
import SearchItemWithSearchField.SearchItemWithSearchFieldTest;
import checkLocalizationLink.LocalizationLinkTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LocalizationLinkTest.class,
        CheckOfItemCounterInItemHistoryTest.class,
        EditProfileTest.class,
        FindItemWithFilterTest.class,
        ItemPageTest.class,
        LoginTest.class,
        LogOutTest.class,
        RegistrationErrorText.class,
        SearchItemWithSearchFieldTest.class,
})
public class RegressionTest {
}
