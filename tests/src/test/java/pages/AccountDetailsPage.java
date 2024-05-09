package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDetailsPage extends BasePage {

    private final By formSelector = By.xpath("//div[contains(@class, 'p-body')]//form");

    private final By privacyNavItemSelector = By.xpath("//div[contains(@class, 'p-body-sideNav')]//a[contains(text(), 'Privacy')]");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getForm() {
        return waitAndGet(formSelector);
    }

    public PrivacyPage openPrivacyPage() {
        waitAndGet(privacyNavItemSelector).click();
        body();

        return new PrivacyPage(driver);
    }
}
