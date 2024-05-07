package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final WebDriver driver;

    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndGet(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector);
    }

    protected String getText(By selector) {
        return waitAndGet(selector).getText();
    }

    protected void click(By selector) {
        waitAndGet(selector).click();
    }
}
