package ActionItems.HealthPartners;

import ReusableLibrary.Reusable_Actions_Loggers_x;
import ReusableLibrary.Reusable_actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class US02and03 {

    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    @BeforeSuite
    public void chromesetup(){
        driver = Reusable_actions.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/US02&03_end-to-end_appt.html");
    }// end of before Suite

    // user story 2 with all acceptance criteria ( all test cases) and some of US 3 included.
    // I also, finish the process by doing an end-to-end test on making an appointment.
    @Test (priority = 1)
    public void TC01_01 () throws InterruptedException {
        logger= reports.startTest("Testcase01");
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



        reports.endTest(logger);
    } // end of test 1 _ end of TC01_01

    @Test(priority = 1)
    public void US02and3 () throws InterruptedException {
        logger= reports.startTest("US02and3");
        driver.navigate().to("https://www.healthpartners.com/care/"); // navigate to website

        ArrayList <String> DOB= new ArrayList<>();
        DOB.add("09/09/1999");

        ArrayList<String>speciality = new ArrayList<>();
        speciality.add("dermatologist");

        ArrayList<String>location= new ArrayList<>();
        location.add("New York ");

        ArrayList<String>apptDate=new ArrayList<>();
        apptDate.add("01/12/2023");

        ArrayList<String>firstname=new ArrayList<>();
        firstname.add("Michael");

        ArrayList<String>lastname=new ArrayList<>();
        lastname.add("Jordan");

        ArrayList<String>street=new ArrayList<>();
        street.add("103 Wills Ave");

        ArrayList<String>city=new ArrayList<>();
        city.add("Rancocas");

        ArrayList<String>zipcode=new ArrayList<>();
        zipcode.add("08073");

        ArrayList<String>email=new ArrayList<>();
        email.add("testingap@aol.com");

        ArrayList<String>phone=new ArrayList<>();
        phone.add("718-909-0987");

        ArrayList<String>subID=new ArrayList<>();
        subID.add("987354763");

        for (int i =0 ; i< DOB.size();i++) {
            // UserStory 2- testcase 1&2 = locate the make an appointment and make sure it's clicking.
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@href='/care/appointments/']", logger, "Click on make an appointment");
            //UserStory 2 - Testcase 3 = user should be able to make an appointment without login in
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Find an appointment first']", logger, "Click on find an appointment first");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@href='./whose-appointment?who=me&null']", logger, "Click on make an appointment for me");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='dob']", DOB.get(i), logger, "enter DOB");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='continue-link']", logger, "click next for DOB");
            //User Story 3- TestCase 1&2 = Search for a doctor and reduce amount of doctors by speciality
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='reason-search']", speciality.get(i), logger, "enter speciality");
            Reusable_Actions_Loggers_x.clickAction(driver,"//*[contains(@id,'care-selection-href-derm-so')]",logger,"click on the speciality matching the search");
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver,"//*[contains(@onclick,'selectReason(')]",0,logger,"Select reason for visit");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@aria-label='No']", logger, "Click no to find a new doctor");
            //User Story 3- TestCase 3 = find a doctor based on the distance
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Location']",logger,"Search by location");
            Reusable_Actions_Loggers_x.clearAction(driver, "//*[@id='location-text']",logger,"Clear location in type box");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='location-text']",location.get(i),logger,"Type location");
           // Reusable_Actions_Loggers_x.clearAction(driver,"//*[@id='btn-search']",logger,"click search");
            Thread.sleep(1000); // wait for results
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver,"//*[contains(@href,'/care/appointments/location-selected?locationId=')]", 0,logger,"Pick a location");
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver,"//*[contains(@href,'/care/appointments/provider-selected?providerId=')]", 4,logger,"Pick a Doctor");
           Reusable_Actions_Loggers_x.clearAction(driver,"//*[@id='date']",logger,"Clear date for the appointment ");
            Reusable_Actions_Loggers_x.sendKeysAction(driver,"//*[@id='date']",apptDate.get(i),logger,"Submit date for the appointment ");
            Thread.sleep(1500);
            Reusable_Actions_Loggers_x.ClickByIndexAction(driver,"//*[contains(@id, ' a.m.')]", 1, logger, "Click time of appointment");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='firstName']", firstname.get(i),logger,"enter first name");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='lastName']", lastname.get(i),logger,"enter first name");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[text()='Male']",logger,"Click on gender- male");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='street']", street.get(i),logger,"enter street address");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='city']", city.get(i),logger,"enter city address");
            //select State
            WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
            Select st = new Select(state);
            st.selectByVisibleText("New Jersey");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='zip']", zipcode.get(i),logger,"enter zipecode");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='save-patient-info-btn']",logger,"click on next");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='email']", email.get(i),logger,"enter email");
            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='mobilePhone']", phone.get(i),logger,"enter phone");
            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='save-contact-button']",logger,"click on next");
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

            Reusable_Actions_Loggers_x.sendKeysAction(driver, "//*[@id='subscriberId']", subID.get(i),logger,"enter subscriber ID");
            Thread.sleep(1000);

            Reusable_Actions_Loggers_x.clickAction(driver, "//*[@id='save-insurance-btn']",logger,"click on make an appointment");

            String appointinfo= Reusable_Actions_Loggers_x.captureText(driver,"//*[@class='xs']",logger,"Capture text");
            System.out.println(appointinfo);

        }//end of loop

        reports.endTest(logger);
    } // end of test 1 _ end of TC01_01


    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite
}// end of class
