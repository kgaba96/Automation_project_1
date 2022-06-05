package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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


public class Reusable_Actions_Loggers_x {
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
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successful mouse hover on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to mouse hover on element " + elementName+ "  "+ e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successful click on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName+ "  "+ e);
        }
    }//end of clickAction

    public static void clearAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            logger.log(LogStatus.PASS, "Successful click on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName+ "  "+ e);

        }
    }//end of clickAction


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, ExtentTest logger ,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successful enter values on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to enter value on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to enter value on element " + elementName+ "  "+ e);

        }
    }//end of sendkeys method


    public static void ClickByIndexAction(WebDriver driver, String xpath, int indexNumber,ExtentTest logger ,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successful click by index  on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + "" + e);
            logger.log(LogStatus.FAIL, "Unable to click by index on element " + elementName+ "  "+ e);


        }// end of catch ant try

    }// end of click Index Action

   /* public static void ClickByIndexActionPresence(WebDriver driver, String xpath, int indexNumber,ExtentTest logger ,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successful click by index  on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + "" + e);
            logger.log(LogStatus.FAIL, "Unable to click by index on element " + elementName+ "  "+ e);


        }// end of catch ant try

    }// end of click Index Action
    */



    public static void verifyTitle(WebDriver driver, String title ,String elementName) {
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

    public static void switchTabByIndex(WebDriver driver, int indexNumber, ExtentTest logger ,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(indexNumber));
            logger.log(LogStatus.PASS, "Successful switch tab on element "+ elementName );
        } catch (Exception e) {

            System.out.println(" Unable to switch tabs" + e);
            logger.log(LogStatus.FAIL, "Unable to switch tabs on element " + elementName+ "  "+ e);

        } // end of try and catch

    }// end of switchTabByIndex

    public static void selectByText(WebDriver driver, String xpath, String DropdownList, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(DropdownList);
            logger.log(LogStatus.PASS, "Successful drop down select on element "+ elementName );
        } catch (Exception e) {

            System.out.println(" Unable to select a month" + e);
            logger.log(LogStatus.FAIL, "Unable to select from drop down on element " + elementName+ "  "+ e);

        } // end of try and catch

    }// end of DropdownList Action

    public static String captureText(WebDriver driver, String xpath, ExtentTest logger ,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;
        try {
            WebElement  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result= element.getText();
//            System.out.println(element);
            logger.log(LogStatus.PASS, "Successful get text on element "+ elementName );

        } catch (Exception e) {
            System.out.println("Unable to capture text" + e);
            logger.log(LogStatus.FAIL, "Unable to capture text an element " + elementName+ "  "+ e);

        }
        return result;
    }//end of clickAction


    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger,  String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successful sumbit on element "+ elementName );
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName+ "  "+ e);
        }
    }
    //end of submit
    
}