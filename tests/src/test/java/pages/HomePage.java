package pages;

import core.BasePage;
import core.configuration.ConfigKey;
import core.configuration.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    final By forumNavItemSelector = By.xpath("//div[@class='mainblock']//ul[@class='navbar']//li//a[text()='Forums']");
    final By newsBlockSelector = By.xpath("//div[@class='boxframe' and .//div[@class='boxtitle' and contains(text(), 'News')]]");

    public HomePage(WebDriver driver) {
        super(driver);

        driver.get(Configuration.getProperty(ConfigKey.URL));
        body();
    }

    public ForumPage clickForumNavItem() {
        waitAndGet(forumNavItemSelector).click();

        return new ForumPage(driver);
    }

    public WebElement getNewsBlock() {
        return waitAndGet(newsBlockSelector);
    }
}
