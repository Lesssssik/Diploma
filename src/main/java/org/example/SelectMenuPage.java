package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class SelectMenuPage extends MainPage{

    private final SelenideElement selectValueDropdown = $(By.xpath("(//div[@class=' css-1hwfws3'])[1]"));
    private final SelenideElement selectOneDropdown = $(By.xpath("(//div[@class=' css-1hwfws3'])[2]"));
    private final SelenideElement oldSelectMenu = $(By.id("oldSelectMenu"));
    private final SelenideElement multiselectContainer = $(By.xpath("(//div[@class=' css-1hwfws3'])[3]"));
    private final SelenideElement multiSelectDropdown = $(By.xpath("(//div[contains(@class,'css-1hwfws3')])[3]"));
    private final SelenideElement dropdownListMultiselect = $(By.xpath("(//div[@class=' css-26l3qy-menu'])[1]"));
    private final SelenideElement selectedValueInMultiselectContainer = $(By.xpath("(//div[contains(@class,'css-1rhbuit-multiValue')])[1]"));
    private final SelenideElement removeButtonSelectedValueInMultiselectContainer = $(By.xpath("(//div[contains(@class,'css-xb97g8')])[1]"));
    private final SelenideElement clearButtonMultiselectContainer = $(By.xpath("(//*[name()='svg'][contains(@class,'css-19bqh2r')])[5]"));
    private final SelenideElement multipleList = $(By.id("cars"));
    private final ElementsCollection option = $$(".css-yt9ioa-option");
    private final ElementsCollection listMultiselectOption = $$(".css-11unzgr div");
    private final ElementsCollection multiValue = $$(".css-12jo7m5");

    public SelectMenuPage open(){
        Selenide.open("https://demoqa.com/select-menu");
        return this;
    }

    public void selectValue(String value) {
        selectValueDropdown.click();
        option.findBy(text(value)).click();
    }

    public void selectOne(String value) {
        selectOneDropdown.click();
        option.findBy(text(value)).click();
    }

    public void selectOldStyle(String value) {
        oldSelectMenu.selectOptionContainingText(value);
    }

    public String getSelectedValue() {
        return selectValueDropdown.getText();
    }

    public String getSelectedOne() {
        return selectOneDropdown.getText();
    }

    public String getSelectedOldStyle() {
        return oldSelectMenu.getSelectedOptionText();
    }

    public void selectMultiStandard(String value, String value2) {
        actions().keyDown(Keys.CONTROL);
        multipleList.selectOptionContainingText(value, value2);
        actions().keyUp(Keys.CONTROL).perform();
    }
    public String getSelectedMultiStandard(){
        return multipleList.getSelectedOptionText();
    }

    public void selectMultipleValues(String[] values) {

        multiSelectDropdown.click();
        for (String value : values) {
            listMultiselectOption.findBy(text(value)).shouldBe(visible).click();
        }
    }

    public String[] getSelectedMultipleValues() {
        return multiValue.texts().toArray(new String[0]);
    }






}
