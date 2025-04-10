# language: pt
Funcionalidade: Login

  Contexto:
    Dado que estou na página de login

  @Login
  Esquema do Cenario: Autenticacao
    Quando escrevo "<username>" no campo username
    E escrevo "<password>" no campo password

    Exemplos:
      | username     | password |
      | ivalene.lima | Fr3381rd |
      | ivaleneLima  | 2469oeee |

    Cenario: Login com conta valida
      Entao valido que estou no dashboard com a timeline

    Cenario: Login com conta invalida
      Entao valido a mensagem de erro

    Cenario: Logout
      Dado que estou logado com o username "ivalene.lima" e a senha "Fr3381rd"
      Quando clico no botao do perfil
      E clico na opcao logout
      Entao estou na página de login
