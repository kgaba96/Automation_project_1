package Day11_052922;

import ReusableLibrary.Reusable_actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class USPS_List_WebElement {
    WebDriver driver;

    @BeforeSuite
    public void chromesetup() {
        driver = Reusable_actions.setDriver();
    }

    @Test(priority = 1)
    public void USPS_Tabs_Count() throws InterruptedException {
        //navigate to usps
        driver.navigate().to("https://www.usps.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //store the navigation tabs as a list to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        //print the tab count
        System.out.println("Tabs count is " + tabsCount.size());

        for (int i = 0; i < tabsCount.size(); i++) {
            driver.navigate().to("https://www.usps.com");
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            //click on each tab
            tabsCount.get(i).click();
        }
    }//end of test


    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//end of after suite

}//end of class
