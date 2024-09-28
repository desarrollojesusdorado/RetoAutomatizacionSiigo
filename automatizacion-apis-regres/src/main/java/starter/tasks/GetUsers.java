package starter.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetUsers implements Task {

    public static GetUsers fromPage(int page) {
        return new GetUsers(page);
    }

    private int page;

    public GetUsers(int page) {
        this.page = page;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/users?page={page}")
                        .with(request -> request.pathParam("page", page))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
