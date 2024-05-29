package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {
    @Test
    public void testBackspace(){
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPressesPage.returnResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi(){
        var keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();
        //assertEquals(keyPressesPage.returnResult(), );
    }
}
