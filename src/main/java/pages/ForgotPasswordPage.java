package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By Byemail = By.id("email");
    private By RetrievePasswordButton = By.id("form_submit");
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public PasswordConfirmationPage clickOnRetrievePasswordButton(){
        //enterEmail("tau@example.com");
        driver.findElement(RetrievePasswordButton).click();
        return new PasswordConfirmationPage(driver);
    }

    public void enterEmail(String email){
        driver.findElement(Byemail).sendKeys(email);
    }

}
