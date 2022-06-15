package generic_Utility;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFile_Utility 
{
public String getPropertykey(String key) throws Throwable
{
	FileInputStream fis= new FileInputStream("./testfolder/test.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String value = pro.getProperty(key);
	return value;
}
	

}
