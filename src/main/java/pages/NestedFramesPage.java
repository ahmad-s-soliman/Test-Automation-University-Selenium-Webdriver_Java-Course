package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrameNameAttribute = "frame-top";
    private String leftFrameNameAttribute = "frame-left";
    private String bottomFrameNameAttribute = "frame-bottom";
    private By bodyTag = By.tagName("body");
    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    /*
    private void switchToTopFrame(){
        driver.switchTo().frame(topFrameNameAttribute);
    }
    private void switchToLeftFrame(){
        driver.switchTo().frame(leftFrameNameAttribute);
    }

    private String returnText(){
        return driver.findElement(bodyTag).getText();
    }


     */
    public String getLeftFrameText(){
        driver.switchTo().frame(topFrameNameAttribute);
        driver.switchTo().frame(leftFrameNameAttribute);
        String text = driver.findElement(bodyTag).getText();
        driver.switchTo().parentFrame(); //go to top frame
        driver.switchTo().parentFrame(); //go to main dom
        return text;
    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrameNameAttribute);
        String text = driver.findElement(bodyTag).getText();
        driver.switchTo().parentFrame();
        return text;
    }

}
