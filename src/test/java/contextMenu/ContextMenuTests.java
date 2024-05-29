package contextMenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.sendRightClick();
        String text = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickToAccept();
        assertEquals(text, "You selected a context menu", "incorrect alert message");
    }
}
