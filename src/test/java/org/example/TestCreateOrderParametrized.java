package org.example;
import org.example.pageObject.MainPageElements;
import org.example.pageObject.RentInfoOrderPageElements;
import org.example.pageObject.UserInfoOrderPageElements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class TestCreateOrderParametrized extends BaseTest{
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String orderDate;
    private final String comment;

    public TestCreateOrderParametrized(String userName, String userSurname, String userAddress, String userPhoneNumber, String orderDate, String comment) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.orderDate = orderDate;
        this.comment = comment;
    }

    //Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Павел", "Виноградов", "Бегова 5", "89040076836", "12.03.2023", "Вези быстрее"},
                {"Василий", "Пупкин", "Пушкина 11", "89040036836", "10.04.2023", "ТОРОПИСЬ"},
        };
    }
    @Test
    public void TestOrder(){
        MainPageElements objelements = new MainPageElements(driver);
        UserInfoOrderPageElements objUserInfo = new UserInfoOrderPageElements(driver);
        RentInfoOrderPageElements objInfoOrdred = new RentInfoOrderPageElements(driver);

        objelements.pushAcceptCookieButton();
        objelements.scrollToPushHeaderOrderButton();
        objelements.pushFooterOrderButton();
        objUserInfo.createOrder(userName,userSurname, userAddress,userPhoneNumber);
        objInfoOrdred.acceptOrder(orderDate,comment);
        assertTrue(objInfoOrdred.checkModalWindowEnabled());
    }
}
