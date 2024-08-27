package org.example;

import com.codeborne.selenide.*;
import lombok.Getter;
import org.openqa.selenium.By;
import java.io.File;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.FileFilters.withName;

@Getter
public class UploadAndDownloadPage extends MainPage{

    private final SelenideElement downloadButton = $(By.id("downloadButton"));
    private final SelenideElement uploadButton = $(By.id("uploadFile"));
    private final SelenideElement filePathP = $("#uploadedFilePath");

    public UploadAndDownloadPage open(){
        Selenide.open("https://demoqa.com/upload-download");
        return this;
    }
    public UploadAndDownloadPage downloadAFile(){
        File file = downloadButton.download(DownloadOptions.using(FOLDER));
        return this;
    }
    public UploadAndDownloadPage downloadAFile(String pathToFile){
        Configuration.downloadsFolder = pathToFile;
        File file = downloadButton.download(DownloadOptions.using(FOLDER));
        return this;
    }
    public void downloadAFile(String pathToFile, String expectedFileName){
        Configuration.downloadsFolder = pathToFile;
        Configuration.fileDownload = FOLDER;
        File file = downloadButton.download(withName(expectedFileName));
    }
    public void uploadFile(String filePath){
        uploadButton.uploadFile(new File(filePath));
    }
}
