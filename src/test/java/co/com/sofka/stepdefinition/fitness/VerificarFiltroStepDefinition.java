package co.com.sofka.stepdefinition.fitness;

import co.com.sofka.pages.fitness.FitnessPage;
import co.com.sofka.pages.gear.GearPage;
import co.com.sofka.pages.home.HomePage;
import co.com.sofka.stepdefinition.setup.BaseTestPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class VerificarFiltroStepDefinition extends BaseTestPage {

    private HomePage homePage;
    private GearPage gearPage;
    private FitnessPage fitnessPage;



    @Dado("que el usuario se dirige al modulo de Gear-Fitness Equipement")
    public void queElUsuarioSeDirigeAlModuloDeGearFitnessEquipement() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            homePage = new HomePage(driver,10);
            gearPage = homePage.openGearPage();
            fitnessPage = gearPage.openFitnessPage();
        }catch (Exception e){
            handleException(e);
        }
    }

    @Cuando("filtre los productos por Actividad en Gym")
    public void filtreLosProductosPorActividadEnGym() {
        try {
            fitnessPage.selectActivityGym();
        }catch (Exception e){
            handleException(e);
        }
    }

    @Y("filtre los productos por Genero en unisex")
    public void filtreLosProductosPorGeneroEnUnisex() {
        try {
            fitnessPage.selectGenderUnixes();
        }catch (Exception e){
            handleException(e);
        }
    }

    @Entonces("podrá ver que haya como mínimo {int} productos")
    public void podraVerQueHayaComoMínimoProductos(int products) {
        try {
            Assertions.assertTrue(fitnessPage.getAmountProducts() >= products);
        }catch (Exception e){
            handleException(e);
        }
    }


}
