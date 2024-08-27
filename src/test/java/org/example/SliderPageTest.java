package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderPageTest extends MainTest{

    @Test
    public void testSliderValue() {
        sliderPage.open();
        int expectedValue = 30;
        sliderPage.setSliderValue(expectedValue);

        int actualValue = sliderPage.getSliderValue();
        Assert.assertEquals(expectedValue, actualValue);
    }
}
