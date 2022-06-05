package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ForLoop_ArrayList_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        // setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();


        //set chrome options arguements
        ChromeOptions options = new ChromeOptions();

        // set the condition to incognito mode

        options.addArguments("incognito");

        // set the condition to maximize

        options.addArguments("start-maximized");

        // add headless running

        //options.addArguments("headless");

// options must be added before introducing the web drive im going to use
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
// capture search number and print for following cities using arraylist and for loop

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        //cities.add("Bronx NY");
        cities.add("Utica NY");
        cities.add("Alabama ");
        cities.add("Buffalo NY");

        for (int i = 0; i < cities.size (); i++) {
            driver.navigate().to("https://www.google.com");

            // slow down the running
            Thread.sleep(3000); //sometimes the codes are running faster than the webpage and you need it to slow down and a timer


            //maximize the driver -no need when using chrome option
            //driver.manage().window().maximize();// for mac use window().fullScreen();


            // locate element for search field and type keyword cars
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys( cities.get(i));

            // sumbit on google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            Thread.sleep(3000);// sometimes the codes are running faster than the webpage and you need it to slow down and a timer

            // capture the google search and print it
            String searchResults = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("Results are "+searchResults);

            // extract out the number and print the search number only

            String[] arrayResults = searchResults.split(" ");
            System.out.println("My Search number for city of  "+ cities.get(i)+ " is " + arrayResults[1]);



        }// end of for loop
    }//end of method

}//end of java class
