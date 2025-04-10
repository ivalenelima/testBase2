package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage;


    @Dado("que estou na página de login")
    public void queEstouNaPaginaDeLogin() {
        driver.get("https://mantis-prova.base2.com.br/login_page.php");
        loginPage = new LoginPage(driver);
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
        assertTrue("Não está na tela de dashboard", driver.getCurrentUrl().contains("my_view_page"));
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
    }

