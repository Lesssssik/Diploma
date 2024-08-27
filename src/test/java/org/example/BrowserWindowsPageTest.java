package org.example;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BrowserWindowsPageTest extends MainTest {


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
                getBody().shouldHave(Condition.text("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        closeWindow();
        switchTo().window(0);
    }

}
