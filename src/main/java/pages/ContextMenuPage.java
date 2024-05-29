package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By targetBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public void sendRightClick(){
        WebElement box = driver.findElement(targetBox);
        Actions actions = new Actions(driver);
        actions.moveToElement(box).contextClick().perform();

    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
}
