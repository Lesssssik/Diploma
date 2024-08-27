package org.example;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragabblePageTest extends MainTest{

    @Test
    public void testSimpleDrag() {
        dragabblePage.open();
        Point startPosition = dragabblePage.getElementPosition(dragabblePage.getDragMeBox());
        dragabblePage.testTabSimple(320,40);
        Point endPosition = dragabblePage.getElementPosition(dragabblePage.getDragMeBox());
        Assert.assertNotEquals(startPosition, endPosition);
    }

    @Test
    public void testAxisRestrictedDrag() {
        dragabblePage.open().switchToTabAxisRestriction();
        Point startPositionX = dragabblePage.getElementPosition(dragabblePage.getAxisBoxX());
        dragabblePage.testAxisBoxX(340,0);
        Point endPositionX = dragabblePage.getElementPosition(dragabblePage.getAxisBoxX());
        Assert.assertNotEquals(startPositionX, endPositionX);

        Point startPositionY = dragabblePage.getElementPosition(dragabblePage.getAxisBoxY());
        dragabblePage.testAxisBoxY(0,47);
        Point endPositionY = dragabblePage.getElementPosition(dragabblePage.getAxisBoxY());
        Assert.assertNotEquals(startPositionY, endPositionY);
    }

    @Test
    public void testContainerRestrictedDrag() {
        dragabblePage.open().switchToTabContainerRestriction();
        Point startPositionInLargeContainer = dragabblePage.getElementPosition(dragabblePage.getMoveTextInBoxLargeContainer());
        dragabblePage.testMoveTextInBoxInLargeContainer(427,106);
        Point endPositionInLargeContainer = dragabblePage.getElementPosition(dragabblePage.getMoveTextInBoxLargeContainer());
        Assert.assertNotEquals(startPositionInLargeContainer, endPositionInLargeContainer);

        Point startPositionInSmallContainer = dragabblePage.getElementPosition(dragabblePage.getMoveTextInSmallContainer());
        dragabblePage.testMoveTextInSmallContainer(13,86);
        Point endPositionInSmallContainer = dragabblePage.getElementPosition(dragabblePage.getMoveTextInSmallContainer());
        Assert.assertNotEquals(startPositionInSmallContainer, endPositionInSmallContainer);
    }

    @Test
    public void testCursorStyleDrag() {
        dragabblePage.open().switchToTabCursorStyle();
        Point startPositionCursorCenter = dragabblePage.getElementPosition(dragabblePage.getCursorCenterTabCursorStyle());
        dragabblePage.testCursorCenterTabCursorStyle(186,76);
        Point endPositionCursorCenter = dragabblePage.getElementPosition(dragabblePage.getCursorCenterTabCursorStyle());
        Assert.assertNotEquals(startPositionCursorCenter, endPositionCursorCenter);

        Point startPositionCursorTopLeft = dragabblePage.getElementPosition(dragabblePage.getCursorTopLeftTabCursorStyle());
        dragabblePage.testCursorTopLeftTabCursorStyle(262, -38);
        Point endPositionCursorTopLeft = dragabblePage.getElementPosition(dragabblePage.getCursorTopLeftTabCursorStyle());
        Assert.assertNotEquals(startPositionCursorTopLeft, endPositionCursorTopLeft);

        Point startPositionCursorBottom = dragabblePage.getElementPosition(dragabblePage.getCursorBottomTabCursorStyle());
        dragabblePage.testCursorBottomTabCursorStyle(431, 36);
        Point endPositionCursorBottom = dragabblePage.getElementPosition(dragabblePage.getCursorBottomTabCursorStyle());
        Assert.assertNotEquals(startPositionCursorBottom, endPositionCursorBottom);
    }
}
