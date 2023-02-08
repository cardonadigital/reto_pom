package co.com.sofka.pages.fitness;

import co.com.sofka.common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FitnessPage extends BasePageActions {
    By activity = By.xpath("//div[contains(text(), 'Activity')]");
    By gymActivity = By.xpath("//a[contains(text(), 'Gym')]");

    By gender = By.xpath("//div[contains(text(), 'Gender')]");
    By unisexGender = By.xpath("//a[contains(text(), 'Unisex')]");




    public FitnessPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }


    public void selectActivityGym(){
        scrollOn(element(activity));
        clickOnElement(element(activity));
        clickOnElement(element(gymActivity));
    }

    public void selectGenderUnixes(){
        scrollOn(element(gender));
        clickOnElement(element(gender));
        clickOnElement(element(unisexGender));
    }

    public Integer getAmountProducts() throws InterruptedException {
        Thread.sleep(500);
        By productsOnPage = By.xpath("//a[contains(@class, 'product-item-link')]");
        List<WebElement> products = elements(productsOnPage);
        return products.size();
    }
}
