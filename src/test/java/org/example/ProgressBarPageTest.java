package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class ProgressBarPageTest extends MainTest {

    @BeforeSuite
    public void config() {
        Configuration.pageLoadTimeout = 90000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void test1() {
        progressBarPage.open().clickButton().waitForCompletion();
        Assert.assertEquals(progressBarPage.getProgressText(), "100%");

        progressBarPage.clickResetButton();
        Assert.assertEquals(progressBarPage.getProgressText(), "0%");

        sleep(2000);
    }
}
