package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;


//rathna Mr
public class BaseUtil {

//child branchc- BaseUtil
    //second comment

    public  WebDriver Driver;

    public ExtentReports extent;

    public static ExtentTest scenarioDef;

    public static ExtentTest features;

    public static String reportLocation = "/Users/karthikkk/extent";
    
    @AfterSuite
    public void tt()
    {
    	 try {
 			Runtime.getRuntime().exec("wscript C:\\Users\\rathna.maram\\Desktop\\rr.vbs ");
 			//Runtime.getRuntime().exec( "cscript E:/Send_Mail_updated.vbs" )
 			
 			//Runtime.getRuntime().exec(new String[] {
 			  //      "wscript.exe", "C:\\path\\example.vbs"
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }


}
