package org.example;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.URL_OF_SITE;

public class HomePage extends MainPage {

    private final SelenideElement formsButton = $(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']" +
            "/div[@class='home-body']/div[@class='category-cards']/div[2]/div[1]"));
    private final SelenideElement elementsButton = $(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']"));
    private final SelenideElement alertsButton = $(By.xpath("//div[normalize-space()='Alerts, Frame & Windows']"));
    private final SelenideElement widgetsButton = $(By.xpath("//h5[normalize-space()='Widgets']"));
    private final SelenideElement interactionsButton = $(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/span[1]/div[1]"));
    private final SelenideElement bookStoreApplicationButton = $(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/span[1]/div[1]"));


    public HomePage open() {
        Selenide.open(URL_OF_SITE);
        return this;
    }

    public FormsPage clickFormsButton(){
        formsButton.click();
        return new FormsPage();
    }
    public ElementsPage clickElementsButton(){
        elementsButton.click();
        return new ElementsPage();
    }
    public AlertsPage clickAlertsButton(){
        alertsButton.click();
        return new AlertsPage();
    }
}
