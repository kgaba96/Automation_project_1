package Day6_51422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_mortCalc {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); // set up the chrome driver with webDriver manager

        ChromeOptions o1 = new ChromeOptions(); // add chrome options arguments
        o1.addArguments("--incognito");
        o1.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(o1);

        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        JavascriptExecutor jse =(JavascriptExecutor)driver;
//        jse.executeAsyncScript("scroll(0,400)");
//        Thread.sleep(3000);
        WebElement shareButton = driver.findElement(By.xpath("//*[@id= 'share_button']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        Thread.sleep(2000);
        shareButton.click();
        Thread.sleep(2000);
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(2000);
        driver.quit();


    }//end of main
}//end of class
