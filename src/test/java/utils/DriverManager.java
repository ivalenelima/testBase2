package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("🚀 Abrindo nova instância do WebDriver");
            System.setProperty("webdriver.chrome.driver", "/home/ivalenelima/Downloads/chromedriver-linux64/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("➡️ Reciclando instância do WebDriver");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            System.out.println("🛑 Fechando WebDriver");
            driver.quit();
            driver = null;
        }
    }
}
