import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ForumPage;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private ForumPage forumPage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        final var homePage = new HomePage(driver);

        forumPage = homePage.clickForumNavItem();
    }

    @Test
    public void invalidUsernameShouldCauseError() {
        forumPage.tryToLogin("asd123asd123asd123", "asd123asd123asd123");

        assertTrue(stringContains(forumPage.getBlockMessage().getText(), "could not be found"));
    }

    @Test
    public void invalidPasswordShouldCauseError() {
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), "asd123asd123asd123");

        assertTrue(stringContains(forumPage.getBlockMessage().getText(), "incorrect password"));
    }

    @Test
    public void validUsernameAndPasswordShouldBeSuccess() {
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));

        assertTrue(stringContains(forumPage.getNotices().getText(), "Welcome"));
        assertTrue(stringContains(forumPage.getNotices().getText(), Configuration.getProperty(ConfigKey.USERNAME)));
    }

    @Test
    public void onLogoutClickShouldLogout() {
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));
        forumPage.clickLogoutButton();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
