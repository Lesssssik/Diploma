package org.example;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class AccordianPageTest extends MainTest{
    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void test1(){
        accordianPage.open()
                .clickSection2Heading()
                .clickSection3Heading()
                .clickSection1Heading();

        Assert.assertEquals(accordianPage.getSection2Heading().getOwnText(), "Where does it come from?");
        Assert.assertEquals(accordianPage.getSection3Heading().getOwnText(), "Why do we use it?");
        Assert.assertEquals(accordianPage.getSection1Heading().getOwnText(), "What is Lorem Ipsum?");

        sleep(3000);
    }
    @Test
    public void test2(){
        Assert.assertEquals(accordianPage.open().
                clickSection2Heading().
                getSection2Content().
                getText()+accordianPage.getSection2ContentTextPart2().
                getOwnText(), accordianPage.bodyAccordian2);

        sleep(3000);
    }
    @Test
    public void test3(){
        Assert.assertEquals(accordianPage.open().
                clickSection3Heading().
                getSection3Content().
                getOwnText(), accordianPage.bodyAccordian3);

        sleep(3000);
    }
    @Test
    public void test4(){
        Assert.assertEquals(accordianPage.open().
                getSection1Content().
                getText(), accordianPage.bodyAccordian1);

        sleep(3000);
    }
}
