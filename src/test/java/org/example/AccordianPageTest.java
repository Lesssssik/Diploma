package org.example;
import org.testng.annotations.Test;

public class AccordianPageTest extends MainTest{

    @Test
    public void testAccordion() {
        accordianPage.open().checkAccordionBehavior();
    }
}
