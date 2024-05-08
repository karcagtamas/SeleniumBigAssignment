package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);

        driver.get("https://karcags.eu:9800");

        body();

        // doHumanCheck();
    }
}
