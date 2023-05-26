package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.Home_Page;
import com.utility.Base_Utility;
@Listeners(com.utility.listner.class)
public class Home_Page_Test extends Base_Utility {

	public Login_Page_Test login;
	public Home_Page ob;
	@Test(priority = 0)
public void TC006_Home_page_verify() throws InterruptedException
{
	login = new Login_Page_Test();
	 ob = new Home_Page();
	 login.login();
	 log.info("Current Temperature is =" +ob.temperature().getText());
	 VerifyElementPresent(ob.vehicle_img(), "Vehicle Img is");
	 Thread.sleep(2000);
	 ob.all_vehicle_inside_drop_down();
	 Custom_click(ob.Collapse_btn(), "Collapse button");
	 Thread.sleep(2000);
	 Custom_click(ob.Collapse_btn(), " Return collapse button");
	 Custom_click(ob.notification(), "Notification");
	 log.info("Total Notification are=" +ob.notification_count());
	 Custom_click(ob.notification_back(), "Notification back");
	 
}
	@Test(priority = 1)
	public void TC007__verify_Navigate()
	{
		Custom_click(ob.Navigate_menu(), "Navigate menu");
		Custom_click(ob.Search_destination(), "Search destination");
		custom_sendkeys(ob.Search_here(), config_getdata("search_destination"), "Noida");
	}
}