package org.example;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;


public class ModalDialogsPageTest extends MainTest{

    @Test
    public void test1(){
        modalDialogsPage.open().
                clickSmallModalButton().verifySmallModalIsVisible();
        modalDialogsPage.clickCloseSmallModalButton().verifySmallModalIsNotVisible();
        modalDialogsPage.clickLargeModalButton().verifyLargeModalIsVisible();
        modalDialogsPage.clickCloseLargeModalButton().verifyLargeModalIsNotVisible();
    }

    @Test
    public void test2(){
        modalDialogsPage.open().
                clickSmallModalButton().verifySmallModalIsVisible();
        modalDialogsPage.clickCloseSmallModalWindow().verifySmallModalIsNotVisible();
        modalDialogsPage.clickLargeModalButton().verifyLargeModalIsVisible();
        modalDialogsPage.clickCloseLargeModalWindow().verifyLargeModalIsNotVisible();
    }

    @Test
    public void test3(){
        modalDialogsPage.open().
                clickSmallModalButton().getModalSmallWindowBody().shouldHave(Condition.text("This is a small modal. It has very less content"));
        modalDialogsPage.clickCloseSmallModalButton().verifySmallModalIsNotVisible();
        modalDialogsPage.clickLargeModalButton().getModalLargeWindowBody().shouldHave(Condition.text("Lorem Ipsum is simply dummy text of the printing"));
        modalDialogsPage.clickCloseLargeModalButton().verifyLargeModalIsNotVisible();
    }
}
