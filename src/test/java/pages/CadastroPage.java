package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitManager;

public class CadastroPage {
    WebDriver driver;
    WaitManager wait;
    public CadastroPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("🚫 WebDriver is null in LoginPage constructor!");
        }
        if (driver.toString().toLowerCase().contains("null")) {
            throw new IllegalStateException("❗ WebDriver was closed and is being reused!");
        }
        this.driver = driver;
        this.wait = new WaitManager(driver, 20);
    }

    By newAccount = By.cssSelector("a[href='signup_page.php']");
    By newUsername = By.id("username");
    By newEmail = By.id("email-field");
    By newSubmit = By.cssSelector("input[type='submit']");
    By validScreen = By.id("login-box");

    public void signupNewAccount(){
        wait.waitForElementToBeVisible(newAccount);
        wait.waitForElementToBeClickable(newAccount).click();
    }

    public void enterNewUsername(String username){
        WebElement input = wait.waitForElementToBeVisible(newUsername);
        input.clear();
        input.sendKeys(username);
    }

    public void enterNewEmail(String email){
        WebElement input = wait.waitForElementToBeVisible(newEmail);
        input.clear();
        input.sendKeys(email);
    }

    public void clickSignupBtn(){
        wait.waitForElementToBeClickable(newSubmit).click();
    }

    public boolean validateScreen(){
        try {
            return wait.waitForElementToBeVisible(validScreen).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
