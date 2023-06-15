package Page_Test;

import static org.testng.Assert.assertEquals;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.page_object.Login_page;
import com.page_object.Select_Vehicle_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(com.utility.listner.class)
public class Login_Page_Test extends Base_Utility {

	public Login_page ob;
	public Select_Vehicle_Page ob1;

	@Test(priority = 0)
	public void TC001_Verify_Login_with_Invalid_credential() {
		msg("************************Login page test**************************");
		ob = new Login_page();
		Custom_click(ob.deny(), "Deny");
		Custom_click(ob.allow(), "Allow Now");	
		Custom_click(ob.ok(), "OK");			//this line is for pcloudy	
		Custom_click(ob.Allow(), "Allow notification");  //this line is for pcloudy	
//		driver.findElement(By.xpath("cdshvkdfjk")).click();
	//	Custom_click(ob.open(), "Open");	//This line for real device
//	Custom_click(ob.close(), "Close button"); // for emulator and real device
	}

	@Test(priority = 1)
	public void TC002_invalidmobileno() {
		custom_sendkeys(ob.mobile_No(), config_getdata("invalidmobileno"), "Login with unregisterd mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.continue_button(), "Coninue button enter after unregistered mobile number");
		assertEquals(ob.Wrong_mobile_message().getText(), config_getdata("invalid_message"));
	}

	@Test(priority = 2)
	public void TC003_Verify_Login_with_short_length_of_mobile_number_credential() throws InterruptedException {
		custom_sendkeys(ob.mobile_No(), config_getdata("short_digit_mobile_number"),
				"Login with short_digit_mobile_number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		VerifyElementPresent(ob.continue_button(), "Coninue button enter after short length of mobile number is");
	}

	@Test(priority = 3)
	public void TC004_max_digit_mobile_number() throws InterruptedException {
		custom_sendkeys(ob.mobile_No(), config_getdata("max_digit_mobile_number"),
				"Login with More than 10 digit mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		if (config_getdata("max_digit_mobile_number").equalsIgnoreCase(ob.mobile_No().getText())) {
			msg("More then 10 digit mobile numbers are acceptable");
		} else {
			msg("More then 10 digits mobiles number are not acceptable");
		}
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test(priority = 4)
	public void TC005_Terms_of_use_button() throws InterruptedException {
		Custom_click(ob.Terms_of_Use(), "Terms of use button");
		Thread.sleep(8000);
//		msg("Terms of use: First condition = " + ob.Terms_of_Use_condition().getText());	// For emulator
		msg("Terms of use: First condition = " + ob.Terms_of_Use_condition_for_real_device().getText()); // for real device
		Custom_click(ob.back_page(), "back terms of use page ");
	}

	@Test(priority = 5)
	public void TC006_Privacy_policy() throws InterruptedException {
		Custom_click(ob.Privacy_Policy(), "Privacy Policy");
		Thread.sleep(5000);
//		msg("Privacy policy : First Condition = " + ob.Privacy_Policy_condition().getText());// For emulator
		msg("Privacy policy : First Condition = " + ob.Terms_of_Use_condition_for_real_device().getText());// for real device
		Custom_click(ob.back_page(), "back Privacy Policy page ");
		
	}

	@Test(priority = 6)
	public void TC007_contact_Us() throws InterruptedException {
	//	Scroll_down_page_Action("Contact us");
		Custom_click(ob.contact_us(), "Contact us");
		Thread.sleep(2000);
		Custom_click(ob.contact_via_email(), "contact via email");
		driver.navigate().back();
		driver.navigate().back();
		if(ob.back_page().isDisplayed()!=true)
		{
			driver.navigate().back();
		}
		Custom_click(ob.back_page(), "back Contact us page ");
	}

	@Test(priority = 7)
	public void TC008_Verify_Login_with_valid_credential() throws InterruptedException {
		custom_sendkeys(ob.mobile_No(), config_getdata("mobileno"), "Login with Registerd mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		VerifyElementPresent(ob.continue_button(), "Coninue button is");
		Custom_click(ob.continue_button(), "Coninue button");
		String registered_mob = ob.registered_mobile_no().getText();
		String[] mob = registered_mob.split(" ");
		System.out.println(mob[1]);
		assertEquals(config_getdata("mobileno"), mob[1]);
		Thread.sleep(15000);
	}

	@Test(priority = 8)
	public void TC009_resend_butn() throws InterruptedException {
		VerifyElementPresent(ob.resend_button(), "Resend button is");
		Custom_click(ob.resend_button(), "Resend button");
		Thread.sleep(15000);
	}

	@Test(priority = 9)
	public void TC010_inavalid_OTP() {
		ob.enter_inavalid_OTP();
		Custom_click(ob.verify_button(), "Verify Button");
		VerifyElementPresent(ob.verify_button(), "Verify Button is still");
	}

	@Test(priority = 10)
	public void TC011_edit_moble() throws InterruptedException {
		Custom_click(ob.edit_moble_button(), "Edit Mobile Number");
		custom_sendkeys(ob.mobile_No(), config_getdata("mobileno"), "Login with Registerd mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.continue_button(), "Coninue button");
		Thread.sleep(15000);
		ob.enter_Valid_OTP();
		Custom_click(ob.verify_button(), "Verify Button");
	}

	public void login() {
		ob = new Login_page();
		ob1 = new Select_Vehicle_Page();
		try {
//			Custom_click(ob.deny(), "Deny");
//			Custom_click(ob.allow(), "Allow Now");	// all 3 line for real device
//			Custom_click(ob.open(), "Open");
			Custom_click(ob.close(), "Close button");
			custom_sendkeys(ob.mobile_No(), config_getdata("mobileno"), "Login with Registerd mobile number");
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			Custom_click(ob.continue_button(), "Coninue button");
			Thread.sleep(15000);
			ob.enter_Valid_OTP();
			Custom_click(ob.verify_button(), "Verify Button");
			Thread.sleep(2000);
			// when excute select vehicle page class then need to comment below three line.
			Custom_click(ob1.click_first_vehicle(), " Select first vehicle");
			Custom_click(ob1.continue_button(), "Continue Button after select vehicle");
			Custom_click(ob1.While_using_the_app(), "While using the app");
//			Custom_click(ob1.video_close_button(), "Vodeo close");
		} catch (Exception e) {
			System.out.println("Problem with login" + e);
		}

	}

}