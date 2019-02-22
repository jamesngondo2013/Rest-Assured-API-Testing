package com.james.training.RestAssuredTestingFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class GetDataFromConfigProperties {

	 	protected Properties prop;
	    protected FileInputStream fis;
	    
	    @BeforeTest
	    public void getDataconfigProperties() throws IOException, FileNotFoundException{
	        
	        prop = new Properties();
	       // fis = new FileInputStream("C:\\Users\\I350380\\workspace\\RestAssuredTestingFramework\\src\\main\\java\\com\\config\\files\\config.properties");
	        fis = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
	        prop.load(fis);
	        
	    }
	   
}
