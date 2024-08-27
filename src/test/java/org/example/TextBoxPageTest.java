package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TextBoxPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }
    @Test
    public void test1(){
        String test1 = textBoxPage.open().
                fillFullName("Иванов Иван").
                fillEmail("ivan@gmail.com").
                fillCurrentAddress("г.Москва, ул.Кирова, д.5").
                fillPermanentAddress("г.Пермь, ул.Центральная, д.30, кв.3").
                clickSubmitButton().getOutput().getText();

        Assert.assertEquals(textBoxPage.getOutput().getText(), test1);
        System.out.println(test1);
    }
}
