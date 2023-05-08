package RegressionTest;

import CheckOfItemCounterInItemHistoryTest.CheckOfItemCounterInItemHistoryTest;
import EditProfileTest.EditProfileTest;
import FindItemWithFilterTest.FindItemWithFilterTest;
import LogOutTest.LogOutTest;
import RegistrationTest.RegistrationErrorText;
import RegistrationTest.RegistrationTest;
import checkLocalizationLink.LocalizationLinkTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LocalizationLinkTest.class,
        CheckOfItemCounterInItemHistoryTest.class,
        EditProfileTest.class,
        FindItemWithFilterTest.class,
        LogOutTest.class,
        RegistrationErrorText.class,
})
public class RegressionTest {
}
