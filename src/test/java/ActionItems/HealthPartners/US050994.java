package ActionItems.HealthPartners;

import ReusableLibrary.Reusable_Actions_Loggers_x;
import ReusableLibrary.Reusable_actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class US050994 {
    WebDriver driver;

    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void chromesetup() {
        driver = Reusable_actions.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/H0000.html");
    }// end of before Suite

    @Test (priority = 4)
    public void us05() throws InterruptedException {
        logger = reports.startTest("0983784");

        driver.navigate().to("https://www.healthpartners.com");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@name='system-menu']", logger, "click on right navigation");
        Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[@class='mobile-nav-option']", 1, logger,"click on service");

        //I was able to click on the element when using findElements but not visibility of an element - presence of all element .get(O) don't work
        //Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[contains(text(),'Clinics & hospitals')]", 0, logger,"click on service");
        driver.findElements(By.xpath("//*[contains(text(),'Clinics & hospitals')]")).get(0).click();
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[@name='system-menu']",logger,"click on the side menu");
        driver.findElements(By.xpath("//*[text()='Our locations']")).get(1).click();
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[text()='All locations']",logger,"click on the side menu for all location");
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[@id='sort-medium-up']",logger,"click on sort location by");
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[text()='Wait times']",logger,"click on sort by wait time");
        //count locations result
        try {
        ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='location-tile-outer']")));
        System.out.println("Number of location found is: " + searchResults.size());
            logger.log(LogStatus.PASS, "Successful opening locations page. Here is the location search size  " + searchResults);
        }catch (Exception e){
            System.out.println("an error found");
            logger.log(LogStatus.FAIL, "Unable to get the count of locations " + "  " + e);
        }//end of catch and try

        JavascriptExecutor jse =(JavascriptExecutor)driver; // used Javascript Executor to scroll down
        jse.executeScript("scroll(0,1200)");
        Thread.sleep(1000);
        try {
            String location = driver.findElements(By.xpath("//*[@class='location-tile-outer']")).get(10).getText();
            System.out.println("Info for location #10 is : " + location);
            logger.log(LogStatus.PASS, "Successful collection of Info for location #10 is : " + location);
        }catch (Exception e){
            System.out.println("an error found");
            logger.log(LogStatus.FAIL, "Unable to get the info for locations " + "  " + e);
        }//end of catch and try

        reports.endTest(logger);

    }//method test number 4
}//class
