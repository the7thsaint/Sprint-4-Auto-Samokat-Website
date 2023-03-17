package org.example.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class MainPageElements {
    private static WebDriver driver;
    // кнопка "Заказать" в верхней части страницы
    private final By headerOrderButton = By.className("Button_Button__ra12g");
    // кнопка "Заказать" в нижней части страницы
    private final By footerOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // Локаторы кнопок с вопросами
    private static final String[] buttonsQuestionArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};
    //Локаторы текстов "Вопросы о важном
    private static final String[]  textQuestionsAboutImportantArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};


    // кнопка "Статус заказа"
    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    // лого яндекс самокат
    private final By yandexLogo = By.className("Header_Logo__23yGT");


    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка для нажатия на верхнюю кнопку "Заказать"

    public void pushHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
    }
    // метод для скролла до нижней кнопки "Заказать"
    public void scrollToPushHeaderOrderButton(){
        WebElement element = driver.findElement(headerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToPushFooterOrderButton(){
        WebElement element = driver.findElement(footerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // метод для нажатия нижней кнопки "Заказать"
    public void pushFooterOrderButton(){
        driver.findElement(footerOrderButton).click();
    }

    //метод для скролла до списка "Вопросы о важном"
    public MainPageElements scrollPageToQuestionsAboutImportant(){
        WebElement lastQuestionArrow = driver.findElement(By.id(buttonsQuestionArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }
    // клик по стрелке выпадающего списка
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(buttonsQuestionArray[questionNumber])));
        driver.findElement(By.id(buttonsQuestionArray[questionNumber])).click();
    }
    //проверка текста кнопок списка "Вопросы о важном"
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(textQuestionsAboutImportantArray[answerNumber])));
        String answerText = driver.findElement(By.id(textQuestionsAboutImportantArray[answerNumber])).getText();
        assertEquals(expectedText, answerText);
    }
    //Клик по кнопке вопроса
    public MainPageElements clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }






    //метод для создания и сравнения списков "Вопросы о важном"
//    public void equalsListsOfQuestionsAboutImportant(){
//        pushAcceptCookieButton();
//        scrollToNoteQuestionsAboutImportant();
//        List<WebElement> buttonsQuestionAboutImportant = driver.findElements(buttonsListQuestionsAboutImportant);
//        for (int i = 0; i < buttonsQuestionAboutImportant.size(); i++){
//            buttonsQuestionAboutImportant.get(i).click();
//            List<WebElement> textQuestionsAboutImportant = driver.findElements(textListQuestionsAboutImportant);
//            List<String> actualResult = Arrays.asList(actualResultOfQuestion);
//            assertEquals("Строки не совпали", textQuestionsAboutImportant.get(i).getText(), actualResult.get(i));
//        }
//    }


}
