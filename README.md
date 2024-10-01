# PRUEBA TÉCNICA PARA QA ENGINEER

## INSTRUCCIONES

Realice los siguientes escenarios de prueba utilizando las herramientas y tecnologías que considere apropiadas.

---

## 1. FrontEnd: Inicio de prueba E2E Crear clientes

### Descripción

En la ruta de la aplicación [https://qastaging.siigo.com/#/login](https://qastaging.siigo.com/#/login) con el usuario:

- **Usuario**: `admin@siigoautomationqa.com`
- **Contraseña**: `[REDACTADO]`

Se espera que el **QA Engineer** realice el inicio de la prueba donde se loguee en la aplicación y acceda hasta el formulario que se encuentra en:

- Botón superior **“+Crear”**
  - Opción **“Clientes”**

Teniendo en cuenta el formulario desplegado:

- Diseñe un escenario **E2E** (preferiblemente en lenguaje **Gherkin** aplicando técnicas de prueba).
- La continuación y finalización del escenario se realizará en **vivo** en la entrevista técnica.

### Casos de Prueba

#### @CrearCliente

**Escenario:** Crear cliente tercero

- **Cuando** el realiza la creación de un tercero con su información
- **Entonces** el verifica la creación del tercero con sus datos
- **Y** el verifica que el estado del tercero sea **"Activo"**

#### Escenario: Login Exitoso

- **Dado** que Jesús quiere ingresar a la página de Siigo
- **Cuando** él se autentica con el **"admin@siigoautomationqa.com"** y **"[REDACTADO]"**
- **Entonces** él verifica el login exitoso con el mensaje **"SiigoAutomationQA"**

#### @LoginFallido

**Escenario:** Login fallido

- **Dado** que Jesús quiere ingresar a la página de Siigo
- **Cuando** él se autentica con el **"admin@siigoautomationqa.com"** y **"[REDACTADO]"**
- **Entonces** él verifica el mensaje de login fallido con el mensaje **"Usuario o contraseña inválidos"**

---

## 2. Backend: Verificación de Endpoints en ReqRes

### Descripción

Utilizaremos la página [https://reqres.in](https://reqres.in) para realizar pruebas y asegurarnos de que los **Endpoints** funcionen correctamente.

### Pasos a seguir

- Diseñe **mínimo un escenario E2E** o **cuatro escenarios puntuales** para diferentes servicios.
- Utilice una herramienta para enviar solicitudes **POST**, **GET**, **PUT** y **DELETE**.
- Verifique que los **Endpoints** responden correctamente y valide las respuestas.

### Casos de Prueba

**Feature:** Testing Reqres.in API

**Background:**

- **Given** que quiero consumir los servicios de ReqRes

#### @ObtenerListaUsuarios

**Scenario Outline:** Obtener lista de usuarios

- **When** realizo una petición GET a la API con la página `<page>`
- **Then** recibo un código de respuesta **200**
- **And** la lista de usuarios no está vacía

**Examples:**

| page |
|------|
| 1    |
| 2    |

#### @CrearNuevoUsuario

**Scenario:** Crear un nuevo usuario

- **When** realizo una petición POST a la API con los datos del usuario
- **Then** recibo un código de respuesta **201**
- **And** el usuario es creado con los datos correctos

#### @ActualizarUsuario

**Scenario:** Actualizar un usuario existente

- **When** realizo una petición PUT a la API con los nuevos datos del usuario
- **Then** recibo un código de respuesta **200**
- **And** el usuario es actualizado correctamente

#### @EliminarUsuario

**Scenario:** Eliminar un usuario

- **When** realizo una petición DELETE a la API
- **Then** recibo un código de respuesta **204**

---

## 3. Performance: Evaluación del tiempo de carga de ReqRes

### Descripción

El **QA Engineer** deberá realizar pruebas de rendimiento para identificar posibles cuellos de botella y generar un informe respecto a la ejecución.

### Pasos a seguir

- Utilice una herramienta para enviar **solicitudes concurrentes** a un **Endpoint** de ReqRes.
- Aumente gradualmente la carga de solicitudes y observe cómo responde el backend. *(No es necesario llegar a la indisponibilidad del servicio)*.
- Proporcione un **informe** respecto al comportamiento identificado.

### Detalles de la Prueba

Se generó un script de prueba de carga utilizando **JMeter**, el cual se encuentra en la carpeta **prueba-jmeter** junto con el informe de resultados de la prueba de carga. Se ejecutaron cargas incrementales para evaluar el comportamiento del servicio bajo diferentes niveles de carga.

| Fase de Carga | Usuarios Concurrentes | Tiempo de Respuesta Promedio (ms) | Tasa de Éxito (%) | Errores (%) |
|----------------|-----------------------|-----------------------------------|-------------------|-------------|
| Inicial        | 10                    | 200                               | 100               | 0           |
| Moderada       | 50                    | 350                               | 98                | 2           |
| Alta           | 100                   | 600                               | 95                | 5           |


---

## 4. Evidencia

Sube tu prueba a tu repositorio personal en **GitHub**. Puedes mantener el proyecto público o proporcionarnos acceso para que podamos consultar y validar la implementación.

- **Correos de contacto**:
  - edison.vasquez@siigo.com
  - wilson.medina@siigo.com

---

**NOTA**:

Se valorará especialmente el uso de patrones de diseño como **POM** o **ScreenPlay**, la adopción de metodologías como **GitFlow** para la gestión del flujo de trabajo en el control de versiones y la familiaridad con herramientas como **Serenity**, **SerenityRest**, **Postman**, **JMeter** o **K6** para la automatización y el análisis de pruebas.

---

**Importante**: Por motivos de seguridad y confidencialidad, las contraseñas han sido omitidas en este documento. Asegúrate de manejar esta información de manera adecuada en tus entornos de trabajo.
