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
	public void TC030_Verify_My_Profile() throws InterruptedException {
		msg("************************My_Profile_Page_Test**************************");
		ob = new My_Profile_Page();
//		login = new Login_Page_Test();
//		login.login();
		try {
			Custom_click(ob.home(), "Home");
			Thread.sleep(2000);
			Custom_click(ob.side_menu_button(), "Side menu button");
			Custom_click(ob.my_profile(), "My profile");
			msg("User name = " + ob.user_name().getText());
			msg("User mobile number =" + ob.user_mobile_no().getText());
			msg("User email =" + ob.user_email().getText());
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 1)
	public void TC031_verify_more_detais_button() {
		try {
			Custom_click(ob.More_details(), "More details");
			ob.user_info();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 2)
	public void TC032_edit_profile_button() {
		try {
			Custom_click(ob.edit_profile_details_button(), "Edit profile details button");
			Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
			try {
				if(ob.Choose_from_library().isDisplayed()==true)
						{
				Custom_click(ob.Choose_from_library(), " Chose profile pic from liberary ");
						}
			}catch(Exception e) {
				msg("while_using_the_app popup is given");
				Custom_click(ob.while_using_the_app(), "while_using_the_app");
				Custom_click(ob.allow(), "Allow");
				Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
				Custom_click(ob.Choose_from_library(), " Chose profile pic from liberary ");
			}
			Thread.sleep(2000);
			driver.navigate().back();
			Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
			Custom_click(ob.Take_a_Photo(), " Take a pic for profile ");
			Thread.sleep(2000);
			driver.navigate().back();
			Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
			Custom_click(ob.upload_close_button(), " Upload close button ");
		} catch(Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 3)
	public void TC033_edit_Personal_Details() throws InterruptedException {
		map = new LinkedHashMap<>();
		try {
			map.put("Name", ob.edit_full_name().getText());
			map.put("Email ID", ob.edit_email_id().getText());
			map.put("Registered mobile number", ob.edit_registered_mobile_number().getText());
			custom_sendkeys(ob.edit_full_name(), config_getdata("edit_name_in_personal_detail"), " Change Name");	
			ob.gender_selection();
			driver.navigate().back();
			custom_sendkeys(ob.edit_email_id(), config_getdata("edit_email_id"), " Change Email id");
			driver.navigate().back(); 												//for pCloudy
//		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB)); 		//for emulator
			Custom_click(ob.edit_date_of_birth(), " Date of Birth");
			Custom_click(ob.DOB_edit_button(), "Edit DOB");
			ob.send_dob().clear();
			custom_sendkeys(ob.send_dob(), config_getdata("edit_DOB"), "change dob in mm/dd/yyyy");
			if (ob.confirm_dob().isEnabled()) {
				Custom_click(ob.confirm_dob(), " Confirm DOB");
			} else {
				msg("DOB is not accepted " + config_getdata("edit_DOB"));
				Custom_click(ob.Cancel_dob(), " Cancel DOB");
			}
			driver.navigate().back(); 													//for pCloudy
			custom_sendkeys(ob.blood_group(), "B+", "Blood group");
			Custom_click(ob.blood_group(), " Blood group");
			Scroll_down_page_Action("Street name");
			custom_sendkeys(ob.Street_name(), "Jindal colony", "Street name");
			driver.navigate().back(); 														//for pCloudy
//			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));			 //for emulator
//			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB)); 			 //for emulator
			Thread.sleep(2000);
			Custom_click(ob.pin_code(), "Pin code");
			ob.pin_code().clear();
			custom_sendkeys(ob.pin_code(), "110027", "Pin code");
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			Custom_click(ob.Save_button(), "Save button");
			try {
				if (ob.More_details().isDisplayed()) {
					msg("Personal Details editd sucessfully");
				}
			} catch(Exception e) {
				Custom_click(ob.Back(), " Back from profile Details");
				Custom_click(ob.More_details(), ob.More_details().getText());
			}
		} catch(Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC033_edit_Personal_Details()", priority = 4)
	public void TC034_change_original_Personal_Details() throws InterruptedException {
		try {
			Custom_click(ob.More_details(), "More details");
			Custom_click(ob.edit_profile_details_button(), "Edit profile details button");
			custom_sendkeys(ob.edit_full_name(), map.get("Name"), " Original Name");
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			driver.navigate().back();
			custom_sendkeys(ob.edit_email_id(), map.get("Email ID"), "Original Email id");
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			driver.navigate().back();
			Custom_click(ob.Save_button(), "Save button");
		} catch(Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 5)
	public void TC035_Manage_License() throws InterruptedException {
		try {
			Custom_click(ob.manage_license(), " Manage License");
			Thread.sleep(2000);
			try {
				msg(ob.License_verify().getText());
				Custom_click(ob.add_Liense_now(), "  Add License now");
				Custom_click(ob.Choose_License_from_library(), "Choose license from Libery");
				Thread.sleep(1000);
				driver.navigate().back();
				Custom_click(ob.add_Liense_now(), "  Add License now");
				Custom_click(ob.Take_License_Photo(), "Take License Photo");
				Thread.sleep(1000);
				driver.navigate().back();
				Custom_click(ob.add_Liense_now(), "  Add License now");
				Custom_click(ob.close_button_for_license_upload(), " Close license upload page");
			} catch(Exception e) {
				msg("Manage License is already given");
			}
			Custom_click(ob.Back(), " Back from Driver License");
		} catch(Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 6)
	public void TC036_Verify_emergency_contacts() throws InterruptedException {
		try {
			Custom_click(ob.emergency_contacts(), "Emergency contacts");
			Thread.sleep(2000);
			try {
				msg("Emergency contacts" + ob.License_verify().getText());
				Custom_click(ob.add_Liense_now(), "  Add Emergency contacts");
				Custom_click(ob.Back(), " Back from Select Contacts page");
			} catch (Exception e) {
				msg("Emergency contacts is already given");
			}
			Custom_click(ob.Back(), " Back from Emergency Contacts page");
			Custom_click(ob.Back(), " Back from profile Details");
			driver.navigate().back();	

		} catch (Exception e) {
			msg("" + e);

		}
	}
}
