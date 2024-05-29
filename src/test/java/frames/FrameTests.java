package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {
    @Test
    public void testWysisyg(){
        var editorPage = homePage.clickWysiwyg();
        editorPage.clearTextArea();
        editorPage.setTextArea("hello world");
        editorPage.decreaseIndent();
        assertEquals(editorPage.getTextFromEditor(), "hello world", "text is incorrect");
    }
}
