package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Iniciando cenário: " + scenario.getName());
        DriverManager.quitDriver();
        DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Cenário falhou: " + scenario.getName());
        } else {
            System.out.println("Cenário passou: " + scenario.getName());
        }

        DriverManager.quitDriver();
    }
}
