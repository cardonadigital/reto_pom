package co.com.sofka.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = false,
        features = {"src/test/resources/features/purchase/comprarProductosMujerHombre.feature"},
        glue = "co.com.sofka.stepdefinition.purchase",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class ComprarProductosStepDefinition {
}
