package co.com.sofka.pages.women;

import co.com.sofka.common.BasePageActions;
import co.com.sofka.pages.men.MenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WomenPage extends BasePageActions {
    By productsLocator = By.className("product-item");
    By menLocator = By.xpath("//span[contains(text(), 'Men')]");

    public WomenPage(WebDriver driver, int seconds) {
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

    public MenPage openMenPage(){
        scrollOn(element(menLocator));
        clickOnElement(element(menLocator));
        return new MenPage(driver, 10);
    }
}
