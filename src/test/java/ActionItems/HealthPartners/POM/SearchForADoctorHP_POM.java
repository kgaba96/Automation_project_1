package ActionItems.HealthPartners.POM;

import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class SearchForADoctorHP_POM extends Reusable_Annotations_Class {

    @Test
    public void searchDOC (){

        driver.navigate().to("https://www.healthpartners.com/care/find/doctors/");
        BaseClassHP.SearchForADoctorHP().OpenNavTab();
        BaseClassHP.SearchForADoctorHP().OpenServiceTab();
        BaseClassHP.SearchForADoctorHP().OpenServiceTab();
        BaseClassHP.SearchForADoctorHP().OpenCL_HOS();
        BaseClassHP.SearchForADoctorHP().OpenNavCareWell();
        BaseClassHP.SearchForADoctorHP().SearchDoc();
        BaseClassHP.SearchForADoctorHP().SearchAlldocs();
        BaseClassHP.SearchForADoctorHP().searchSpeciality();
        BaseClassHP.SearchForADoctorHP().typeofdoc();
        BaseClassHP.SearchForADoctorHP().primarydoc();
        BaseClassHP.SearchForADoctorHP().Doctype();
        BaseClassHP.SearchForADoctorHP().sortdoc();
        BaseClassHP.SearchForADoctorHP().rating();
        BaseClassHP.SearchForADoctorHP().infobox();
        BaseClassHP.SearchForADoctorHP().capturetec();


    }//end of test




}//end of class
