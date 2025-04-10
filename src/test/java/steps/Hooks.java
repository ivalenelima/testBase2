package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("🔵 Iniciando cenário: " + scenario.getName());
        DriverManager.getDriver(); // Don't store it in static here
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("🔴 Cenário falhou: " + scenario.getName());
            // You could also add screenshot capture here
        } else {
            System.out.println("✅ Cenário passou: " + scenario.getName());
        }

        DriverManager.quitDriver();
    }
}
