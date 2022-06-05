package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_Al03 {
    public static void main (String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); // set up the chrome driver with webDriver manager

        ChromeOptions o1 = new ChromeOptions(); // add chrome options arguments
        o1.addArguments("--incognito");
        o1.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(o1); // define the drive im going to use

        // create an arraylist with different location

        ArrayList<String> hobby = new ArrayList <>();// create an ArrayList
        hobby.add(" Soccer");
        hobby.add("Football");
        hobby.add("Swimming");
        hobby.add("Racing");
        hobby.add("hockey");

       for (int i =0; i<   hobby.size();i++ ) {

           driver.navigate().to("https://www.bing.com/");// go the website using this command

           Thread.sleep(3000);// slow down the code inorder to catch up with the page


           // locate element for search field and type keyword cars
           driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(  hobby.get(i));

           driver.findElement(By.xpath("//*[@name='search']")).submit(); // submit the entry

           Thread.sleep(2000);

           // add where the manager will collect the text
           String searchResults = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

           // add the split command to collect the excat data you are looking for.
           String [] arrayResults= searchResults.split(" ");
           System.out.println("My hobby is "+ hobby.get(i)+" and the amount of search results on bing.com is "+ arrayResults[0] + ".");


       }// end of for loop

        driver.quit();

    }// end of main


}// end of class
