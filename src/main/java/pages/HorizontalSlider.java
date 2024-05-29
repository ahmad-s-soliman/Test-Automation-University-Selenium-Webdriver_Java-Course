package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSlider {
    private WebDriver driver;
    private By slider = By.cssSelector("div input");

    private By value = By.id("range");

    public HorizontalSlider(WebDriver driver){
        this.driver = driver;
    }

    private void moveSliderToTheRight(){
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
    }

    public String getCurrentRangeValue(){
        return driver.findElement(value).getText();
    }

    public void stopAtDesiredValue(String desiredValue){
        while(!getCurrentRangeValue().equals(desiredValue)){
            moveSliderToTheRight();
        }

    }


}
