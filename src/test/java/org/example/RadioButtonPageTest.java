package org.example;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RadioButtonPageTest extends MainTest{

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
