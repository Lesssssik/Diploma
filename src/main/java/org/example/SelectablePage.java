package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class SelectablePage extends MainPage{

    private final SelenideElement tabList = $(By.id("demo-tab-list"));
    private final SelenideElement tabGrid = $(By.id("demo-tab-grid"));
    private final ElementsCollection listItem = $$("#verticalListContainer li");
    private final ElementsCollection gridItem = $$("#gridContainer .list-group-item");

    public SelectablePage open(){
        Selenide.open("https://demoqa.com/selectable");
        return this;
    }

    public SelectablePage switchToTabList(){
        tabList.click();
        return this;
    }
    public SelectablePage switchToTabGrid(){
        tabGrid.click();
        return this;
    }

    public void selectListItem(int index) {
        listItem.get(index).click();
    }

    public boolean isListItemSelected(int index) {
        return listItem.get(index).has(cssClass("active"));
    }

    public void selectGridItem(int row, int col) {
        int index = (row) * 3 + (col);
        gridItem.get(index).click();
    }

    public boolean isGridItemSelected(int row, int col) {
        int index = (row) * 3 + (col);
        return gridItem.get(index).has(cssClass("active"));
    }
}
