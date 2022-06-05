package ActionItems;

import ReusableLibrary.Reusable_actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.ArrayList;

public class Automation_Al05 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= Reusable_actions.setDriver();

        ArrayList <String> firstName = new ArrayList<>(); // first name array list
        firstName.add("Jason");
        firstName.add("Justin ");
        firstName.add("Jack");

        ArrayList <String> lastName = new ArrayList<>(); // last name array list
        lastName.add("Smith");
        lastName.add("Johnson");
        lastName.add("McClaw");

        ArrayList <String> birthMonth = new ArrayList<>(); // last name array list
        birthMonth.add("January");
        birthMonth.add("February");
        birthMonth.add("March");

        ArrayList <String> birthDay = new ArrayList<>(); // last name array list
        birthDay.add("10");
        birthDay.add("13");
        birthDay.add("14");

        ArrayList <String> birthYear = new ArrayList<>(); // last name array list
        birthYear.add("1999");
        birthYear.add("1998");
        birthYear.add("1997");

        ArrayList <String> zipCode = new ArrayList<>(); // last name array list
        zipCode.add("11101");
        zipCode.add("11102");
        zipCode.add("11103");

        ArrayList <String> memberID = new ArrayList<>(); // last name array list
        memberID.add("001122233");
        memberID.add("001122244");
        memberID.add("001122255");

        for ( int i=0; i < firstName.size(); i++){

            driver.navigate().to("https://www.uhc.com/");

            Reusable_actions.verifyTitle(driver, "Health insurance plan", "Verify title name");

            Reusable_actions.clickAction(driver,"//*[@href='/find-a-doctor']", "click on Find a doctor");

            Reusable_actions.clickAction(driver,"//*[@class='jump-menu__content-wrapper color-greyDark weight-regular']","click on sign in");

            Reusable_actions.clickAction(driver, "//*[text()='Medicare plan']", "click on medicare plan");

            Reusable_actions.switchTabByIndex(driver,1, "Switch tab to 1");

            Reusable_actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "click on Register now");

            Reusable_actions.sendKeysAction(driver, "//*[@id='firstName']",firstName.get(i), "enter first name");

            Reusable_actions.sendKeysAction(driver, "//*[@id='lastName']",lastName.get(i), "enter last name");

            Reusable_actions.selectByText(driver,"//*[@name='dob_month']",birthMonth.get(i),"Select by text the birthday month");


            Reusable_actions.sendKeysAction(driver, "//*[@id='dob_day']",birthDay.get(i), "enter Birth date ");

            Reusable_actions.sendKeysAction(driver, "//*[@id='dob_year']",birthYear.get(i), "enter Birth year ");

            Reusable_actions.sendKeysAction(driver, "//*[@id='zipCode']",zipCode.get(i), "enter Zipcode");

            Reusable_actions.sendKeysAction(driver, "//*[@id='memberId']",memberID.get(i), "enter memberID");

            Reusable_actions.clickAction(driver, "//*[@id='submitBtn']","click submit");

            Reusable_actions.captureText(driver,"//*[@id='personalInfo_errors']","Capture Error message");

            System.out.println(" " );


            Thread.sleep(4000);

            driver.close();

            Reusable_actions.switchTabByIndex(driver,0, "change tab to homepage");

        }// end of loop

        Thread.sleep(2000);

        driver.quit();


    }// end of main
}// end of class
