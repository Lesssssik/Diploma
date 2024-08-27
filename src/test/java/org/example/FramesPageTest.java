package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FramesPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void test1(){
        Assert.assertEquals(framesPage.open().
                switchToFrame1().getPageH1(),"This is a sample page");
    }
    @Test
    public void test2(){
        Assert.assertEquals(framesPage.open().
                switchToFrame2().getPageH1(), "This is a sample page");
    }
    @Test
    public void test3(){

        Assert.assertEquals(framesPage.open().
                switchToFrame2().
                getPageH1(), "This is a sample page");

        Assert.assertEquals(framesPage.switchToMain().getPageH1(), "Frames");
    }
}
