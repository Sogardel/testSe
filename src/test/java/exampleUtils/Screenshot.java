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

/**
 * @author dragos
 *
 */
public class Screenshot extends Driver {
	
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

}
