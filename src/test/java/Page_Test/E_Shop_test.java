package Page_Test;

import org.testng.annotations.Test;

import com.page_object.E_Shop;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class E_Shop_test extends Base_Utility{
	public Login_Page_Test login;
	public E_Shop ob;
	@Test(priority = 0)
	public void registered_customers() throws InterruptedException
	{
		msg("************************E Shop**************************");
		ob = new E_Shop();
		login = new Login_Page_Test();
		login.login();
		Thread.sleep(5000);
		try {
		Custom_click(ob.E_shop(), ob.E_shop().getText());
		Thread.sleep(5000);
		try {
		Custom_click(ob.shoping_cart(), "Shoping Cart list");
		Thread.sleep(2000);
		}catch(Exception e) { System.err.println(e);}
		try {
		msg(ob.shoping_cart_items().getText());
		}catch(Exception e) { System.err.println(e);}
		try {
		Custom_click(ob.wishlist(), "wishlist");
		Thread.sleep(2000);
		}catch(Exception e) { System.err.println(e);}
		try {
		msg("for " +ob.customer_login_heading().getText());
		msg(ob.registered_custombers_message().getText());
		}catch(Exception e) { System.err.println(e);}
		custom_sendkeys(ob.enter_email_or_mobile_number(), "rahul@gmail.com", "Email ID");
		driver.navigate().back();
		Custom_click(ob.Continue_button(), "Continue button");
		msg(ob.verify_mobile().getText());
		msg(ob.verify_mobile_message().getText());
		Custom_click(ob.otp_pop_up_close(), "OTP Pop Up close");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	@Test(priority = 1)
	public void new_customers() {
		try {
		Custom_click(ob.user_account(), "User account");
		msg(ob.newcustomer_heading().getText());
		msg(ob.newcustomer_message1().getText());
		msg(ob.newcustomer_message2().getText());
		msg(ob.newcustomer_message3().getText());
		msg(ob.newcustomer_message4().getText());
		Custom_click(ob.create_account(), ob.create_account().getText());
		custom_sendkeys(ob.firstname(), "Sonu", " First name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		custom_sendkeys(ob.lastname(), "Jindal", " Last name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		Custom_click(ob.CheckBox(), ob.CheckBox().getText());
		custom_sendkeys(ob.mobile(), "9876564534", " Mobile number ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		custom_sendkeys(ob.email_address(), "sonu@gmail.com", " Email ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		Custom_click(ob.checkbox_for_T_and_C(), " Tearms and Condition check Box ");
		Custom_click(ob.OTP(), ob.OTP().getText());
		msg(ob.verify_mobile().getText());
		msg(ob.verify_mobile_message().getText());
		Custom_click(ob.otp_pop_up_close(), "OTP Pop Up close");
		Custom_click(ob.create_an_account(), ob.create_an_account().getText());
		Thread.sleep(2000);
		driver.navigate().back();
		Custom_click(ob.back_button(), "Back from Create New Customer Account");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
