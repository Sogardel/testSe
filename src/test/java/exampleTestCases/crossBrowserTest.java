
package exampleTestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exampleProperties.PropertiesLoad;

import org.openqa.selenium.WebDriver;

import exampleUtils.Global;
import exampleUtils.Log;

/**
 * @author dragos
 *
 *
 */


 public class crossBrowserTest {

	// WebDriver driver;
	String appURL = PropertiesLoad.environement.getProperty("PP");

	
	@Test 
	@Parameters("browser")
    public void  selectBrowser(String browsername) throws MalformedURLException {
    	
    	if ( browsername == null) {
    		System.out.println("No browser is defined in browser.properties. Please set a browser");
    		Log.error("No browser is defined in browser.properties. Please set a browser");
    	}
		if(browsername.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "seleniumDrivers//geckodriver");
    	//	driver = new FirefoxDriver();   
            DesiredCapabilities cap =  DesiredCapabilities.firefox();
            cap.setPlatform(Platform.LINUX);
            URL url = new URL("http://10.97.178.217:4444/wd/hub");
            WebDriver driver = new RemoteWebDriver(url, cap);
            driver.get(appURL);
            driver.quit();
       }
    	else if(browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "seleniumDrivers//chromedriver");
            DesiredCapabilities cap =  DesiredCapabilities.chrome();
            cap.setPlatform(Platform.LINUX);
            URL url = new URL("http://10.97.178.217:4444/wd/hub");
            WebDriver driver = new RemoteWebDriver(url, cap);
           // ChromeOptions options = new ChromeOptions();
          //  options.setExperimentalOption("useAutomationExtension", false);
            //driver = new ChromeDriver(options);
            driver.get(appURL);
            driver.quit();
            
            
    	}
/*	    System.out.println(appURL);

    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(800, 600)); //.maximize();
        driver.navigate().to(appURL);
        driver.quit();*/
    }
}
	

