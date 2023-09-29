package Page_Test;

import org.testng.annotations.Test;

import com.page_object.Home_Page;
import com.page_object.Services_Page;
import com.page_object.Vehicle_Details;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Vehicle_Details_test extends Base_Utility {
	public Vehicle_Details ob;
	public Login_Page_Test login;

	@Test(priority = 0)
	public void TC037_Verify_My_Vehicle() throws InterruptedException {
		msg("*********************My Vehicle page**************************");
		ob = new Vehicle_Details();
		login = new Login_Page_Test();
		login.login();
		try {
		Custom_click(ob.home(), "Home");
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		msg(ob.user_name().getText());
		msg("You are using =" +ob.vehicle_name_1().getText());
		msg(ob.vehicle_number_1().getText());
		Custom_click(ob.Vehicle_details(), "Vehicle Details");
		Custom_click(ob.Selected_vehicle(), ob.Selected_vehicle().getText());
		Custom_click(ob.Selected_vehicle(), ob.Selected_vehicle().getText());
		if (ob.Vehicle_img().isDisplayed()) {
			msg("Vehicle image is present");
		} else {
			msg("Vehicle image is missing");
		}
		try {
		msg("Vehicle status =" + ob.vehicle_status().getText());
		}catch(Exception e) { msg("Vehicle Status is not given");}
		try {
		msg("Vehicle number =" + ob.Vehicle_number().getText());
		}catch(Exception e) { msg("Vehicle number is not given");}
		Custom_click(ob.verify_GoodLife(), " Verify Good Life");
		Thread.sleep(5000);
		msg("verify goodlife page =" +ob.verify_goodlife_page().getText());
		Custom_click(ob.back_button(), " Back from GoodLife page");
		Custom_click(ob.verify_joyRide(), " Verify JoyRide ");
		msg("Verify joyRide page =" +ob.verify_joyRide_page().getText());
		Custom_click(ob.back_button(), " Back from joyRide page");
		}catch(Exception e) 
		{ msg(""+e);
		}
	}

	@Test(priority = 1)
	public void TC038_Verify_My_Vehicle_more_details() {
		try {
		Custom_click(ob.more_details(), ob.more_details().getText());
		ob.vehicle_info();
		Custom_click(ob.nick_name_edit(), "Nick name");
		custom_sendkeys(ob.nick_name_input_field(), config_getdata("nickname"), "Nick name edit");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.save_button(), "Save button");
		Custom_click(ob.more_details(), ob.more_details().getText());
		}catch(Exception e) 
		{ msg(""+e);
		}
	}

	@Test(priority = 2)
	public void TC039_Verify_My_Vehicle_Documents() throws InterruptedException {
		try {
		Custom_click(ob.my_vehicle_documents(), ob.my_vehicle_documents().getText());
		Thread.sleep(2000);
		ob.Documents_list();
		Custom_click(ob.back_button(), " Back from my vehicle documents page");
		}catch(Exception e) 
		{ msg(""+e);
		}
	}

	@Test(priority = 3)
	public void TC040_Verify_Owners_Manual() {
		try {
		Custom_click(ob.owners_manual(), "Owners manual");
		try {
		msg("My Vehicle Owners manual =" +ob.owners_title().getText());
		Custom_click(ob.back_button(), " Back from Owners manual page");
		}catch(Exception e)
		{
			msg("Owner details already given");
			Custom_click(ob.back_button(), " Back from Owners manual page");
		}
		}catch(Exception e) 
		{ msg(""+e);
		}
	}
	@Test(priority = 4)
	public void TC041_Verify_my_Vehicle_service_History() {
		try {
		Custom_click(ob.My_vehicle_Service_history(), "My Vehicle Service history");
		try {
			ob.Service_history();
			Custom_click(ob.back_button(), " Back from Service History page");
			Custom_click(ob.back_button(), " Back from My Vehicle page");
		}catch(Exception e)
		{
			msg("My Vehicle Service history" +ob.owners_title().getText());
			Custom_click(ob.back_button(), " Back from Service History page");
			Custom_click(ob.back_button(), " Back from My Vehicle page");
			
		}
		}catch(Exception e) 
		{ msg(""+e);
		}
	}
	@Test(priority = 5)
	public void TC042_Verify_Tips_and_DIY_videos_inside_sideMenu() throws InterruptedException
	{
		try {
		Custom_click(ob.Tips_and_DIY_videos(), ob.Tips_and_DIY_videos().getText());
		Custom_click(ob.Tips_info(), ob.Tips_info().getText());
		Custom_click(ob.DIY_Videos(), ob.DIY_Videos().getText());
		Custom_click(ob.back_button(), " Back from My Tips page");
		driver.navigate().back();
		}catch(Exception e) 
		{ msg(""+e);
		}
	}
}
