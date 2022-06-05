package ActionItems.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.util.ArrayList;

public class Z13 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions o1 = new ChromeOptions();
        o1.addArguments("incognito");
        o1.addArguments("start-maximized");

        WebDriver d = new ChromeDriver(o1);


        ArrayList<String> v1= new ArrayList<>();
        v1.add("Yemen");
        v1.add("Aden");
        v1.add("cars");

        for (int i=0;v1.size()<i;i++) {
            d.navigate().to("https://www.google.com");

            Thread.sleep(2000);




        }//end of loop
    }//end of method
}//end of class
