package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NestedFramesPageTest extends MainTest{

    @Test
    public void test1(){

        Assert.assertEquals(nestedFramesPage.open().
                switchToParentFrame().
                switchToChildFromParent().getPText().getOwnText(), "Child Iframe");
    }
}
