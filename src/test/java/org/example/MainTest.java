package org.example;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MainTest {

    MainPage mainPage = new MainPage();
    HomePage homePage = new HomePage();
    FormsPage formsPage = new FormsPage();
    ElementsPage elementsPage = new ElementsPage();
    AccordianPage accordianPage = new AccordianPage();
    DroppablePage droppablePage = new DroppablePage();
    FramesPage framesPage = new FramesPage();
    NestedFramesPage nestedFramesPage = new NestedFramesPage();
    ModalDialogsPage modalDialogsPage = new ModalDialogsPage();
    AutoCompletePage autoCompletePage = new AutoCompletePage();
    AlertsPage alertsPage = new AlertsPage();
    BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
    ButtonsPage buttonsPage = new ButtonsPage();
    BrokenLinksPage brokenLinksPage = new BrokenLinksPage();
    DatePickerPage datePickerPage = new DatePickerPage();
    DragabblePage dragabblePage = new DragabblePage();
    LinksPage linksPage = new LinksPage();
    MenuPage menuPage = new MenuPage();
    ResizablePage resizablePage = new ResizablePage();
    SelectablePage selectablePage = new SelectablePage();
    SelectMenuPage selectMenuPage = new SelectMenuPage();
    SortablePage sortablePage = new SortablePage();
    TextBoxPage textBoxPage = new TextBoxPage();
    SliderPage sliderPage = new SliderPage();
    ToolTipsPage toolTipsPage = new ToolTipsPage();
    ProgressBarPage progressBarPage = new ProgressBarPage();
    RadioButtonPage radioButtonPage = new RadioButtonPage();
    TabsPage tabsPage = new TabsPage();
    DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();
    UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage();
    WebTablesPage webTablesPage = new WebTablesPage();

    @BeforeSuite
    @Parameters({"pageLoadTimeout", "browserSize"})
    public void config(@Optional("80000")long pageLoadTimeout, @Optional("1920x1080") String browserSize){
        Configuration.pageLoadTimeout = pageLoadTimeout;
        Configuration.browserSize = browserSize;
    }
}
