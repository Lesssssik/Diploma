package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TabsPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void test1(){
        Assert.assertEquals(tabsPage.open().clickTabOrigin().getOriginContent().getText(), tabsPage.originText+tabsPage.originTextPart2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(tabsPage.open().clickTabUse().getUseContent().getText(), tabsPage.useText);
    }

    @Test
    public void test3(){
        Assert.assertEquals(tabsPage.open().clickTabOrigin().clickTabWhat().getWhatContent().getText(), tabsPage.whatText);
    }

    @Test
    public void test4(){
        Assert.assertTrue(tabsPage.open().getTabMore().is(Condition.editable));
    }
}
