package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Getter
public class ResizablePage extends MainPage{

    private final SelenideElement constraintArea = $(By.xpath("//div[@class='constraint-area']"));
    private final SelenideElement resizableBoxWithRestriction = $(By.id("resizableBoxWithRestriction"));
    private final SelenideElement resizeHandle = $(By.xpath("//div[@id='resizableBoxWithRestriction']//span[contains(@class,'react-resizable-handle react-resizable-handle-se')]"));
    private final SelenideElement resizableBoxNoLimit = $(By.id("resizable"));
    private final SelenideElement resizeHandleNoLimit = $(By.xpath("//div[@id='resizable']//span[@class='react-resizable-handle react-resizable-handle-se']"));

    public ResizablePage open(){
        Selenide.open("https://demoqa.com/resizable");
        return this;
    }

    public int[] getBoxSize() {
        int width = resizableBoxWithRestriction.getSize().getWidth();
        int height = resizableBoxWithRestriction.getSize().getHeight();
        return new int[]{width, height};
    }

    public void resizeBox(int xOffset, int yOffset) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDropBy(resizeHandle, xOffset, yOffset).perform();
    }

    public int[] getBoxSizeNoLimit() {
        int width = resizableBoxNoLimit.getSize().getWidth();
        int height = resizableBoxNoLimit.getSize().getHeight();
        return new int[]{width, height};
    }

    public void resizeBoxNoLimit(int xOffset, int yOffset) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDropBy(resizeHandleNoLimit, xOffset, yOffset).perform();
    }
}
