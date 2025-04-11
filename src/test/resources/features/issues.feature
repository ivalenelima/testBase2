# language: pt
  Funcionalidade: Operações com Issues
    Contexto:
      Dado que estou logado com o username "ivalene.lima" e a senha "Fr3381rd"

      @Issues
      Cenario: Reportar novo issue
        Quando clico no botao report issue
        E seleciono a categoria Categoria Teste
        E seleciono a reproducibility sometimes
        E escrevo "teste automatizado de report de bug" no campo summary
        E escrevo " descrição automatizada de teste" no campo description
        E clico em submit issue
        Entao valido a tela de sucesso