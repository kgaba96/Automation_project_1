package Day6_51422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_mortgagecalc {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup(); // set up the chrome driver with webDriver manager

        ChromeOptions o1 = new ChromeOptions(); // add chrome options arguments
        o1.addArguments("--incognito");
        o1.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(o1);

        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

//        JavascriptExecutor jse =(JavascriptExecutor)driver;
//        jse.executeAsyncScript("scroll(0,400)");


        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeValue.click();
        homeValue.click();

        homeValue.sendKeys("950000");

        driver.findElement(By.xpath("//*[@value='percent']")).click();

        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));

        downPayment.click();
        downPayment.clear();

        downPayment.sendKeys("5");
        Thread.sleep(3000);
        driver.quit();



    }//end od method
}//end of class
