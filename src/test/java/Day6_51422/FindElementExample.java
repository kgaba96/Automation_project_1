package Day6_51422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); // set up the chrome driver with webDriver manager

        ChromeOptions o1 = new ChromeOptions(); // add chrome options arguments
        o1.addArguments("--incognito");
        o1.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(o1);

        driver.navigate().to("https://www.bing.com");

        Thread.sleep(3000);

        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(3).click();




    }//end of main
}//end of class

