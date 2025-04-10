package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("🔵 Starting Scenario: " + scenario.getName());
        DriverManager.getDriver(); // Don't store it in static here
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("🔴 Scenario failed: " + scenario.getName());
            // You could also add screenshot capture here
        } else {
            System.out.println("✅ Scenario passed: " + scenario.getName());
        }

        DriverManager.quitDriver();
    }
}
