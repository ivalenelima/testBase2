# language: pt
  Funcionalidade: Esqueci a senha

    @Senha
    Cenário: Recuperar a senha
      Dado que eu estou na página de login
      Quando  ponho "ivalene.lima" no campo username
      E clico no link Lost your Password
      E escrevo "ivalenelima@gmail.com" no campo email
      Entao clico no botao submit