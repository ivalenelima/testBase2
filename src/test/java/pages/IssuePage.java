package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitManager;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class IssuePage {

    WebDriver driver;
    WaitManager wait;

    public IssuePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver nulo no construtor");
        }
        if (driver.toString().toLowerCase().contains("null")) {
            throw new IllegalStateException("WebDriver foi fechado e estava sendo reusado");
        }
        this.driver = driver;
        this.wait = new WaitManager(driver, 20);
    }

    By reportBtn = By.className("btn-sm");
    By categorySelector = By.id("category_id");
    By reproSelector = By.id("reproducibility");
    By summaryField = By.id("summary");
    By descField = By.id("description");
    By submitIssueBtn = By.cssSelector("input[type='submit']");
    By summaryValidation = By.cssSelector("td.bug-summary");

    public void clickReportIssue() {
        wait.waitForElementToBeVisible(reportBtn);
        wait.waitForElementToBeClickable(reportBtn).click();
    }

    public void selectCategory() {
        WebElement dropdown = wait.waitForElementToBeVisible(categorySelector);
        Select select = new Select(dropdown);
        select.selectByVisibleText("[All Projects] categoria teste");
    }

    public void selectRepro() {
        WebElement dropdown = wait.waitForElementToBeVisible(reproSelector);
        Select select = new Select(dropdown);
        select.selectByVisibleText("sometimes");
    }

    public void writeOnSummary(String summary) {
        WebElement input = wait.waitForElementToBeVisible(summaryField);
        input.clear();
        input.sendKeys(summary);
    }

    public void writeOnDescription(String desc) {
        WebElement input = wait.waitForElementToBeVisible(descField);
        input.clear();
        input.sendKeys(desc);
    }

    public void clickSubmitIssue() {
        wait.waitForElementToBeVisible(submitIssueBtn);
        wait.waitForElementToBeClickable(submitIssueBtn).click();
    }

    public void summaryCheck() {
        String expected = "teste automatizado de report de bug";
        WebElement summaryText = wait.waitForElementToBeVisible(summaryValidation);
        String result = summaryText.getText();
        assertEquals("O summary não é o esperado", expected, result);
    }
}
