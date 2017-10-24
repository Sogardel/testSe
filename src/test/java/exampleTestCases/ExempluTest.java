package exampleTestCases;
import exampleProperties.PropertiesLoad;
import org.testng.annotations.Test;

import examplePages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import exampleUtils.Driver;
import exampleUtils.Global;
import exampleUtils.Log;

/**
 * @author dragos_tanta
 * @category this is an example class for usage of the log class defined for log4j2 
 *
 */

@Listeners(exampleListeners.logListener.class)
public class ExempluTest {

		//WebDriver driver = Driver.selectBrowser();
  //  String appURL = "http://www.antena3.ro";
		String appURL = PropertiesLoad.environement.getProperty("DEV");

	    @BeforeClass
	   	    public void setUp(){
	    	WebDriver driver = Driver.selectBrowser();
	    	
	    	    }
		
		
		
    @Test
    public void testSetUp() {
    //	Log.startTestCaseFormat("testSetUp");
       // System.setProperty("webdriver.gecko.driver", "seleniumDrivers//geckodriver.exe");
        //driver= new FirefoxDriver();
    	//driver = Driver;
    	Global.openURL(appURL);
    	System.out.println("Thread id = " + Thread.currentThread().getId());  
        System.out.println();
      //  Log.info("Instantiate the Firefox driver");
        //driver.get(appURL);
       // Log.info("Navigate to the following site :" + appURL);
      //  String browswerTitle = driver.getTitle();
    //    Log.info("Read the browser title and the title is : " + browswerTitle);
    }
    
    @Test(dependsOnMethods={"testSetUp"},alwaysRun =true)
    public void Secodtest() throws IOException {
    	System.out.println("al doilea test");
    	String username = PropertiesLoad.user.getProperty("username");
    	String env = PropertiesLoad.environement.getProperty("DEV");
    	Assert.assertTrue(true);

    //    String browswerTitle = driver.getTitle();
    //	Assert.assertTrue(browswerTitle.contains("Antena2"));
    	System.out.println("Username este :" + username);
        Log.info("environement este :" + env);
	//	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// now copy the  screenshot to desired location using copyFile //method
		//FileUtils.copyFile(src, new File("screenshots\\" + "testSetUp" + ".png"));
    }
    @Test(dependsOnMethods={"testSetUp"},alwaysRun =true)
    public void thirdTest() {
    	System.out.println("al doilea test");
    	Assert.assertTrue(true);
    	String username = PropertiesLoad.user.getProperty("username");
    	String env = PropertiesLoad.environement.getProperty("DEV");

    	System.out.println("Username este :" + username);
        Log.info("environement este :" + env);
    	
    }
    @Test(dependsOnMethods={"thirdTest"},alwaysRun = true)
    public void fourTest() {
    	HomePage homePage = new HomePage();
    	homePage.ReadTitle();
    }


	@AfterClass
    public void tearDown() {
		Global.closeBrowser();

    }
}
