package pageClass;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	public String fetchdata(String key) throws Throwable
	{
	 Properties prop=new Properties();
	 FileInputStream file=new FileInputStream("D:\\Asvanth\\qspiders\\selenium\\selenium\\SeleniumAutomation\\config.properties");
	 prop.load(file);
	 String data=prop.getProperty(key);
	 return data;
	}
}
