package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static constants.Constants.PATH_TO_RESOURCES;

public class UploadAndDownloadPageTest extends MainTest{

    @BeforeSuite
    public void config(){
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void test1(){
        uploadAndDownloadPage.open()
                .downloadAFile("src\\main\\resources", "sampleFile.jpeg");
    }
    @Test
    public void test2(){
        String fileName = "UploadFile.txt";

        uploadAndDownloadPage.open()
                .uploadFile(PATH_TO_RESOURCES+fileName);

        Assert.assertTrue(uploadAndDownloadPage.getFilePathP().getOwnText().matches("^C:.*"+fileName+"$"));

    }
}
