package ReusableLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class Reusable_actions {
    //resuable function for webdriver as a return method

    static int timeout = 20;
    public static WebDriver setDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method


    public static void ClickByIndexAction(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + "" + e);

        }// end of catch ant try

    }// end of click Index Action


    public static void verifyTitle(WebDriver driver, String title, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(title)) {
                System.out.println("My title matches.");
            } else {
                System.out.println("Title doesn't match and actual title is " + actualTitle);
            } //end of if condition
        } catch (Exception e) {
            System.out.println("Unable to get actual Title" + e);

        }// end of getting title action
    }// end if verify Title action

    public static void switchTabByIndex(WebDriver driver, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(indexNumber));
        } catch (Exception e) {

            System.out.println(" Unable to switch tabs" + e);
        } // end of try and catch

    }// end of switchTabByIndex

    public static void selectByText(WebDriver driver, String xpath, String DropdownList, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(DropdownList);
        } catch (Exception e) {

            System.out.println(" Unable to select a month" + e);
        } // end of try and catch

    }// end of DropdownList Action

    public static String captureText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            WebElement  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result= element.getText();
//            System.out.println(element);

        } catch (Exception e) {
            System.out.println("Unable to capture text" + e);
        }
        return result;
    }//end of clickAction


    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }
    //end of submit



    
}