package core;

import core.configuration.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Properties properties;

    protected final By bodySelector = By.tagName("body");

    protected final By overlayTitleSelector = By.xpath("//div[contains(@class, 'overlay-container')]//div[@class='overlay-title']");
    protected final By overlaySelector = By.xpath("//div[@class='overlay']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10L);
        properties = Configuration.getProperties();
    }

    /**
     * Get the WebElement of the `body` tag
     *
     * @return Web element
     */
    public WebElement body() {
        return waitAndGet(bodySelector);
    }

    /**
     * Get the WebElement of the title of the overlay (dialog)
     *
     * @return Web element
     */
    public WebElement overlayTitle() {
        return waitAndGet(overlayTitleSelector);
    }

    /**
     * Get the WebElement of the overlay box (dialog)
     *
     * @return Web element
     */
    public WebElement overlay() {
        return waitAndGet(overlaySelector);
    }

    /**
     * Check is overlay box (dialog) exists
     *
     * @return True if exists
     */
    public boolean isOverlayExists() {
        return isElementExists(overlaySelector);
    }

    /**
     * Get page title
     *
     * @return Title text
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Wait and find a WebElement by the given selector
     *
     * @param selector By predicate
     * @return Found web element
     */
    protected WebElement waitAndGet(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector);
    }

    /**
     * Get text() property of the WebElement by the given selector
     *
     * @param selector By predicate
     * @return String content
     */
    protected String getText(By selector) {
        return waitAndGet(selector).getText();
    }

    /**
     * Commit click action on a WebElement by the given selector
     *
     * @param selector By predicate
     */
    protected void click(By selector) {
        waitAndGet(selector).click();
    }

    /**
     * Check WebElement existence by the given selector
     *
     * @param selector By predicate
     * @return True if the waitAndGet didn't throw any exception and the WebElement was found
     */
    protected boolean isElementExists(By selector) {
        try {
            waitAndGet(selector);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
