package co.com.sofka.stepdefinition.login;

import co.com.sofka.pages.home.HomePage;
import co.com.sofka.pages.singin.SignInPage;
import co.com.sofka.stepdefinition.setup.BaseTestPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

public class LogueoExitosoStepDefinition extends BaseTestPage {

    private HomePage homePage;
    private SignInPage signInPage;

    @Dado("que el usuario previamente registrado se dirige al modulo de Sing in")
    public void queElUsuarioPreviamenteRegistradoSeDirigeAlModuloDeSingIn() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver,10);
        }catch (Exception e){
            handleException(e);
        }
    }

    @Cuando("inicie sección con el email: {string} y la contraseña: {string}")
    public void inicieSecciónConElEmailYLaContraseña(String email, String password) {
        signInPage = homePage.openSignInPage();
        signInPage.signIn(email, password);
    }

    @Entonces("podrá ver el siguiente mensaje: {string}")
    public void podráVerElSiguienteMensaje(String message) {
        System.out.println(signInPage.getUser());
        Assertions.assertTrue(signInPage.getUser().contains(message));
    }
}
