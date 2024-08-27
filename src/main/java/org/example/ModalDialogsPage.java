package org.example;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
@Getter
public class ModalDialogsPage extends MainPage{

    private final SelenideElement smallModalButton = $(By.id("showSmallModal"));
    private final SelenideElement largeModalButton = $(By.id("showLargeModal"));
    private final SelenideElement smallModalTitle = $(By.id("example-modal-sizes-title-sm"));
    private final SelenideElement closeSmallModalWindow = $(By.xpath("//button[@class='close']"));
    private final SelenideElement modalSmallWindowBody = $(By.xpath("//div[@class='modal-body']"));
    private final SelenideElement closeSmallModalButton = $(By.id("closeSmallModal"));
    private final SelenideElement largeModalTitle = $(By.id("example-modal-sizes-title-lg"));
    private final SelenideElement closeLargeModalWindow = $(By.xpath("//span[@aria-hidden='true']"));
    private final SelenideElement modalLargeWindowBody = $(By.xpath("//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]"));
    private final SelenideElement closeLargeModalButton = $(By.id("closeLargeModal"));

    public ModalDialogsPage open(){
        Selenide.open("https://demoqa.com/modal-dialogs");
        return this;
    }
    public ModalDialogsPage clickSmallModalButton(){
        smallModalButton.click();
        return this;
    }
    public ModalDialogsPage clickLargeModalButton(){
        largeModalButton.click();
        return this;
    }
    public ModalDialogsPage clickCloseSmallModalWindow(){
        closeSmallModalWindow.click();
        return this;
    }
    public ModalDialogsPage clickCloseSmallModalButton(){
        closeSmallModalButton.click();
        return this;
    }
    public ModalDialogsPage clickCloseLargeModalWindow(){
        closeLargeModalWindow.click();
        return this;
    }
    public ModalDialogsPage clickCloseLargeModalButton(){
        closeLargeModalButton.click();
        return this;
    }
    public void verifySmallModalIsVisible() {
        smallModalTitle.shouldBe(visible);
    }
    public void verifySmallModalIsNotVisible() {
        smallModalTitle.shouldNotBe(visible);
    }
    public void verifyLargeModalIsVisible() {
        largeModalTitle.shouldBe(visible);
    }
    public void verifyLargeModalIsNotVisible() {
        largeModalTitle.shouldNotBe(visible);
    }


}
