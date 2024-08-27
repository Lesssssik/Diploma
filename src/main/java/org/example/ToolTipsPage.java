package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ToolTipsPage extends MainPage{

    private final SelenideElement button = $(By.id("toolTipButton"));
    private final SelenideElement field = $(By.id("toolTipTextField"));
    private final SelenideElement contraryLink = $(By.xpath("//a[normalize-space()='Contrary']"));
    private final SelenideElement sectionLink = $(By.xpath("//a[normalize-space()='1.10.32']"));

    public ToolTipsPage open(){
        Selenide.open("https://demoqa.com/tool-tips");
        return this;
    }
    public void hoverOverElement(SelenideElement element) {
        element.hover();
    }

    public String getToolTipText(SelenideElement element) {
        return $(".tooltip-inner").shouldBe(visible).getText();
    }
}
