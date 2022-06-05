package Day9_52222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class mouseActions {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        // declare and define mouse actions

        Actions mouseActions = new Actions(driver);

        //hover to send tav

        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        // click on tracking using mouse action

        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();

        Thread.sleep(3000);

        // type a invalid tracking

        WebElement trackingfield= driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingfield).click().perform();
        mouseActions.moveToElement(trackingfield).sendKeys("11111111111").perform();




    }//end of main
}// end of class


