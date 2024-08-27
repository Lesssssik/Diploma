package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class SortablePageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }

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
