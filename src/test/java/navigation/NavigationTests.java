package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoadingPage().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTabByTitle("New Window");
    }

    //optional exercise
    @Test
    public void testClickAndSwitch(){
        var dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        var example2Page = dynamicLoadingPage.clickExample2NewTab();
        getWindowManager().switchToTabByWindowHandle();
        assertTrue(example2Page.returnStartButtonElement().isDisplayed(), "start button not displayed");
    }
}
