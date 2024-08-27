package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectablePageTest extends MainTest{

    @Test
    public void testSelectListItem() {
        selectablePage.open().selectListItem(1);

        Assert.assertTrue(selectablePage.isListItemSelected(1));
    }

    @Test
    public void testSelectGridItem() {
        selectablePage.open().switchToTabGrid().selectGridItem(2,1);

        Assert.assertTrue(selectablePage.isGridItemSelected(2, 1));
    }
}
