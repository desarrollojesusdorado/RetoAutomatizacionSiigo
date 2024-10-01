#language: es

  Característica: Crear Cliente

    Como usuario de siigo
    Quiero diligenciar el formulario para crear un tercero
    Para validar que la creación sea exitosa

  Antecedentes:
    Dado que jesus quiere ingresar a la pagina de siigo
    Cuando el se autentica con el "admin@siigoautomationqa.com" y "(#T0Nu@QrO"

  @CrearCliente
  Escenario: Crear cliente tercero
    Cuando el realiza la creación de un tercero con su informacion
    Entonces el verifica la creación  del tercero con sus datos
    Y el verifica que el estado del tercero sea "Activo"

