package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
@Getter
public class AlertsPage extends MainPage{

    private final SelenideElement alertButton = $(By.id("alertButton"));
    private final SelenideElement alert5Seconds = $(By.id("timerAlertButton"));
    private final SelenideElement confirmButton = $(By.id("confirmButton"));
    private final SelenideElement confirmResultText = $(By.id("confirmResult"));
    private final SelenideElement promptButton = $(By.id("promtButton"));
    private final SelenideElement promptResultText = $(By.id("promptResult"));

    public AlertsPage open(){
        Selenide.open("https://demoqa.com/alerts");
        return this;
    }
    public AlertsPage clickAlertButton(){
        alertButton.click();
        return this;
    }
    public AlertsPage clickAlert5Seconds(){
        alert5Seconds.click();
        return this;
    }
    public AlertsPage clickConfirmButton(){
        confirmButton.click();
        return this;
    }
    public AlertsPage clickPromptButton(){
        promptButton.click();
        return this;
    }
    public AlertsPage switchToAlertAccept(){
        switchTo().alert().accept();
        return this;
    }
    public AlertsPage clickAlertAccept(long timeout){
        switchTo().alert(Duration.ofSeconds(timeout)).accept();
        return this;
    }
    public AlertsPage switchToAlertDismiss(long timeout){
        switchTo().alert(Duration.ofSeconds(timeout)).dismiss();
        return this;
    }
    public AlertsPage switchToAlertDismiss(){
        switchTo().alert().dismiss();
        return this;
    }
    public AlertsPage alertPrompt(String text){
        switchTo().alert().sendKeys(text);
        return this;
    }
    public String getAlertText(){
        return switchTo().alert().getText();
    }
    public String getAlertText(long timeout){
        return switchTo().alert(Duration.ofSeconds(timeout)).getText();
    }
    public String getAlertTextAccept(long timeout){
        String text = switchTo().alert(Duration.ofSeconds(timeout)).getText();
        switchTo().alert().accept();
        return text;
    }
    public String getAlertTextAccept(){
        String text = switchTo().alert().getText();
        switchTo().alert().accept();
        return text;
    }
}
