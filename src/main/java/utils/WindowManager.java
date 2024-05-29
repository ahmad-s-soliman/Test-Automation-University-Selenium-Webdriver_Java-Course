package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Example2Page;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate; //object?

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate(); //instantiation?
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchToTabByTitle(String tabTitle){
        var windows = driver.getWindowHandles(); //gets handles of all open tabs. Handles are unique identifiers that
        // we don't know.
        System.out.println("Number of open tabs is " + windows.size());
        System.out.println("Window handles are:");
        windows.forEach(System.out::println);

        for(String window : windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("current window title is: " + driver.getTitle()); //title is what's displayed to the user

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    public void switchToTabByWindowHandle(){
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
        //assert driver.getWindowHandles().size() == 1;

        //Click the link which opens in a new window
        //driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();

        //Wait for the new window or tab
        WebDriverWait wait = new WebDriverWait(driver, Duration.ZERO);
        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //Wait for the new tab to finish loading content
        //wait.until(titleIs("Selenium documentation"));

    }
}
