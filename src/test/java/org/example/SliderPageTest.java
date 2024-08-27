package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SliderPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void testSliderValue() {
        sliderPage.open();
        int expectedValue = 30;
        sliderPage.setSliderValue(expectedValue);

        int actualValue = sliderPage.getSliderValue();
        Assert.assertEquals(expectedValue, actualValue);
    }
}
