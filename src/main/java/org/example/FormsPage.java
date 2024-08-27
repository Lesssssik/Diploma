package org.example;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import lombok.Getter;
import org.openqa.selenium.By;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class FormsPage extends MainPage {

    private final SelenideElement practiceFormButton = $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
    private final SelenideElement firstNameInput = $(By.xpath("//input[@id='firstName']"));
    private final SelenideElement lastNameInput = $(By.xpath("//input[@id='lastName']"));
    private final SelenideElement submitButton = $(By.xpath("//button[@id='submit']"));
    private final SelenideElement mobileInput = $(By.xpath("//input[@id='userNumber']"));
    private final SelenideElement maleGenderButton = $(By.xpath("//label[normalize-space()='Male']"));
    private final SelenideElement femaleGenderButton = $(By.xpath("//label[normalize-space()='Female']"));
    private final SelenideElement otherGenderButton = $(By.xpath("//label[normalize-space()='Other']"));
    private final SelenideElement emailInput = $(By.xpath("//input[@id='userEmail']"));
    private final SelenideElement sportsCheckBox = $(By.xpath("//label[normalize-space()='Sports']"));
    private final SelenideElement readingCheckBox = $(By.xpath("//label[normalize-space()='Reading']"));
    private final SelenideElement musicCheckBox = $(By.xpath("//label[normalize-space()='Music']"));
    private final SelenideElement yearSelect = $(By.xpath("//select[@class='react-datepicker__year-select']"));
    private final SelenideElement monthSelect = $(By.xpath("//select[@class='react-datepicker__month-select']"));
    private final SelenideElement stateName = $(By.cssSelector(".css-1uccc91-singleValue"));
    private final SelenideElement stateList = $(By.cssSelector(".css-11unzgr"));
    private final SelenideElement stateListArrow = $(By.xpath("(//*[name()='svg'][@class='css-19bqh2r'])[1]"));
    private final SelenideElement cityListArrow = $(By.xpath("(//*[name()='svg'][@class='css-19bqh2r'])[2]"));
    private final SelenideElement cityName = $(By.cssSelector("div[id='city'] div[class=' css-1uccc91-singleValue']"));
    private final SelenideElement dateOfBirthInput = $(By.id("dateOfBirthInput"));
    private final SelenideElement submitFormPopup = $(By.xpath("//div[@class='modal-content']"));
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement uploadPictureText = $("input#uploadPicture");

    public FormsPage chooseState(String state){
        stateListArrow.click();
        stateList.$(new ByText(state)).click();
        return this;
    }

    public FormsPage chooseCity(String city){
        cityListArrow.click();
        stateList.$(new ByText(city)).click();
        return this;
    }

    public FormsPage chooseDateOfBirth(String day, String month, String year){
        dateOfBirthInput.click();
        yearSelect.click();
        yearSelect.selectOptionContainingText(year);
        monthSelect.click();
        monthSelect.selectOptionContainingText(month);
        $(By.cssSelector("div[aria-label*='"+month+" "+day+"']")).click();
        return this;
    }

    public String stringForValueOfCalendar(String day, String month, String year){
        return day+" "+month.substring(0,3)+" "+year;
    }

    public FormsPage clickPracticeFormsButton(){
        practiceFormButton.click();
        return this;
    }

    public FormsPage fillFirstName (String firstName){
        firstNameInput.type(firstName);
        return this;
    }
    public FormsPage fillLastName (String lastName){
        lastNameInput.type(lastName);
        return this;
    }

    public FormsPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public FormsPage fillMobile(String phoneNumber){
        mobileInput.type(phoneNumber);
        return this;
    }

    public FormsPage chooseGender(String gender){
        if (gender.equalsIgnoreCase("female")) {
            femaleGenderButton.click();
        } else if (gender.equalsIgnoreCase("male")) {
            maleGenderButton.click();
        }else {
            otherGenderButton.click();
        }
        return this;
    }

    public FormsPage fillEmail(String email){
        emailInput.type(email);
        return this;
    }

    public FormsPage uploadPicture(String filePath) {
        uploadPictureButton.uploadFile(new File(filePath));
        return this;
    }
    public FormsPage setSubjects(String subjects) {
        subjectInput.type(subjects).pressEnter();
        return this;
    }
    public FormsPage setCurrentAddress(String address) {
        currentAddressInput.type(address);
        return this;
    }
}
