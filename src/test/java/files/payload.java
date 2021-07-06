package files;

public class payload {

	
	public static String AddPlace()
	
	{
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
		
		
	}

	public static String Addbook(String isbn, String aisle) {
		String payload="{\r\n" +
						" \"name\" : \"Learn Appium Automation with Java\",\r\n" +
						" \"isbn\":  \""+isbn+"\",\r\n" +
						" \"aisle\":\""+aisle+"\",\r\n" +
						" \"author\":\"John foe\"\r\n" +
						"}\r\n" + 
						"";
		// TODO Auto-generated method stub
		return payload;
	}
	
	public static String Deletebook(String id) {
		String payload="{\r\n" +
						" \"ID\" : \""+id+"\",\r\n" +
						"}\r\n" + 
						"";
		// TODO Auto-generated method stub
		return payload;
	}

	
}
