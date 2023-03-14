package org.example.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainPageElements {
    private final WebDriver driver;
    // кнопка "Заказать" в верхней части страницы
    private final By headerOrderButton = By.className("Button_Button__ra12g");
    // кнопка "Заказать" в нижней части страницы
    private final By footerOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // кнопка принятия куки
    private final By acceptCookieButton = By.id("rcc-confirm-button");
    //Надпись "вопросы о важном"
    private final By noteQuestionsAboutImportant = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    // локатор для сбора кнопок списка "Вопросы о важном"
    private final By buttonsListQuestionsAboutImportant = By.xpath(".//div[@class='accordion__button']");
    // локатор для сбора текстов кнопок списка "Вопросы о важном"
    private final By textListQuestionsAboutImportant = By.xpath(".//div[@class='accordion__panel']/p");
    //массив актуальных текстов
    private String[] actualResultOfQuestion = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    // кнопка "Статус заказа"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    // лого яндекс самокат
    private final By yandexLogo = By.className("Header_Logo__23yGT");


    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }
    // метод для принятия куки
    public void pushAcceptCookieButton(){
        driver.findElement(acceptCookieButton).click();
    }
    // кнопка для нажатия на верхнюю кнопку "Заказать"

    public void pushHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
    }
    // метод для скролла до нижней кнопки "Заказать"
    public void scrollToPushHeaderOrderButton(){
        WebElement element = driver.findElement(footerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // метод для нажатия нижней кнопки "Заказать"
    public void pushFooterOrderButton(){
        driver.findElement(footerOrderButton).click();
    }
    //метод для скролла до списка "Вопросы о важном"
    public void scrollToNoteQuestionsAboutImportant(){
        WebElement element = driver.findElement(noteQuestionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //метод для создания и сравнения списков "Вопросы о важном"
    public void equalsListsOfQuestionsAboutImportant(){
        pushAcceptCookieButton();
        scrollToNoteQuestionsAboutImportant();
        List<WebElement> buttonsQuestionAboutImportant = driver.findElements(buttonsListQuestionsAboutImportant);
        for (int i = 0; i < buttonsQuestionAboutImportant.size(); i++){
            buttonsQuestionAboutImportant.get(i).click();
            List<WebElement> textQuestionsAboutImportant = driver.findElements(textListQuestionsAboutImportant);
            List<String> actualResult = Arrays.asList(actualResultOfQuestion);
            assertEquals("Строки не совпали", textQuestionsAboutImportant.get(i).getText(), actualResult.get(i));
        }
    }


}
