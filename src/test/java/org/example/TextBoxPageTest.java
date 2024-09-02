package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TextBoxPageTest extends MainTest{

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
