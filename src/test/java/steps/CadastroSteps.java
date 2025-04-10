package steps;
import io.cucumber.java.pt.*;
import pages.CadastroPage;
import utils.ContextManager;

public class CadastroSteps {

    private ContextManager context;
    private CadastroPage cadastroPage;

    public CadastroSteps(ContextManager context) {
        this.context = context;
        this.cadastroPage = context.getCadastroPage();
    }
    @Quando("clico no link Signup for a new account")
    public void clicoNoLinkSignupForANewAccount() {
        cadastroPage.signupNewAccount();
    }

    @E("coloco {string} no campo username")
    public void colocoNoCampoUsername(String username) {
        cadastroPage.enterNewUsername(username);
    }

    @E("coloco {string} no campo email")
    public void colocoNoCampoEmail(String email) {
        cadastroPage.enterNewEmail(email);
    }

    @E("clico no botao Signup")
    public void clicoNoBotaoSignup(){
        cadastroPage.clickSignupBtn();
    }

    @Entao("valido a mensagem de sucesso")
    public void validoAMensagemDeSucesso() {
        cadastroPage.validateScreen();
    }
}
