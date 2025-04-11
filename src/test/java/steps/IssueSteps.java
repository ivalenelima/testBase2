package steps;
import io.cucumber.java.pt.*;
import pages.IssuePage;
import utils.ContextManager;

public class IssueSteps {
    private ContextManager context;
    private IssuePage issuePage;

    public IssueSteps(ContextManager context) {
        this.context = context;
        this.issuePage = context.getIssuePage();
    }
    @Quando("clico no botao report issue")
    public void clicoNoBotaoReportIssue() {
        issuePage.clickReportIssue();
    }

    @E("seleciono a categoria Categoria Teste")
    public void selecionoACategoriaCategoriaTeste() {
        issuePage.selectCategory();
    }

    @E("seleciono a reproducibility sometimes")
    public void selecionoAReproducibilitySometimes() {
        issuePage.selectRepro();
    }

    @E("escrevo {string} no campo summary")
    public void escrevoNoCampoSummary(String summary) {
        issuePage.writeOnSummary(summary);
    }

    @E("escrevo {string} no campo description")
    public void escrevoNoCampoDescription(String desc) {
        issuePage.writeOnDescription(desc);
    }

    @E("clico em submit issue")
    public void clicoEmSubmitIssue() {
        issuePage.clickSubmitIssue();
    }

    @Entao("valido a tela de sucesso")
    public void validoATelaDeSucesso() {
        issuePage.summaryCheck();
    }
}
