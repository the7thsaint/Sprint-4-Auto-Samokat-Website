package org.example.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserInfoOrderPageElements {
    private final WebDriver driver;
    // Локатор для ввода имени
    private final By orderUserName = By.xpath(".//input[@placeholder='* Имя']");
    // Локатор для ввода фамилии
    private final By orderUserSurname = By.xpath(".//input[(@placeholder='* Фамилия')]");
    // Локатор для ввода адреса доставки
    private final By orderUserAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор для ввода станции метро
    private final By orderMetroStation = By.xpath(".//*[(@class='select-search__input' and @placeholder='* Станция метро')]");
    //локатор для выбора станции метро
    private final By selectMetroStation = By.xpath(".//*[@class='Order_SelectOption__82bhS select-search__option' and @value='2']");
    // Локатор для ввода номера телефона
    private final By orderUserPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор для кнопки "Далее"
    private final By orderNextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");



    public UserInfoOrderPageElements(WebDriver driver){
        this.driver = driver;
    }
    // метод для ввода имени
    public void inputUserName(String userFirstName){
        driver.findElement(orderUserName).sendKeys(userFirstName);
    }
    // метод для ввода фамилии
    public void inputUserSurname(String userSurName){
        driver.findElement(orderUserSurname).sendKeys(userSurName);
    }
    // метод для ввода Адреса
    public void inputUserAddress(String userAddress){
        driver.findElement(orderUserAddress).sendKeys(userAddress);
    }
    // метод для ввода метро
    public void SelectMetroStation(){
        driver.findElement(orderMetroStation).click();
        driver.findElement(selectMetroStation).click();
    }
    //метод для ввода мобильного телефона пользователя
    public void inputUserPhoneNumber(String userPhoneNumber){
        driver.findElement(orderUserPhoneNumber).sendKeys(userPhoneNumber);
    }
    // метод для нажатия кнопки "Далее"
    public void pushNextButton(){
        driver.findElement(orderNextButton).click();
    }
    // метод для создания заказа
    public void createOrder(String userFirstName, String userSurName, String userAddress, String userPhoneNumber){
        inputUserName(userFirstName);
        inputUserSurname(userSurName);
        inputUserAddress(userAddress);
        SelectMetroStation();
        inputUserPhoneNumber(userPhoneNumber);
        pushNextButton();
    }
}
