package org.example;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlertsPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }
    @Test
    public void test1(){
        String alertText = alertsPage.open().
                clickAlertButton().
                getAlertText();

        alertsPage.switchToAlertAccept();

        Assert.assertEquals(alertText, "You clicked a button");
    }
    @Test
    public void test2(){
        String alertText = alertsPage.open().
                clickAlert5Seconds().
                getAlertText(7);

        alertsPage.switchToAlertAccept();

        Assert.assertEquals(alertText, "This alert appeared after 5 seconds");
    }
    @Test
    public void test3(){
        String alertText = alertsPage.open().
                clickConfirmButton().
                getAlertTextAccept();

        Assert.assertEquals(alertText, "Do you confirm action?");
        Assert.assertEquals(alertsPage.getConfirmResultText().getText(), "You selected Ok");
    }
    @Test
    public void test4(){
        String promptText = "lolkek";
        String alertText = alertsPage.open().
                clickPromptButton().
                getAlertText();

        alertsPage.alertPrompt(promptText).switchToAlertAccept();

        Assert.assertEquals(alertText, "Please enter your name");
        Assert.assertEquals(alertsPage.getPromptResultText().getText(), "You entered " + promptText);
    }
}
