package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class SelectablePageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testSelectListItem() {
        selectablePage.open().selectListItem(1);

        Assert.assertTrue(selectablePage.isListItemSelected(1));
    }

    @Test
    public void testSelectGridItem() {
        selectablePage.open().switchToTabGrid().selectGridItem(2,1);

        Assert.assertTrue(selectablePage.isGridItemSelected(2, 1));
    }
}
