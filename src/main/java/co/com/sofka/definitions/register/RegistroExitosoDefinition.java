package co.com.sofka.definitions.register;

import co.com.sofka.definitions.setup.BaseTestPage;
import co.com.sofka.pages.createaccount.CreateAccountPage;
import co.com.sofka.pages.home.HomePage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

public class RegistroExitosoDefinition extends BaseTestPage {
    private HomePage homePage;
    private CreateAccountPage createAccountPage;


    @Dado("que el cliente se dirige al modulo de Create an Account")
    public void queElClienteSeDirigeAlModuloDeCreateAndAccount() {
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

    @Cuando("ingrese los datos correctos y de clic en Create and Account")
    public void ingreseLosDatosCorrectosYDeClicEnCreateAndAccount() {
        try {
            createAccountPage.fillFields();
            createAccountPage.createAccount();
        }catch (Exception e){
            handleException(e);
        }
    }


    @Entonces("podrá ver el siguiente mensaje : {string}.")
    public void podráVerElSiguienteMensaje(String message) {
        try {
            Assertions.assertTrue(createAccountPage.successfulMessage().contains(message));
            quiteDriver();
        }catch (Exception e){
            handleException(e);
        }
    }
}
