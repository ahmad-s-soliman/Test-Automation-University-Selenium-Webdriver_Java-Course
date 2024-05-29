package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example1Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("div>button");
    private By loadingIcon = By.id("loading");
    private By finalText = By.id("finish");
    public Example1Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();

        //////////////////////////////////////////////////////////////
        //for example of implicit wait, check base test file, in the setup method
        /////////////////////////////////////////////////////////////

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIcon))); //explicit wait for loading
        // icon to disappear for a maximum of 5 seconds.

        //Below is a fluent wait
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIcon)));
    }

    public String getFinalText(){
        return driver.findElement(finalText).getText();
    }

}
