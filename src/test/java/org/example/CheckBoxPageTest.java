package org.example;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends MainTest{

    @Test
    public void test1(){
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage.open()
                .clickHomeArrow()
                .clickDownloadArrow()
                .clickDocumentsArrow()
                .clickDownloadArrow();
    }
}