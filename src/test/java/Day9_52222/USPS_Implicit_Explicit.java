package Day9_52222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class USPS_Implicit_Explicit {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        // set your global implicit wait
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.navigate().to("https://www.usps.com");

        // call mouse action

        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver,8);

        // hover to quick tools

        WebElement qktls = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
        actions.moveToElement(qktls).perform();

        // click on track a package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();

        //click and type track number

        WebElement pkgf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")));
        pkgf.click();
        pkgf.sendKeys("11111111111");




    }// end of class

}// end of class
