package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class NestedFramesPage extends MainPage{

    public final SelenideElement parentFrame = $(By.id("frame1"));
    private final SelenideElement pText = $("p");

    public SelenideElement getPText() {
        return pText;
    }

    public NestedFramesPage open(){
        Selenide.open("https://demoqa.com/nestedframes");
        return this;
    }

    public NestedFramesPage switchToParentFrame(){
        switchTo().frame(parentFrame);
        return this;
    }
    public NestedFramesPage switchToChildFromParent(){
        switchTo().frame(0);
        return this;
    }
}
