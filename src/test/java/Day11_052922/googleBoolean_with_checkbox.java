package Day11_052922;

import ReusableLibrary.Reusable_actions;
import ReusableClasses.Reusable_Annotations_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class googleBoolean_with_checkbox extends Reusable_Annotations_Class {


    @Test(priority = 1)
    public void Yahoo_Stay_signed_in_checkbox_verification() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com");
        Reusable_actions.clickAction(driver, "//*[text()='Sign in']", "click on sign in");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean check = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();

        System.out.println("Is element checked ? "+ check);

    }//end of test



}// end of class
