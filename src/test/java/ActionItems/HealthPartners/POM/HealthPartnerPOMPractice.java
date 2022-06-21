package ActionItems.HealthPartners.POM;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HealthPartnerPOMPractice extends Reusable_Annotations_Class {

    ExtentTest logger;

    public HealthPartnerPOMPractice (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger=Reusable_Annotations_Class.logger;
    }// end of constructor

    @FindBy(xpath = "//*[@class='icon-menu hidden-lg']")
    WebElement clickOnNAv;
    @FindBy(xpath = "//*[@class='nav-content']")
    List<WebElement> clickOnService;
    @FindBy(xpath = "//*[text()='Clinics & hospitals'")
    WebElement clickOnCLandHS;
    @FindBy(xpath = "//*[@name='system-menu']")
    WebElement clickonCareWell;
    @FindBy(xpath = "//*[@class='nav-text']")
    List <WebElement> clickonSearchofDOC;
    @FindBy(xpath = "//*[text()='All doctors']")
    WebElement searchAlldocs;
    @FindBy(xpath = "//*[@name='Specialty']")
    WebElement searchOfSpecialty;
    @FindBy(xpath = "//*[@id='expertisesPrimary Care']")
    WebElement clickOnPrimaryDocs;
    @FindBy(xpath = "//*[@name='Type of doctor']")
    WebElement clickOnTypeofDOC;
    @FindBy(xpath = "//*[@id='typeDoctor']")
    WebElement clickOntypePrimarydocs;
    @FindBy(xpath = "//*[@id='sort-medium-up']")
    WebElement clickToSort;
    @FindBy(xpath = "//*[@value='rating']")
    WebElement clickratings;
    @FindBy(xpath = "//*[@data-analytics='person-card']")
    List<WebElement> clickdoctorbox;
    @FindBy(xpath = "//*[@class='header-container']")
    WebElement captureInfo;

    public void OpenNavTab (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickOnNAv,logger,"OPen Nav");
    }
    public void OpenServiceTab (){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver,clickOnService,1,logger,"OPen service");
    }
    public void OpenCL_HOS (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickOnCLandHS,logger,"Clinics & hospitals");
    }
    public void OpenNavCareWell (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickonCareWell,logger,"click on right navigation care well");
    }
    public void SearchDoc (){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver,clickonSearchofDOC,1,logger,"click on search for a doctor");
    }
    public void SearchAlldocs (){
        Reusable_Actions_POM_Loggers.clickAction(driver,searchAlldocs,logger,"click on search for all doctors");
    }
    public void searchSpeciality (){
        Reusable_Actions_POM_Loggers.clickAction(driver,searchOfSpecialty,logger,"click on specialty");
    }

    public void typeofdoc (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickOnPrimaryDocs,logger,"click on type of doctor");
    }
    public void primarydoc (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickOnTypeofDOC,logger,"click primary doc");
    }
    public void Doctype (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickOntypePrimarydocs,logger,"click on type of doc");
    }

    public void sortdoc (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickToSort,logger,"click on sort docs");
    }
    public void rating (){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickratings,logger,"click on rating");
    }
    public void infobox (){
        Reusable_Actions_POM_Loggers.clickByIndexAction(driver,clickdoctorbox,3,logger,"click doc box");
    }
    public void capturetec (){
        Reusable_Actions_POM_Loggers.getTextAction(driver,captureInfo,logger,"capture text");
    }













}//end of class
