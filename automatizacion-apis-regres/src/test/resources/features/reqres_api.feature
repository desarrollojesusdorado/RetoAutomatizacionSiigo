Feature: Testing Reqres.in API

  @ObtenerListaUsuarios
  Scenario: Obtener lista de usuarios
    Given que quiero consumir los servicios de regres
    When realizo una peticion GET a la API
    Then recibo un codigo de respuesta 200
    And la lista de usuarios no esta vacia

  @CrearNuevoUsuario
  Scenario: Crear un nuevo usuario
    Given que quiero consumir los servicios de regres
    When realizo una peticion POST a la API con los datos del usuario
    Then recibo un codigo de respuesta 201
    And el usuario es creado con los datos correctos

  @ActualizarUsuario
  Scenario: Actualizar un usuario existente
    Given que quiero consumir los servicios de regres
    When realizo una peticion PUT a la API con los nuevos datos del usuario
    Then recibo un codigo de respuesta 200
    And el usuario es actualizado correctamente

  @EliminarUsuario
  Scenario: Eliminar un usuario
    Given que quiero consumir los servicios de regres
    When realizo una peticion DELETE a la API
    Then recibo un codigo de respuesta 204
