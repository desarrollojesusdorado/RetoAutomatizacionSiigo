package starter.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class LoguinPage {
    public static final Target USER = Target.the("Send user").located(ByShadow.cssSelector("input[id='username-input']","input-atom[id='username']"));
    public static final Target PASSWORD = Target.the("Send pasword").located(ByShadow.cssSelector("input[id='password-input']","input-atom[id='current-password']"));
    public static final Target GET_INTO = Target.the("Click ingresar").located(By.id("login-submit"));
    public static final Target INVALID_CREDENTIALS_MESSAGE = Target.the("Expected menssage invalid").located(By.xpath("//div[contains(text(), 'Usuario o contraseña inválidos')]"));
}
