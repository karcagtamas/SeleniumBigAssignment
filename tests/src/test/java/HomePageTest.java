import core.DriverInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class HomePageTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        final var driver = DriverInitializer.initialize("http://selenium:4444/wd/hub");
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePage() {

    }
}
