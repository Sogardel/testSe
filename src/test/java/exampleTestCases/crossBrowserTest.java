/**
 * 
 */
package exampleTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import exampleUtils.Log;

/**
 * @author dragos
 *
 *
 */


 public class crossBrowserTest {

	 WebDriver driver;
	
	@Test 
	@Parameters("browser")
    public void  selectBrowser(String browsername) {
    	
    	if ( browsername == null) {
    		System.out.println("No browser is defined in browser.properties. Please set a browser");
    		Log.error("No browser is defined in browser.properties. Please set a browser");
    	}
		if(browsername.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "seleniumDrivers//geckodriver.exe");
    		driver = new FirefoxDriver();   

       }
    	else if(browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "seleniumDrivers//chromedriver.exe");
    		driver = new ChromeDriver();   
    	}
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(800, 600)); //.maximize();
        driver.get("https://www.facebook.com");
        driver.quit();
    }
}
	

