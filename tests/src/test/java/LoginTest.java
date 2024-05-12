import core.SeleniumTest;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ForumPage;
import pages.HomePage;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>Test cases for Login/Logout functionality.<p/>
 * <p>The cases test the success and denied cases too</p>
 */
public class LoginTest extends SeleniumTest {

    private ForumPage forumPage;

    @Override
    protected void testCaseInitializer(WebDriver driver) {
        final var homePage = new HomePage(driver);

        forumPage = homePage.clickOnForumNavigationItem();
    }

    @Test
    @DisplayName("Test login with invalid entries (username and password)")
    public void invalidUsernameShouldCauseUsernameNotFoundError() {
        forumPage.doLogin("asd123asd123asd123", "asd123asd123asd123");

        assertTrue(stringContains(forumPage.getBlockMessage().getText(), "could not be found"));
    }

    @Test
    @DisplayName("Test login with invalid password (username is valid)")
    public void invalidPasswordShouldCauseIncorrectPasswordError() {
        forumPage.doLogin(Configuration.getProperty(ConfigKey.USERNAME), "asd123asd123asd123");

        assertTrue(stringContains(forumPage.getBlockMessage().getText(), "incorrect password"));
    }

    @Test
    @DisplayName("Test successful login scenario")
    public void validUsernameAndPasswordShouldDisplayWelcome() {
        forumPage.doLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));

        assertTrue(stringContains(forumPage.getNotices().getText(), "Welcome"));
        assertTrue(stringContains(forumPage.getNotices().getText(), Configuration.getProperty(ConfigKey.USERNAME)));
    }

    @Test
    @DisplayName("Test logout scenario")
    public void onLogoutClickPageShouldDoLogout() {
        forumPage.doLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));
        forumPage.clickOnLogoutButton();
    }
}
