package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NestedFramesPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void test1(){

        Assert.assertEquals(nestedFramesPage.open().
                switchToParentFrame().
                switchToChildFromParent().getPText().getOwnText(), "Child Iframe");
    }
}
