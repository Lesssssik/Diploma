package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Getter
public class ProgressBarPage extends MainPage {

    private final SelenideElement progressBar = $(By.id("progressBar"));
    private final SelenideElement progressBarValue = $(By.xpath("//div[@role='progressbar']"));
    private final SelenideElement startStopButton = $(By.id("startStopButton"));
    private final SelenideElement resetButton = $(By.id("resetButton"));

    public ProgressBarPage open() {
        Selenide.open("https://demoqa.com/progress-bar");
        return this;
    }
    public ProgressBarPage clickButton() {
        startStopButton.click();
        return this;
    }
    public ProgressBarPage clickResetButton() {
        resetButton.shouldBe(visible).click();
        return this;
    }
    public void waitForCompletion() {
        progressBar.shouldHave(text("100%"), Duration.ofSeconds(15));
    }
    public String getProgressText() {
        return progressBar.getText();
    }
}
