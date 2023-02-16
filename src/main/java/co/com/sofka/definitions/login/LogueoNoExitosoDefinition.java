package co.com.sofka.definitions.login;

import co.com.sofka.definitions.setup.BaseTestPage;
import co.com.sofka.pages.home.HomePage;
import co.com.sofka.pages.signin.SignInPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

public class LogueoNoExitosoDefinition extends BaseTestPage {

    private HomePage homePage;
    private SignInPage signInPage;

    @Dado("que el usuario con datos incorrectos")
    public void queElUsuarioConDatosIncorrectos() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver, 10);
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Cuando("inicie sección con el email: {string} y con la contraseña: {string}")
    public void inicieSecciónConElEmailYLaContraseña(String email, String password) {
        try {
            signInPage = homePage.openSignInPage();
            signInPage.signIn(email, password);
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Entonces("podrá ver el siguiente mensaje de error : {string}.")
    public void podráVerElSiguienteMensajeDeError(String message) {
        try {
            Assertions.assertTrue(signInPage.getError().contains(message));
            quiteDriver();
        } catch (Exception e) {
            handleException(e);
        }
    }
}
