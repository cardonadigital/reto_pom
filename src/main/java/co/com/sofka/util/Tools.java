package co.com.sofka.util;

import co.com.sofka.common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tools extends BasePageActions {

    public Tools(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void addProductsToCart(By productsLocator ,Integer productsAmount) {
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

    public Integer getAmountOfProducts(By productsLocator){
        List<WebElement> products = elements(productsLocator);
        return products.size();
    }
}
