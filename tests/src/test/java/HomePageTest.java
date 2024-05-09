import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        homePage = new HomePage(driver);
    }

    @Test
    public void newsShouldBeOnThePage() {
        assertTrue(homePage.getNewsBlock().getText().toLowerCase().contains("news"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
