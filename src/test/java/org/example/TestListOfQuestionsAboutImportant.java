package org.example;

import org.example.pageObject.MainPageElements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestListOfQuestionsAboutImportant extends BaseTest {
    //    @Test
//    public void ListsEquals(){
//        MainPageElements objElements = new MainPageElements(driver);
//        objElements.equalsListsOfQuestionsAboutImportant();
//    }
    private final String questionLocator;
    private final String answerLocator;
    private final String answerText;


    public TestListOfQuestionsAboutImportant(String questionLocator, String answerLocator, String answerText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        return new Object[][]{
                {MainPageElements.buttonsQuestionArray[0], MainPageElements.textQuestionsAboutImportantArray[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPageElements.buttonsQuestionArray[1], MainPageElements.textQuestionsAboutImportantArray[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPageElements.buttonsQuestionArray[2], MainPageElements.textQuestionsAboutImportantArray[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPageElements.buttonsQuestionArray[3], MainPageElements.textQuestionsAboutImportantArray[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPageElements.buttonsQuestionArray[4], MainPageElements.textQuestionsAboutImportantArray[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPageElements.buttonsQuestionArray[5], MainPageElements.textQuestionsAboutImportantArray[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPageElements.buttonsQuestionArray[6], MainPageElements.textQuestionsAboutImportantArray[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPageElements.buttonsQuestionArray[7], MainPageElements.textQuestionsAboutImportantArray[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void testEqualsTextQuestionsAboutImportant(){
        MainPageElements objMainElements = new MainPageElements(driver);
        objMainElements.scrollPageToQuestionsAboutImportant();
        objMainElements.clickQuestionButton(questionLocator);
        String ActualAnswerText = driver.findElement(By.id(answerLocator)).getText();
        assertEquals("Тексты не совпали", answerText, ActualAnswerText);
    }
}
