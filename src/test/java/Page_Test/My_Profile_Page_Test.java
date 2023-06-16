package Page_Test;

import java.util.LinkedHashMap;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.My_Profile_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(com.utility.listner.class)
public class My_Profile_Page_Test extends Base_Utility {
	public Map<String, String> map;
	public Login_Page_Test login;
	public My_Profile_Page ob;

	@Test(priority = 0)
	public void TC026_Verify_My_Profile() throws InterruptedException {
		msg("************************My_Profile_Page_Test**************************");
		ob = new My_Profile_Page();
		login = new Login_Page_Test();
		login.login();
		Custom_click(ob.home(), "Home");
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.my_profile(), "My profile");
		msg("User name = " + ob.user_name().getText());
		msg("User mobile number =" + ob.user_mobile_no().getText());
		msg("User email =" + ob.user_email().getText());
	}

	@Test(priority = 1)
	public void TC027_verify_more_detais_button() {
		Custom_click(ob.More_details(), "More details");
		ob.user_info();
	}

	@Test(priority = 2)
	public void TC028_edit_prifile_button() {
		Custom_click(ob.edit_profile_details_button(), "Edit profile details button");
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		if (ob.Choose_from_library().isDisplayed() != true) {
			Custom_click(ob.while_using_the_app(), "while_using_the_app");
			Custom_click(ob.allow(), "Allow");
			Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		}

		Custom_click(ob.Choose_from_library(), " Chose profile pic from liberary ");
		driver.navigate().back();
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		Custom_click(ob.Take_a_Photo(), " Take a pic for profile ");
		driver.navigate().back();
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		Custom_click(ob.upload_close_button(), " Upload close button ");

	}
	@Test(priority = 3)
	public void TC028_edit_Personal_Details() throws InterruptedException {
		map = new LinkedHashMap<>();
		map.put("Name", ob.edit_full_name().getText());
		map.put("Email ID", ob.edit_email_id().getText());
		map.put("Registered mobile number", ob.edit_registered_mobile_number().getText());
		custom_sendkeys(ob.edit_full_name(), config_getdata("edit_name_in_personal_detail"), " Change Name");
		ob.gender_selection();
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		custom_sendkeys(ob.edit_email_id(), config_getdata("edit_email_id"), " Change Email id");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
//		custom_sendkeys(ob.edit_registered_mobile_number(), config_getdata("edit_registered_mobile_number"),
//				" Change registered mobile number");
		Custom_click(ob.edit_date_of_birth(), " Date of Birth");
		Custom_click(ob.DOB_edit_button(), "Edit DOB");
		custom_sendkeys(ob.send_dob(), config_getdata("edit_DOB"), "change dob in mm/dd/yyyy");
		Custom_click(ob.confirm_dob(), " Confirm DOB");
		custom_sendkeys(ob.blood_group(), "B+", "Blood group");
		Custom_click(ob.blood_group(), " Blood group");
		Scroll_down_page_Action("Street name");
		custom_sendkeys(ob.Street_name(), "Jindal colony", "Street name");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		custom_sendkeys(ob.pin_code(), "110030", "Pin code");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.Save_button(), "Save button");

	}
	@Test(dependsOnMethods = "TC028_edit_Personal_Details()",priority = 4)
	public void TC028_change_original_Personal_Details() throws InterruptedException {
		Custom_click(ob.More_details(), "More details");
		Custom_click(ob.edit_profile_details_button(), "Edit profile details button");
//		System.out.println(map.get("Name"));
		custom_sendkeys(ob.edit_full_name(), map.get("Name"), " Original Name");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		custom_sendkeys(ob.edit_email_id(), map.get("Email ID"), "Original Email id");
//		custom_sendkeys(ob.edit_registered_mobile_number(), map.get("Registered mobile number"),
//				"Original registered mobile number");
		Custom_click(ob.Save_button(), "Save button");
		Thread.sleep(2000);
		Custom_click(ob.Back(), " Back from profile Details");
		Custom_click(ob.close_my_profile_page(), " close my profile page ");
	}
}
