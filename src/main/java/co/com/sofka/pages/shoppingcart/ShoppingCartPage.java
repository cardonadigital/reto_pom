package co.com.sofka.pages.shoppingcart;

import co.com.sofka.common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static co.com.sofka.models.ShippingInfo.shippingInfo;

public class ShoppingCartPage extends BasePageActions {
    By emailLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input");
    By firstNameLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input");
    By lastNameLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input");
    By addressLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input");
    By cityLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input");
    By provinceLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[5]/div/select");
    By zipLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input");
    By phoneNumberLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input");
    By bestWayLocator = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input");
    By nextButtonLocator = By.xpath("//span[contains(text(), 'Next')]");
    By placeOrderLocator = By.xpath("//span[contains(text(), 'Place Order')]");
    By successfulOrderLocator = By.xpath("//span[contains(text(), 'Thank')]");

    public ShoppingCartPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void checkOut() throws InterruptedException {
        waitElement(emailLocator);
        typeOnTextField(element(emailLocator), "example@gmail.com");
        typeOnTextField(element(firstNameLocator), "example@gmail.com");
        typeOnTextField(element(lastNameLocator), "example@gmail.com");
        typeOnTextField(element(addressLocator), "example@gmail.com");
        typeOnTextField(element(cityLocator), "Medellin");
        Select drpCountry = new Select(driver.findElement(provinceLocator));
        drpCountry.selectByVisibleText("South Carolina");
        typeOnTextField(element(zipLocator), "12345-6789");
        typeOnTextField(element(phoneNumberLocator), "3224443252");
        clickOnElement(element(bestWayLocator));
        scrollOn(element(nextButtonLocator));
        clickOnElement(element(nextButtonLocator));
    }

    public void placeOrder() throws InterruptedException {
        waitElement(placeOrderLocator);
        clickOn(element(placeOrderLocator));
    }

    public String successfulMessage(){
        waitElement(successfulOrderLocator);
        return getTextFromElement(element(successfulOrderLocator));
    }
}
