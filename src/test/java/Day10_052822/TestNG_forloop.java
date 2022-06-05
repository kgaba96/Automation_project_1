package Day10_052822;

import ReusableLibrary.Reusable_actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_forloop {
    WebDriver driver;

    @BeforeSuite
    public void chromesetup() {
        driver = Reusable_actions.setDriver();

    }


    @Test
    public void SearchForKeyword() {
        ArrayList<String> cars = new ArrayList();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        for (int i = 0; i < cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            Reusable_actions.sendKeysAction(driver, "//*[@name='q']", cars.get(i), "type name");

            Reusable_actions.submitAction(driver, "//*[@name='btnK']", "google search");
            //enter a keyword on search field

//capture search result
            String result = Reusable_actions.captureText(driver, "//*[@id='result-stats']", "capture text");
            System.out.println(result);
            String[] arrayResult = result.split(" ");
            System.out.println("Search number is " + cars.get(i) + " is " + arrayResult[1]);
        }//end of loop
    }//end of test


    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//end of after suite


}// end of class
