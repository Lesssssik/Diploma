package org.example;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class AutoCompletePage extends  MainPage{

    private final SelenideElement autocompleteMultipleContainer = $(".auto-complete__value-container.auto-complete__value-container--is-multi.auto-complete__value-container--has-value.css-1hwfws3");
    private final SelenideElement autocompleteClearButton = $(".css-19bqh2r[height='20']");
    private final SelenideElement autocompleteListMultiple = $(".auto-complete__menu-list.auto-complete__menu-list--is-multi.css-11unzgr");
    private final SelenideElement autoCompleteMultipleInput = $(By.id("autoCompleteMultipleInput"));
    private final SelenideElement autocompleteSingleContainer = $(By.id("autoCompleteSingleContainer"));
    private final SelenideElement autoCompleteSingleInput = $(By.id("autoCompleteSingleInput"));
    private final SelenideElement autocompleteListSingle = $(".auto-complete__menu.css-26l3qy-menu");
    private final SelenideElement multipleValueRemove = $(By.xpath("(//div[@class='css-xb97g8 auto-complete__multi-value__remove'])[1]"));
    private final SelenideElement multipleValue = $(".auto-complete__value-container.auto-complete__value-container--is-multi.auto-complete__value-container--has-value.css-1hwfws3");
    private final SelenideElement singleValue = $(".auto-complete__single-value.css-1uccc91-singleValue");

    public AutoCompletePage open(){
        Selenide.open("https://demoqa.com/auto-complete");
        return this;
    }

    public void selectOptionFromSingleInput(String option) {
        autoCompleteSingleInput.setValue(option);
        autocompleteListSingle.shouldHave(text(option)).click();
    }

    public void selectOptionFromMultipleInput(String [] options) {
        for (String option:options){
            autoCompleteMultipleInput.setValue(option);
            autocompleteListMultiple.shouldHave(text(option)).click();
        }
    }
    public AutoCompletePage ClickAutocompleteClearButton(){
        autocompleteClearButton.click();
        return this;
    }

    public AutoCompletePage clickMultipleValueRemove(){
        multipleValueRemove.click();
        return this;
    }

    public String getSingleValueText() {
        return singleValue.getText();
    }

    public String [] getMultipleValueText(){
        String [] array = getMultipleValue().getText().split("\n");
        return array;
    }

}
