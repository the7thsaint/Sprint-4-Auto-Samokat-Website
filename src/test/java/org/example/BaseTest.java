package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageObject.Constans;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTest {
    protected WebDriver driver;
    private final By acceptCookieButton = By.id("rcc-confirm-button");


    @Before
    public void startUp() {

        //System.setProperty("webdriver.gecko.driver","/Users/pavelvinogradov/Documents/bin/geckodriver");
        //driver = new FirefoxDriver();
        // SafariDriver driver = new SafariDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Constans.PAGE_URL);
        driver.findElement(acceptCookieButton).click();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}