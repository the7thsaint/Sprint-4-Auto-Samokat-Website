package org.example;

import org.example.pageObject.MainPageElements;
import org.example.pageObject.RentInfoOrderPageElements;
import org.example.pageObject.UserInfoOrderPageElements;
import org.junit.Test;



import static org.junit.Assert.assertTrue;

public class TestCreateOrder extends BaseTest {


    @Test
    public void TestOrderWithHeaderButton(){

        MainPageElements objelements = new MainPageElements(driver);
        UserInfoOrderPageElements objUserInfo = new UserInfoOrderPageElements(driver);
        RentInfoOrderPageElements objInfoOrdred = new RentInfoOrderPageElements(driver);

        objelements.pushAcceptCookieButton();
        objelements.pushHeaderOrderButton();
        objUserInfo.createOrder("Павел","Виноградов", "Бегова 5","89040076836");
        objInfoOrdred.acceptOrder("12.03.2023","Вези быстрее");
        assertTrue(objInfoOrdred.checkModalWindowEnabled());
    }

    @Test
    public void TestOrder(){
        MainPageElements objelements = new MainPageElements(driver);
        UserInfoOrderPageElements objUserInfo = new UserInfoOrderPageElements(driver);
        RentInfoOrderPageElements objInfoOrdred = new RentInfoOrderPageElements(driver);

        objelements.pushAcceptCookieButton();
        objelements.scrollToPushHeaderOrderButton();
        objelements.pushFooterOrderButton();
        objUserInfo.createOrder("Павел","Виноградов", "Бегова 5","89040076836");
        objInfoOrdred.acceptOrder("12.03.2023","Вези быстрее");
        assertTrue(objInfoOrdred.checkModalWindowEnabled());
    }
}
