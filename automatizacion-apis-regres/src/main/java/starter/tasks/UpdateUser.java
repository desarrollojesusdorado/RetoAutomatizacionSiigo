package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpHeaders;
import starter.models.User;

public class UpdateUser implements Task {

    private User user;
    private int userId;

    public UpdateUser(User user, int userId) {
        this.user = user;
        this.userId = userId;
    }

    public static UpdateUser withInfo(User user, int userId) {
        return new UpdateUser(user, userId);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/users/{id}")
                        .with(request -> request
                                .pathParam("id", userId)
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .body(user))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
