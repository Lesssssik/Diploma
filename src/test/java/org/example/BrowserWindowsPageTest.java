package org.example;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BrowserWindowsPageTest extends MainTest {

    @BeforeSuite
    public void config() {
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
    }

    @Test
    public void test1() {

        browserWindowsPage.open().
                clickNewTabButton().
                getH1().shouldHave(text("This is a sample page"));

        browserWindowsPage.closeTheCurrentWindow().
                switchToMainWindow().
                clickNewWindowButton().
                getH1().shouldHave(text("This is a sample page"));
    }

    @Test
    public void test2() {
        browserWindowsPage.open().
                clickNewWindowMessageButton().
                getBody().shouldBe(visible);
        browserWindowsPage.getBody().shouldHave(Condition.text("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        closeWindow();
        switchTo().window(0);
    }


}
