package ActionItems.HealthPartners;

import ReusableLibrary.Reusable_Actions_Loggers_x;
import ReusableLibrary.Reusable_actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HealthPartner {


    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    @BeforeSuite
    public void chromesetup() {
        driver = Reusable_actions.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/HealthPartner_US.html");
    }// end of before Suite

    // This test cover User story 1: cover the main webpages for Healthpartner and their services
    @Test(priority = 1)
    public void TC01_01() throws InterruptedException {
        logger = reports.startTest("US01");
        driver.navigate().to("https://www.healthpartners.com/"); // navigate to website
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,900)"); // scroll down to see the tab to click on the link for clinics

        // click on the tab
        //Reusable_actions.clickAction(driver, "//*[@href='/care/']","Click to open up clinic tab");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@href='/care/']", logger, "click to open up tab");

        //verify title name.
        Reusable_actions.verifyTitle(driver, "HealthPartners’ clinic & hospital main services", "get title info");

        Thread.sleep(1000);

        // bring to view the four services
        jse.executeScript("scroll(0,600)");


        //String a1= Reusable_actions.captureText(driver,"//*[@href='/care/everyday/']" , " capture  1st service title and summary ");
        String a1 = Reusable_Actions_Loggers_x.captureText(driver, "//*[@href='/care/everyday/']", logger, " capture  1st service title and summary ");
        System.out.println(a1);

        //String a2= Reusable_actions.captureText(driver,"//*[@href='/care/specialty/']" , " capture  2nd service title and summary  ");
        String a2 = Reusable_Actions_Loggers_x.captureText(driver, "//*[@href='/care/specialty/']", logger, " capture  2nd service title and summary  ");
        System.out.println(a2);

        // String a3= Reusable_actions.captureText(driver,"//*[@href='/care/everyday/virtuwell-online-clinic/']" , " capture  3rd service title and summary ");
        String a3 = Reusable_Actions_Loggers_x.captureText(driver, "//*[@href='/care/everyday/virtuwell-online-clinic/']", logger, " capture  3rd service title and summary ");
        System.out.println(a3);


        // String a4= Reusable_actions.captureText(driver,"//*[@href='/care/find/locations/']" , " capture  4th service title and summary ");
        String a4 = Reusable_Actions_Loggers_x.captureText(driver, "//*[@href='/care/find/locations/']", logger, " capture  4th service title and summary ");
        System.out.println(a4);


        //driver.navigate().to("https://www.healthpartners.com/care/");

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
            logger.log(LogStatus.PASS, "Successful opening up the webpages to all four services");

        } catch (Exception e) {

            System.out.println("Error found" + e);
            logger.log(LogStatus.FAIL, "Unable to enter value on element " + serviceCount + "  " + e);

        }
        reports.endTest(logger);

    }// end of Test 1


    //This test covers user story 2 and 3: making an appointment and picking the doctor based on rating
    @Test(priority = 2)
    public void US02and3() throws InterruptedException {
        logger = reports.startTest("US02and3");
        driver.navigate().to("https://www.healthpartners.com/care/"); // navigate to website

        ArrayList<String> DOB = new ArrayList<>();
        DOB.add("02/01/1980");

        ArrayList<String> speciality = new ArrayList<>();
        speciality.add("skin");

        ArrayList<String> location = new ArrayList<>();
        location.add("Queensbury ");

        ArrayList<String> apptDate = new ArrayList<>();
        apptDate.add("02/02/2023");

        ArrayList<String> firstname = new ArrayList<>();
        firstname.add("John");

        ArrayList<String> lastname = new ArrayList<>();
        lastname.add("Mills");

        ArrayList<String> street = new ArrayList<>();
        street.add("105 Aills Ave");

        ArrayList<String> city = new ArrayList<>();
        city.add("New York");

        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11011");

        ArrayList<String> email = new ArrayList<>();
        email.add("testing.awap@aol.com");

        ArrayList<String> phone = new ArrayList<>();
        phone.add("800-009-0007");

        ArrayList<String> subID = new ArrayList<>();
        subID.add("987354763");

        for (int i = 0; i < DOB.size(); i++) {
            // UserStory 2- testcase 1&2 = locate the make an appointment and make sure it's clicking.
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@href='/care/appointments/']", logger, "Click on make an appointment");
            //UserStory 2 - Testcase 3 = user should be able to make an appointment without login in
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Find an appointment first']", logger, "Click on find an appointment first");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@href='./whose-appointment?who=me&null']", logger, "Click on make an appointment for me");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='dob']", DOB.get(i), logger, "enter DOB");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='continue-link']", logger, "click next for DOB");
            //User Story 3- TestCase 1&2 = Search for a doctor and reduce amount of doctors by speciality
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='reason-search']", speciality.get(i), logger, "enter speciality");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[contains(@id,'care-selection-href-derm-so')]", logger, "click on the speciality matching the search");
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[contains(@onclick,'selectReason(')]", 0, logger, "Select reason for visit");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@aria-label='No']", logger, "Click no to find a new doctor");
            //User Story 3- TestCase 3 = find a doctor based on the distance
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Location']", logger, "Search by location");
            Reusable_Actions_Loggers_x.clearAction(driver, "//*[@id='location-text']", logger, "Clear location in type box");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='location-text']", location.get(i), logger, "Type location");
            // Reusable_Actions_Loggers_x.clearAction(driver,"//*[@id='btn-search']",logger,"click search");
            Thread.sleep(2000); // wait for results
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[contains(@href,'/care/appointments/location-selected?locationId=')]", 0, logger, "Pick a location");
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[contains(@href,'/care/appointments/provider-selected?providerId=')]", 6, logger, "Pick a Doctor");
            Reusable_Actions_Loggers_x.clearAction(driver, "//*[@id='date']", logger, "Clear date for the appointment ");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='date']", apptDate.get(i), logger, "Submit date for the appointment ");
            Thread.sleep(1500);
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[contains(@id, ' a.m.')]", 1, logger, "Click time of appointment");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='firstName']", firstname.get(i), logger, "enter first name");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='lastName']", lastname.get(i), logger, "enter first name");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Male']", logger, "Click on gender- male");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='street']", street.get(i), logger, "enter street address");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='city']", city.get(i), logger, "enter city address");
            //select State
            WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
            Select st = new Select(state);
            st.selectByVisibleText("New Jersey");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='zip']", zipcode.get(i), logger, "enter zipecode");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='save-patient-info-btn']", logger, "click on next");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='email']", email.get(i), logger, "enter email");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='mobilePhone']", phone.get(i), logger, "enter phone");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='save-contact-button']", logger, "click on next");
            //select insurance
            WebElement ins = driver.findElement(By.xpath("//*[@id='payorId']"));
            Select in = new Select(ins);
            in.selectByVisibleText("Humana");
            Thread.sleep(1000);
            //select plan
            WebElement planID = driver.findElement(By.xpath("//*[@id='planId']"));
            Select pi = new Select(planID);
            pi.selectByVisibleText("Humana Gold Choice");
            Thread.sleep(1000);

            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='subscriberId']", subID.get(i), logger, "enter subscriber ID");
            Thread.sleep(1000);

            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='save-insurance-btn']", logger, "click on make an appointment");

            String appointinfo = Reusable_Actions_Loggers_x.captureText(driver, "//*[@class='xs']", logger, "Capture text");
            // System.out.println(appointinfo);

            try {
                System.out.println(appointinfo);
                logger.log(LogStatus.PASS, "Successful making an appointment and the information  are   " + appointinfo);

            } catch (Exception e) {
                System.out.println("an error found");
                logger.log(LogStatus.FAIL, "Unable to enter value on element " + "  " + e);
            }// added a try and catch to get the appointment info into the html report

        }//end of loop

        reports.endTest(logger);
    } // end of test 2

    //This test covers user story 4 & 6 : picking a doctor and also reading the rating and feedback
    @Test(priority = 3)
    public void US03and04() throws InterruptedException {
        logger = reports.startTest("US04and06");
        driver.navigate().to("https://www.healthpartners.com"); // navigate to website

        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@class='icon-menu hidden-lg']", logger, "click on right navigation");
        Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[@class='nav-content']", 1, logger, "click on services");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Clinics & hospitals']", logger, "click on Clinics & hospitals");
        Thread.sleep(1000);
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@name='system-menu']", logger, "click on right navigation care well");
        Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[@class='nav-text']", 1, logger, "click on search for a doctor");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='All doctors']", logger, "click on search for all doctors");
        Thread.sleep(1000);
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@name='Specialty']", logger, "click on specialty");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='expertisesPrimary Care']", logger, "click on Primary doctor");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@name='Type of doctor']", logger, "click on type of doctor");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='typeDoctor']", logger, "click on Primary doctor");
        Thread.sleep(1000);
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@name='Type of doctor']", logger, "click on type of doctor");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='sort-medium-up']", logger, "click on sort by");
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@value='rating']", logger, "click on base on rating ");
        Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[@data-analytics='person-card']", 3, logger, "click on a doctor box");
        String doctorinfo = Reusable_Actions_Loggers_x.captureText(driver, "//*[@class='header-container']", logger, "Capture doctor information");
        try {
            System.out.println(doctorinfo);// print doctor info in the creen log
            logger.log(LogStatus.PASS, "Successful opening doctor page. Here is the doctor info  " + doctorinfo);

        } catch (Exception e) {
            System.out.println("an error found");
            logger.log(LogStatus.FAIL, "Unable to enter value on element " + "  " + e);
        }// added a try and catch to get the doctor info into the html report


        reports.endTest(logger);

    }//end of Test  3 method


    //This test cover user story 5: finding the best location
    @Test (priority = 4)
    public void us07yg5() throws InterruptedException {
        logger = reports.startTest("US05");

        driver.navigate().to("https://www.healthpartners.com");
        //click on right navigation
        Reusable_Actions_Loggers_x.clickAction(driver, "//*[@name='system-menu']", logger, "click on right navigation");
        //click on service
        Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[@class='mobile-nav-option']", 1, logger,"click on service");

        //I was able to click on the element when using findElements but not visibility of an element - presence of all element .get(O) don't work
        //Reusable_Actions_Loggers_x.ClickByIndexAction(driver, "//*[contains(text(),'Clinics & hospitals')]", 0, logger,"click on service");
        Reusable_Actions_Loggers.ClickByIndexAction(driver,"//*[contains(text(),'Clinics & hospitals')]", 0, logger,"click++++++");
        //click on the side menu
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[@name='system-menu']",logger,"click on the side menu");
        //click on the side menu for all location
        driver.findElements(By.xpath("//*[text()='Our locations']")).get(1).click();
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[text()='All locations']",logger,"click on the side menu for all location");
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[@id='sort-medium-up']",logger,"click on sort location by");
        Reusable_Actions_Loggers_x.clickAction(driver,"//*[text()='Wait times']",logger,"click on sort by wait time");
        //count locations result
        try {
            ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='location-tile-outer']")));
            System.out.println("Number of location found is: " + searchResults.size());
            logger.log(LogStatus.PASS, "Successful opening locations page and counting tha mount location available." );
        }catch (Exception e){
            System.out.println("an error found");
            logger.log(LogStatus.FAIL, "Unable to get the count of locations " + "  " + e);
        }//end of catch and try

        // used Javascript Executor to scroll down
        JavascriptExecutor jse =(JavascriptExecutor)driver; // used Javascript Executor to scroll down
        jse.executeScript("scroll(0,1200)");
        Thread.sleep(1000);

        //collect location information
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



    @AfterSuite
    public void quitSession() {
        driver.quit();
        reports.flush();
    }//end of after suite


}//end of class
