import core.SeleniumTest;
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
    public void newsBlockShouldBeOnThePage() {
        assertTrue(stringContains(homePage.getNewsBlock().getText(), "news")); // Static page test
    }

    @Test
    public void forumNavigationItemShouldBeOnThePage() {
        assertTrue(homePage.isFormNavigationItemsExists()); // Static page test
    }
}
