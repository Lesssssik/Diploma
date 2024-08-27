package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class CheckBoxPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void test1(){
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage.open()
                .clickHomeArrow()
                .clickDownloadArrow()
                .clickDocumentsArrow()
                .clickDownloadArrow();

        sleep(3000);
    }
}