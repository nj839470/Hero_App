package Page_Test;

import static org.testng.Assert.assertEquals;

import org.asynchttpclient.util.Assertions;
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

	@Test(priority = 2)
	public void TC003_Verify_Login_with_valid_credential() throws InterruptedException {
		custom_sendkeys(ob.mobile_No(), config_getdata("mobileno"), "Login with Registerd mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		VerifyElementPresent(ob.continue_button(), "Coninue button is");
		Custom_click(ob.continue_button(), "Coninue button");
		String registered_mob = ob.registered_mobile_no().getText();
		String[] mob = registered_mob.split(" ");
		System.out.println(mob[1]);
		assertEquals(config_getdata("mobileno"), mob[1]);
		Thread.sleep(15000);
		VerifyElementPresent(ob.resend_button(), "Resend button is");
		Custom_click(ob.resend_button(), "Resend button");
		Thread.sleep(15000);
		ob.enter_inavalid_OTP();
		Custom_click(ob.verify_button(), "Verify Button");
		VerifyElementPresent(ob.verify_button(), "Verify Button is still");
		Custom_click(ob.edit_moble_button(), "Edit Mobile Number");
		custom_sendkeys(ob.mobile_No(), config_getdata("mobileno"), "Login with Registerd mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.continue_button(), "Coninue button");
		Thread.sleep(15000);
		ob.enter_Valid_OTP();
		Custom_click(ob.verify_button(), "Verify Button");
	}

	@Test(priority = 0)
	public void TC001_Verify_Login_with_Invalid_credential() {
		msg("************************Login page test**************************");
		ob = new Login_page();
		Custom_click(ob.close(), "Close button");
		custom_sendkeys(ob.mobile_No(), config_getdata("invalidmobileno"), "Login with unregisterd mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.continue_button(), "Coninue button enter after unregistered mobile number");
		assertEquals(ob.Wrong_mobile_message().getText(), config_getdata("invalid_message"));

	}

	@Test(priority = 1)
	public void TC002_Verify_Login_with_short_length_of_mobile_number_credential() throws InterruptedException {
		custom_sendkeys(ob.mobile_No(), config_getdata("short_digit_mobile_number"),
				"Login with short_digit_mobile_number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		VerifyElementPresent(ob.continue_button(), "Coninue button enter after short length of mobile number is");
		custom_sendkeys(ob.mobile_No(), config_getdata("max_digit_mobile_number"),
				"Login with More than 10 digit mobile number");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		if (config_getdata("max_digit_mobile_number").equalsIgnoreCase(ob.mobile_No().getText())) {
			log.info("More then 10 digit mobile numbers are acceptable");
			test.log(Status.PASS, " More then 10 digit mobile numbers are acceptable");
		} else {
			log.info("More then 10 digits mobiles number are not acceptable");
			test.log(Status.PASS, " More then 10 digit mobile numbers are not acceptable");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		Custom_click(ob.Terms_of_Use(), "Terms of use button");
		Thread.sleep(8000);
		msg("Terms of use: First condition = " +ob.Terms_of_Use_condition().getText());
		Custom_click(ob.back_page(), "back terms of use page ");
		Custom_click(ob.Privacy_Policy(), "Privacy Policy");
		Thread.sleep(8000);
		msg("Privacy policy : First Condition = "+ob.Privacy_Policy_condition().getText());
		Custom_click(ob.back_page(), "back Privacy Policy page ");
		Custom_click(ob.contact_us(), "Contact us");
		Thread.sleep(2000);
		Custom_click(ob.contact_via_email(), "contact via email");
		driver.navigate().back();
		Custom_click(ob.back_page(), "back Contact us page ");
	}

	public void login() {
		ob = new Login_page();
		ob1 = new Select_Vehicle_Page();
		try {
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