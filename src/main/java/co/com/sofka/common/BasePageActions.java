package co.com.sofka.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.Return;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePageActions {
    private static final Logger LOGGER = Logger.getLogger(BasePageActions.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    protected WebDriver driver;

    //Constructor
    public BasePageActions(WebDriver driver) {
        try {
            if (driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public BasePageActions(WebDriver driver, int seconds) {
        try {
            if (driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;

            webDriverImplicitWait(driver, seconds);

        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Init POM with Page Factory
    protected void pageFactoryInitElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }

    //Implicit wait.
    private void webDriverImplicitWait(WebDriver driver, int seconds){
        try{
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }


    //----------- Functionalities -----------

    //Click on Element
    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //type on text field
    protected void typeOnTextField(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Scroll On Element
    protected void scrollOn(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Click On Element
    protected void clickOn(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Is an Element Displayed
    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return false;
        }
    }

    //Get text from element
    protected String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return "";
        }
    }

    //Fluent wait element
    protected WebElement waitElement(By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        return  wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    //waituntil
    public void waitUntilClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected WebElement element(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> elements(By locator){
        return driver.findElements(locator);
    }

    protected String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    protected void clearField(WebElement element){
        element.clear();
    }
}

