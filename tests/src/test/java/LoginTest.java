import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ForumPage;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private ForumPage forumPage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        final var driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        final var homePage = new HomePage(driver);

        forumPage = homePage.clickForumNavItem();
    }

    @Test
    public void invalidUsernameShouldCauseError() {
        forumPage.tryToLogin("asd123asd123asd123", "asd123asd123asd123");

        assertTrue(forumPage.getBlockMessage().getText().contains("could not be found"));
    }

    @Test
    public void invalidPasswordShouldCauseError() {
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), "asd123asd123asd123");

        assertTrue(forumPage.getBlockMessage().getText().toLowerCase().contains("incorrect password"));
    }

    @Test
    public void validUsernameAndPasswordShouldBeSuccess() {
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));

        assertTrue(forumPage.getNotice().getText().contains("Welcome"));
        assertTrue(forumPage.getNotice().getText().contains(Configuration.getProperty(ConfigKey.USERNAME)));
    }

    @Test
    public void onLogoutClickShouldLogout() {
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));
        forumPage.getUserProfileLink().click();
        forumPage.clickLogoutButton();
    }
}
