package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Getter
public class LinksPage extends MainPage{

    private final SelenideElement simpleLink = $(By.id("simpleLink"));
    private final SelenideElement dynamicLink = $(By.id("dynamicLink"));
    private final SelenideElement createdLink = $(By.id("created"));
    private final SelenideElement noContentLink = $(By.id("no-content"));
    private final SelenideElement movedLink = $(By.id("moved"));
    private final SelenideElement badRequestLink = $(By.id("bad-request"));
    private final SelenideElement unauthorizedLink = $(By.id("unauthorized"));
    private final SelenideElement forbiddenLink = $(By.id("forbidden"));
    private final SelenideElement notFoundLink = $(By.id("invalid-url"));
    private final SelenideElement linkResponse = $(By.id("linkResponse"));
    private final SelenideElement bannerImage = $(By.xpath("//img[@src='/images/Toolsqa.jpg']"));

    public SelenideElement getLinkResponseText(){
        return linkResponse;
    }

    public LinksPage open(){
        Selenide.open("https://demoqa.com/links");
        return this;
    }

    public LinksPage clickSimpleLink(){
        simpleLink.click();
        switchTo().window(1);
        return this;
    }
    public LinksPage clickDynamicLink(){
        dynamicLink.click();
        switchTo().window(1);
        return this;
    }
    public LinksPage clickCreatedLink(){
        createdLink.click();
        return this;
    }
    public LinksPage clickNoContentLink(){
        noContentLink.click();
        return this;
    }
    public LinksPage clickMovedLink(){
        movedLink.click();
        return this;
    }
    public LinksPage clickBadRequestLink(){
        badRequestLink.click();
        return this;
    }
    public LinksPage clickUnauthorizedLink(){
        unauthorizedLink.click();
        return this;
    }
    public LinksPage clickForbiddenLink(){
        forbiddenLink.click();
        return this;
    }
    public LinksPage clickNotFoundLink(){
        notFoundLink.click();
        return this;
    }
    public void waitForBanner(){
        bannerImage.shouldBe(visible);
    }

}

