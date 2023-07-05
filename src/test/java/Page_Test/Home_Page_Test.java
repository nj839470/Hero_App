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
		try
		{
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
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}
	
//		public void TC018__verify_Navigate() {
//		Custom_click(ob.Navigate_menu(), "Navigate menu");
//		Custom_click(ob.Search_destination(), "Search destination");
//		custom_sendkeys(ob.Search_here(), config_getdata("search_destination"), "Noida");
//		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
//		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
//		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
//		msg("Searched Nmae and address are=" + ob.Searched_name().getText() + ob.Searched_address().getText());
//		Custom_click(ob.Navigate_button(), "Navigate address");
//		Custom_click(ob.Start(), "Start");
//		Custom_click(ob.change_search(), "Change search");
//		Custom_click(ob.Back_button(), "Back from start destination");
//		Custom_click(ob.Back_button(), "Back from Navigation");
//	}

	@Test(priority = 1)
	public void TC019_Verify_Documents() throws InterruptedException // 54 steps
	{
//		login = new Login_Page_Test();
//		login.login();
		try
		{
		Custom_click(ob.Documents_Menu(), "Document menu");
		ob.Documents_list();
		Custom_click(ob.Back(), "Back from Documents");
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}

	@Test(priority = 2)
	public void TC020_Verify_Relationship_Manager() throws InterruptedException {
//		login = new Login_Page_Test();
//		ob = new Home_Page();
//		login.login();
		try
		{
		Thread.sleep(2000);
		Custom_click(ob.Relationship_Manager(), "Relationship Manager");
		Thread.sleep(2000);
		try
		{
		if(ob.Relationship_Manager_name().getSize()!= null)
		{
		msg("Relationship Manager name is =" + ob.Relationship_Manager_name().getText());
		msg("Relationship Manager address is =" + ob.Relationship_Manager_Address().getText());
		msg("Relationship Manager Contact number is =" + ob.Relationship_Manager_Contact_number().getText());
		Custom_click(ob.Relationship_Manager_Contact_number(), "Relationship manager contact");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		}
		}catch(Exception e)
		{
			msg("Relationship Manager name is not given");
		}
		Thread.sleep(2000);
		ob.Others_Contacts();
		Custom_click(ob.Back(), "Back from Relationship Manager");
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}

	@Test(priority = 3)
	public void TC021_Verify_RSA() throws InterruptedException {
		try {
		Custom_click(ob.RSA(), "RSA");
		Thread.sleep(2000);
		try {
		Custom_click(ob.locate_nearest_dealer(), "locate nearest dealer"); //for emulator
//		Custom_click(ob.locate_nearest_dealer_real_device(), "locate nearest dealer"); //for real device
		if(ob.locate_nearest_dealer_real_device().isDisplayed()==true)
		{
			msg("Locate nearest dealer link is not working");
			test.log(Status.FAIL, "Locate nearest dealer link is not working");
			log.error("Locate nearest dealer link is not working");
		}
		else
		{
			test.log(Status.PASS, "Locate nearest dealer link is working");
			log.info("Locate nearest dealer link is working");
		}
		}catch(Exception e)
		{
			msg("Locate nearest dealer link is working");
			
		}

		Custom_click(ob.Back(), "Back from RSA");
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}

	@Test(priority = 4)
	public void TC022_Verify_Technical_Support_Manager() throws InterruptedException {
		try {
		Custom_click(ob.Technical_Support(), "Technical Support");
		Thread.sleep(2000);
		try {
		msg("Technical Support Manager Name is =" + ob.Technical_Support_Manager_Name().getText());
		msg("Technical Support Manager address is =" + ob.Technical_Support_Manager_Address().getText());
		msg("Technical Support Manager contact number is =" + ob.Technical_Support_Manager_Contact_Number().getText());
		}catch(Exception e)
		{
			msg("Technical Support Manager information not given");
			
		}
		Custom_click(ob.Back(), "Back from Technical Support Manager");
	}catch(Exception e)
	{
		msg(""+e);
		
	}
	}

	@Test(priority = 5)
	public void TC023_Verify_Dealer_Locator() throws InterruptedException {
//		login = new Login_Page_Test();
//		ob = new Home_Page();
//		login.login();
		try
		{
		Custom_click(ob.Dealer_Locator(), "Dealer Locator");
		Thread.sleep(2000);
		Custom_click(ob.Select_State(), "Select state");
		ob.Select_State("BIHAR");
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}

	@Test(priority = 6)
	public void TC024_Select_city() {
		try {
		Custom_click(ob.Select_City(), "Select city");
		ob.Select_City("BAGAHA");
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}

	@Test(priority = 7)
	public void TC025_View_dealer_name_and_address() {
		try {
		Custom_click(ob.map_view(), "Map View dealer name and address");
		ob.Dealer_info();
		Custom_click(ob.Back(), "Back from Dealer Locator");
		}catch(Exception e)
		{
			msg(""+e);
			
		}
	}
//	@Test(priority = 8)
//	public void TC035_Service_information()
//	{
////		ob = new Home_Page();
////		login = new Login_Page_Test();
////		login.login();
//		scrollByText("Discover");
//		ob.Service_info();
	//		}


}