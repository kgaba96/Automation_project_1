package Day7_51522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortCal {

        public static void main(String[] args) throws InterruptedException {


            WebDriverManager.chromedriver().setup(); // set up the chrome driver with webDriver manager

            ChromeOptions o1 = new ChromeOptions(); // add chrome options arguments
            o1.addArguments("--incognito");
            o1.addArguments("start-maximized");


            WebDriver driver = new ChromeDriver(o1);

            driver.navigate().to("https://www.mortgagecalculator.org");
            Thread.sleep(3000);

            WebElement startmonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));


           // startmonth.click();

          //  driver.findElement(By.xpath("//*[text()='Jun']")).click();

        Select dd = new Select(startmonth);
           dd.selectByVisibleText("Jun");

WebElement loanT = driver.findElement(By.xpath("//*[@name='param[milserve]']"));

            Select loanTypeDropdown = new Select(loanT);
            loanTypeDropdown.selectByVisibleText("FHA");
            Thread.sleep(5000);
            driver.quit();

        }// end of main
}// end of class
