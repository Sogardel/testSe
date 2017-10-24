/**
 * 
 */
package exampleUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exampleProperties.PropertiesLoad;
/**
 * @author dragos
 *
 */
public abstract class Driver {

		public static  WebDriver driver;
    	static String browser = PropertiesLoad.browser.getProperty("browser");

    	
	    public static WebDriver  selectBrowser() {
	    	
	    	if ( browser == null) {
	    		System.out.println("No browser is defined in browser.properties. Please set a browser");
	    		Log.error("No browser is defined in browser.properties. Please set a browser");
	    	}
			if(browser.equalsIgnoreCase("firefox")) {
	            System.setProperty("webdriver.gecko.driver", "seleniumDrivers//geckodriver.exe");
	    		driver = new FirefoxDriver();   

	       }
	    	else if(browser.equalsIgnoreCase("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "seleniumDrivers//chromedriver.exe");
	    		driver = new ChromeDriver();   
	    	}
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        return driver;
	    }
	}

