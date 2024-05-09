package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPage extends BasePage {

    private final By statusCheckboxSelector = By.xpath("//label[.//input[@name='user[activity_visible]']]//i");
    private final By submitButtonSelector = By.xpath("//div[contains(@class, 'p-body')]//form//button[@type='submit']");

    public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    public void selectStatusCheckbox() {
        waitAndGet(statusCheckboxSelector).click();
    }

    public void clickSubmitButton() {
        waitAndGet(submitButtonSelector).click();
    }
}
