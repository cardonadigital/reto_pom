package co.com.sofka.definitions.shoppingcart;

import co.com.sofka.definitions.setup.BaseTestPage;
import co.com.sofka.pages.home.HomePage;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class EliminarProductosDefinition extends BaseTestPage {
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private Integer products = 2;
    private String shoppingCartTitle = "Shopping Cart";


    @Dado("que el usuario se encuentre en la página principal")
    public void queElUsuarioSeEncuentreEnLaPáginaPrincipal() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver,10);
        }catch (Exception e){
            handleException(e);
        }
    }

    @Cuando("añada productos al carrito de compras")
    public void añadaProductosAlCarritoDeCompras() {
        try {
            homePage.addProductsToCart(products);
        }catch (Exception e){
            handleException(e);
        }
    }

    @Entonces("podrá ver los productos añadidos en el carrito de compras")
    public void podráVerLosProductosAñadidosEnElCarritoDeCompras() {
        try {
            shoppingCartPage = homePage.openShoppingCartPage();
            Assertions.assertEquals(products, shoppingCartPage.getAmountOfProducts());
        }catch (Exception e){
            handleException(e);
        }
    }

    @Dado("que el usuario se encuentra en el modulo de Shopping Cart")
    public void queElUsuarioSeEncuentraEnElModuloDeShoppingCart() {
        try {
            System.out.println("ssd");
            Assertions.assertEquals(shoppingCartTitle, shoppingCartPage.getPageTitle());
        }catch (Exception e){
            handleException(e);
        }
    }

    @Cuando("elimine un producto del carro de compras")
    public void elimineUnProductoDelCarroDeCompras() {
        try {
            shoppingCartPage.deleteProducts(1);
        }catch (Exception e){
            handleException(e);
        }
    }

    @Entonces("podrá ver que el producto fue eliminado del carrito.")
    public void podráVerQueElProductoFueEliminadoDelCarrito() {
        try {
            Assertions.assertEquals(1, (int) shoppingCartPage.getAmountOfProducts());
            quiteDriver();
        }catch (Exception e){
            handleException(e);
        }
    }
}
