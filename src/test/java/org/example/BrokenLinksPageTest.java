package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrokenLinksPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void testLoadedImage() {
        Assert.assertTrue(brokenLinksPage.open().isImageLoaded(brokenLinksPage.getValidImage()));
    }

    @Test
    public void testBrokenImage() {
        // Проверяем, что изображение сломано
        Assert.assertTrue(brokenLinksPage.open().isImageBroken(brokenLinksPage.getBrokenImage()));
    }

    @Test
    public void testValidLink() {
        Assert.assertTrue(brokenLinksPage.open().isLinkWorking(brokenLinksPage.getValidLink()));
    }

    @Test
    public void testBrokenLink() {
        Assert.assertTrue(brokenLinksPage.open().isLinkBroken(brokenLinksPage.getBrokenLink()));
    }

}
