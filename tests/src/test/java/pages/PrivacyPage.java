package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPage extends BasePage {

    private final By statusCheckboxSelector = By.xpath("//label[.//input[@name='user[activity_visible]']]//i");
    private final By submitButtonSelector = By.xpath("//div[contains(@class, 'p-body')]//form//button[@type='submit']");

    private final By selectedNavItemSelector = By.xpath("//div[contains(@class, 'p-body-sideNav')]//a[contains(@class, 'selected')]");

    public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    public void selectStatusCheckbox() {
        waitAndGet(statusCheckboxSelector).click();
    }

    public void clickOnSubmitButton() {
        waitAndGet(submitButtonSelector).click();
    }

    public String getSelectedNavigationItemText() {
        return getText(selectedNavItemSelector);
    }
}
