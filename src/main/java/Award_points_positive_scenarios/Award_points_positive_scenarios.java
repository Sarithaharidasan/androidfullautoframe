package Award_points_positive_scenarios;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Reusable_functions.Generic_functions;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Award_points_positive_scenarios extends Generic_functions{
	public static boolean value;
	static String str,text;

	@Given("Application is open")
	public static void app_is_open() {
		try {
			app_launch();
			page_wait(20);
			click("welcome_login");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",6));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",4));
			click("login");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*TC 001 - Validate that the user is able to navigated to Utilities screen */
	@When("User should click on Utilities tab and navigated to Utilities Dashboard")
	public static void Award_point_positive_tc_001() throws IOException{
		try {
			click("utilities");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
			}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_001");
		}	
	}
	
	/*TC 002 - Validate that user can click the Tile "Award Points"in the Utilities dashboard*/
	@When("User should be able to click on Award point tile and to Award points page successfully")
	public static void Award_point_positive_tc_002()throws InterruptedException, IOException {
		try {
			click("utilities_award_points");
			value = driver.findElement(By.xpath(OR_reader("award_points_history_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_002");
		}	

	}

	/*TC 003 - Validate that user is able to redeem points  in the Award points dashboard.*/
	@When("User should be able to click on the Redeem Points button and navigated to redeem award points page")
	public static void Award_point_positive_tc_003() throws IOException {
		try {
			click("awardpoints_redeem_button");
			page_wait(5);
			value = driver.findElement(By.xpath(OR_reader("redeem_award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("award_points_availableassert"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("redeem_points_giftcard");
			text = td_reader("redeem_points_giftcard");
			scrolldown(text);
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",2));
			 value = driver.findElement(By.xpath(OR_reader("award_points_redeemassert"))).isDisplayed();
			 Assert.assertEquals(true,value);
			 scrollAndClick("Email ID");
//			 scrollAndClick("Redeem");
    		}
		  catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_003");
		}
	}
	
	/*TC 004 - Validate that the user is able to navigate to the 'redeemed' page */
	@When("User should be able to navigated to the redeemed page successfully")
	public static void Award_point_positive_tc_004() throws IOException {
		try {
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_redeemed_titleassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_redeem_pointsassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_redeempage_availedassert"))).isDisplayed();
//			Assert.assertEquals(true,value);
//			click("award_points_goto_dashboard");
//			value = driver.findElement(By.xpath(OR_reader("Object Locator", "award_points_history_title"))).isDisplayed();
//			Assert.assertEquals(true,value);
			close();
			}
		   catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_tc_004");
		}
	}
}
