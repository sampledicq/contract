package baseTestPackage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import TestDataExternalization.TestDataManagement;

public class BaseTest_TestNG extends TestDataManagement{
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeClass
	public static void startTest() throws Exception
	{
		File f=new File(".");
		loadTestDataFile();
		 Date date = Calendar.getInstance().getTime();  
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");  
	     String strDate = dateFormat.format(date); 
	    	File reportFile=new File(f.getCanonicalPath()+"\\ExtentReport\\ExtentReportResults1_"+strDate+".html");
	        if(!reportFile.exists()){
	       	 reportFile.createNewFile();
	        }
	    report = new ExtentReports(f.getCanonicalPath()+"\\ExtentReport\\ExtentReportResults1_"+strDate+".html",true);
	}
	
	@AfterClass
	public static void endTest() throws Exception
	{
	report.endTest(test);
	report.flush();
	}
}