package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ButtonsPage extends MainPage{

    private final SelenideElement doubleClickButton = $(By.id("doubleClickBtn"));
    private final SelenideElement rightClickButton = $(By.id("rightClickBtn"));
    private final SelenideElement clickMeButton = $(By.xpath("(//button[normalize-space()='Click Me'])[1]"));
    private final SelenideElement doubleClickMessage = $(By.id("doubleClickMessage"));
    private final SelenideElement rightClickMessage = $(By.id("rightClickMessage"));
    private final SelenideElement dynamicClickMessage = $(By.id("dynamicClickMessage"));

    public ButtonsPage open(){
        Selenide.open("https://demoqa.com/buttons");
        return this;
    }

    public ButtonsPage doubleClickButtonClick(){
        doubleClickButton.doubleClick();
        return this;
    }
    public ButtonsPage rightClickButtonClick(){
        rightClickButton.contextClick();
        return this;
    }
    public ButtonsPage clickMeButtonClick(){
        clickMeButton.click();
        return this;
    }
}
