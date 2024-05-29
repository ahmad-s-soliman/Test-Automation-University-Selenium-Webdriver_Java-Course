package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example2Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("div>button");
    private By loadedText = By.id("finish");

    public Example2Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));
    }

    public String getText(){
        return driver.findElement(loadedText).getText();
    }

    public WebElement returnStartButtonElement(){
        return driver.findElement(startButton);
    }
}

