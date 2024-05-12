import core.SeleniumTest;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AccountDetailsPage;
import pages.HomePage;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>Test cases for the Account Details Page</p>
 * <p>The test cases verify the static overview of the Account Details page</p>
 */
public class AccountDetailsPageTest extends SeleniumTest {

    private AccountDetailsPage accountDetailsPage;

    @Override
    protected void testCaseInitializer(WebDriver driver) {
        final var homePage = new HomePage(driver);
        final var forumPage = homePage.clickOnForumNavigationItem();
        forumPage.doLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));
        accountDetailsPage = forumPage.openAccountDetailsPage();
    }

    @Test
    @DisplayName("Verify username visibility on the form")
    public void usernameShouldBeVisibleOnTheForm() {
        assertTrue(stringContains(accountDetailsPage.getForm().getText(), Configuration.getProperty(ConfigKey.USERNAME)));
    }

    @Test
    @DisplayName("Verify the currently selected navigator item")
    public void selectedNavigationItemShouldBeAccountDetails() {
        assertTrue(stringContains(accountDetailsPage.getSelectedNavigationItemText(), "Account details"));
    }

    @Test
    @DisplayName("Verify the page title")
    public void pageTitleShouldContainsAccountDetailsWord() {
        assertTrue(stringContains(accountDetailsPage.getTitle(), "Account details")); // Static test for current page title
    }
}
