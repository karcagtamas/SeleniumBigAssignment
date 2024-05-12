import core.SeleniumTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ForumPage;
import pages.HomePage;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>Test cases for the Forum Page</p>
 * <p>The tests are testing the Forum page specific functionalities and statuses</p>
 */
public class ForumPageTest extends SeleniumTest {

    private ForumPage forumPage;

    @Override
    protected void testCaseInitializer(WebDriver driver) {
        final var homePage = new HomePage(driver);

        forumPage = homePage.clickOnForumNavigationItem();
    }

    @Test
    public void pageTitleShouldContainsForumWord() {
        assertTrue(stringContains(forumPage.getTitle(), "Forum")); // Static test for current page title
    }

    @Test
    public void loginButtonShouldBeVisible() {
        assertTrue(forumPage.isLoginButtonExists());
        assertTrue(forumPage.getLoginButton().isDisplayed());
    }

    @Test
    public void onLoginClickLoginDialogShouldDisplayed() {
        forumPage.clickOnLoginButton();
        assertTrue(forumPage.isOverlayExists());
        assertTrue(forumPage.overlayTitle().isDisplayed());
        assertTrue(stringContains(forumPage.overlayTitle().getText(), "Log in"));
    }
}
