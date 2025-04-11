package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitManager;

public class SenhaPage {
    WebDriver driver;
    WaitManager wait;
    public SenhaPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver nulo no construtor");
        }
        if (driver.toString().toLowerCase().contains("null")) {
            throw new IllegalStateException("WebDriver foi fechado e estava sendo reusado");
        }
        this.driver = driver;
        this.wait = new WaitManager(driver, 10);
    }

    By usernameInput = By.id("username");
    By loginUsernameButton = By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]");
    By forgotLink = By.linkText("Lost your password?");
    By emailInput = By.id("email-field");
    By submitBtn = By.cssSelector("input[type='submit']");

    public void enterUsernameForgot(String username) {
        WebElement input = wait.waitForElementToBeVisible(usernameInput);
        input.clear();
        input.sendKeys(username);
        wait.waitForElementToBeClickable(loginUsernameButton).click();
    }
    public void clickForgotLink() {
        wait.waitForElementToBeClickable(forgotLink).click();
        wait.waitForElementToBeVisible(emailInput);

    }

    public void enterEmail(String email) {
        WebElement input = wait.waitForElementToBeVisible(emailInput);
        input.clear();
        input.sendKeys(email);
    }

    public void clickSubmitBtn() {
        wait.waitForElementToBeClickable(submitBtn).click();
    }
}