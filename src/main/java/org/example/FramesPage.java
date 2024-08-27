package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Getter
public class FramesPage extends MainPage{

    private final SelenideElement frame1 = $(By.id("frame1"));
    private final SelenideElement frame2 = $(By.id("frame2"));
    private final SelenideElement h1 = $("h1");

    public FramesPage open(){
        Selenide.open("https://demoqa.com/frames");
        return this;
    }

    public FramesPage switchToFrame1() {
        switchTo().frame(frame1);
        return this;
    }
    public FramesPage switchToFrame2() {
        switchTo().frame(frame2);
        return this;
    }
    public String getPageH1(){
        return h1.getOwnText();
    }
    public FramesPage switchToMain(){
        switchTo().defaultContent();
        return this;
    }


}
