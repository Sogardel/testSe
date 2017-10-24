/**
 * 
 */
package exampleUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestException;
import org.testng.annotations.BeforeClass;

/**
 * @author dragos
 *
 */
public  class Global extends Driver{

	//public static WebDriver driver = Driver.selectBrowser();  


	
//	public static WebDriver driver;

	public Select select;
	

	public static void openURL(String URL) {
		try {
			Log.info("Trying to lucnch the url :" + URL);
			driver.navigate().to(URL);
			Log.info("URL" + URL + "opened!");
		}
		catch(Exception e) {
			Log.error("ERROR : Unable to load URL" + URL);
			Log.error("Error " + e.getStackTrace());
			throw new TestException("Unable to load URL");

		}
	}
	
	
    public static void ScreenShot(String testCaseName){
				try {
					// Take screenshot and store as a file format
					TakesScreenshot ts= ((TakesScreenshot)driver);
					File src = ts.getScreenshotAs(OutputType.FILE);
					String screenshotFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
					FileUtils.copyFile(src, new File("./screenshots/" + testCaseName+ "_" + screenshotFileName +  ".png"));
					Log.info("Screenshot : "+ testCaseName+ "_" + screenshotFileName +  ".png" + "saved to screenshots folder");
					}
				catch (Exception e)
					{
					Log.error("Screenshot cannot be taken due to the follwoing error: "+ e.getMessage());
					System.out.println("Screenshot cannot be taken due to the follwoing error: " +e.getMessage());
					}
	} 
    
    public static void closeBrowser() {
			    	Log.info("Call the quit browser on the @AfterClass");	    	
			    	try {
			    		driver.quit();
			    		Log.info("Browser was closed!");
			    	}
			    	catch(Exception e) {
			    		Log.error("Browser was not closed due to the : " + e.getMessage());
			    	}
			    	Log.endTestCaseFormat("tearDown");
			    	
    }

}
