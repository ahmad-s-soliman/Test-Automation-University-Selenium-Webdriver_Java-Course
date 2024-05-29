package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By byExample2 = By.linkText("Example 2: Element rendered after the fact");
    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public Example1Page clickExample1(){
        clickLink("Example 1: Element on page that is hidden");
        return new Example1Page(driver);
    }

    public Example2Page clickExample2(){
        clickLink("Example 2: Element rendered after the fact");
        return new Example2Page(driver);
    }

    public Example2Page clickExample2NewTab(){
        Actions actions = new Actions(driver);
        WebElement elementExample2 = driver.findElement(byExample2);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(elementExample2)
                .perform();
        return new Example2Page(driver);
    }
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

}
