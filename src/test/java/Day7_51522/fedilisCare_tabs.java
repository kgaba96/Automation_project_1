package Day7_51522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class fedilisCare_tabs {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup(); // set up the chrome driver with webDriver manager

        ChromeOptions o1 = new ChromeOptions(); // add chrome options arguments
        o1.addArguments("--incognito");
        o1.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(o1);

        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(2000);

        driver.findElements(By.xpath("//*[text() = 'Shop For a Plan']")).get(0).click();
        Thread.sleep(2000);

        driver.findElements(By.xpath("//*[text() = 'Medicaid Managed Care']")).get(0).click();
        Thread.sleep(2000);// dont need to write @ when using elements with conatins and text
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();

        Thread.sleep(2000);

        driver.close();

        driver.switchTo().window(tabs.get(0));

        Thread.sleep(5000);

        driver.close();





    }// end of main
}// end class
