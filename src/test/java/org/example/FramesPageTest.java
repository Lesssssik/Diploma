package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FramesPageTest extends MainTest{

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
