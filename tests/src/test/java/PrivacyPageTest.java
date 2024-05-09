import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.PrivacyPage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrivacyPageTest {

    private WebDriver driver;
    private PrivacyPage privacyPage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        final var homePage = new HomePage(driver);
        final var forumPage = homePage.clickForumNavItem();
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));
        final var accountDetailsPage = forumPage.openAccountDetails();
        privacyPage = accountDetailsPage.openPrivacyPage();
    }

    @Test
    public void usernameShouldBeVisibleOnTheForm() {
        privacyPage.selectStatusCheckbox();
        privacyPage.clickSubmitButton();

        assertTrue(true);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
