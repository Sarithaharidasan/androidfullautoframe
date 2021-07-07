package Help_positive_scenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Help_positive_scenarios extends Generic_functions {
	public static boolean value;
	/*Application launch*/
	@Given("App is open")
	public void app_is_open() {
		try {
			app_launch();
			page_wait(20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*TC 001 - Validate that the  'Frequently asked questions’ title  should be present in  Help page*/
	@Then("check  the  Frequently asked questions title  should be present in  Help page")
	public void help_positive_tc_001() throws Exception  {
		try {
			
			click("welcome_login");
			driver.findElement(By.xpath(OR_reader( "login_phone_number"))).sendKeys(td_reader("login_phone_number",0));
			driver.findElement(By.xpath(OR_reader( "login_password"))).sendKeys(td_reader("login_password",0));
			page_wait(10);
			click("login");
			Thread.sleep(1000);
			click("home_first_tile");
			page_wait(50);
			value=driver.findElement(By.xpath(OR_reader( "home_dashboard_back_arrow"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("home_dashboard_back_arrow");
			click("hamburger");
			page_wait(20);
			click("header_faq");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("header_faq_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("help_positive_tc_001");
		}
		 
	}
	
	/*TC 002 - Validate that the 'Second Opinions' title  should be present  and able to see description , when user click on Second Opinions title */
	@Then("check able to see description , when user click on Second Opinions title")
	public void help_positive_tc_002() {
		try {
			value=driver.findElement(By.xpath(OR_reader( "help_secondopinions_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("help_secondopinions_click");
			page_wait(20);
			value=driver.findElement(By.xpath(OR_reader( "help_secondopinions_des"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*TC 003 - Validate that the 'Award Points' title  should be present  and able to see description , when user click on Award Points title  */
	@Then("check able to see description , when user click on Award Points title")
	public void help_positive_tc_003() {
		
	    	}


}
