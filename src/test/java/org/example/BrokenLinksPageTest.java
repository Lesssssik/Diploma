package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinksPageTest extends MainTest{

    @Test
    public void testLoadedImage() {
        Assert.assertTrue(brokenLinksPage.open().isImageLoaded(brokenLinksPage.getValidImage()));
    }

    @Test
    public void testBrokenImage() {
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
