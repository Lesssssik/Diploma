package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class WebTablesPageTest extends MainTest {

    @BeforeSuite
    public void config() {
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
    }
    

    @Test
    public void testAddNewRecord() {
        webTablesPage.open().addNewRecord("Ivan", "Ivanov", "ivanov@mail.ru", "22", "30000", "Police");
        Assert.assertTrue(webTablesPage.getRegistrationFormPopup().isDisplayed());
        Assert.assertTrue(webTablesPage.isRecordPresent("Ivan"));
    }

    @Test
    public void testSearchRecord() {
        webTablesPage.open().search("Cierra");
        Assert.assertTrue(webTablesPage.isRecordPresent("Cierra"));
    }

    @Test
    public void testEditRecord() {
        webTablesPage.open().editRecord(2, "UpdatedName", "UpdatedLastName");
        Assert.assertTrue(webTablesPage.isRecordPresent("UpdatedName"));
    }

    @Test
    public void testDeleteRecord() {
        webTablesPage.open().deleteRecord(2);
        Assert.assertFalse(webTablesPage.isRecordPresent("Alden"));
    }

    @Test
    public void testScrollThePage(){
        String rows = "5 rows";
        String page = "1";

        webTablesPage.open()
                .chooseRows(rows)
                .addNewRecord("Vasya", "Katin", "vasya@mail.ru", "25", "31000", "Police")
                .addNewRecord("Maria", "Kekovna", "mashakek@mail.ru", "20", "40000", "Engineer")
                .buttonNextClick()
                .addNewRecord("Olga", "Tsareva", "tsarevao@mail.ru", "25", "90000", "Director")
                .addNewRecord("John", "Miller", "jmiller@gmail.com", "30", "100000", "IT").inputPageJumpClick(page);
    }

}
