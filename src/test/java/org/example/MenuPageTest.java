package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class MenuPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void test1(){
        Assert.assertEquals(menuPage.
                open().
                hoverOver(menuPage.getMainMenu2(), menuPage.getSubSubList())
                .toMenuPage()
                .getSubSubItem1()
                .getOwnText(), "Sub Sub Item 1");
    }
}
