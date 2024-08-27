package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void test1(){
        dynamicPropertiesPage.open().refresh().clickEnableAfterButton();
    }
    @Test
    public void test2(){
        dynamicPropertiesPage.open().clickColorChangeButton();

        System.out.println(dynamicPropertiesPage.getColorChangeButton().getCssValue("color"));
    }
    @Test
    public void test3(){
        dynamicPropertiesPage.open().clickVisibleAfterButton();
    }
}
