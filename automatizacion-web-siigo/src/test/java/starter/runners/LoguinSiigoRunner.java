package starter.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/loguin_siigo.feature",
        glue = "starter.stepdefinitions",
        tags = "@LoguinExitoso",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoguinSiigoRunner {
}
