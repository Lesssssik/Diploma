package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResizablePageTest extends MainTest{

    @Test
    public void test1() {
        resizablePage.open();
        int[] initialSize = resizablePage.getBoxSize();
        resizablePage.resizeBox(50, 50);
        int[] newSize = resizablePage.getBoxSize();

        Assert.assertEquals(initialSize[0] + 50, newSize[0]);
        Assert.assertEquals(initialSize[1] + 50, newSize[1]);
    }

    @Test
    public void test2() {
        resizablePage.open();
        int[] initialSize = resizablePage.getBoxSizeNoLimit();
        resizablePage.resizeBoxNoLimit(100, 150);
        int[] newSize = resizablePage.getBoxSizeNoLimit();

        Assert.assertEquals(initialSize[0] + 100, newSize[0]);
        Assert.assertEquals(initialSize[1] + 150, newSize[1]);
    }
}
