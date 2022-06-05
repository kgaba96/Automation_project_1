package ActionItems.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class z14 {
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
            Thread.sleep(2000); // slow the code for the website

            driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click(); // used elements because I used text " attend"


//            Thread.sleep(1000);
//
//            driver.findElements(By.xpath("//*[text()='Virtual or in-person Workshops']")).get(1).click(); // used elements with text, easier to single out the code
//
//            Thread.sleep(1000);

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

            try {
                ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkContainer-1NkqM']")));
                System.out.println("Number of Studios found for zipcode: " + searchResults.size());
                Thread.sleep(1000);
                if (i == 0) {
                    searchResults.get(1).click();
                } else if (i == 1) {
                    searchResults.get(2).click();
                } else if (i == 2) {
                    searchResults.get(0).click();
                }
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to get list of studios " + e);
            }//end of get list of studios exception

            Thread.sleep(3000);

    try {

    String address1 = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
    String sub1 = address1.substring(0, 60); // used substring to get the address

            int last = sub1.lastIndexOf('\n');// get only the numbers as the end value
    sub1 = sub1.substring(0,last);// collect only numbers at the end

    System.out.println("The address for " + ZipCode.get(i) + " Zipcode is " + sub1);
    } catch (Exception e) {
        System.out.println("Unable to get the address " + e);
    }//end of enter address exception


//end of get list of studios exception
            try {

            JavascriptExecutor jse =(JavascriptExecutor)driver; // used Javascript Executor to scroll down
            jse.executeScript("scroll(0,1200)");
            Thread.sleep(1200);

            String Table1 = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(1).getText();// got the table schedule for the virtual session
            System.out.println(" The Virtual Class schedule for this Location is " + Table1);

            } catch (Exception e) {
                System.out.println("Unable to get the table " + e);
            }//end of getting table exception


        }//  end of loop
    }//end of main
}//end of class