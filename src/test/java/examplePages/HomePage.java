
package examplePages;


import exampleUtils.SeleniumUtils;


public class HomePage extends SeleniumUtils{
		
	
	public HomePage() {
		
	}
	public void ReadTitle() {
		getPageTitle("expectTitle");
	}

}
