package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyPage extends BasePage {

    private final By statusCheckboxSelector = By.xpath("//label[.//input[@name='user[visible]']]//i");
    private final By checkedStatusCheckboxSelector = By.xpath("//label//input[@name='user[visible]' and @checked='1']");
    private final By submitButtonSelector = By.xpath("//div[contains(@class, 'p-body')]//form//button[@type='submit']");

    private final By selectedNavItemSelector = By.xpath("//div[contains(@class, 'p-body-sideNav')]//a[contains(@class, 'selected')]");

    public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getStatusCheckbox() {
        return waitAndGet(statusCheckboxSelector);
    }

    public void selectStatusCheckbox() {
        getStatusCheckbox().click();
    }

    public void clickOnSubmitButton() {
        waitAndGet(submitButtonSelector).click();
    }

    public String getSelectedNavigationItemText() {
        return getText(selectedNavItemSelector);
    }

    public boolean isStatusCheckboxSelected() {
        return isElementExists(checkedStatusCheckboxSelector);
    }
}
