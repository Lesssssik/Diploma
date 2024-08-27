package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class DroppablePage extends MainPage {

    private final SelenideElement simpleTab = $("#droppableExample-tab-simple");
    private final SelenideElement acceptTab = $("#droppableExample-tab-accept");
    private final SelenideElement preventTab = $("#droppableExample-tab-preventPropogation");
    private final SelenideElement revertTab = $("#droppableExample-tab-revertable");

    private final SelenideElement draggable = $(By.id("draggable"));
    private final SelenideElement droppable = $(By.id("droppable"));

    private final SelenideElement acceptableDraggable = $("#acceptable");
    private final SelenideElement notAcceptableDraggable = $("#notAcceptable");
    private final SelenideElement droppableAccept = $("#acceptDropContainer #droppable");

    private final SelenideElement dragBox = $("#dragBox");
    private final SelenideElement outerDroppable = $("#notGreedyDropBox");
    private final SelenideElement innerDroppable = $("#notGreedyInnerDropBox");
    private final SelenideElement outerGreedy = $("#greedyDropBox");
    private final SelenideElement innerGreedy = $("#greedyDropBoxInner");

    private final SelenideElement revertableDraggable = $("#revertable");
    private final SelenideElement notRevertableDraggable = $("#notRevertable");
    private final SelenideElement droppableRevert = $("#revertableDropContainer #droppable");

    public DroppablePage open(){
        Selenide.open("https://demoqa.com/droppable");
        return this;
    }

    public DroppablePage switchToSimpleTab() {
        simpleTab.click();
        return this;
    }
    public DroppablePage switchToAcceptTab() {
        acceptTab.click();
        return this;
    }
    public DroppablePage switchToPreventTab() {
        preventTab.click();
        return this;
    }
    public DroppablePage switchToRevertTab() {
        revertTab.click();
        return this;
    }

    public DroppablePage dragAndDropSimple(){
        actions().dragAndDrop(draggable, droppable).build().perform();
        return this;
    }

    public String getSimpleDropText() {
        return droppable.getText();
    }

    public void dragAcceptable() {
        actions().dragAndDrop(acceptableDraggable, droppableAccept).build().perform();
    }

    public void dragNotAcceptable() {
        actions().dragAndDrop(notAcceptableDraggable, droppableAccept).build().perform();
    }

    public String getAcceptDropText() {
        return droppableAccept.getText();
    }

    public void dragToOuterDroppable() {
        actions().dragAndDropBy(dragBox, 293, 11 ).build().perform();
    }

    public void dragToInnerDroppable() {
        actions().dragAndDrop(dragBox, innerDroppable).build().perform();
    }
    public void dragToInnerGreedy() {
        actions().dragAndDrop(dragBox, innerGreedy).build().perform();
    }

    public String getOuterDropText() {
        return outerDroppable.getOwnText();
    }
    public String getOuterFromGreedyText() {
        return outerGreedy.getOwnText();
    }

    public String getInnerDropText() {
        return innerDroppable.getText();
    }
    public String getInnerGreedyText() {
        return innerGreedy.getText();
    }

    public void dragRevertable() {
        actions().dragAndDrop(revertableDraggable, droppableRevert).build().perform();
    }

    public void dragNotRevertable() {
        actions().dragAndDrop(notRevertableDraggable, droppableRevert).build().perform();
    }

    public String getRevertDropText() {
        return droppableRevert.getText();
    }

    public boolean isRevertableBack1() {
        return revertableDraggable.isDisplayed() && droppableRevert.getAttribute("class").equals("drop-box ui-droppable ui-state-highlight ui-droppable-active ui-active ui-droppable-hover ui-hover");
    }
    public boolean isRevertableBack2() {
        return notRevertableDraggable.isDisplayed() && droppableRevert.getAttribute("class").equals("drop-box ui-droppable ui-state-highlight");
    }
}
