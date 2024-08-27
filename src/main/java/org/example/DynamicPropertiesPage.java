package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DynamicPropertiesPage extends MainPage{

    private final SelenideElement enableAfterButton = $(By.id("enableAfter"));
    private final SelenideElement colorChangeButton = $(By.id("colorChange"));
    private final SelenideElement visibleAfterButton = $(By.id("visibleAfter"));

    public SelenideElement getEnableChangeButton() {
        return colorChangeButton;
    }

    public DynamicPropertiesPage open(){
        Selenide.open("https://demoqa.com/dynamic-properties");
        return this;
    }
    public DynamicPropertiesPage refresh(){
        Selenide.refresh();
        return this;
    }
    public DynamicPropertiesPage clickEnableAfterButton(){
        enableAfterButton.shouldBe(Condition.enabled, Duration.ofSeconds(6));
        enableAfterButton.click();
        return this;
    }
    public DynamicPropertiesPage clickColorChangeButton(){
        colorChangeButton.shouldBe(Condition.not(Condition.cssValue("color", "rgba(255,255,255,1)")),Duration.ofSeconds(6));
        colorChangeButton.click();
        return this;
    }
    public DynamicPropertiesPage clickVisibleAfterButton(){
        visibleAfterButton.shouldBe(Condition.visible, Duration.ofSeconds(6));
        visibleAfterButton.click();
        return this;
    }
}
