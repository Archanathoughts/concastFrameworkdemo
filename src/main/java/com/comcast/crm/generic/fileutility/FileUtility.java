package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException 
	{		
			FileInputStream fis = new FileInputStream("./configAppData/commanData.properties");
			Properties pobj=new Properties();
			pobj.load(fis);
			String data = pobj.getProperty(key);
			return data;
		
	}
	public String getDataFromJSONFile(String key) throws IOException, ParseException
	{	FileReader fr=new FileReader("./configAppData/commData.json");
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(fr);
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(key);
		return data;	
	
	}
}
