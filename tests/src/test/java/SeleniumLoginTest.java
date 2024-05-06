import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumLoginTest {

    private WebDriver driver;
    private TestHelper helper;

    private final By bodySelector = By.tagName("body");
    private final By nameInputSelector = By.id("username");
    private final By passwordInputSelector = By.id("password");
    private final By loginButtonSelector = By.tagName("button");
    private final By flashSelector = By.id("flash");
    private final By logoutButtonSelector = By.className("button");

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), new ChromeOptions());
        final var wait = new WebDriverWait(driver, 10);
        helper = new TestHelper(driver, wait);
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodySelector));

        helper.waitAndGet(nameInputSelector).sendKeys("tomsmith");
        helper.waitAndGet(passwordInputSelector).sendKeys("SuperSecretPassword!");
        helper.waitAndGet(loginButtonSelector).click();
    }

    @Test
    public void shouldLoginOnCorrectCredentials() {
        assertTrue(helper.waitAndGet(flashSelector).getText().contains("logged in"));
        assertTrue(helper.waitAndGet(bodySelector).getText().contains("Secure Area"));
    }

    @Test
    public void shouldLogoutOnLinkClick() {
        helper.waitAndGet(logoutButtonSelector).click();
        assertTrue(helper.waitAndGet(flashSelector).getText().contains("logged out"));
        assertTrue(helper.waitAndGet(bodySelector).getText().contains("Login Page"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
