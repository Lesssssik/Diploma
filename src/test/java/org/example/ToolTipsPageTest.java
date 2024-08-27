package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ToolTipsPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void test1() {
        toolTipsPage.open().
                hoverOverElement(toolTipsPage.getButton());
        String buttonToolTip = toolTipsPage.getToolTipText(toolTipsPage.getButton());
        Assert.assertEquals(buttonToolTip, "You hovered over the Button");
    }
    @Test
    public void test2(){
        toolTipsPage.open().hoverOverElement(toolTipsPage.getField());
        String fieldToolTip = toolTipsPage.getToolTipText(toolTipsPage.getField());
        Assert.assertEquals(fieldToolTip, "You hovered over the text field");
    }
    @Test
    public void test3() {
        toolTipsPage.open().hoverOverElement(toolTipsPage.getContraryLink());
        String contraryLinkToolTip = toolTipsPage.getToolTipText(toolTipsPage.getContraryLink());
        Assert.assertEquals(contraryLinkToolTip, "You hovered over the Contrary");
    }

    @Test
    public void test4(){
        toolTipsPage.open().hoverOverElement(toolTipsPage.getSectionLink());
        String sectionLinkToolTip = toolTipsPage.getToolTipText(toolTipsPage.getSectionLink());
        Assert.assertEquals(sectionLinkToolTip, "You hovered over the 1.10.32");
    }

}
