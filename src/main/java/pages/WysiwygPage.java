package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("button[title='Increase indent']");

    public WysiwygPage(WebDriver driver){
        this.driver = driver;
    }

    public void clearTextArea(){
        switchToEditorArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditorArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void decreaseIndent(){
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditorArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    private void switchToEditorArea(){
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
