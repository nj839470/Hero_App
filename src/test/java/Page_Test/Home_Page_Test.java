package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.page_object.Home_Page;
import com.page_object.Services_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(com.utility.listner.class)
public class Home_Page_Test extends Base_Utility {

	public Login_Page_Test login;
	public Home_Page ob;

	@Test(priority = 0)
	public void TC017_Home_page_verify() throws InterruptedException {
		msg("************************Home_Page_Test**************************");
		ob = new Home_Page();
//		login = new Login_Page_Test();
//		login.login();
		try {
			Thread.sleep(5000);
			msg("Current Temperature is =" + ob.temperature().getText());
			VerifyElementPresent(ob.vehicle_img(), "Vehicle Img is");
			Thread.sleep(2000);
			ob.all_vehicle_inside_drop_down();
			Custom_click(ob.Collapse_btn(), "Collapse button");
			Thread.sleep(2000);
			Custom_click(ob.Collapse_btn(), " Return collapse button");
			Thread.sleep(2000);
			Custom_click(ob.notification(), "Notification");
			msg("Total Notification are=" + ob.notification_count());
			Custom_click(ob.notification_back(), "Notification back");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 1)
	public void TC018__verify_Navigate() {
		Custom_click(ob.Navigate_menu(), "Navigate menu");
		// Please comment out from line no 50 to 54 for When script execute from pcloudy
		try {
			Custom_click(ob.While_using_the_app(), "While using the app");
		} catch (Exception e) {
			msg("While Using the app pop up did not come");
		}
		Custom_click(ob.Search_destination(), "Search destination");
		msg(ob.Search_here().getText());
		Custom_click(ob.Back_button(), "Back from Search here");
		Custom_click(ob.Back_button(), "Back from Navigation");
	}

	@Test(priority = 2)
	public void TC019_Verify_Documents() throws InterruptedException 
	{
		try {
			Custom_click(ob.Documents_Menu(), "Document menu");
			ob.Documents_list();
			Custom_click(ob.Back(), "Back from Documents");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 3)
	public void TC020_Verify_Relationship_Manager() throws InterruptedException {
		try {
			Thread.sleep(2000);
			Custom_click(ob.Relationship_Manager(), "Relationship Manager");
			Thread.sleep(2000);
			try {
				if (ob.Relationship_Manager_name().getSize() != null) {
					msg("Relationship Manager name is =" + ob.Relationship_Manager_name().getText());
					msg("Relationship Manager address is =" + ob.Relationship_Manager_Address().getText());
					msg("Relationship Manager Contact number is ="
							+ ob.Relationship_Manager_Contact_number().getText());
					Custom_click(ob.Relationship_Manager_Contact_number(), "Relationship manager contact");
					driver.navigate().back();
					driver.navigate().back();
					driver.navigate().back();
				}
			} catch (Exception e) {
				msg("Relationship Manager name is not given");
			}
			Thread.sleep(2000);
			ob.Others_Contacts();
			Custom_click(ob.Back(), "Back from Relationship Manager");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 4)
	public void TC021_Verify_RSA() throws InterruptedException {
		Custom_click(ob.RSA(), "RSA");
		Thread.sleep(1000);
		try {
			Custom_click(ob.locate_nearest_dealer(), "locate nearest dealer"); // for emulator and pCloudy
			Thread.sleep(1000);
//		Custom_click(ob.locate_nearest_dealer_real_device(), "locate nearest dealer"); //for real device
			try {
				msg(ob.locate_the_nearest_dealer().getText()); // only for emulator
//				msg(ob.locate_the_nearest_dealer_real().getText()); // only for real device & pCloudy
				msg("Locate nearest dealer link is working");
				Custom_click(ob.accept_cookie(), ob.accept_cookie().getText() + " Coockie");
			} catch (Exception e) {
				test.log(Status.FAIL, "Locate nearest dealer link is not working" + e);
				log.error("Locate nearest dealer link is not working" + e);
				Custom_click(ob.Back(), "Back from RSA");
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Locate nearest dealer link is not given" + e);
			log.error("Locate nearest dealer link is not given" + e);
			Custom_click(ob.Back(), "Back from RSA");
		}
	}
	@Test(dependsOnMethods = "TC021_Verify_RSA()" ,priority = 5)
	public void TC022_Select_State_For_Nearest_Dealer() throws InterruptedException {
		Custom_click(ob.State(), ob.State().getText());
		Thread.sleep(2000);
		//For pCloudy please comment out line No:133 to 137.
		String state_name = ob.State().getText();
		if(state_name.equalsIgnoreCase("State*"))
		{
			Custom_click(ob.State(), ob.State().getText());
		}
		ob.select_state("Bihar");
	}
	@Test(dependsOnMethods = "TC022_Select_State_For_Nearest_Dealer()" ,priority = 6)
	public void TC023_Select_City_For_Nearest_Dealer() throws InterruptedException {
		Thread.sleep(3000);
		Custom_click(ob.City(), ob.City().getText());
		ob.select_city("Muzaffarpur");
	}
	@Test(dependsOnMethods = "TC022_Select_State_For_Nearest_Dealer()" ,priority = 7)
	public void TC024_Select_Locality_For_Nearest_Dealer() throws InterruptedException
	{
		Thread.sleep(3000);
		Custom_click(ob.Locality(), ob.Locality().getText());
		ob.select_Locality("Sujawalpur");
		Thread.sleep(3000);
		Custom_click(ob.Search_button(), ob.Search_button().getText());
	}
	@Test(dependsOnMethods = "TC022_Select_State_For_Nearest_Dealer()" ,priority = 8)
	public void TC025_Verify_Nearest_Dealer_info() throws InterruptedException
	{
		Thread.sleep(3000);
		msg(ob.Local_dealer_fullname().getText());  // for emulator
//		msg(ob.Local_dealer_fullname_real().getText());   // for pCloudy and real device
		Scroll_down_page_Action("View More");
		msg(ob.Local_dealer_name().getText());
		msg(ob.Local_dealer_address().getText());   // for emulator
//		msg(ob.Local_dealer_address_real().getText());   // for pCloudy and real device
		Custom_click(ob.Back(), "Back from RSA");
	}
	@Test(priority = 9)
	public void TC026_Verify_Technical_Support_Manager() throws InterruptedException {
		try {
			Custom_click(ob.Technical_Support(), "Technical Support");
			Thread.sleep(2000);
			try {
				msg("Technical Support Manager Name is =" + ob.Technical_Support_Manager_Name().getText());
				msg("Technical Support Manager address is =" + ob.Technical_Support_Manager_Address().getText());
				msg("Technical Support Manager contact number is ="
						+ ob.Technical_Support_Manager_Contact_Number().getText());
			} catch (Exception e) {
				msg("Technical Support Manager information not given");

			}
			Custom_click(ob.Back(), "Back from Technical Support Manager");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 10)
	public void TC027_Verify_Dealer_Locator() throws InterruptedException {
		try {
			Custom_click(ob.Dealer_Locator(), "Dealer Locator");
			Thread.sleep(2000);
			Custom_click(ob.Select_State(), "Select state");
			ob.Select_State("BIHAR");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 11)
	public void TC028_Select_city() {
		try {
			Custom_click(ob.Select_City(), "Select city");
			ob.Select_City("BAGAHA");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 12)
	public void TC029_View_dealer_name_and_address() {
		try {
			Custom_click(ob.map_view(), "Map View dealer name and address");
			ob.Dealer_info();
			Custom_click(ob.Back(), "Back from Dealer Locator");
		} catch (Exception e) {
			msg("" + e);

		}
	}
//	@Test(priority = 13)
//	public void verify_Service_at_home_page()
//	{
//		scrollByText("Latest");
//		msg("Service status =" +ob.Service_status().getText());
//		Custom_click(ob.View_details_button(), ob.View_details_button().getText());
//		msg(ob.Vehicle_service().getText()+" for " +ob.Vehicle_name().getText());
//		driver.navigate().back();
//	}
//	@Test(priority = 14)
//	public void verify_Latest_at_home_page() throws InterruptedException
//	{
//		Custom_click(ob.Latest_Vehicle(), "Latest Vehicle");
//		Thread.sleep(6000);
//		msg(ob.latest_vehicle_message().getText());
//		msg(ob.mute().getText());
//		Custom_click(ob.Back(), ob.latest_vehicle_message().getText() );
////		Custom_click(ob.mute(), ob.mute().getText());
////		Thread.sleep(2000);
////		Custom_click(ob.mute(), ob.mute().getText());
////		Custom_click(ob.scroll_img(), " Scroll img");
////		Thread.sleep(3000);
//	}
////	@Test(priority = 11)
////	public void verify_Notify_me_in_Latest_at_home_page() throws InterruptedException
////	{
////		Custom_click(ob.Notify_me(), ob.Notify_me().getText());
////		Thread.sleep(2000);
////		custom_sendkeys(ob.user_name(), "Renu", "User name ");
////		custom_sendkeys(ob.user_email(), "Resnu@gmail.com", " User email ");
////		custom_sendkeys(ob.pincode(), "657809", "Pin code ");
////		custom_sendkeys(ob.user_mobile(), "9809786765", "Mobile number");
////		ob.pincode().click();
////		Custom_click(ob.Send_OTP_button(), " Send OTP Button ");
////		Thread.sleep(10000);
////		ob.otp();
////		if(ob.submit_button().isEnabled()!=true)
////		{
////			msg("Submitting buton is not clickable");
////			msg(ob.otp_error_message().getText());
////		}
////		else
////		{
////			Custom_click(ob.submit_button(), "Submit button");
////		}
////		Custom_click(ob.Back(), " Back from Get ready to #LiveTheLegend");
////	}
//	@Test(priority = 15)
//	public void verify_EShop() throws InterruptedException
//	{
//		Scroll_down_page_Action("Benefits");
//		Custom_click(ob.E_shop(), "E-Shop ");
//		msg(ob.E_shop_location().getText());
//		Custom_click(ob.Categories(), ob.Categories().getText());
//		Thread.sleep(2000);
//		Custom_click(ob.BACK_TO_HERO_MOTOCORP(), " Back from hero Motocorp ");
//		Custom_click(ob.Back(), " Back from Merchandise ");
//		}
//	@Test(priority = 16)
//	public void verify_Benifits_Vehicle_Exchange() throws InterruptedException
//	{
//		Custom_click(ob.Benifits(), "Benifits ");
//		Thread.sleep(6000);
//		msg("Welcome to " +ob.goodlife().getText() +" page");
//		msg(ob.goodlife_message().getText());
//		Custom_click(ob.Back(), " Back from Hero GoodLife ");
//		Custom_click(ob.Vehicle_Exchange(), "Vehicle Exchange ");
//		Thread.sleep(2000);
//		Custom_click(ob.language(), " English ");
//		msg("For exchange please fill below mandatory filled");
//		ob.Vehicle_Exchange_info();
//		Custom_click(ob.Back(), " Back from Wheels of Trust ");
//	}
//	@Test(priority = 17)
//	public void verify_Community_and_Tips() throws InterruptedException
//	{
//		Scroll_down_page_Action("What's New");
//		Custom_click(ob.Community(), "Community ");
//		Thread.sleep(5000);
//		msg(ob.Community_message_1().getText());
//		msg(ob.Community_message().getText());
//		Custom_click(ob.Back(), " Back from Xclan ");
//		scrollByText("Key Actions");
//		
//	}
}