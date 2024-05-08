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

public class ForumTest {

    private ForumPage forumPage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        final var driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        final var homePage = new HomePage(driver);

        forumPage = homePage.clickForumNavItem();
    }

    @Test
    public void loginButtonShouldBeVisible() {
        assertTrue(forumPage.getLoginButton().isDisplayed());
    }

    @Test
    public void onLoginClickLoginDialogShouldDisplayed() {
        forumPage.clickLoginButton();
        assertTrue(forumPage.overlayTitle().isDisplayed());
        assertTrue(forumPage.overlayTitle().getText().contains("Log in"));
    }
}
