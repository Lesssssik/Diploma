package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ResizablePageTest extends MainTest{
    @BeforeSuite
    public void config() {
        Configuration.pageLoadTimeout = 90000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void test1() {
        resizablePage.open();
        int[] initialSize = resizablePage.getBoxSize();
        resizablePage.resizeBox(50, 50);
        int[] newSize = resizablePage.getBoxSize();

        Assert.assertEquals(initialSize[0] + 50, newSize[0]);
        Assert.assertEquals(initialSize[1] + 50, newSize[1]);
        sleep(3000);
    }
    @Test
    public void test2() {
        resizablePage.open();
        int[] initialSize = resizablePage.getBoxSizeNoLimit();
        resizablePage.resizeBoxNoLimit(100, 150);
        int[] newSize = resizablePage.getBoxSizeNoLimit();

        Assert.assertEquals(initialSize[0] + 100, newSize[0]);
        Assert.assertEquals(initialSize[1] + 150, newSize[1]);
        sleep(3000);
    }
}
