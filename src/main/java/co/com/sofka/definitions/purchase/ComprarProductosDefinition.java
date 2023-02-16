package co.com.sofka.definitions.purchase;

import co.com.sofka.definitions.setup.BaseTestPage;
import co.com.sofka.pages.home.HomePage;
import co.com.sofka.pages.men.MenPage;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import co.com.sofka.pages.women.WomenPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;

public class ComprarProductosDefinition extends BaseTestPage {
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
            homePage = new HomePage(driver, 10);
            womenPage = homePage.openWomenPage();
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Y("agregue {int} productos al carrito de compras")
    public void agregueProductosAlCarritoDeCompras(int productsAmount) {
        try {
            womenPage.addProductsToCart(productsAmount);
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Y("valla al modulo de hombres")
    public void vallaAlModuloDeHombres() {
        try {
            menPage = womenPage.openMenPage();
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Y("agregue otros {int} productos al carrito de compras")
    public void agregueOtrosProductosAlCarritoDeCompras(int productsAmount) throws InterruptedException {
        try {
            menPage.addProductsToCart(productsAmount);
            shoppingCartPage = menPage.openShoppingCartPage();
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Cuando("realize el checkout rellenando los campos obligatorios")
    public void realizeElCheckoutRellenandoLosCamposObligatorios() throws InterruptedException {
        try {
            shoppingCartPage.checkOut();
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Y("confirme la compra")
    public void confirmeLaCompra() throws InterruptedException {
        try {
            shoppingCartPage.placeOrder();
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Entonces("podrá ver el siguiente mensaje  : {string}.")
    public void podraVerElSiguienteMensaje(String message) {
        try {
            Assertions.assertTrue(shoppingCartPage.successfulMessage().contains(message));
            quiteDriver();
        } catch (Exception e) {
            handleException(e);
        }
    }
}
