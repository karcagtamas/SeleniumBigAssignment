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

public class ForumTest {

    private WebDriver driver;
    private ForumPage forumPage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        final var homePage = new HomePage(driver);

        forumPage = homePage.clickForumNavItem();
    }

    @Test
    public void titleShouldContainsForumWord() {
        assertTrue(stringContains(forumPage.getTitle(), "Forum"));
    }

    @Test
    public void loginButtonShouldBeVisible() {
        assertTrue(forumPage.getLoginButton().isDisplayed());
    }

    @Test
    public void onLoginClickLoginDialogShouldDisplayed() {
        forumPage.clickLoginButton();
        assertTrue(forumPage.overlayTitle().isDisplayed());
        assertTrue(stringContains(forumPage.overlayTitle().getText(), "Log in"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
