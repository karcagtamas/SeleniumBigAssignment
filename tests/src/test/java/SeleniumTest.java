import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private TestHelper helper;

    private final By bodySelector = By.tagName("body");
    private final By nameInputSelector = By.id("username");
    private final By passwordInputSelector = By.id("password");
    private final By loginButtonSelector = By.tagName("button");
    private final By flashSelector = By.id("flash");

    private final String pagePath = "http://the-internet.herokuapp.com/login";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), new ChromeOptions());
        wait = new WebDriverWait(driver, 10);
        helper = new TestHelper(driver, wait);
        driver.manage().window().maximize();

        driver.get(pagePath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodySelector));
    }

    @Test
    public void shouldOpenSuccessfully() {
        assertTrue(helper.waitAndGet(bodySelector).isDisplayed());
    }

    @Test
    public void shouldContainsTheLoginPageTitle() {
        assertTrue(helper.waitAndGet(bodySelector).getText().contains("Login Page"));
    }

    @Test
    public void shouldBeUsernameAndPasswordField() {
        assertEquals("input", helper.waitAndGet(nameInputSelector).getTagName());
        assertEquals("input", helper.waitAndGet(passwordInputSelector).getTagName());
    }

    @ParameterizedTest
    @CsvSource({"SuperSecretPassword!,asd"})
    public void shouldNotLoginOnIncorrectUsername(String pass) {
        helper.waitAndGet(nameInputSelector).sendKeys("asd");
        helper.waitAndGet(passwordInputSelector).sendKeys(pass);
        helper.waitAndGet(loginButtonSelector).click();

        assertTrue(helper.waitAndGet(flashSelector).getText().contains("username is invalid"));
        assertTrue(helper.waitAndGet(bodySelector).getText().contains("Login Page"));
    }

    @Test
    public void shouldNotLoginOnIncorrectPassword() {
        helper.waitAndGet(nameInputSelector).sendKeys("tomsmith");
        helper.waitAndGet(passwordInputSelector).sendKeys("asd!");
        helper.waitAndGet(loginButtonSelector).click();

        assertTrue(helper.waitAndGet(flashSelector).getText().contains("password is invalid"));
        assertTrue(helper.waitAndGet(bodySelector).getText().contains("Login Page"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
