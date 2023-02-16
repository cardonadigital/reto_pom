package co.com.sofka.pages.men;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import co.com.sofka.util.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenPage extends BasePageActions {
    Tools tools = new Tools(driver, 10);
    By productsLocator = By.className("product-item");
    By shoppingCartLocator = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    By proceedCheckoutLocator = By.id("top-cart-btn-checkout");

    public MenPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void addProductsToCart(Integer productsAmount) {
        tools.addProductsToCart(productsLocator, productsAmount);
    }

    public ShoppingCartPage openShoppingCartPage() throws InterruptedException {
        Thread.sleep(500);
        clickOnElement(element(shoppingCartLocator));
        clickOnElement(element(proceedCheckoutLocator));
        return new ShoppingCartPage(driver, 10);
    }
}
