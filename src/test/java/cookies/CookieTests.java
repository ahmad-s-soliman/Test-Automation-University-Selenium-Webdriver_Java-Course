package cookies;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CookieTests extends BaseTests {
    @Test
    public void testDeleteCookie(){
        var cookieManager = getCookieManager();
        Cookie cookieToDelete = cookieManager.buildCookie("optimizelyBuckets", "%7B%TD");
        cookieManager.deleteCookie(cookieToDelete);
        assertFalse(cookieManager.isCookiePresent(cookieToDelete), "cooke is still present");
    }
}
