package org.example;

import org.example.pageObject.MainPageElements;
import org.junit.Test;

public class TestListOfQuestionsAboutImportant extends BaseTest {
    @Test
    public void ListsEquals(){
        MainPageElements objElements = new MainPageElements(driver);
        objElements.equalsListsOfQuestionsAboutImportant();
    }



}
