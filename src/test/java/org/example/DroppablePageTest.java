package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppablePageTest extends MainTest{

    @Test
    public void testSimpleDragAndDrop(){

        droppablePage.open().dragAndDropSimple();
        Assert.assertEquals(droppablePage.getSimpleDropText(), "Dropped!");

    }

    @Test
    public void testAcceptableElement() {
        droppablePage.open().switchToAcceptTab().dragNotAcceptable();
        Assert.assertNotEquals(droppablePage.getAcceptDropText(), "Dropped!");

        droppablePage.dragAcceptable();
        Assert.assertEquals(droppablePage.getAcceptDropText(), "Dropped!");
    }

    @Test
    public void testPreventPropagation() {
        droppablePage.open().switchToPreventTab().dragToOuterDroppable();
        Assert.assertEquals(droppablePage.getInnerDropText(), "Inner droppable (not greedy)");

        droppablePage.dragToInnerDroppable();
        Assert.assertNotEquals(droppablePage.getOuterDropText(), "Dropped!");
        Assert.assertEquals(droppablePage.getInnerDropText(), "Dropped!");
    }

    @Test
    public void testPreventPropagationInnerGreedy() {
        droppablePage.open().switchToPreventTab().dragToInnerGreedy();
        Assert.assertNotEquals(droppablePage.getOuterFromGreedyText(), "Dropped!");
        Assert.assertEquals(droppablePage.getInnerGreedyText(), "Dropped!");
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
