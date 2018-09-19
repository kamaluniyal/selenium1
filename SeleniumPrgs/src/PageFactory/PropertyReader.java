package PageFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	FileInputStream fileInput;
	Properties prop ;
	PropertyReader(String path) throws IOException{		
		File file = new File(path);
		fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);	
		
	}
	
	String getProperty(String property){
		return prop.getProperty(property);
	}
	
	void setProperty(String property,String value){
		prop.setProperty(property, value);
	}
	
//	//Alternate 
//	PropertyReader(String path) throws IOException{		
//		BufferedReader reader = new BufferedReader(new FileReader(path));
//		prop = new Properties();
//		prop.load(reader);
//		
//	}
	

}
