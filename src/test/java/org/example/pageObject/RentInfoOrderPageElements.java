package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentInfoOrderPageElements {
    private final WebDriver driver;
    //ввод даты доставки заказа
    private final By orderDateOfDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //нажатие на поле количества суток
    private final By orderRentalPeriod = By.className("Dropdown-control");
    //выбор количества суток
    private final By orderHowManydaysRent = By.xpath(".//*[(@role ='option' and text()='двое суток')]");
    //выбор цвета самоката
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    //локатор для поля комментарий
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатора на кнопку "Да"
    private final By acceptOrderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Локатор на кнопку "Заказать"
    private final By approveOrderForButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор на кнопку "Посмотреть статус"
    private final By modalWindow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");


    public RentInfoOrderPageElements(WebDriver driver) {
        this.driver = driver;
    }
    // метод для ввода даты доставки
    public void inputOrderDate(String orderDate){
        driver.findElement(orderDateOfDelivery).sendKeys(orderDate);
        driver.findElement(orderDateOfDelivery).sendKeys(Keys.ENTER);
    }
    // метод для ввода срока владения
    public void inputRentalPeriod(){
        driver.findElement(orderRentalPeriod).click();
        driver.findElement(orderHowManydaysRent).click();
    }
    // метод для выбора цвета самоката
    public void pushCheckbox(){
        driver.findElement(checkBoxColourBlackPearl).click();
    }
    // метод для ввода комментария
    public void inputCommentForDeliveryCourier(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    // метод для принятия заказа
    public void pushAcceptOrderButton(){
        driver.findElement(acceptOrderButton).click();
    }
    // метод для подверждения заказа
    public void approveOrderButton(){
        driver.findElement(approveOrderForButton).click();
    }
    // метод для проверки появления модального окна
    public  boolean checkModalWindowEnabled() {
        return driver.findElement(modalWindow).isEnabled();
    }
    // метод для прохождения шагов по созданию заказа
    public void acceptOrder(String orderDate, String comment){
        inputOrderDate(orderDate);
        inputRentalPeriod();
        pushCheckbox();
        inputCommentForDeliveryCourier(comment);
        approveOrderButton();
        pushAcceptOrderButton();
    }

}
