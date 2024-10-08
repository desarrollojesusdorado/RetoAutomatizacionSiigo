package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.userinterface.LoguinPage.*;

public class Login implements Task {

    private String user;
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Login withCredentials(String user, String password) {
        return Tasks.instrumented(Login.class, user,password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USER, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(user).into(USER),
                Enter.theValue(password).into(PASSWORD),
                Click.on(GET_INTO)
        );
    }
}
