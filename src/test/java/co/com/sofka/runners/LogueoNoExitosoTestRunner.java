package co.com.sofka.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/login/logueoNoExitoso.feature"},
        glue = "co.com.sofka.definitions.login",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class LogueoNoExitosoTestRunner {
}
