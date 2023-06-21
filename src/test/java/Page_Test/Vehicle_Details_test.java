package Page_Test;

import org.testng.annotations.Test;

import com.page_object.Home_Page;
import com.page_object.Vehicle_Details;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Vehicle_Details_test extends Base_Utility {
	public Vehicle_Details ob;
	public Home_Page hp;
	public Login_Page_Test login;

	@Test(priority = 0)
	public void TC034_Verify_My_Vehicle() throws InterruptedException {
		msg("*********************My Vehicle page**************************");
		ob = new Vehicle_Details();
		hp = new Home_Page();
		login = new Login_Page_Test();
		login.login();
		Custom_click(ob.home(), "Home");
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.Vehicle_details(), "Vehicle Details");
		Custom_click(ob.Selected_vehicle(), ob.Selected_vehicle().getText());
		Custom_click(ob.Selected_vehicle(), ob.Selected_vehicle().getText());
		if (ob.Vehicle_img().isDisplayed()) {
			msg("Vehicle image is present");
		} else {
			msg("Vehicle image is missing");
		}
		msg("Vehicle status =" + ob.vehicle_status().getText());
		msg("Vehicle number =" + ob.Vehicle_number().getText());
		Custom_click(ob.verify_GoodLife(), " Verify Good Life");
		msg("verify goodlife page =" +ob.verify_goodlife_page().getText());
		Custom_click(ob.back_button(), " Back from GoodLife page");
		Custom_click(ob.verify_joyRide(), " Verify JoyRide ");
		msg("Verify joyRide page =" +ob.verify_joyRide_page().getText());
		Custom_click(ob.back_button(), " Back from joyRide page");
	}

	@Test(priority = 1)
	public void TC035_Verify_My_Vehicle_more_details() {
		Custom_click(ob.more_details(), ob.more_details().getText());
		ob.vehicle_info();
		Custom_click(ob.nick_name_edit(), "Nick name");
		custom_sendkeys(ob.nick_name_input_field(), config_getdata("nickname"), "Nick name edit");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.save_button(), "Save button");
		Custom_click(ob.more_details(), ob.more_details().getText());
	}

	@Test(priority = 2)
	public void TC036_Verify_My_Vehicle_Documents() throws InterruptedException {
		Custom_click(ob.my_vehicle_documents(), ob.my_vehicle_documents().getText());
		hp.Documents_list();
		Custom_click(ob.back_button(), " Back from my vehicle documents page");
	}

	@Test(priority = 3)
	public void TC037_Verify_Owners_Manual() {
		Custom_click(ob.owners_manual(), "Owners manual");
		msg("My Vehicle Owners manual =" +ob.owners_title().getText());
		Custom_click(ob.back_button(), " Back from Owners manual page");
	}
	@Test(priority = 4)
	public void TC038_Verify_my_Vehicle_service_History() {
		Custom_click(ob.My_vehicle_Service_history(), "My Vehicle Service history");
		msg("My Vehicle Service history" +ob.owners_title().getText());
		Custom_click(ob.back_button(), " Back from Service History page");
		Custom_click(ob.back_button(), " Back from My Vehicle page");
	}
}
