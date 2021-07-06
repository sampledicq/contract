package com.ContractTesting.ConversionService;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ResuableLibrary.ResuableComponents;
import baseTestPackage.BaseTest_TestNG;


public class CurrencyConversionServiceApplicationTestsEndPoint extends BaseTest_TestNG{


	
	static String response;	
	static String Url;
	ResuableComponents resuableComponents=new ResuableComponents();
	
	@BeforeClass
	public void initialize()
	{
		Url=System.getProperty("url");
	}
	@Test
	public void given_WhenConvertingFromUSDtoINR_ThenReturn() throws Exception {
		Url=System.getProperty("url");
		test = report.startTest("USD to INR Convertor Mock");
		freezeTestDataRow(this.getClass().getSimpleName());
		response = getValue("ExpectedResponse");
		System.out.println("Url"+Url);
		String res= given().when().get(Url+":8100/currency-exchange/from/USD/to/INR").then().extract().asString();
	System.out.println("res--------------------------------------"+res);
		String actualResponse=res;
		test.log(LogStatus.INFO, "Validating actualResponse ---->"+actualResponse );
		resuableComponents.validateResponse (actualResponse,response,test);
		JSONArray array = new JSONArray("["+actualResponse+"]");  
		System.out.println(array);
		for(int i=0; i < array.length(); i++)   
		{  
		JSONObject object = array.getJSONObject(i);  
//		System.out.println("Enter");
//		System.out.println(object);
		System.out.println(object.get("id"));  
		System.out.println(object.get("from"));  
		resuableComponents.validateContract("id",object.get("id").toString(),"int",test);
		resuableComponents.validateContract("from",object.get("from").toString(),test);
		resuableComponents.validateContract("to",object.get("to").toString(),test);
		
		
		}  
	}
		@Test
		public void given_WhenConvertingFromUSDtoINR_ThenReturn2() throws Exception {
			Url=System.getProperty("url");
			test = report.startTest("USD to INR Convertor Mock");
			freezeTestDataRow(this.getClass().getSimpleName());
			response = getValue("ExpectedResponse");
			String res= given().when().get(Url+":8100/currency-exchange/from/USD/to/INR").then().extract().asString();
		System.out.println("response 2 checker--------------------------------------"+res);
			String actualResponse=res;
			test.log(LogStatus.INFO, "Validating actualResponse ---->"+actualResponse );
			resuableComponents.validateResponse (actualResponse,response,test);
			JSONArray array = new JSONArray("["+actualResponse+"]");  
			System.out.println(array);
			for(int i=0; i < array.length(); i++)   
			{  
			JSONObject object = array.getJSONObject(i);  
			System.out.println("Enter");
			System.out.println(object);
			System.out.println(object.get("id"));  
			System.out.println(object.get("from"));  
			resuableComponents.validateContract("id",object.get("id").toString(),"int",test);
			resuableComponents.validateContract("from",object.get("from").toString(),test);
			resuableComponents.validateContract("to",object.get("to").toString(),test);
			
			
			}  
		}	
	
	
}
