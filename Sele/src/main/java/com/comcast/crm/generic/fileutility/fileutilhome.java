package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileutilhome {

	public String getDataFromPropertiesFile( String key) throws Throwable {
	FileInputStream fis = new FileInputStream("./configAppData/vtigerhome.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String data = pobj.getProperty(key);
	
	return data;
	
}
}
