package ResuableLibrary;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;

public class ResuableComponents{
	public void validateResponse(String actualResponse,String expectedResponse,ExtentTest test) throws UnsupportedEncodingException {
		test.log(LogStatus.INFO, "Expected Response is ------->   "+expectedResponse);
		test.log(LogStatus.INFO, "Actual Response is ------->   "+actualResponse);
		if(actualResponse.replaceAll(" ", "").equalsIgnoreCase(expectedResponse.replaceAll(" ", "")))
			test.log(LogStatus.PASS, "Test Passed");
		else
			test.log(LogStatus.FAIL, "Test Failed");
	}
	public void validateJSONResponse(String actualResponse,String expectedValue,String strJsonPath,ExtentTest test){
		JsonPath jsonPath = new JsonPath(actualResponse);
		 String strActualValue = jsonPath.getString(strJsonPath);
		 if(expectedValue.equalsIgnoreCase(strActualValue)){
			 test.log(LogStatus.PASS, "Test Passed");
			 }
		else{
			test.log(LogStatus.FAIL, "Test Failed"); 
		 }
	}
	public void validateXMLResponse(String actualResponse,String expectedValue,String strJsonPath,ExtentTest test){
		XmlPath xmlPath = new XmlPath(actualResponse);
		 String strActualValue = xmlPath.getString(strJsonPath);
		 if(expectedValue.equalsIgnoreCase(strActualValue)){
			 test.log(LogStatus.PASS, "Test Passed");
			 }
		else{
			test.log(LogStatus.FAIL, "Test Failed"); 
		 }
	}
	public void validateContract(String strField,String strFieldValue, String strDataType,ExtentTest test){
		test.log(LogStatus.INFO, "Validation for the field '"+strField+"' starts----------->");
			if(NumberUtils.isNumber(strFieldValue)){
				test.log(LogStatus.PASS, "Validation for the field '"+strField+"' is successfull. It is an Integer Value as expected----------->");
			}else{
				test.log(LogStatus.FAIL, "Validation for the field '"+strField+"' is not successfull. It is not an Integer Value----------->");
			}
		
	}
	public void validateContract(String strField,String strFieldValue, ExtentTest test){
		test.log(LogStatus.INFO, "Validation for the field '"+strField+"' starts----------->");
		if(StringUtils.isAlpha(strFieldValue)){
				test.log(LogStatus.PASS, "Validation for the field '"+strField+"' is successfull. It is a String Value as expected----------->");
			}else{
				test.log(LogStatus.FAIL, "Validation for the field '"+strField+"' is not successfull. It is not a String Value----------->");
			}
		
	}
}
