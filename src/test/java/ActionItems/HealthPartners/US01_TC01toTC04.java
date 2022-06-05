package ActionItems.HealthPartners;

import ReusableLibrary.Reusable_Actions_Loggers_x;
import ReusableLibrary.Reusable_actions;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class US01_TC01toTC04 extends Reusable_Annotations_Class {


    //User story 1 =  Test Case 1 =  view the clinical and hospital service
    @Test (priority = 1)
    public void TC01_01 () throws InterruptedException {
        driver.navigate().to("https://www.healthpartners.com/"); // navigate to website
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("scroll(0,900)"); // scroll down to see the tab to click on the link for clinics

        // click on the tab
        //Reusable_actions.clickAction(driver, "//*[@href='/care/']","Click to open up clinic tab");
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[@href='/care/']",logger,"click to open up tab");

        //verify title name.
        Reusable_actions.verifyTitle(driver, "HealthPartners’ clinic & hospital main services", "get title info" );

        Thread.sleep(1000);

        // bring to view the four services
        jse.executeScript("scroll(0,600)");

    } // end of test 1 _ end of TC01_01


    // Testcase 01_02&3 = Check the title of the four services and summary is there
    @Test(dependsOnMethods = "TC01_01")
    public void TC01_02and03 (){

        //String a1= Reusable_actions.captureText(driver,"//*[@href='/care/everyday/']" , " capture  1st service title and summary ");
        String a1= Reusable_Actions_Loggers_x.captureText(driver,"//*[@href='/care/everyday/']" , logger," capture  1st service title and summary ");
        System.out.println(a1);

        //String a2= Reusable_actions.captureText(driver,"//*[@href='/care/specialty/']" , " capture  2nd service title and summary  ");
        String a2= Reusable_Actions_Loggers_x.captureText(driver,"//*[@href='/care/specialty/']" , logger," capture  2nd service title and summary  ");
        System.out.println(a2);

       // String a3= Reusable_actions.captureText(driver,"//*[@href='/care/everyday/virtuwell-online-clinic/']" , " capture  3rd service title and summary ");
        String a3= Reusable_Actions_Loggers_x.captureText(driver,"//*[@href='/care/everyday/virtuwell-online-clinic/']" , logger," capture  3rd service title and summary ");
        System.out.println(a3);


       // String a4= Reusable_actions.captureText(driver,"//*[@href='/care/find/locations/']" , " capture  4th service title and summary ");
        String a4= Reusable_Actions_Loggers_x.captureText(driver,"//*[@href='/care/find/locations/']" ,logger," capture  4th service title and summary ");
        System.out.println(a4);



    }// end of TC01_02 & 3

    @Test(priority = 3)
    public void TC01_04 () throws InterruptedException {

/*
        Reusable_actions.clickAction(driver, "//*[@href='/care/everyday/']", "Everyday Care" );
        Thread.sleep(1000);
        driver.navigate().to("https://www.healthpartners.com/care/");
*/
        driver.navigate().to("https://www.healthpartners.com/care/");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // get the tab count into one variable to use in the for loop
        List<WebElement> serviceCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='hp-image-card-vertical']")));
        //print the tab count
        System.out.println("Service tab count is " + serviceCount.size());

    try {
        for (int i = 0; i < serviceCount.size(); i++) {
            driver.navigate().to("https://www.healthpartners.com/care/");
            serviceCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='top-link']")));
            //click on each tab
            serviceCount.get(i).click();
            Thread.sleep(1000);

        }// end of for loop
        logger.log(LogStatus.PASS, "Successful opening up of web page to the four services" );

    }catch (Exception e) {

        System.out.println("Error found" + e);
        logger.log(LogStatus.FAIL, "Unable to enter value on element " + serviceCount+ "  "+ e);

    }

    }// end of TestCase 4


}//end of class
