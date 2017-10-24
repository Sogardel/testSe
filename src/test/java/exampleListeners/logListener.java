/**
 * 
 */
package exampleListeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import exampleUtils.Global;
import exampleUtils.Log;
import exampleUtils.Screenshot;

/**
 * @author dragos_tanta
 *
 */

public class logListener extends TestListenerAdapter {
	//static WebDriver driver = Driver.selectBrowser();    
	WebDriver driver;
	//TakeScreenshots screenShot = new TakeScreenshots();
	//WebDriver driver;
	public void onFinish(ITestResult  result) {
		// TODO Auto-generated method stub
		Log.endTestCaseFormat(result.getMethod().getMethodName());
	}

	public void onStart(ITestResult result) {
		// TODO Auto-generated method stub
		Log.startTestCaseFormat(result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
			//Global.ScreenShot(result.getMethod().getMethodName());
			Screenshot.ScreenShot(result.getMethod().getMethodName());
			Log.error("Test has failed with following details : "+ result.getThrowable());
		//	Log.endTestCaseFormat(result.getMethod().getMethodName());


	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("The test " + result.getMethod().getMethodName() + "has been skipped!!");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Log.startTestCaseFormat(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Log.endTestCaseFormat("Test " +result.getMethod().getMethodName()+ "has been passed with status " + result.getStatus());
	}

	public void beforeConfiguration(ITestResult result) {
		Log.getBrowser();

	}

}
