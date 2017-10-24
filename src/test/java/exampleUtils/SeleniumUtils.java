/**
 * 
 */
package exampleUtils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.TestException;
import org.testng.annotations.BeforeClass;

/**
 * @author dragos
 *
 */
public abstract class SeleniumUtils extends Driver {
	
	public static int timeout =10;
	

//	public SeleniumUtils() {
	//	driver = Driver.selectBrowser();
//	}

	//public static WebDriver driver;
	
	
				public void navigateBack() {
							try {
									driver.navigate().back();
									Log.info("called navigate back function!");
								}
							catch(Exception e) {
									Log.error("Unable to navigate back to previous page.!");
									Log.error("Error : " + e);
									throw new TestException("Unable to navigate back to previous page.");
								}	
				}

				public void navigateForward() {
							try {
								driver.navigate().forward();
								Log.info("called <navigateForward> function!");
							}
							catch(Exception e) {
								Log.error("Error on function <navigateForward>");
								Log.error("Error : " + e);
								throw new TestException("Unable to navigate forward.");
							}
				}
				public void browserRefresh() {
							try {
								driver.navigate().refresh();
								Log.info("called <browserRefresh> function!");
							}
							catch(Exception e) {
								Log.error("Error on function <browserRefresh>");
								Log.error("Error : " + e);
								throw new TestException("nable to perform browser refresh !");
							}
				}
				public  String getPageTitle() {
							try {
								String actualTitle=driver.getTitle();
								Log.info("called function <getPageTitle> and current page title is: "+ driver.getTitle().toString());
								String expectedTitle = "Antena2 - Speciali?ti în ?tiri";
								assertEquals(actualTitle, expectedTitle);
							}
							catch(Exception e) {
								Log.error("Error in function <getPageTitle>");
								Log.error("Error : " + e);
					            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));

							}
							return driver.getTitle();
				}
							

		}

