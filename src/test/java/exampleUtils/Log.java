/**
 * 
 */
package exampleUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exampleProperties.PropertiesLoad;

/**
 * @author dragos_tanta
 * @category this is a log class defined for log4j2 
 *
 */
public class Log {
	/// Initialize Log4j2 
	private static Logger Log = LogManager.getLogger(Log.class.getName()); 
	//constructor
	//public Log(){}	
	/**
	 * @category method to format the log with test case start
	 * @param: can be called as ; log.stratTestCaseFormat("test_case_name")at the begging of the test case
	 */	
	public static void startTestCaseFormat(String startTestCaseName) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++++++++++++ Start of test case: "+ startTestCaseName );
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	/**
	 * @category method to format the log with test case end
	 * @param: can be called as ; log.endTestCaseFormat("test_case_name")at the end of the test case
	 */	
	public static void endTestCaseFormat(String endTestCaseName) {
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++++++++  End of test case: " + endTestCaseName);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	/**
	 * @category method to for the INFO level
	 * @param: can be called as ; log.info("message")anywhere
	 */	
	public static void info(String message) {
		Log.info(message);
	}
	/**
	 * @category method to for the ERROR level
	 * @param: can be called as ; log.info("message")anywhere
	 */	
	public static void error(String message) {
		Log.error(message);
	}
	public static void getBrowser () {
    	String browserR = PropertiesLoad.browser.getProperty("browser");
 		Log.info("Started test suite with browser : " + browserR);

    	 

	}
}
