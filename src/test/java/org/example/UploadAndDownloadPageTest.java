package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;
import static constants.Constants.PATH_TO_RESOURCES;

public class UploadAndDownloadPageTest extends MainTest{

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
