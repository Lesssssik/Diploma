package org.example;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class RadioButtonPage extends MainPage{

    private final SelenideElement question = $(By.cssSelector(".mb-3"));
    private final SelenideElement yesRadioButton = $(By.xpath("//label[normalize-space()='Yes']"));
    private final SelenideElement impressiveRadioButton = $(By.xpath("//label[normalize-space()='Impressive']"));
    private final SelenideElement noRadioButton = $(By.xpath("//label[normalize-space()='No']"));
    private final SelenideElement answer = $(By.cssSelector(".mt-3"));
    private final SelenideElement textSuccess = $(By.xpath("//span[@class='text-success']"));

    public RadioButtonPage open(){
        open("https://demoqa.com/radio-button");
        return this;
    }
    public RadioButtonPage yesRadioButtonClick(){
        yesRadioButton.click();
        return this;
    }
    public RadioButtonPage impressiveRadioButtonClick(){
        impressiveRadioButton.click();
        return this;
    }
    public RadioButtonPage noRadioButtonClick(){
        noRadioButton.click();
        return this;
    }

}
