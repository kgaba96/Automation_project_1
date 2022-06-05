package Day8_52122;

import ReusableLibrary.Reusable_actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com");
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Google")){
            System.out.println("My title matches.");
        } else {
            System.out.println("Title doesn't match and actual title is "+ actualTitle);
        } //end of if condition

//        Reusable_actions.verifyTitle(driver, "google");
        driver.quit();
    }//end of main
}//end of class
