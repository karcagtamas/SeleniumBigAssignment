package pages;

import core.BasePage;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForumPage extends BasePage {

    private final By loginButtonSelector = By.xpath("//a[.//span[text()='Log in']]");
    private final By loginUsernameFieldSelector = By.xpath("//input[@name='username']");
    private final By loginPasswordFieldSelector = By.xpath("//input[@name='password']");
    private final By loginFormButtonSelector = By.xpath("//button[.//span[text()='Log in']]");
    private final By blockMessageSelector = By.xpath("//div[contains(@class,'blockMessage')]");
    private final By noticeSelector = By.xpath("//div[contains(@class,'notice-content')]");
    private final By logoutSelector = By.xpath("//a[text()='Log out']");

    public ForumPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        return waitAndGet(loginButtonSelector);
    }

    public void clickLoginButton() {
        waitAndGet(loginButtonSelector).click();
    }

    public void clickLogoutButton() {
        waitAndGet(logoutSelector).click();
    }

    public void tryToLogin(String username, String password) {
        clickLoginButton();
        waitAndGet(loginUsernameFieldSelector).sendKeys(username);
        waitAndGet(loginPasswordFieldSelector).sendKeys(password);
        waitAndGet(loginFormButtonSelector).click();
    }

    public WebElement getBlockMessage() {
        return waitAndGet(blockMessageSelector);
    }

    public WebElement getNotice() {
        return waitAndGet(noticeSelector);
    }

    public WebElement getUserProfileLink() {
        return waitAndGet(By.xpath("//a[.//span[text()='%s']]".formatted(Configuration.getProperty(ConfigKey.USERNAME))));
    }
}
