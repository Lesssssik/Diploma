package org.example;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public MainPage open(String urlOrPath){
        Selenide.open(urlOrPath);
        return this;
    }

    public MainPage click(SelenideElement... elements){
        for (SelenideElement element: elements){
            element.click();
        }
        return this;
    }

    public FormsPage toFormsPage(){
        return new FormsPage();
    }

    public MainPage hoverOver(SelenideElement ...elements){
        for (SelenideElement element: elements){
            element.hover();
        }
        return this;
    }
    public MenuPage toMenuPage(){
        return new MenuPage();
    }

}
