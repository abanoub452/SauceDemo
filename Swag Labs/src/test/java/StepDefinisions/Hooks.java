package StepDefinisions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void openBrowser() throws InterruptedException {
        //1- bridge
        WebDriverManager.edgedriver().setup();
        //OR
        //System.setProperty

        //2- new object from chrome
        driver = new EdgeDriver();
        //3-Configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //4-Navigate
        driver.navigate().to("https://www.saucedemo.com");
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        //quit driver
        driver.quit();
    }

}
