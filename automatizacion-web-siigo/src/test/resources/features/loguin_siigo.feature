#language: es
Característica: Loguin Siigo

  Como usuario
  Quiero autenticarme en la pagina de Siigo
  Para verificar el correcto funcionamiento

  @LoguinExitoso
  Escenario: Login Exitoso
    Dado que jesus quiere ingresar a la pagina de siigo
    Cuando el se autentica con el "admin@siigoautomationqa.com" y "(#T0Nu@QrO"
    Entonces el verifica el loguin existoso con el mensaje "SiigoAutomationQA"

  @LoguinFallido
  Escenario: Login fallido
    Dado que jesus quiere ingresar a la pagina de siigo
    Cuando el se autentica con el "admin@siigoautomationqa.com" y "$22g0QA321"
    Entonces el verifica el mensaje de login fallido con el mensaje "Usuario o contraseña inválidos"




