package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class SortablePage extends MainPage{

    private final SelenideElement tabList = $(By.id("demo-tab-list"));
    private final SelenideElement tabGrid = $(By.id("demo-tab-grid"));
    private final SelenideElement tabListContent = $(By.id("demo-tabpane-list"));
    private final SelenideElement tabGridContent = $(By.xpath("//div[@class='create-grid']"));
    private final SelenideElement listItemOne = $(By.xpath("(//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='One'])[1]"));
    private final SelenideElement listItemTwo = $(By.xpath("(//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Two'])[1]"));
    private final SelenideElement listItemThree = $(By.xpath("(//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Three'])[1]"));
    private final SelenideElement listItemFour = $(By.xpath("(//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Four'])[1]"));
    private final SelenideElement listItemFive = $(By.xpath("(//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Five'])[1]"));
    private final SelenideElement listItemSix = $(By.xpath("(//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Six'])[1]"));
    private final SelenideElement gridItemOne = $(By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action'][normalize-space()='One']"));
    private final SelenideElement gridItemTwo = $(By.xpath("//div[contains(@class,'create-grid')]//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Two']"));
    private final SelenideElement gridItemThree = $(By.xpath("//div[contains(@class,'create-grid')]//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Three']"));
    private final SelenideElement gridItemFour = $(By.xpath("//div[contains(@class,'create-grid')]//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Four']"));
    private final SelenideElement gridItemFive = $(By.xpath("//div[contains(@class,'create-grid')]//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Five']"));
    private final SelenideElement gridItemSix = $(By.xpath("//div[contains(@class,'create-grid')]//div[contains(@class,'list-group-item list-group-item-action')][normalize-space()='Six']"));
    private final SelenideElement gridItemSeven = $(By.xpath("//div[normalize-space()='Seven']"));
    private final SelenideElement gridItemEight = $(By.xpath("//div[normalize-space()='Eight']"));
    private final SelenideElement gridItemNine = $(By.xpath("//div[normalize-space()='Nine']"));

    private final ElementsCollection collection = $$(".vertical-list-container.mt-4");

    public SortablePage open(){
        Selenide.open("https://demoqa.com/sortable");
        return this;
    }
    public void switchToGridTab(){
        tabGrid.click();
    }
    public void dragAndDropFirstToSecond(){
        actions().clickAndHold(listItemOne).moveToElement(listItemFive).release().perform();
    }
    public String getContainerText(){
        return tabListContent.getText();
    }
    public void dragAndDropFirstToSecondGrid(){
        actions().clickAndHold(gridItemNine).moveToElement(gridItemFive).release().perform();
    }
    public String getContainerGridText(){
        return tabGridContent.getText();
    }
}
