package co.com.sofka.pages.gear;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.fitness.FitnessPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GearPage extends BasePageActions {

    By fitnessEquipment = By.xpath("//a[contains(text(), 'Fitness Equipment')]");


    public GearPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public FitnessPage openFitnessPage(){
        clickOnElement(element(fitnessEquipment));
        return new FitnessPage(driver, 10);
    }


}
