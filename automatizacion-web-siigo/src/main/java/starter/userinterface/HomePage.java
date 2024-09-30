package starter.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class HomePage {

    public static final Target SUCCESS_LOGIN_MESSAGE = Target.the("Verify login success").located(ByShadow.cssSelector("div[class='company-header-title']","siigo-header-molecule[class='data-siigo-five9 hydrated']"));

}
