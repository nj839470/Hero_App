package Page_Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.page_object.Select_Vehicle_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
@Listeners(com.utility.listner.class)

public class Select_Vehicle_Page_Test extends Base_Utility {

	public Select_Vehicle_Page ob;
	public Login_Page_Test login;

	@Test(priority = 0)
	public void TC004_verify_Nick_Name() {
		msg("************************Select_Vehicle_Page_Test**************************");
		ob = new Select_Vehicle_Page();
//		login = new Login_Page_Test();
//		login.login();
		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		VerifyElementPresent(ob.save_button(), "Save button before updating the nick name is ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("nickname"), "Nick Name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.nick_name_close_button(), "Nick name close button ");
		if (ob.Nick_name().getText().equalsIgnoreCase(config_getdata("nickname"))) {
			test.log(Status.PASS, " Nick name saved with close button");
			log.info("Nick name saved with close button ");
		} else {
			test.log(Status.PASS, "Nick name is not saved");
			log.info("Nick name is not saved ");
		}
		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("30_letter_nick_name"), " 30 letter Nick Name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.save_button(), "Save button after updating the 30 letter nick name is ");
		String nick1 = ob.Nick_name().getText();
		if (nick1.length() == 30) {
			test.log(Status.PASS, " = 30 letter nick name are acceptable");
			log.info("30 letter nick name are acceptable ");
		} else {
			test.log(Status.PASS, " = 30 letter nick name are not acceptable");
			log.info("30 letter nick name are not acceptable ");
		}
		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("31_letter_nick_name"), "31 letter Nick Name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.save_button(), "Save button after updating 31 letter nick name the nick name  ");
		String nick2 = ob.Nick_name().getText();
		if (nick2.length() == 31) {
			test.log(Status.PASS, " = 31 letter nick name are acceptable");
			log.info("31 letter nick name are acceptable ");
		} else {
			test.log(Status.PASS, " = 31 letter nick name are not acceptable");
			log.info("31 letter nick name are not acceptable ");
		}
		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("29_letter_nick_name"), "29 letter Nick Name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.save_button(), "Save button after updating the 29 letter nick name  ");
		String nick3 = ob.Nick_name().getText();
		if (nick3.length() == 29) {
			test.log(Status.PASS, " = 29 letter nick name are acceptable");
			log.info("29 letter nick name are acceptable ");
		} else {
			test.log(Status.PASS, " = 29 letter nick name are not acceptable");
			log.info("29 letter nick name are not acceptable ");
		}
		assertEquals(ob.Nick_name().getText(), config_getdata("29_letter_nick_name"));

	}

	@Test(priority = 1)
	public void TC005_Select_Vehicle() throws InterruptedException {
		VerifyElementPresent(ob.continue_button(), "Continue Button before select vehicle is");
		ob.vehicle_count();
		Custom_click(ob.click_first_vehicle(), " Select first vehicle");
		VerifyElementPresent(ob.continue_button(), "Continue Button after select vehicle is");
		Custom_click(ob.continue_button(), "Continue Button after select vehicle");
		Custom_click(ob.While_using_the_app(), "While using the app");
		Thread.sleep(2000);
	//	Custom_click(ob.video_full_video(), "Video full");
	//	Thread.sleep(2000);
	//	Custom_click(ob.video_close_button(), "Vodeo close");

	}
}
