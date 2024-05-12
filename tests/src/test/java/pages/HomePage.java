package pages;

import core.BasePage;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.openqa.selenium.*;

public class HomePage extends BasePage {

    final By forumNavItemSelector = By.xpath("//div[@class='mainblock']//ul[@class='navbar']//li//a[text()='Forums']");
    final By newsBlockSelector = By.xpath("//div[@class='boxframe' and .//div[@class='boxtitle' and contains(text(), 'News')]]");

    public HomePage(WebDriver driver) {
        super(driver);

        driver.get(Configuration.getProperty(ConfigKey.URL));
        body();
    }

    public ForumPage clickOnForumNavigationItem() {
        waitAndGet(forumNavItemSelector).click();
        body();

        return new ForumPage(driver);
    }

    public WebElement getNewsBlock() {
        return waitAndGet(newsBlockSelector);
    }

    public boolean isFormNavigationItemsExists() {
        return isElementExists(forumNavItemSelector);
    }
}
