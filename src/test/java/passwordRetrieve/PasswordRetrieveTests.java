package passwordRetrieve;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.PasswordConfirmationPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PasswordRetrieveTests extends BaseTests {


    @Test
    public void retrievePassword(){
       ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
       forgotPasswordPage.enterEmail("tau@example.com");
       PasswordConfirmationPage passwordConfirmationPage = forgotPasswordPage.clickOnRetrievePasswordButton();
       //assertEquals(passwordConfirmationPage.getPageHeader(), "Internal Server Error", "failed");
        assertTrue(passwordConfirmationPage.getPageHeader().contains("Internal Server Error"), "failed");
    }
}
