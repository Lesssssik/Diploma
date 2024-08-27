package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class TextBoxPage extends MainPage{

    private final SelenideElement fillFullName = $(By.xpath("//input[@id='userName']"));
    private final SelenideElement fillEmail = $(By.xpath("//input[@id='userEmail']"));
    private final SelenideElement fillCurrentAddress = $(By.xpath("//textarea[@id='currentAddress']"));
    private final SelenideElement fillPermanentAddress = $(By.xpath("//textarea[@id='permanentAddress']"));
    private final SelenideElement submitButton = $(By.xpath("//button[@id='submit']"));
    private final SelenideElement output = $(By.xpath("(//div[@class='border col-md-12 col-sm-12'])[1]"));

    public TextBoxPage open(){
        Selenide.open("https://demoqa.com/text-box");
        return this;
    }
    public TextBoxPage fillFullName (String fullName){
        fillFullName.type(fullName);
        return this;
    }
    public TextBoxPage fillEmail(String email){
        fillEmail.type(email);
        return this;
    }
    public TextBoxPage fillCurrentAddress(String currentAddress){
        fillCurrentAddress.type(currentAddress);
        return this;
    }
    public TextBoxPage fillPermanentAddress(String permanentAddress){
        fillPermanentAddress.type(permanentAddress);
        return this;
    }
    public TextBoxPage clickSubmitButton(){
        submitButton.click();
        return this;
    }
}
