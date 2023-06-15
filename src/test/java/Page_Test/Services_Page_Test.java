package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.Services_Page;
import com.utility.Base_Utility;

@Listeners(com.utility.listner.class)
public class Services_Page_Test extends Base_Utility {
	public Login_Page_Test login;
	public Services_Page ob;

	@Test(priority = 0)
	public void TC029_Vehicle_details_on_service_page() throws InterruptedException {
		ob = new Services_Page();
//		login = new Login_Page_Test();
//		login.login();
		Thread.sleep(2000);
		Custom_click(ob.Services(), " Services button");
		msg("Vehicle brand name = " + ob.Vehicle_brand_Name().getText());
		if (ob.Vehicle_Nick_Name().isDisplayed() == true) {
			msg("Vehicle nick name = " + ob.Vehicle_Nick_Name().getText());
		}
		if (ob.Vehicle_Number().isDisplayed() == true) {
			msg("Vehicle number =" + ob.Vehicle_Number().getText());
		}
	}

	@Test(priority = 1)
	public void TC030_verify_service_type() {
		if (ob.Vehicle_Service_type().isDisplayed() == true) {
			msg("Vehicle Service type =" + ob.Vehicle_Service_type().getText());
		}
		if (ob.Vehicle_service_booking_no().isDisplayed() == true) {
			msg("Vehicle Service booking number = " + ob.Vehicle_service_booking_no().getText());
		}
		String service_status = ob.next_service_info().getText();
		msg("Service status =" + service_status);
		if (service_status.equalsIgnoreCase("Service Scheduled")) {
			msg("Service date and time =" + ob.service_date_time().getText());
		}
	}

	@Test(priority = 2)
	public void TC031_verify_Dealer_information() 
	{
		ob.dealer_info();
	}

	@Test(priority = 3)
	public void TC032_Verify_dealer_manager_info() {
		msg("Manager type =" + ob.manager_type().getText());
		msg("Manager name =" + ob.manager_name().getText());
		Custom_click(ob.call_manager(), " Call amanger");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		msg("Manager contact number =" + ob.manage_phone_number().getText());
	}

	@Test(priority = 4)
	public void TC033_Verify_Last_Serviced() throws InterruptedException {
		Custom_click(ob.Last_serviced_history(), "Last serviced history");
		ob.Service_history();
		Custom_click(ob.back_button(), " Back from servie history");
	}
	@Test(priority = 6)
	public void TC035_Verify_all_tips_list() throws InterruptedException
	{
		scrollByText("Tips & DIY");
		Custom_click(ob.Tips_and_DIY(), "Tips and DIY");
		ob.tips_list();
	}
	@Test(priority = 7)
	public void TC036_Verify_all_DIY_Videos_list() throws InterruptedException
	{
		Custom_click(ob.DIY_Videos_button(), "DIY video button");
		ob.DIY_Videos_list();
		Custom_click(ob.back_button(), " Back from Tips and DIY page");
	}
}
