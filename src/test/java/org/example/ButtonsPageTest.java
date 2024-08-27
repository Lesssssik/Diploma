package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ButtonsPageTest extends MainTest{

    @Test
    public void ButtonTest(){
        buttonsPage.open().doubleClickButtonClick()
                            .rightClickButtonClick()
                            .clickMeButtonClick();

        Assert.assertTrue(buttonsPage.getDoubleClickMessage().isDisplayed());
        Assert.assertTrue(buttonsPage.getRightClickMessage().isDisplayed());
        Assert.assertTrue(buttonsPage.getDynamicClickMessage().isDisplayed());
    }
}
