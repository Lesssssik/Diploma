package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectMenuPageTest extends MainTest{

    @Test
    public void testSelectValueDropdown() {

        String value = "Group 2, option 1";
        selectMenuPage.open().selectValue(value);

        Assert.assertEquals(selectMenuPage.getSelectedValue(), value);
    }

    @Test
    public void testSelectOneDropdown() {

        String value = "Mr.";
        selectMenuPage.open().selectOne(value);

        Assert.assertEquals(selectMenuPage.getSelectedOne(), value);
    }

    @Test
    public void testOldStyleSelectMenu() {

        String value = "Indigo";
        selectMenuPage.open().selectOldStyle(value);

        Assert.assertEquals(selectMenuPage.getSelectedOldStyle(), value);
    }

    @Test
    public void testStandardMultiSelect() {

        String value = "Saab";
        String value2 = "Audi";
        selectMenuPage.open().selectMultiStandard(value, value2);

        Assert.assertEquals(selectMenuPage.getSelectedMultiStandard(), value+value2);
    }

    @Test
    public void testMultiSelectDropdown() {

        String[] values = new String[]{"Red", "Blue", "Green"};
        selectMenuPage.open().selectMultipleValues(values);

        String[] selectedValues = selectMenuPage.getSelectedMultipleValues();

        Assert.assertEquals(selectedValues, values);
    }
}
