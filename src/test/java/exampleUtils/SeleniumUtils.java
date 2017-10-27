
package exampleUtils;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;


public abstract class SeleniumUtils extends Driver {
	
	public static int timeout =10;

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
				public  String getPageTitle( String expectTitle ) {
							try {
								String actualTitle=driver.getTitle();
								Log.info("called function <getPageTitle> and current page title is: "+ driver.getTitle().toString());
								String expectedTitle = expectTitle;
								assertEquals(actualTitle, expectedTitle);
								return driver.getTitle();

							}
							catch(Exception e) {
								Log.error("Error in function <getPageTitle>");
								Log.error("Error : " + e);
					            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
							}
				}
				
				public WebElement getElement(By selector) {
					        try {
								Log.info("called function <getElement> on selector: "+ selector);
					            return driver.findElement(selector);
					        } catch (Exception e) {
					            System.out.println(String.format("Element " + selector +" does not exist"));
					        }
					        return null;
			    }
			   public List <WebElement> getElements(By Selector) {
					        waitForElementToBeVisible(Selector);
					        try {
					            return driver.findElements(Selector);
					        } catch (Exception e) {
					            throw new NoSuchElementException(String.format("The following element did not display: [%s] ", Selector.toString()));
					        }
					    }

				public void waitForElementToBeVisible(By selector) {
							try {
								WebDriverWait wait = new WebDriverWait(driver, timeout);
								wait.until(ExpectedConditions.presenceOfElementLocated(selector));
							}
							catch(Exception e) {
							  throw new NoSuchElementException(String.format("The element was not visible: " + selector));
							}				
							
				}			

		}

