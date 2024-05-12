import core.DriverInitializer;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>Static page load test</p>
 * <p>The test cases verify the basic load of the pages (from external source) and check their page title</p>
 */
public class StaticPageLoadTest {

    private WebDriver driver;

    @ParameterizedTest(name = "{index} - {0} should have title {1}")
    @CsvFileSource(files = "data.csv")
    @DisplayName("Verify static page titles")
    public void testPageTitles(String url, String expectedTitle) throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));
        driver.get(url);

        assertTrue(stringContains(driver.getTitle(), expectedTitle));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
