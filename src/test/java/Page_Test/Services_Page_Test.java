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
		msg("Vehicle number =" + ob.Vehicle_Number().getText());
	}

	@Test(priority = 1)
	public void TC030_verify_service_info_and_raised_button() {
		if (ob.service_info_and_raised_button().getText().equalsIgnoreCase("Ongoing Service Details")) {
			Custom_click(ob.service_info_and_raised_button(), "Ongoing Service Details button");
		} else {
			if (ob.service_booked_date().isDisplayed() != true) {
				Custom_click(ob.service_info_and_raised_button(), "Service Request Raised button");
			}
		}
		msg("Vehicle brand name in Ongoing Service details= " + ob.Vehicle_brand_Name().getText());
		msg("Vehicle number in Ongoing Service details  = " + ob.Vehicle_Nick_Name().getText());
		msg("Vehicle Serial number in Ongoing Service details =" + ob.Vehicle_Number().getText());
		if (ob.Service_center_name().isDisplayed() == true) {
			msg("Service center name =" + ob.Service_center_name().getText());
		} else {
			msg("Service center name is not given");
		}
		msg("Service center address =" + ob.Service_center_address().getText());
		msg("******************Job card , Estimated date & price ************************");
		msg("Estimated Amount =" + ob.Estimated_Amount().getText());
		msg("Estimated Date & Time =" + ob.Estimated_date().getText());
		ob.Support_info();
		Custom_click(ob.call_supporter(), " call supporter name ");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Custom_click(ob.collapse_button(), "Collapse Button");
		Custom_click(ob.collapse_button(), "Back collapse_button");
		Custom_click(ob.back(), "Back from Ongoing Service details");
	}

	@Test(priority = 2)
	public void TC031_verify_service_booked_info() {
		Custom_click(ob.Service_booked_details(), "Service Booked details");
		msg("Vehicle brand name in Ongoing Service details= " + ob.Vehicle_brand_Name().getText());
		msg("Vehicle number in Ongoing Service details  = " + ob.Vehicle_Nick_Name().getText());
		msg("Vehicle Serial number in Ongoing Service details =" + ob.Vehicle_Number().getText());
		if (ob.Service_center_name().isDisplayed() == true) {
			msg("Service center name =" + ob.Service_center_name().getText());
		} else {
			msg("Service center name is not given");
		}
		msg("Service center address =" + ob.Service_center_address().getText());
		msg("******************Job card , Estimated date & price ************************");
		msg("Estimated Amount =" + ob.Estimated_Amount().getText());
		msg("Estimated Date & Time =" + ob.Estimated_date().getText());
		ob.Support_info();
		Custom_click(ob.call_supporter(), " call supporter name ");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		Custom_click(ob.collapse_button(), "Collapse Button");
		Custom_click(ob.collapse_button(), "Back collapse_button");
		Custom_click(ob.back(), "Back from Ongoing Service details");

	}
	@Test(priority = 3)
	public void TC032_Verify_Last_Serviced()
	{
		Custom_click(ob.Last_serviced(), "Last Serviced ");
		ob.Service_history();
		Custom_click(ob.back(),"Back from Service history" );
	}
	@Test(priority = 4)
	public void TC033_Verify_Tips() throws InterruptedException
	{
		Custom_click(ob.Tips_and_DIY(), "Tips and DIY");
		Thread.sleep(2000);
		ob.tips_list();
	}
	@Test(priority = 5)
	public void TC034_Verify_DIY_Videos() throws InterruptedException
	{
		Custom_click(ob.DIY_Videos_button(), "DIY Videos button");
		ob.DIY_Videos_list();
		Custom_click(ob.back(), "Back from Tips and DIY page ");
		driver.navigate().back();
	
	}
}
