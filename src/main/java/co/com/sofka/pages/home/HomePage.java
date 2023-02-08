package co.com.sofka.pages.home;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.gear.GearPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageActions {
    By gear = By.xpath("//span[contains(text(), 'Gear')]");

    public HomePage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public GearPage openGearPage(){
        clickOnElement(element(gear));
        return new GearPage(driver, 10);
    }
}
