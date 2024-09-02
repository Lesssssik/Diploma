package org.example;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LinksPageTest extends MainTest{

    @Test
    public void testSimpleLink(){
        linksPage.open().clickSimpleLink().waitForBanner();
        Assert.assertEquals(Selenide.title(), "DEMOQA");
        linksPage.closeTheCurrentWindow();
    }

    @Test
    public void testDynamicLink(){
        linksPage.open().clickDynamicLink().waitForBanner();
        Assert.assertEquals(Selenide.title(), "DEMOQA");
        linksPage.closeTheCurrentWindow();
    }

    @Test
    public void testCreatedLink() {
        String code = "201";
        String textStatus = "Created";
        String text = linksPage.open().clickCreatedLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }

    @Test
    public void testNoContentLink() {
        String code = "204";
        String textStatus = "No Content";
        String text = linksPage.open().clickNoContentLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }

    @Test
    public void testMovedLink() {
        String code = "301";
        String textStatus = "Moved Permanently";
        String text = linksPage.open().clickMovedLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }

    @Test
    public void testBadRequestLink() {
        String code = "400";
        String textStatus = "Bad Request";
        String text = linksPage.open().clickBadRequestLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }

    @Test
    public void testUnauthorizedLink() {
        String code = "401";
        String textStatus = "Unauthorized";
        String text = linksPage.open().clickUnauthorizedLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }


    @Test
    public void testForbiddenLink() {
        String code = "403";
        String textStatus = "Forbidden";
        String text = linksPage.open().clickForbiddenLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }

    @Test
    public void testNotFoundLink() {
        String code = "404";
        String textStatus = "Not Found";
        String text = linksPage.open().clickNotFoundLink().getLinkResponseText().getText();
        Assert.assertEquals(text, "Link has responded with staus "+code+" and status text "+textStatus);
    }
}
