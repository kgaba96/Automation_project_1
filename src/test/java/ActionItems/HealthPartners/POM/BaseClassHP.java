package ActionItems.HealthPartners.POM;

import ReusableClasses.Reusable_Annotations_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassHP extends Reusable_Annotations_Class {

    public BaseClassHP (WebDriver driver){
        PageFactory.initElements(driver, this);

    }//end of constctor

    public static HealthPartnerPOMPractice SearchForADoctorHP (){

        HealthPartnerPOMPractice SearchForADoctorHP = new HealthPartnerPOMPractice(driver);
        return SearchForADoctorHP;
    }

}//end of class
