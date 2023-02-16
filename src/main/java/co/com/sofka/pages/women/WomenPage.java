package co.com.sofka.pages.women;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.men.MenPage;
import co.com.sofka.util.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends BasePageActions {
    Tools tools = new Tools(driver, 10);
    By productsLocator = By.className("product-item");
    By menLocator = By.xpath("//span[contains(text(), 'Men')]");

    public WomenPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void addProductsToCart(Integer productsAmount) {
        tools.addProductsToCart(productsLocator, productsAmount);
    }

    public MenPage openMenPage(){
        scrollOn(element(menLocator));
        clickOnElement(element(menLocator));
        return new MenPage(driver, 10);
    }

}
