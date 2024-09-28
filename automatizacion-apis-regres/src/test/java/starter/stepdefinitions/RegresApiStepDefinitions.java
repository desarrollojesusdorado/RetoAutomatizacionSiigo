package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.models.User;
import starter.questions.ResponseCode;
import starter.tasks.CreateUser;
import starter.tasks.DeleteUser;
import starter.tasks.GetUsers;
import starter.tasks.UpdateUser;
import starter.utils.Constants;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class RegresApiStepDefinitions {

    private Actor actor;
    private User user;
    private int userId;

    @Before
    public void setUp() {
        actor = Actor.named("Tester");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que quiero consumir los servicios de regres")
    public void queQuieroConsumirLosServiciosDeRegres() {
        OnStage.theActorCalled(actor.getName()).whoCan(CallAnApi.at(Constants.BASE_URL));
    }

    @When("realizo una peticion GET a la API")
    public void realizoUnaPeticionGETALaAPI() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUsers.fromPage(2));
    }

    @Then("recibo un codigo de respuesta {int}")
    public void reciboUnCodigoDeRespuesta(Integer statusCode) {
        OnStage.theActorInTheSpotlight().should(seeThat(ResponseCode.obtained(), equalTo(statusCode)));
    }

    @Given("que quiero crear un nuevo usuario")
    public void queQuieroCrearUnNuevoUsuario() {

    }
    @When("realizo una peticion POST a la API con los datos del usuario")
    public void realizoUnaPeticionPOSTALaAPIConLosDatosDelUsuario() {
        user = new User("morpheus", "leader");
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withInfo(user));
    }

    @Then("el usuario es creado con los datos correctos")
    public void elUsuarioEsCreadoConLosDatosCorrectos() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El nombre del usuario es correcto",
                        response -> SerenityRest.lastResponse().jsonPath().getString("name"),
                        equalTo(user.getName())),
                seeThat("El trabajo del usuario es correcto",
                        response -> SerenityRest.lastResponse().jsonPath().getString("job"),
                        equalTo(user.getJob()))
        );
    }

    @Given("que quiero obtener la lista de usuarios")
    public void queQuieroObtenerLaListaDeUsuarios() {

    }


    @Then("la lista de usuarios no esta vacia")
    public void laListaDeUsuariosNoEstaVacia() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La lista de usuarios",
                        response -> SerenityRest.lastResponse().jsonPath().getList("data"),
                        not(empty()))
        );
    }

    @When("realizo una peticion PUT a la API con los nuevos datos del usuario")
    public void realizoUnaPeticionPUTALaAPIConLosNuevosDatosDelUsuario() {
        user = new User("morpheus", "zion resident");
        userId = 2; // ID del usuario a actualizar
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUser.withInfo(user, userId));
    }

    @Then("el usuario es actualizado correctamente")
    public void elUsuarioEsActualizadoCorrectamente() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El nombre del usuario es correcto",
                        response -> SerenityRest.lastResponse().jsonPath().getString("name"),
                        equalTo(user.getName())),
                seeThat("El trabajo del usuario es correcto",
                        response -> SerenityRest.lastResponse().jsonPath().getString("job"),
                        equalTo(user.getJob()))
        );
    }

    @When("realizo una peticion DELETE a la API")
    public void realizoUnaPeticionDELETEALaAPI() {
        userId = 2;
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.withId(userId));
    }



}
