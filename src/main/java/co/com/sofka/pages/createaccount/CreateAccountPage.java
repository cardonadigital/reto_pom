package co.com.sofka.pages.createaccount;

import co.com.sofka.common.BasePageActions;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;

import java.util.Locale;

public class CreateAccountPage extends BasePageActions {
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    private By firstNameLocator =  By.id("firstname");
    private By lastNameLocator =  By.id("lastname");
    private By emailLocator =  By.id("email_address");
    private By passwordLocator =  By.id("password");
    private By confirmPasswordLocator =  By.id("password-confirmation");
    private By createAccountButtonLocator =  By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private By successfulMessageLocator = By.xpath("//div[contains(text(), 'Thank you')]");
    private By invalidEmailLocator = By.xpath("/html/body/div[2]/main/div[3]/div/form/fieldset[2]/div[1]/div/div");
    private By invalidPasswordLocator = By.xpath("/html/body/div[2]/main/div[3]/div/form/fieldset[2]/div[2]/div/div[1]");

    public CreateAccountPage(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    public void fillFields(){
        String password = fakeValuesService.regexify("[a-z1-9]{10}");
        typeOnTextField(element(firstNameLocator), faker.name().firstName());
        typeOnTextField(element(lastNameLocator), faker.name().lastName());
        typeOnTextField(element(emailLocator), fakeValuesService.bothify("????##@gmail.com"));
        typeOnTextField(element(passwordLocator), "K" + password);
        typeOnTextField(element(confirmPasswordLocator), "K" + password);
    }

    public void enterNotValidEmail(){
        clearField(element(emailLocator));
        typeOnTextField(element(emailLocator), "NotValidEmail");
    }

    public void createAccount(){
        scrollOn(element(createAccountButtonLocator));
        clickOnElement(element(createAccountButtonLocator));
    }

    public String successfulMessage(){
        waitElement(successfulMessageLocator);
        return getTextFromElement(element(successfulMessageLocator));
    }

    public String invalidEmailAlert(){
        waitElement(invalidEmailLocator);
        return getTextFromElement(element(invalidEmailLocator));
    }
}

