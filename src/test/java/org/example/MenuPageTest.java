package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuPageTest extends MainTest{

    @Test
    public void test1(){
        Assert.assertEquals(menuPage.
                open().
                hoverOver(menuPage.getMainMenu2(), menuPage.getSubSubList())
                .toMenuPage()
                .getSubSubItem1()
                .getOwnText(), "Sub Sub Item 1");
    }
}
