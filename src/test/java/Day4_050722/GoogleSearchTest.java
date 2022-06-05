package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        // setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        // go to google home page
        driver.navigate().to("https://www.google.com");

            // slow down the running
        Thread.sleep(3000);


        //maximize the driver -no need when using chrome option
        //driver.manage().window().maximize();// for mac use window().fullScreen();


        // locate element for search field and type keyword cars
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        // sumbit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        // capture the google search and print it
        String searchResults = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Results are "+searchResults);

        // extract out the number and print the search number only

        String[] arrayResults = searchResults.split(" ");
        System.out.println("results number only is "+ arrayResults[1]);

        String replaceParanth = arrayResults[3].replace("(","").replace(")","");
        System.out.println("in between" + arrayResults[1]);
    // to replace ( and ) from the seconds that's coming from arrayList [3] use .replace command to replace it with  "" (no space)

        driver.quit();
        //quit the driver
        //driver.quit();







    }//end method
}// end of java class
