package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class AccordianPage extends MainPage{
    private final SelenideElement section1Heading = $(By.id("section1Heading"));
    private final SelenideElement section2Heading = $(By.id("section2Heading"));
    private final SelenideElement section3Heading = $(By.id("section3Heading"));
    private final SelenideElement section1Content = $("#section1Content");
    private final SelenideElement section2Content = $("#section2Content");
    private final SelenideElement section3Content = $("div[id='section3Content'] p");
    private final SelenideElement section2ContentTextPart2 = section2Content.lastChild();

    public AccordianPage open(){
        Selenide.open("https://demoqa.com/accordian");
        return this;
    }

    public void clickSectionHeader(SelenideElement header) {
        header.click();
    }

    public void verifySectionContentVisible(SelenideElement content) {
        content.shouldBe(Condition.visible);
    }

    public void verifySectionContentHidden(SelenideElement content) {
        content.shouldBe(Condition.hidden);
    }

    public void checkAccordionBehavior() {

        clickSectionHeader(section1Heading);
        verifySectionContentVisible(section1Content);
        verifySectionContentHidden(section2Content);
        verifySectionContentHidden(section3Content);

        clickSectionHeader(section2Heading);
        verifySectionContentVisible(section2Content);
        verifySectionContentHidden(section1Content);
        verifySectionContentHidden(section3Content);

        clickSectionHeader(section3Heading);
        verifySectionContentVisible(section3Content);
        verifySectionContentHidden(section1Content);
        verifySectionContentHidden(section2Content);
    }
}

