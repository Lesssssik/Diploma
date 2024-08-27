package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProgressBarPageTest extends MainTest {

    @Test
    public void test1() {
        progressBarPage.open().clickButton().waitForCompletion();
        Assert.assertEquals(progressBarPage.getProgressText(), "100%");

        progressBarPage.clickResetButton();
        Assert.assertEquals(progressBarPage.getProgressText(), "0%");
    }
}
