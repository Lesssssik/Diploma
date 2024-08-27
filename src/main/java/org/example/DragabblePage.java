package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Getter
public class DragabblePage extends MainPage{

    private final SelenideElement tabSimple = $(By.id("draggableExample-tab-simple"));
    private final SelenideElement tabAxisRestriction = $(By.id("draggableExample-tab-axisRestriction"));
    private final SelenideElement tabContainerRestriction = $(By.id("draggableExample-tab-containerRestriction"));
    private final SelenideElement tabCursorStyle = $(By.id("draggableExample-tab-cursorStyle"));
    private final SelenideElement dragMeBox = $(By.id("dragBox"));
    private final SelenideElement axisBoxX = $(By.id("restrictedX"));
    private final SelenideElement axisBoxY = $(By.id("restrictedY"));
    private final SelenideElement containerRestrictedLarge = $(By.id("containmentWrapper"));
    private final SelenideElement moveTextInBoxLargeContainer = $(By.xpath("//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']"));
    private final SelenideElement containerRestrictedSmall = $(By.xpath("(//div[@class='draggable ui-widget-content m-3'])[1]"));
    private final SelenideElement moveTextInSmallContainer = $(By.xpath("//span[@class='ui-widget-header ui-draggable ui-draggable-handle']"));
    private final SelenideElement cursorCenterTabCursorStyle = $(By.id("cursorCenter"));
    private final SelenideElement cursorTopLeftTabCursorStyle = $(By.id("cursorTopLeft"));
    private final SelenideElement cursorBottomTabCursorStyle = $(By.id("cursorBottom"));

    public DragabblePage open(){
        Selenide.open("https://demoqa.com/dragabble");
        return this;
    }
    public DragabblePage switchToTabSimple(){
        tabSimple.click();
        return this;
    }
    public DragabblePage switchToTabAxisRestriction(){
        tabAxisRestriction.click();
        return this;
    }
    public DragabblePage switchToTabContainerRestriction(){
        tabContainerRestriction.click();
        return this;
    }
    public DragabblePage switchToTabCursorStyle(){
        tabCursorStyle.click();
        return this;
    }
    public DragabblePage testTabSimple(int xOffset, int yOffset){
        actions().dragAndDropBy(dragMeBox, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testAxisBoxX(int xOffset, int yOffset){
        actions().dragAndDropBy(axisBoxX, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testAxisBoxY(int xOffset, int yOffset){
        actions().dragAndDropBy(axisBoxY, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testMoveTextInBoxInLargeContainer(int xOffset, int yOffset){
        actions().dragAndDropBy(moveTextInBoxLargeContainer, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testMoveTextInSmallContainer(int xOffset, int yOffset){
        actions().dragAndDropBy(moveTextInSmallContainer, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testCursorCenterTabCursorStyle(int xOffset, int yOffset){
        actions().dragAndDropBy(cursorCenterTabCursorStyle, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testCursorTopLeftTabCursorStyle(int xOffset, int yOffset){
        actions().dragAndDropBy(cursorTopLeftTabCursorStyle, xOffset, yOffset).build().perform();
        return this;
    }
    public DragabblePage testCursorBottomTabCursorStyle(int xOffset, int yOffset){
        actions().dragAndDropBy(cursorBottomTabCursorStyle, xOffset, yOffset).build().perform();
        return this;
    }
    public Point getElementPosition(SelenideElement element) {
        return element.getLocation();
    }

}
