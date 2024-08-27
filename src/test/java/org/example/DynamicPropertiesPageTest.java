package org.example;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTest extends MainTest{

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
