package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class DatePickerPage extends MainPage{

    private final SelenideElement datePickerInput = $(By.id("datePickerMonthYearInput"));
    private final SelenideElement dateTimePickerInput = $(By.id("dateAndTimePickerInput"));
    private final SelenideElement previousMonthButtonSelectDate = $(By.xpath("//button[normalize-space()='Previous Month']"));
    private final SelenideElement nextMonthButtonSelectDate = $(By.xpath("//button[normalize-space()='Next Month']"));
    private final SelenideElement monthSelectSelectDate = $(By.xpath("//select[@class='react-datepicker__month-select']"));
    private final SelenideElement yearsSelectSelectDate = $(By.xpath("//select[@class='react-datepicker__year-select']"));
    private final SelenideElement previousMonthButtonDateAndTime = $(By.xpath("//button[normalize-space()='Previous Month']"));
    private final SelenideElement nextMonthButtonDateAndTime = $(By.id("//button[normalize-space()='Next Month']"));
    private final SelenideElement monthDropdownContainer = $(".react-datepicker__month-dropdown-container");
    private final SelenideElement yearDropdownContainer = $(".react-datepicker__year-dropdown-container");
    private final SelenideElement navigationYearsUpButton = $(By.xpath("//a[contains(@class,'react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-upcoming')]"));
    private final SelenideElement navigationYearsPreviousButton = $(By.xpath("//a[contains(@class,'react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-previous')]"));
    private final SelenideElement yearOptionSelected = $(By.xpath("//span[@class='react-datepicker__year-option--selected']"));
    private final SelenideElement monthOptionSelected = $(By.xpath("//span[@class='react-datepicker__month-option--selected']"));
    private final SelenideElement timeList = $(By.xpath("//ul[@class='react-datepicker__time-list']"));

    private final ElementsCollection optionsDayFromSelectDate = $$(".react-datepicker__day");
    private final ElementsCollection optionsYear = $$(".react-datepicker__year-dropdown .react-datepicker__year-option");
    private final ElementsCollection optionsMonth = $$(".react-datepicker__month-dropdown .react-datepicker__month-option");
    private final ElementsCollection optionsDay = $$(".react-datepicker__day");
    private final ElementsCollection optionsTime = $$(".react-datepicker__time-list-item");


    public DatePickerPage open(){
        Selenide.open("https://demoqa.com/date-picker");
        return this;
    }

    public DatePickerPage openDatePicker() {
        datePickerInput.click();
        return this;
    }
    public DatePickerPage openDateTimePicker(){
        dateTimePickerInput.click();
        return this;
    }

    public void selectDate(String day, String month, String year) {
        yearsSelectSelectDate.selectOptionByValue(year);
        monthSelectSelectDate.selectOptionContainingText(month);
        optionsDayFromSelectDate.findBy(text(day)).click();
    }

    public String getSelectedDate() {
        return datePickerInput.getValue();
    }

    public void selectDateTime(String day, String month, String year, String time) {

        yearDropdownContainer.click();
        optionsYear.findBy(text(year)).click();

        monthDropdownContainer.click();
        optionsMonth.findBy(text(month)).click();

        optionsDay.findBy(text(day)).click();

        timeList.shouldBe(visible);
        optionsTime.findBy(text(time)).shouldBe(visible).click();
    }

    public String getSelectedDateTime() {
        return dateTimePickerInput.getValue();
    }
}
