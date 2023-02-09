package co.com.sofka.pages.home;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.gear.GearPage;
import co.com.sofka.pages.signin.SignInPage;
import co.com.sofka.pages.women.WomenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageActions {
    By gearLocator = By.xpath("//span[contains(text(), 'Gear')]");
    By womenLocator = By.xpath("//span[contains(text(), 'Women')]");
    By signInLocator = By.className("authorization-link");

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
}
