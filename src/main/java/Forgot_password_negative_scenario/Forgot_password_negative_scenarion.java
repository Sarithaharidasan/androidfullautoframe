package Forgot_password_negative_scenario;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Forgot_password_negative_scenarion extends Generic_functions{
	static boolean value;
	public static String str;
	
	/* Application  is launching using appium, navigating to Landing Welcome Page and clicking on login button  */
	@Given("App is open")
	public static void app_launching() throws Exception{
			app_launch();
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
	}
	
	/*TC_001 Validate that the user get the validation message when Phone number field is blank */
	@Then("User get the validation message when Phone number field is blank")
	public static void forgot_password_negative_tc_001() throws InterruptedException, IOException  {
		try {
			page_wait(20);
			click("welcome_login");	
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("forgot_password_link");	
			click("forgot_phone_number");
			click("send_resend_link");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("forgot_phonno_requ_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_phoneno_required_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_001");
		}
	}

	/* TC_002 Validate that the user get the validation message on entering less than ten digit phone number */
	@Given("User get the validation message on entering less than ten digit phone number")
	public static void forgot_password_negative_tc_002() throws IOException {
		try {
			page_back();
			click("welcome_login");
			click("forgot_password_link");
			click("forgot_phone_number");
			driver.findElement(By.xpath(OR_reader("forgot_phone_number"))).sendKeys(td_reader("forgot_phone_number",1));
			click("forgot_phone_number");
			click("send_resend_link");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("forgot_phoneno_less_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_less_no_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_002");
		}
	}

	/* TC_003 Validate that the user get the validation message on entering more than ten digit phone number */
	@Given("User get the validation message on entering more than ten digit phone number")
	public static void forgot_password_negative_tc_003() throws IOException {
		try {
			page_back();
			click("welcome_login");
			click("forgot_password_link");
			click("forgot_phone_number");
			driver.findElement(By.xpath(OR_reader("forgot_phone_number"))).sendKeys(td_reader("forgot_phone_number",2));
			click("forgot_phone_number");
			click("send_resend_link");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("forgot_phoneno_less_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_less_no_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_003");
		}
	}
	
	/* TC_004 Validate that the Send Reset Link button is disabled when Phone number field is blank */
	@Then("Send Reset Link button is disabled when Phone number field is blank")
	public static void forgot_password_negative_tc_004() throws IOException {
		try {
			page_back();
			page_wait(20);
			click("welcome_login");
			page_wait(20);
			click("forgot_password_link");
			click("forgot_phone_number");
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("send_resend_link"))).isEnabled(),true);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_004");
		}		
	}

	/* TC_005 Validate that the user should able to get a validation message on entering non registered phone number in the phone number field */
	@Then("User should able to get a validation message on entering non registered phone number in the phone number field")
	public static void forgot_password_negative_tc_005() throws IOException {
		try {
			page_wait(20);
			page_back();
			page_back();
			page_wait(20);
			click("welcome_login");
			click("forgot_password_link");
			click("forgot_phone_number");
			driver.findElement(By.xpath(OR_reader("forgot_phone_number"))).sendKeys(td_reader("forgot_phone_number",3));
			click("forgot_phone_number");
			click("send_resend_link");
			click("send_resend_link");
			page_wait(10);
			str= driver.findElement(By.xpath(OR_reader("forgot_nonreg_no_msg"))).getText();
			Assert.assertEquals(str,td_reader("forgot_nonreg_no_msg"));
			page_wait(30);
			System.out.println("forgot password negative");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("forgot_password_negative_tc_005");
		}
		driver.closeApp();
	}
	
}
