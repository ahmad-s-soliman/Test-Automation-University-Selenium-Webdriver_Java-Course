package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordConfirmationPage {
    private WebDriver driver;
    private By pageHeader = By.tagName("h1");

    public PasswordConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

}
