package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	//
	public java.lang.String getDataFromPropertiesFile(String Key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./configAppData/vtiger.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String data =pobj.getProperty(Key);
		
		
		return data;
	}

}
