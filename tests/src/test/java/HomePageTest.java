import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        final var driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePage() {
        final var body = homePage.body();

        assertTrue(body.getText().contains(""));
    }
}
