package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class RadioButtonPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void radioButtonTest(){
        radioButtonPage.open()
                .yesRadioButtonClick();

        Assert.assertTrue(radioButtonPage.getAnswer().isDisplayed());
        Assert.assertEquals(radioButtonPage.getAnswer().getText(), "You have selected Yes");
    }

    @Test
    public void radioButtonTest1(){
        radioButtonPage.open()
                .impressiveRadioButtonClick();

        Assert.assertTrue(radioButtonPage.getAnswer().isDisplayed());
        Assert.assertEquals(radioButtonPage.getAnswer().getText(), "You have selected Impressive");
    }

    @Test
    public void test2(){
        Assert.assertTrue(radioButtonPage.open().
                getNoRadioButton().is(Condition.editable));
    }
}
