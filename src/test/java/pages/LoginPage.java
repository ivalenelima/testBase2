package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitManager;

public class LoginPage {
    WebDriver driver;
    WaitManager wait;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("🚫 WebDriver is null in LoginPage constructor!");
        }
        if (driver.toString().toLowerCase().contains("null")) {
            throw new IllegalStateException("❗ WebDriver was closed and is being reused!");
        }
        this.driver = driver;
        this.wait = new WaitManager(driver, 10);


    }

    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By loginUsernameButton = By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]");
    By loginPasswordButton = By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]");
    By errorMessage = By.className("alert");
    By profileButton = By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[2]/a/span");
    By logoutButton = By.className("fa-sign-out");


    public void goToLoginPage() {
        driver.get("https://mantis-prova.base2.com.br/login_page.php");
    }
    public void enterUsername(String username) {
        WebElement input = wait.waitForElementToBeVisible(usernameInput);
        input.clear();
        input.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement input = wait.waitForElementToBeVisible(passwordInput);
        input.clear();
        input.sendKeys(password);
    }

    public void clickUsernameLogin() {
        wait.waitForElementToBeClickable(loginUsernameButton).click();
    }

    public void clickPasswordLogin() {
        wait.waitForElementToBeClickable(loginPasswordButton).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return wait.waitForElementToBeVisible(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProfileButton() {
        wait.waitForElementToBeClickable(profileButton).click();
    }

    public void clickLogoutButton() {
        wait.waitForElementToBeClickable(logoutButton).click();
    }
}