package co.com.sofka.pages.home;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.createaccount.CreateAccountPage;
import co.com.sofka.pages.gear.GearPage;
import co.com.sofka.pages.shoppingcart.ShoppingCartPage;
import co.com.sofka.pages.signin.SignInPage;
import co.com.sofka.pages.women.WomenPage;
import co.com.sofka.util.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageActions {
    Tools tools = new Tools(driver, 10);
    By productsLocator = By.className("product-item");
    By gearLocator = By.xpath("//span[contains(text(), 'Gear')]");
    By womenLocator = By.xpath("//span[contains(text(), 'Women')]");
    By signInLocator = By.className("authorization-link");
    By createAccountLocator = By.xpath("//a[contains(text(), 'Create')]");
    By shoppingCartLocator = By.className("showcart");
    By viewEditCartLocator = By.xpath("//span[contains(text(), 'View')]");

    public HomePage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public GearPage openGearPage(){
        clickOnElement(element(gearLocator));
        return new GearPage(driver, 10);
    }

    public SignInPage openSignInPage(){
        clickOnElement(element(signInLocator));
        return new SignInPage(driver, 10);
    }

    public WomenPage openWomenPage(){
        clickOnElement(element(womenLocator));
        return new WomenPage(driver, 10);
    }

    public CreateAccountPage openCreateAccount(){
        clickOnElement(element(createAccountLocator));
        return new CreateAccountPage(driver, 10);
    }

    public void addProductsToCart(Integer productsAmount) {
        tools.addProductsToCart(productsLocator, productsAmount);
    }

    public ShoppingCartPage openShoppingCartPage(){
        scrollOn(element(shoppingCartLocator));
        clickOn(waitElement(shoppingCartLocator));
        clickOn(waitElement(viewEditCartLocator));
        return new ShoppingCartPage(driver, 10);
    }


}
