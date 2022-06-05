package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Automation_Al04 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); // set up Web-driver with the chrome driver

        ChromeOptions op = new ChromeOptions(); // set up arguments to add in options to chrome
        op.addArguments("incognito"); // add in incognito to the options
        op.addArguments("start-maximized"); // add in full screen option to set up

        ArrayList<String> ZipCode = new ArrayList<>(); // create an ArrayList with zipcode
        ZipCode.add("11101");
        ZipCode.add("11102");
        ZipCode.add("11103");


        WebDriver driver = new ChromeDriver(op); // launch chrome with Options added

        for (int i = 0; i < ZipCode.size(); i++) { // start the for loop to run the zip codes

            driver.navigate().to("https://www.weightwatchers.com"); //command to go to the website
            Thread.sleep(3000); // slow the code for the website

            driver.findElements(By.xpath("//*[text () ='Attend']")).get(0).click(); // used elements because I used text " attend"


            Thread.sleep(1000);

            driver.findElements(By.xpath("//*[text()='Virtual or in-person Workshops']")).get(1).click(); // used elements with text, easier to single out the code

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[text() ='Studio']")).click(); // used element because there is only one for text "studio"

            try { // used my try and catch code to see if there is an error and to get a better explanation when code fails.

                WebElement enterZC = driver.findElement(By.xpath("//*[@id='location-search']")); // used web element because i didn't want to repeat the code multiple times
                enterZC.clear();
                enterZC.click();
                enterZC.sendKeys(ZipCode.get(i)); // enter zipcode  to search
            } catch (Exception e) {
                System.out.println("Unable to enter zipcode " + e);
            }//end of enter zipcode exception

            driver.findElement(By.xpath("//*[@class = 'rightArrow-daPRP']")).click();  // command to search the zipcode

            Thread.sleep(3000);


            System.out.println(" "); //space


            if (ZipCode.get(i) == "11101") { // used if conditions to differentiate the requirement asked from each zipcode

                try {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();

                    String address1 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    String sub1 = address1.substring(0, 35); // used substring to get the address

                    System.out.println("My Second Location for " + ZipCode.get(i) + " Zipcode is " + sub1);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to print address " + e);
                }//end of Print address exception

                try {

                    JavascriptExecutor jse = (JavascriptExecutor) driver; // used Javascript Executor to scroll down
                    jse.executeScript("scroll(0,1200)");
                    Thread.sleep(1200);

                    String Table1 = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(1).getText();// got the table schedule for the virtual session
                    System.out.println(" The Virtual Class schedule for this Location is " + Table1);


                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to enter table " + e);
                }//end of print table exception

                System.out.println(" "); //space

            } else if (ZipCode.get(i) == "11102") { // repeated the same command and changed it to justify the requirements for the second zipcode

                try {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();


                    String address2 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    String sub2 = address2.substring(0, 39);

                    System.out.println("My Third Location for " + ZipCode.get(i) + " Zipcode is " + sub2);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to enter address " + e);
                }//end of enter address exception


                try {

                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("scroll(0,1200)");
                    Thread.sleep(1200);

                    String Table2 = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(1).getText();

                    System.out.println(" The Virtual Class schedule for this Location is " + Table2);


                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to enter table " + e);
                }//end of print table exception


                System.out.println(" "); //space

            } else if (ZipCode.get(i) == "11103") { // repeated the same command and changed it to justify the requirements for the third zipcode

                try {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(3).click();


                    String address3 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                    String sub3 = address3.substring(0, 60);

                    System.out.println("My Fourth Location for " + ZipCode.get(i) + " Zipcode is " + sub3);

                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to enter address " + e);
                }//end of enter address exception

                try {
                    String Table3 = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(1).getText();
                    System.out.println(" The Virtual Class schedule for this Location is " + Table3);

                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("scroll(0,1200)");
                    Thread.sleep(1200);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to enter table " + e);
                }//end of print table exception


            } // end of condition

        }// end of loop

        driver.quit();
    }//  end of main
}// end of class
