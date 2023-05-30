package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.page_object.Home_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(com.utility.listner.class)
public class Home_Page_Test extends Base_Utility {

	public Login_Page_Test login;
	public Home_Page ob;

	@Test(priority = 0)
	public void TC006_Home_page_verify() throws InterruptedException {
		ob = new Home_Page();
		login = new Login_Page_Test();
		login.login();
		Thread.sleep(2000);
		msg("Current Temperature is =" + ob.temperature().getText());
		VerifyElementPresent(ob.vehicle_img(), "Vehicle Img is");
		Thread.sleep(2000);
		ob.all_vehicle_inside_drop_down();
		Custom_click(ob.Collapse_btn(), "Collapse button");
		Thread.sleep(2000);
		Custom_click(ob.Collapse_btn(), " Return collapse button");
		Custom_click(ob.notification(), "Notification");
		msg("Total Notification are=" + ob.notification_count());
		Custom_click(ob.notification_back(), "Notification back");

	}
	public void TC007__verify_Navigate() {
		Custom_click(ob.Navigate_menu(), "Navigate menu");
		Custom_click(ob.Search_destination(), "Search destination");
		custom_sendkeys(ob.Search_here(), config_getdata("search_destination"), "Noida");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		msg("Searched Nmae and address are=" + ob.Searched_name().getText() + ob.Searched_address().getText());
		Custom_click(ob.Navigate_button(), "Navigate address");
		Custom_click(ob.Start(), "Start");
		Custom_click(ob.change_search(), "Change search");
		Custom_click(ob.Back_button(), "Back from start destination");
		Custom_click(ob.Back_button(), "Back from Navigation");
	}
	@Test(priority = 1)
	public void TC008_Verify_Documents() throws InterruptedException //54 steps
	{
//		login = new Login_Page_Test();
//		ob = new Home_Page();
//		login.login();
		Custom_click(ob.Documents_Menu(), "Document menu");
		ob.Documents_list();
		Custom_click(ob.Back(), "Back from Documents");
	}
	@Test(priority = 2)
	public void TC009_Verify_Relationship_Manager() throws InterruptedException {
//		login = new Login_Page_Test();
//		ob = new Home_Page();
//		login.login();
//		Thread.sleep(2000);
		Custom_click(ob.Relationship_Manager(), "Relationship Manager");
		Thread.sleep(2000);
		msg("Relationship Manager name is =" +ob.Relationship_Manager_name().getText());
		msg("Relationship Manager address is =" +ob.Relationship_Manager_Address().getText());
		msg("Relationship Manager Contact number is ="+ob.Relationship_Manager_Contact_number().getText());
		Thread.sleep(2000);
		ob.Others_Contacts();
		Custom_click(ob.Back(), "Back from Relationship Manager");
	}
	@Test(priority = 3)
	public void TC010_Verify_RSA() throws InterruptedException
	{
		Custom_click(ob.RSA(), "RSA");
		Thread.sleep(2000);
		Custom_click(ob.Back(), "Back from RSA");
	}
	@Test(priority = 4)
	public void TC011_Verify_Technical_Support_Manager() throws InterruptedException
	{
		Custom_click(ob.Technical_Support(), "Technical Support");
		Thread.sleep(2000);
		msg("Technical Support Manager Name is =" +ob.Technical_Support_Manager_Name().getText());
		msg("Technical Support Manager address is =" +ob.Technical_Support_Manager_Address().getText());
		msg("Technical Support Manager contact number is =" +ob.Technical_Support_Manager_Contact_Number().getText());
		Custom_click(ob.Back(), "Back from Technical Support Manager");
	}
	@Test(priority = 5)
	public void TC011_Verify_Dealer_Locator()
	{
		Custom_click(ob.Dealer_Locator(), "Dealer Locator");
		custom_sendkeys(ob.Select_State(), "Bihar", "State");
		custom_sendkeys(ob.Select_City(), "Samstipur", "City");
		Custom_click(ob.Back(), "Back from Dealer Locator");
	}
}