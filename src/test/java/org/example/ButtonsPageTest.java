package org.example;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class ButtonsPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void ButtonTest(){
        buttonsPage.open().doubleClickButtonClick()
                            .rightClickButtonClick()
                            .clickMeButtonClick();

        Assert.assertTrue(buttonsPage.getDoubleClickMessage().isDisplayed());
        Assert.assertTrue(buttonsPage.getRightClickMessage().isDisplayed());
        Assert.assertTrue(buttonsPage.getDynamicClickMessage().isDisplayed());

                sleep(3000);
    }
}
