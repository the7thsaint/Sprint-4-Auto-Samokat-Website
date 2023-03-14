package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
    protected WebDriver driver;


    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver","/Users/pavelvinogradov/Documents/bin/chromedriver");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver","/Users/pavelvinogradov/Documents/bin/geckodriver");
        //driver = new FirefoxDriver();
        // SafariDriver driver = new SafariDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}