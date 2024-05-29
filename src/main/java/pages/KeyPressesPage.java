package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {
    private WebDriver driver;
    private By formInput = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){

        driver.findElement(formInput).sendKeys(text);
    }

    public void enterPi(){
        //this is not working. Will post it on stack overflow
        new Actions(driver).keyDown(Keys.ALT).sendKeys("227").perform();
        //enterText(Keys.chord(Keys.ALT, Keys.NUMPAD2, Keys.NUMPAD2, Keys.NUMPAD7) +"=3.14");
        //enterText(Keys.chord(Keys.ALT, "227") +"=3.14");
        //enterText("π = 3.14");
         /*
            NOTE: we didn't finish this test in the video.
            We debugged to watch it enter the pi key
         */
    }

    public String returnResult(){
        return driver.findElement(resultText).getText();
    }
}
