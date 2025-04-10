#language: pt
  Funcionalidade: Cadastro
    Contexto:
      Dado que estou na página de login

      @Cadastro
      Cenario: Cadastro válido
        Quando clico no link Signup for a new account
        E coloco "Ivalenelima" no campo username
        E coloco "ivalenelima@outlook.com" no campo email
        E clico no botao Signup
        Entao valido a mensagem de sucesso

      Cenario: Cadastro inválido
        Quando clico no link Signup for a new account
        E coloco "Ivalenelima" no campo username
        E coloco "test@test.com" no campo email
        E clico no botao Signup
        Entao valido a mensagem de sucesso