package utils;

import org.openqa.selenium.WebDriver;
import pages.*;

public class ContextManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private SenhaPage senhaPage;
    private CadastroPage cadastroPage;
    private IssuePage issuePage;

    public ContextManager() {
        this.driver = DriverManager.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public SenhaPage getSenhaPage() {
        if (senhaPage == null) {
            senhaPage = new SenhaPage(driver);
        }
        return senhaPage;
    }

    public CadastroPage getCadastroPage() {
        if (cadastroPage == null) {
            cadastroPage = new CadastroPage(driver);

        }
        return cadastroPage;
    }

    public IssuePage getIssuePage() {
        if (issuePage == null) {
            issuePage = new IssuePage(driver);

        }
        return issuePage;
    }
}
