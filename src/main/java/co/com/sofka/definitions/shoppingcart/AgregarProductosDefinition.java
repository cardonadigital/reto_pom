package co.com.sofka.definitions.shoppingcart;

import co.com.sofka.pages.home.HomePage;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import co.com.sofka.definitions.setup.BaseTestPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

public class AgregarProductosDefinition extends BaseTestPage {
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private Integer products;

    @Dado("que el usuario se dirige a la pagina principal")
    public void queElUsuarioSeDirigeALaPaginaPrincipal() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver,10);
        }catch (Exception e){
            handleException(e);
        }
    }

    @Cuando("añada {int} productos al carrito de compras")
    public void añadaProductosAlCarritoDeCompras(int amountProducts) {
        products = amountProducts;
        try {
            homePage.addProductsToCart(products);
        }catch (Exception e){
            handleException(e);
        }
    }

    @Entonces("podrá ver los productos añadidos al carrito de compras")
    public void podráVerLosProductosAñadidosAlCarritoDeCompras() {
        try {
            shoppingCartPage = homePage.openShoppingCartPage();
            Assertions.assertEquals(products, shoppingCartPage.getAmountOfProducts());
            quiteDriver();
        }catch (Exception e){
            handleException(e);
        }
    }
}
