package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class BrokenLinksPage extends MainPage{

    private final SelenideElement validImage = $(By.xpath("(//img)[3]"));
    private final SelenideElement brokenImage = $("img[src='/images/Toolsqa_1.jpg']");
    private final SelenideElement validLink = $(By.xpath("//a[normalize-space()='Click Here for Valid Link']"));
    private final SelenideElement brokenLink = $(By.xpath("//a[normalize-space()='Click Here for Broken Link']"));

    public BrokenLinksPage open(){
        Selenide.open("https://demoqa.com/broken");
        return this;
    }

    public boolean isImageLoaded(SelenideElement image) {
        return image.getAttribute("naturalWidth") != null && !image.getAttribute("naturalWidth").equals("0");
    }

    public boolean isImageBroken(SelenideElement image) {
        return image.getAttribute("naturalWidth") != null && image.getAttribute("naturalWidth").equals("0");
    }


    public boolean isLinkWorking(SelenideElement link) {
        String href = link.getAttribute("href");
        try {
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL(href).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            return responseCode >= 200 && responseCode < 400;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLinkBroken(SelenideElement link) {
        String href = link.getAttribute("href");
        try {
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL(href).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            return responseCode >= 400;
        } catch (Exception e) {
            return true;
        }
    }

}
