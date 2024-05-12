import core.SeleniumTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Verify the page title")
    public void pageTitleShouldContainsForumWord() {
        assertTrue(stringContains(forumPage.getTitle(), "Forum")); // Static test for current page title
    }

    @Test
    @DisplayName("Verify login button existence and visibility")
    public void loginButtonShouldBeVisible() {
        assertTrue(forumPage.isLoginButtonExists());
        assertTrue(forumPage.getLoginButton().isDisplayed());
    }

    @Test
    @DisplayName("Verify login button click overlay behaviour")
    public void onLoginClickLoginDialogShouldDisplayed() {
        forumPage.clickOnLoginButton();
        assertTrue(forumPage.isOverlayExists());
        assertTrue(forumPage.overlayTitle().isDisplayed());
        assertTrue(stringContains(forumPage.overlayTitle().getText(), "Log in"));
    }
}
