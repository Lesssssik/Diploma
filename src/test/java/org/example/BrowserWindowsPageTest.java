package org.example;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;

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
        browserWindowsPage.closeTheCurrentWindow();
    }
}
