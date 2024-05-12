import core.SeleniumTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static core.Utils.stringContains;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p>Test cases for the Home Page</p>
 * <p>The test cases are mostly static page tests</p>
 */
public class HomePageTest extends SeleniumTest {

    private HomePage homePage;

    @Override
    protected void testCaseInitializer(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Verify news block existence")
    public void newsBlockShouldBeOnThePage() {
        assertTrue(stringContains(homePage.getNewsBlock().getText(), "news")); // Static page test
    }

    @Test
    @DisplayName("Verify forum navigation item existence")
    public void forumNavigationItemShouldBeOnThePage() {
        assertTrue(homePage.isFormNavigationItemsExists()); // Static page test
    }
}
