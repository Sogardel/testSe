/**
 * 
 */
package exampleProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 * @author dragos
 *
 */
public class PropertiesLoad {
 
	
	public static Properties user  = loadProperties("properties/user.properties");
	public static Properties environement  = loadProperties("properties/env.properties");
	public static Properties browser  = loadProperties("properties/browser.properties");

	
	private static Properties loadProperties(String filePath) {
		Properties properties = new Properties();
		try {
            FileInputStream f = new FileInputStream(filePath);
            properties.load(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
		return properties;	
	}
	public static String getValue(String path, String value) {
		Properties incarcaValoare = loadProperties(path);
		String rezultat = "";
		Set<String> key = incarcaValoare.stringPropertyNames();
		for (String valoare : key) {
			if (StringUtils.equalsIgnoreCase(valoare, value)){
				rezultat = incarcaValoare.getProperty(valoare);
				break;
			}
		}
		
		return rezultat;
		
	}
	
}
