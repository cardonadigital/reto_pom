package co.com.sofka.stepdefinition.setup;

import co.com.sofka.stepdefinition.fitness.VerificarFiltroStepDefinition;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class BaseTestPage {
    private static final Logger LOGGER = Logger.getLogger(BaseTestPage.class);

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/drivers/chromedriver.exe";

    private static final String DEMO_QA_URL = "https://magento.softwaretestingboard.com/";

    protected WebDriver driver;

    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalSetUp() {
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quiteDriver() {
        driver.quit();
    }

    protected void handleException(Exception e){
        LOGGER.error("Error en la ejecucion del test: " + e.getMessage());
        Assertions.fail("Error en la ejecucion del test: " + e.getMessage());
        quiteDriver();
    }
}
