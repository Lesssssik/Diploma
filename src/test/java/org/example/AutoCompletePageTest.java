package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class AutoCompletePageTest extends MainTest{

    @Test
    public void test1(){
        String option = "Red";
        autoCompletePage.open().selectOptionFromSingleInput(option);
        String actualText = autoCompletePage.getSingleValueText();

        Assert.assertEquals(option, actualText);
        System.out.println(option);
        System.out.println(actualText);
    }
    @Test
    public void test2(){
        String [] expectedOptions  = new String[]{"Red", "Blue", "Black"};
        autoCompletePage.open().selectOptionFromMultipleInput(expectedOptions);
        autoCompletePage.ClickAutocompleteClearButton();
    }
    @Test
    public void test3(){
        String [] expectedOptions  = new String[]{"Red", "Blue", "Black"};

        autoCompletePage.open().selectOptionFromMultipleInput(expectedOptions);
        String[] actualText = autoCompletePage.getMultipleValueText();

        Assert.assertEquals(expectedOptions, actualText);
        System.out.println(Arrays.toString(expectedOptions));
        System.out.println(Arrays.toString(actualText));
    }
}
