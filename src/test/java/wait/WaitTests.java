package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testWait(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var example1Page = dynamicLoadingPage.clickExample1();
        example1Page.clickStartButton();
        assertEquals(example1Page.getFinalText(), "Hello World!", "text doesn't match");
    }

    @Test
    public void testExample2Page(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var example2Page = dynamicLoadingPage.clickExample2();
        example2Page.clickStartButton();
        assertEquals(example2Page.getText(), "Hello World!", "text doesn't match");
    }

}
