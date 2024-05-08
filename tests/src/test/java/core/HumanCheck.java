package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HumanCheck {

    private final WebDriverWait wait;

    private final By frameSelector = By.xpath("//iframe[@title='Widget containing a Cloudflare security challenge']");
    private final By checkboxSelector = By.xpath("//label[@class='ctp-checkbox-label']");

    public HumanCheck(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void check() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameSelector));
        wait.until(ExpectedConditions.elementToBeClickable(checkboxSelector)).click();
    }
}
