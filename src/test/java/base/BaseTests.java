package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver"); //this was needed for old versions
        //driver = new ChromeDriver();
        driver = new ChromeDriver(getChromeOptions());
        //we have to register a class that's implementing the webdriver event listener interface
        goHome();
        setCookie();
        //below is example of implicit wait which wait for the whole page to load and should be avoided in favor of
        // explicit wait
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void courseCode(){
        //driver.get("https://the-internet.herokuapp.com/");
        //System.out.println(driver.getTitle());
        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(390, 844));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());


        WebElement inputLinks = driver.findElement(By.linkText("Inputs"));
        inputLinks.click();
        System.out.println(driver.getTitle());
    }


    public void extraExercise(){
        //driver.get("https://the-internet.herokuapp.com/");
        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        WebElement menuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuElement.click();
        List<WebElement> elementsToCount = driver.findElements(By.cssSelector("li>a"));
        System.out.println(elementsToCount.size());
    }

    @AfterClass
    public void cleanup(){
        driver.quit();
    }


    @AfterMethod
    public void recordFailure(ITestResult result){ //ITestResult is from testNG
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("Screenshot location is: " + screenshot.getAbsoluteFile()); //this uses whatever
            // default location is
            try {
                                                                                     //this gets the failed test method
                                                                                     // with @Test tag before it
                Files.move(screenshot, new File("src/main/resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
        //test.courseCode();
        test.extraExercise();
        test.cleanup();
    }

     */


    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //This flag is no longer needed by the perf testing infrastructure and can be
        //misused for malicious purposes, so remove it.
        //options.addArguments("disable-infobars"); //deprecated
        //options.addArguments("--headless=new"); //runs test without actually openning the browser for the user
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

   public CookieManager getCookieManager(){
        return new CookieManager(driver);
   }

}
