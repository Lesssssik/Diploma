package org.example;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class DroppablePageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void testSimpleDragAndDrop(){

        droppablePage.open().dragAndDropSimple();
        Assert.assertEquals(droppablePage.getSimpleDropText(), "Dropped!");

        sleep(3000);
    }
    @Test
    public void testAcceptableElement() {
        droppablePage.open().switchToAcceptTab().dragNotAcceptable();
        Assert.assertNotEquals(droppablePage.getAcceptDropText(), "Dropped!");
        sleep(2000);

        droppablePage.dragAcceptable();
        Assert.assertEquals(droppablePage.getAcceptDropText(), "Dropped!");
        sleep(2000);
    }

    @Test
    public void testPreventPropagation() {
        droppablePage.open().switchToPreventTab().dragToOuterDroppable();
        Assert.assertEquals(droppablePage.getInnerDropText(), "Inner droppable (not greedy)");
        sleep(4000);

        droppablePage.dragToInnerDroppable();
        Assert.assertNotEquals(droppablePage.getOuterDropText(), "Dropped!");
        Assert.assertEquals(droppablePage.getInnerDropText(), "Dropped!");
        sleep(4000);
    }
    @Test
    public void testPreventPropagationInnerGreedy() {
        droppablePage.open().switchToPreventTab().dragToInnerGreedy();
        Assert.assertNotEquals(droppablePage.getOuterFromGreedyText(), "Dropped!");
        Assert.assertEquals(droppablePage.getInnerGreedyText(), "Dropped!");
        sleep(2000);
    }

    @Test
    public void testRevertDraggable() {
        droppablePage.open().switchToRevertTab().dragRevertable();
        Assert.assertEquals(droppablePage.getRevertDropText(), "Dropped!");
        Assert.assertFalse(droppablePage.isRevertableBack1());
    }

    @Test
    public void testRevertDraggable2() {
        droppablePage.open().switchToRevertTab().dragNotRevertable();
        Assert.assertEquals(droppablePage.getRevertDropText(), "Dropped!");
        Assert.assertTrue(droppablePage.isRevertableBack2());
    }


}
