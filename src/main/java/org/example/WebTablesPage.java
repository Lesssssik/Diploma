package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class WebTablesPage extends MainPage{

    private final SelenideElement addButton = $(By.id("addNewRecordButton"));
    private final SelenideElement searchBox = $(By.id("searchBox"));
    private final SelenideElement searchButton = $(By.xpath("//div[@class='input-group-append']"));
    private final SelenideElement inputPageJump = $("div.-pageJump input");
    private final SelenideElement selectRowsPerPage = $(By.xpath("//select[@aria-label='rows per page']"));
    private final SelenideElement buttonPrevious = $(By.xpath("//button[normalize-space()='Previous']"));
    private final SelenideElement buttonNext = $(By.xpath("//button[normalize-space()='Next']"));
    private final SelenideElement registrationFormPopup = $(By.xpath("//div[@class='modal-content']"));
    private final SelenideElement inputFirstName = $(By.id("firstName"));
    private final SelenideElement inputLastName = $(By.id("lastName"));
    private final SelenideElement inputEmail = $(By.id("userEmail"));
    private final SelenideElement inputAge = $(By.id("age"));
    private final SelenideElement inputSalary = $(By.id("salary"));
    private final SelenideElement inputDepartment = $(By.id("department"));
    private final SelenideElement buttonSubmit = $(By.id("submit"));
    private final SelenideElement buttonClosePopup = $(By.xpath("//span[@aria-hidden='true']"));
    private final ElementsCollection tableRows = $$("div.rt-tbody div[role='row']");

    public WebTablesPage open(){
        Selenide.open("https://demoqa.com/webtables");
        return this;
    }
    public SelenideElement deleteButton(int rowNumber) {
        return $("#delete-record-" + rowNumber);
    }
    public SelenideElement editButton(int rowNumber) {
        return $$("#edit-record-" + rowNumber).first();
    }

    public WebTablesPage buttonClosePopupClick(){
        buttonClosePopup.click();
        return this;
    }

    public WebTablesPage inputPageJumpClick(String page){
        inputPageJump.click();
        inputPageJump.sendKeys(Keys.DELETE);
        inputPageJump.setValue(page).pressEnter();
        return this;
    }

    public WebTablesPage chooseRows(String rows){
        selectRowsPerPage.click();
        selectRowsPerPage.selectOptionContainingText(rows);
        return this;
    }
    public WebTablesPage buttonPreviousClick(){
        buttonPrevious.click();
        return this;
    }

    public WebTablesPage buttonNextClick(){
        buttonNext.click();
        return this;
    }

    public WebTablesPage addNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        addButton.click();
        inputFirstName.type(firstName);
        inputLastName.type(lastName);
        inputEmail.type(email);
        inputAge.type(age);
        inputSalary.type(salary);
        inputDepartment.type(department);
        buttonSubmit.click();
        return this;
    }

    public WebTablesPage editRecord(int rowNumber, String firstName, String lastName) {
        editButton(rowNumber).click();
        inputFirstName.type(firstName);
        inputLastName.type(lastName);
        buttonSubmit.click();
        return this;
    }

    public WebTablesPage search(String keyword) {
        searchBox.type(keyword);
        return this;
    }

    public WebTablesPage deleteRecord(int rowNumber) {
        deleteButton(rowNumber).click();
        return this;
    }

    public boolean isRecordPresent(String searchText) {
        return tableRows.find(text(searchText)).exists();
    }





}
