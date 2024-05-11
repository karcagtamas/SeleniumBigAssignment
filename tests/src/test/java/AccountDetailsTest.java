import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AccountDetailsPage;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountDetailsTest {

    private WebDriver driver;
    private AccountDetailsPage accountDetailsPage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        final var homePage = new HomePage(driver);
        final var forumPage = homePage.clickForumNavItem();
        forumPage.tryToLogin(Configuration.getProperty(ConfigKey.USERNAME), Configuration.getProperty(ConfigKey.PASSWORD));
        accountDetailsPage = forumPage.openAccountDetails();
    }

    @Test
    public void usernameShouldBeVisibleOnTheForm() {
        assertTrue(stringContains(accountDetailsPage.getForm().getText(), Configuration.getProperty(ConfigKey.USERNAME)));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
