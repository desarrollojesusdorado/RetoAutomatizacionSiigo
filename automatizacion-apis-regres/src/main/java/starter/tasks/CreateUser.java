package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;
import starter.models.User;

public class CreateUser implements Task {

    private User user;

    public CreateUser(User user) {
        this.user = user;
    }

    public static CreateUser withInfo(User user) {
        return new CreateUser(user);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users")
                        .with(request -> request
                                .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                                .body(user))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
