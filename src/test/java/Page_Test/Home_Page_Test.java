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
		test.log(Status.PASS, "Current Temperature is =" + ob.temperature().getText());
		log.info("Current Temperature is =" + ob.temperature().getText());
		VerifyElementPresent(ob.vehicle_img(), "Vehicle Img is");
		Thread.sleep(2000);
		ob.all_vehicle_inside_drop_down();
		Custom_click(ob.Collapse_btn(), "Collapse button");
		Thread.sleep(2000);
		Custom_click(ob.Collapse_btn(), " Return collapse button");
		Custom_click(ob.notification(), "Notification");
		test.log(Status.PASS, "Total Notification are=" + ob.notification_count());
		log.info("Total Notification are=" + ob.notification_count());
		Custom_click(ob.notification_back(), "Notification back");

	}
	public void TC007__verify_Navigate() {
		Custom_click(ob.Navigate_menu(), "Navigate menu");
		Custom_click(ob.Search_destination(), "Search destination");
		custom_sendkeys(ob.Search_here(), config_getdata("search_destination"), "Noida");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		test.log(Status.PASS,
				"Searched Nmae and address are=" + ob.Searched_name().getText() + ob.Searched_address().getText());
		log.info("Searched Nmae and address are=" + ob.Searched_name().getText() + ob.Searched_address().getText());
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
	}
}