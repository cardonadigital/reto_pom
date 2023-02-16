package co.com.sofka.definitions.register;

import co.com.sofka.pages.createaccount.CreateAccountPage;
import co.com.sofka.pages.home.HomePage;
import co.com.sofka.definitions.setup.BaseTestPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

public class RegistroNoExitosoDefinition extends BaseTestPage {
    private HomePage homePage;
    private CreateAccountPage createAccountPage;

    @Dado("que el cliente se dirigió al modulo de Create an Account")
    public void queElClienteSeDirigióAlModuloDeCreateAndAccount() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver,10);
            createAccountPage = homePage.openCreateAccount();
        }catch (Exception e){
            handleException(e);
        }
    }

    @Cuando("ingrese los datos incorrectos y de clic en Create and Account")
    public void ingreseLosDatosIncorrectosYDeClicEnCreateAndAccount() {
        try {
            createAccountPage.fillFields();
            createAccountPage.enterNotValidEmail();
            createAccountPage.createAccount();
        }catch (Exception e){
            handleException(e);
        }
    }

    @Entonces("podrá ver un mensaje de advertencia de campo invalido.")
    public void podráVerUnMensajeDeAdvertenciaDeCampoInvalido() {
        try {
            Assertions.assertTrue(createAccountPage.invalidEmailAlert().contains("Please enter a valid email address"));
            quiteDriver();
        }catch (Exception e){
            handleException(e);
        }
    }
}
