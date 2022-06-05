package Day10_052822;

import ReusableLibrary.Reusable_actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_example {

    // declare the local driver outside so that it can be reusable with other annotation methods

     WebDriver driver;
    @BeforeSuite
    public void chromesetup(){
        driver = Reusable_actions.setDriver();

    }

    @Test(priority = 1)
    public void searchkeyword() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Reusable_actions.sendKeysAction(driver,"//*[@name='q']","BMW", "type name");

        Reusable_actions.submitAction(driver,"//*[@name='btnK']","google search");
Thread.sleep(3000);
    } // end of test 1

    @Test(priority = 2)
    public void CaptureSearchNumber(){
        String result = Reusable_actions.captureText(driver, "//*[@id='result-stats']", "capture text");
        System.out.println(result);
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite




}//end of class
