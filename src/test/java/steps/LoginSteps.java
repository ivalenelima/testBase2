package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import utils.*;
import pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    private ContextManager context;
    private LoginPage loginPage;
    WaitManager wait;

    public LoginSteps(ContextManager context) {
        this.context = context;
        this.loginPage = context.getLoginPage();
    }


    @Dado("que estou na página de login")
    public void queEstouNaPaginaDeLogin() {
        loginPage.goToLoginPage();
    }

    @Quando("escrevo {string} no campo username")
    public void escrevoNoCampoUsername(String username) {
        loginPage.enterUsername(username);
        loginPage.clickUsernameLogin();
    }

    @E("escrevo {string} no campo password")
    public void escrevoNoCampoPassword(String password) {
        loginPage.enterPassword(password);
        loginPage.clickPasswordLogin();
    }


    @Entao("valido que estou no dashboard com a timeline")
    public void validoQueEstouNoDashboardComATimeline() {
        if (driver.getCurrentUrl().contains("my_view_page")) {
            System.out.println("Login funcionou");
        } else {
            System.out.println("Login falhou");
            assertTrue("Não está na tela de dashboard", loginPage.isErrorDisplayed());
        }
    }


    @Entao("valido a mensagem de erro")
    public void validoAMensagemDeErro() {
        loginPage.isErrorDisplayed();
    }

    @Quando("clico no botao do perfil")
    public void clicoNoBotaoDoPerfil() {
        loginPage.clickProfileButton();
    }

    @E("clico na opcao logout")
    public void clicoNaOpcaoLogout() {
        loginPage.clickLogoutButton();
    }

    @Entao("estou na página de login")
    public void estouNaPaginaDeLogin() {
        assertTrue("Não está na tela de login", driver.getCurrentUrl().contains("login_page"));
        }

    @Dado("que estou logado com o username {string} e a senha {string}")
    public void queEstouLogadoComOUsernameEASenha(String username, String password) {
        loginPage.goToLoginPage();
        wait.waitForUrlContains("login_page");
        loginPage.enterUsername(username);
        loginPage.clickUsernameLogin();
        loginPage.enterPassword(password);
        loginPage.clickPasswordLogin();
    }
}

