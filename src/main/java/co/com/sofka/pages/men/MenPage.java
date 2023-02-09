package co.com.sofka.pages.men;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenPage extends BasePageActions {
    By productsLocator = By.className("product-item");
    By shoppingCartLocator = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    By proceedCheckoutLocator = By.id("top-cart-btn-checkout");

    public MenPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void getProducts(Integer productsAmount) {
        for (int i = 0; i < productsAmount; i++) {
            var element = driver.findElements(productsLocator).get(i);
            scrollOn(element);
            clickOnElement(element);
            clickOnElement(element(By.xpath("//div[contains(@id, 'option-label-size-143-item-166')]")));
            clickOnElement(element(By.xpath("//div[contains(@id, 'option-label-color')]")));
            clickOnElement(element(By.xpath("//span[contains(text(), 'Add to Cart')]")));
            waitElement(By.xpath("//div[contains(text(), 'You added')]"));
            driver.navigate().back();
        }
    }

    public ShoppingCartPage openShoppingCartPage() throws InterruptedException {
        Thread.sleep(500);
        clickOnElement(element(shoppingCartLocator));
        clickOnElement(element(proceedCheckoutLocator));
        return new ShoppingCartPage(driver, 10);
    }
}
