package co.com.sofka.pages.singin;

import co.com.sofka.common.BasePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePageActions {
    By emailLocator = By.id("email");
    By passwordLocator = By.id("pass");
    By signInLocator = By.xpath("//span[contains(text(), 'Sign In')]");
    By errorLocator = By.xpath("//div[contains(text(),'Incorrect CAPTCHA')]");
    By userLocator = By.xpath("//span[contains(text(), 'Welcome')]");


    public SignInPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void signIn(String emailUser, String password){
        typeOnTextField(element(emailLocator), emailUser);
        typeOnTextField(element(passwordLocator), password);
        scrollOn(element(signInLocator));
        clickOnElement(element(signInLocator));
    }

    public String getError(){
        return getTextFromElement(element(errorLocator));
    }

    public String getUser() {
        WebElement element = waitElement(userLocator);
        return getTextFromElement(element);
    }
}
