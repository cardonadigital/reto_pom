package co.com.sofka.stepdefinition.purchase;

import co.com.sofka.pages.home.HomePage;
import co.com.sofka.pages.men.MenPage;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import co.com.sofka.pages.women.WomenPage;
import co.com.sofka.stepdefinition.setup.BaseTestPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;

public class ComprarProductosStepDefinition extends BaseTestPage {
    private HomePage homePage;
    private WomenPage womenPage;
    private MenPage menPage;
    private ShoppingCartPage shoppingCartPage;


    @Dado("que el usuario se dirige al modulo de women")
    public void queElUsuarioSeDirigeAlModuloDeWomen() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver,10);
            womenPage = homePage.openWomenPage();
        }catch (Exception e){
            handleException(e);
        }
    }

    @Y("agregue {int} productos al carrito de compras")
    public void agregueProductosAlCarritoDeCompras(int productsAmount) {
        womenPage.getProducts(productsAmount);
    }

    @Y("valla al modulo de hombres")
    public void vallaAlModuloDeHombres() {
        menPage = womenPage.openMenPage();
    }

    @Y("agregue otros {int} productos al carrito de compras")
    public void agregueOtrosProductosAlCarritoDeCompras(int productsAmount) throws InterruptedException {
        menPage.getProducts(productsAmount);
        shoppingCartPage = menPage.openShoppingCartPage();
    }

    @Cuando("realize el checkout rellenando los campos obligatorios")
    public void realizeElCheckoutRellenandoLosCamposObligatorios() throws InterruptedException {
        shoppingCartPage.checkOut();
    }

    @Y("confirme la compra")
    public void confirmeLaCompra() throws InterruptedException {
        shoppingCartPage.placeOrder();
    }

    @Entonces("podrá ver el siguiente mensaje  : {string}.")
    public void podraVerElSiguienteMensaje(String message) {
        System.out.println(shoppingCartPage.successfulMessage());
        Assertions.assertTrue(shoppingCartPage.successfulMessage().contains(message));
    }
}
