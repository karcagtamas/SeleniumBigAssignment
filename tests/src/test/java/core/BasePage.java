package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Properties properties;

    protected final By bodySelector = By.tagName("body");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        properties = Configuration.getProperties();
    }

    protected WebElement waitAndGet(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector);
    }

    public WebElement body() {
        return waitAndGet(bodySelector);
    }

    protected String getText(By selector) {
        return waitAndGet(selector).getText();
    }

    protected void click(By selector) {
        waitAndGet(selector).click();
    }

    protected void doHumanCheck() {
        final var humanCheck = new HumanCheck(driver);
        humanCheck.check();
    }
}
