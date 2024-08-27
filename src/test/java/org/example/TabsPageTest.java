package org.example;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabsPageTest extends MainTest{

    @Test
    public void testTabs() {

        Assert.assertEquals(tabsPage.open().clickTabOrigin().getOriginContent().getText(), tabsPage.originTabText);

        Assert.assertEquals(tabsPage.open().clickTabUse().getUseContent().getOwnText(), tabsPage.useTabText);

        Assert.assertEquals(tabsPage.clickTabWhat().getWhatContent().getOwnText(), tabsPage.whatTabText);
    }

    @Test
    public void testTabs1(){
        Assert.assertTrue(tabsPage.open().getTabMore().is(Condition.editable));
    }
}
