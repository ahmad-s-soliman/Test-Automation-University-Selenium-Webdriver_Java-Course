package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NestedFramesTests extends BaseTests {
    @Test
    public void testNestedFrames(){
        var framesPage = homePage.clickFramesButton();
        var nestedFramesPage = framesPage.clickNestedFramesButton();
        assertTrue(nestedFramesPage.getLeftFrameText().contains("LEFT"), "wrong frame"); //note: test is case sensitive
        assertTrue(nestedFramesPage.getBottomFrameText().contains("BOTTOM"), "wrong frame"); //test is case sensitive
    }
}
