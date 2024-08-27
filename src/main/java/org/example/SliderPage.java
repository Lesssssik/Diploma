package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

public class SliderPage extends MainPage{

    private final SelenideElement slider = $("#sliderContainer input");
    private final SelenideElement sliderValue = $("#sliderValue");

    public SliderPage open() {
        Selenide.open("https://demoqa.com/slider");
        return this;
    }

    public void setSliderValue(int targetValue) {

        int currentValue = getSliderValue();

        while (currentValue != targetValue) {
            if (currentValue < targetValue) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else if (currentValue > targetValue) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
            currentValue = getSliderValue();
        }
    }

    public int getSliderValue() {
        return Integer.parseInt(sliderValue.getValue());
    }
}
