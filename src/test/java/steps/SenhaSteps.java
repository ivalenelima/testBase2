package steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import pages.SenhaPage;
import utils.ContextManager;
import utils.DriverManager;

public class SenhaSteps {

    WebDriver driver = DriverManager.getDriver();
    SenhaPage senhaPage;

    @Dado("que eu estou na página de login")
    public void queEuEstouNaPaginaDeLogin() {
        driver.get("https://mantis-prova.base2.com.br/login_page.php");
        senhaPage = new SenhaPage(driver);
    }

    @Quando("ponho {string} no campo username")
    public void escrevoNoCampoUsername(String username){
        senhaPage.enterUsernameForgot(username);
    }

    @E("clico no link Lost your Password")
    public void clicoNoLinkLostYourPassword() {
        senhaPage.clickForgotLink();
    }

    @E("escrevo {string} no campo email")
    public void escrevoNoCampoEmail(String email) {
        senhaPage.enterEmail(email);
    }

    @Entao ("clico no botao submit")
    public void clicoNoBotaoSubmit() {
        senhaPage.clickSubmitBtn();
    }
}

