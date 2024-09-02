package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SortablePageTest extends MainTest{

    @Test
    public void testSortableItems() {

        sortablePage.open();
        String listBefore = sortablePage.getContainerText();

        sortablePage.dragAndDropFirstToSecond();
        String listAfter = sortablePage.getContainerText();

        Assert.assertNotEquals(listBefore, listAfter);
    }

    @Test
    public void testSortableItems2() {

        sortablePage.open().switchToGridTab();
        String gridBefore = sortablePage.getContainerGridText();

        sortablePage.dragAndDropFirstToSecondGrid();
        String gridAfter = sortablePage.getContainerGridText();

        Assert.assertNotEquals(gridBefore, gridAfter);
    }
}
