package core;

import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public abstract class SeleniumTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {
        driver = DriverInitializer.initialize(Configuration.getProperty(ConfigKey.BROWSER));

        testCaseInitializer(driver);
    }

    /**
     * Set up test case (Test) specific settings. It is defined by the child.
     * @param driver Current WebDriver
     */
    protected abstract void testCaseInitializer(WebDriver driver);

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
