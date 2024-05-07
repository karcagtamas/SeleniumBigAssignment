package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);

        driver.get("http://app.roll20.net");
    }
}
