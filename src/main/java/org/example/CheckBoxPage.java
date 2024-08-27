package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class CheckBoxPage extends MainPage {

    ArrayList <String> listOfCheckBoxes = new ArrayList<String>();

    public CheckBoxPage(){
        listOfCheckBoxes.add("You have selected :");
    }

    private final SelenideElement collapseAllButton = $(By.cssSelector("button[title='Collapse all']"));
    private final SelenideElement expandAllButton = $(By.cssSelector("button[title='Expand all']"));
    private final SelenideElement downloadArrowButton = $(By.xpath("//li[3]//span[1]//button[1]"));
    private final SelenideElement documentsArrowButton = $(By.xpath("//li[2]//span[1]//button[1]"));
    private final SelenideElement desktopArrowButton = $(By.xpath("//li[1]//span[1]//button[1]"));
    private final SelenideElement homeArrowButton = $(By.xpath("(//button[@title='Toggle'])[1]"));
    private final SelenideElement workspaceArrowButton = $(By.xpath("//li[2]//li[1]//span//button"));
    private final SelenideElement officeArrowButton = $(By.xpath("//li[2]//li[2]//span//button"));
    private final SelenideElement excelFileCheckbox = $("label[for='tree-node-excelFile'] span[class='rct-checkbox']");
    private final SelenideElement resultText = $(By.id("result"));
    private final SelenideElement wordFileCheckbox = $("label[for='tree-node-wordFile'] span[class='rct-checkbox']");
    private final SelenideElement downloadCheckbox = $("label[for='tree-node-downloads'] span[class='rct-checkbox']");
    private final SelenideElement generalCheckbox = $("label[for='tree-node-general'] span[class='rct-checkbox']");
    private final SelenideElement classifiedCheckbox = $("label[for='tree-node-classified'] span[class='rct-checkbox']");
    private final SelenideElement privateCheckbox = $("label[for='tree-node-private'] span[class='rct-checkbox']");
    private final SelenideElement publicCheckbox = $("label[for='tree-node-public'] span[class='rct-checkbox']");
    private final SelenideElement officeCheckbox = $("label[for='tree-node-office'] span[class='rct-checkbox']");
    private final SelenideElement veuCheckbox = $("label[for='tree-node-veu'] span[class='rct-checkbox']");
    private final SelenideElement angularCheckbox = $("label[for='tree-node-angular'] span[class='rct-checkbox']");
    private final SelenideElement reactCheckbox = $("label[for='tree-node-react'] span[class='rct-checkbox']");
    private final SelenideElement workSpaceCheckbox = $("label[for='tree-node-workspace'] span[class='rct-checkbox']");
    private final SelenideElement documentsCheckbox = $("label[for='tree-node-documents'] span[class='rct-checkbox']");
    private final SelenideElement commandsCheckbox = $("label[for='tree-node-commands'] span[class='rct-checkbox']");
    private final SelenideElement notesCheckbox = $("label[for='tree-node-notes'] span[class='rct-checkbox']");
    private final SelenideElement desktopCheckbox = $("label[for='tree-node-desktop'] span[class='rct-checkbox']");
    private final SelenideElement homeCheckbox = $("label[for='tree-node-home'] span[class='rct-checkbox']");

    private boolean everythingIsChecked(){
        return (desktopCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")&&
                documentsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")&&
                downloadCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"));
    }

    private void smartClick(SelenideElement child, SelenideElement parent, String parentName){

        SelenideElement arrowButton;
        if (parentName.equalsIgnoreCase("downloadCheckbox")){
            arrowButton = downloadArrowButton;
        } else if (parentName.equalsIgnoreCase("documentsCheckbox")) {
            arrowButton = documentsArrowButton;
        } else if (parentName.equalsIgnoreCase("desktopCheckbox")) {
            arrowButton = desktopArrowButton;
        }else{
            arrowButton = expandAllButton;
        }

        if (child.exists()){
            child.click();
        }else{
            if (!parent.exists()){
                homeArrowButton.click();
                if (child.exists()) {
                    child.click();
                }else{
                    arrowButton.click();
                    child.click();
                }
            }
        }

    }

    private boolean homeIsChecked(){
        return homeCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check");

    }

    private boolean documentsIsChecked(){
        return documentsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check");
    }

    private void homeManagement(boolean homeIsChecked){
        if (homeIsChecked){
            listOfCheckBoxes.remove("home");
        }else if (homeIsChecked()){ //everythingIsChecked())
            listOfCheckBoxes.add("home");
        }
    }
    public CheckBoxPage clickHomeArrow(){
        homeArrowButton.click();
        return this;
    }
    public CheckBoxPage clickDocumentsArrow(){
        documentsArrowButton.click();
        return this;
    }
    public CheckBoxPage clickDownloadArrow(){
        downloadArrowButton.click();
        return this;
    }
    public CheckBoxPage open(){
        open("https://demoqa.com/checkbox");
        return this;
    }
    public CheckBoxPage desktopArrowClick(){
        desktopArrowButton.click();
        return this;
    }
    public CheckBoxPage workspaceArrowClick(){
        workspaceArrowButton.click();
        return this;
    }
    public CheckBoxPage officeArrowClick(){
        officeArrowButton.click();
        return this;
    }
    public CheckBoxPage clickExpandAllButton(){
        expandAllButton.click();
        return this;
    }

    public CheckBoxPage clickExcelFileCheckbox() {

        boolean homeIsChecked = homeIsChecked();

        smartClick(excelFileCheckbox, downloadCheckbox, "downloadCheckbox");

        if (excelFileCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("excelFile");
        }else{
            listOfCheckBoxes.remove("excelFile");
        }
        if (downloadCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("downloads");
        }else if (!(downloadCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"))
                && wordFileCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.remove("downloads");
        }
        homeManagement(homeIsChecked);
        return this;
    }

    public CheckBoxPage clickWordFileCheckbox() {

        boolean homeIsChecked = homeIsChecked();

        smartClick(wordFileCheckbox, downloadCheckbox, "downloadCheckbox");

        if (wordFileCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("wordFile");
        }else{
            listOfCheckBoxes.remove("wordFile");
        }

        if (downloadCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("downloads");
        }else if (!(downloadCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"))
                && excelFileCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.remove("downloads");
        }
        homeManagement(homeIsChecked);
        return this;
    }

    public CheckBoxPage clickNotesCheckbox() {

        boolean homeIsChecked = homeIsChecked();

        smartClick(notesCheckbox, desktopCheckbox, "desktopCheckbox");

        if (notesCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("notes");
        }else{
            listOfCheckBoxes.remove("notes");
        }

        if (desktopCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("desktop");
        }else if (!(desktopCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"))
                && commandsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.remove("desktop");
        }
        homeManagement(homeIsChecked);
        return this;
    }

    public CheckBoxPage clickCommandsCheckbox() {

        boolean homeIsChecked = homeIsChecked();

        smartClick(commandsCheckbox, desktopCheckbox, "desktopCheckbox");

        if (commandsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("commands");
        }else{
            listOfCheckBoxes.remove("commands");
        }

        if (desktopCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("desktop");
        }else if (!(desktopCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"))
                && notesCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.remove("desktop");
        }
        homeManagement(homeIsChecked);
        return this;
    }

    public CheckBoxPage clickWorkSpaceCheckbox() {

        boolean homeIsChecked = homeIsChecked();

        smartClick(workSpaceCheckbox, documentsCheckbox, "documentsCheckbox");

        if (workSpaceCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("workspace");
            listOfCheckBoxes.add("react");
            listOfCheckBoxes.add("angular");
            listOfCheckBoxes.add("veu");
        }else{
            listOfCheckBoxes.remove("workspace");
            listOfCheckBoxes.remove("react");
            listOfCheckBoxes.remove("angular");
            listOfCheckBoxes.remove("veu");
        }
        if (documentsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("documents");
        }else if (!(documentsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"))
                && officeCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.remove("documents");
        }
        homeManagement(homeIsChecked);
        return this;
    }

    public CheckBoxPage clickOfficeCheckbox() {

        boolean homeIsChecked = homeIsChecked();

        smartClick(officeCheckbox, documentsCheckbox, "documentsCheckbox");

        if (officeCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("office");
            listOfCheckBoxes.add("private");
            listOfCheckBoxes.add("classified");
            listOfCheckBoxes.add("general");
        }else{
            listOfCheckBoxes.remove("office");
            listOfCheckBoxes.remove("private");
            listOfCheckBoxes.remove("classified");
            listOfCheckBoxes.remove("general");
        }
        if (documentsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.add("documents");
        }else if (!(documentsCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check"))
                && workSpaceCheckbox.lastChild().getAttribute("class").equals("rct-icon rct-icon-check")){
            listOfCheckBoxes.remove("documents");
        }
        homeManagement(homeIsChecked);
        return this;
    }

    public String [] getSortedTextArray(){
        String [] array = getResultText().getText().split("\n");
        Arrays.sort(array);
        return array;
    }
}