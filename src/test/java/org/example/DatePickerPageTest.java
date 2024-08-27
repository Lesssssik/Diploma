package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePickerPageTest extends MainTest{

    @Test
    public void test1() {
        String day = "15";
        String month = "April";
        String year = "2024";
        datePickerPage.open().openDatePicker();
        datePickerPage.selectDate(day, month, year);

        String expectedDate = "04/15/2024";

        Assert.assertEquals(datePickerPage.getSelectedDate(), expectedDate);
    }

    @Test
    public void test2() {
        String day = "15";
        String month = "April";
        String year = "2024";
        String time = "23:15";
        datePickerPage.open().openDateTimePicker();
        datePickerPage.selectDateTime(day, month, year, time);

        String expectedDateTime = "April 15, 2024 11:15 PM";

        Assert.assertEquals(datePickerPage.getSelectedDateTime(), expectedDateTime);
    }
}