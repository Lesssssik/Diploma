package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.visible;

public class FormsPageTest extends MainTest {

    @Test
    public void testingFormInvalid(){
        homePage.open()
                .clickFormsButton()
                .clickPracticeFormsButton();

        String oldColor = formsPage.getMobileInput().getCssValue("border-color");


        formsPage.fillFirstName("kek")
                .fillLastName("kekov")
                .fillEmail("kekushka@gmail.com")
                .chooseGender("female")
                .fillMobile("7")
                .click(formsPage.getSportsCheckBox(), formsPage.getReadingCheckBox(), formsPage.getMusicCheckBox()).toFormsPage()
                .clickSubmitButton();

        Assert.assertNotEquals(formsPage.getMobileInput().getCssValue("border-color"), oldColor);
    }

    @Test
    public void testingForm(){
        String subjects = "Math";
        String currentAddress = "123 Main Street";

        homePage.open()
                .clickFormsButton()
                .clickPracticeFormsButton()
                .fillFirstName("Vladimir")
                .fillLastName("Markov")
                .fillEmail("markovV@gmail.com")
                .chooseGender("male")
                .fillMobile("7895641253")
                .setSubjects(subjects)
                .uploadPicture("src\\main\\resources\\UploadFile.txt")
                .setCurrentAddress(currentAddress)
                .clickSubmitButton();

        Assert.assertTrue(formsPage.getSubmitFormPopup().shouldBe(visible).isDisplayed());
    }

    @Test
    public void chooseDate(){
        String day = "25";
        String month = "March";
        String year = "1980";
        homePage.open()
                .clickFormsButton()
                .clickPracticeFormsButton()
                .chooseDateOfBirth(day,month,year);

        Assert.assertEquals(formsPage.getDateOfBirthInput().getValue(), formsPage.stringForValueOfCalendar(day, month, year)); //day+" "+month.substring(0,3)+" "+year);
        System.out.println(formsPage.stringForValueOfCalendar(day, month, year));
        System.out.println(formsPage.getDateOfBirthInput().getValue());
    }

    @Test
    public void chooseState() {
        String state = "NCR";
        String city = "Delhi";

        homePage.open()
                .clickFormsButton()
                .clickPracticeFormsButton()
                .chooseState(state)
                .chooseCity(city);

        Assert.assertEquals(formsPage.getStateName().getOwnText(), state);
        Assert.assertEquals(formsPage.getCityName().getOwnText(), city);
    }

}


