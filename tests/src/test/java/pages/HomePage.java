package pages;

import core.BasePage;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);

        driver.get(Configuration.getProperty(ConfigKey.URL));
    }
}
