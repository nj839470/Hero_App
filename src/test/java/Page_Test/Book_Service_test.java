package Page_Test;

import org.testng.annotations.Test;

import com.page_object.Book_Service;
import com.utility.Base_Utility;

public class Book_Service_test extends Base_Utility {
	public Login_Page_Test login;
	public Book_Service ob;
	@Test(priority = 0)
	public void TC109_previous_service_info() {
		ob = new Book_Service();
		login = new Login_Page_Test();
		login.login();
		Custom_click(ob.Services(), "Services button");
		msg(ob.next_service_info().getText());
		msg(ob.service_date_time().getText());
		Custom_click(ob.Book_Service_button(), ob.Book_Service_button().getText());
		msg(ob.Vehicle_brand_Name().getText());
		try {
		msg(ob.Vehicle_Nick_Name().getText());
		}catch(Exception e) {msg("Vehicle nick name is not given");}
		try {
		msg(ob.Vehicle_license_no().getText());
		}catch(Exception e) {msg("Vehicle License number is not given");}
	}

	@Test(priority = 1)
	public void TC110_Book_service() throws InterruptedException {
		msg(ob.select_date().getText());
		ob.pick_date();
		msg("Selected date = " + ob.Selected_date().getText());
		msg(ob.select_time().getText());
		swipe_page_direction(100, 1250, 590, 1250, "Pick time");
		msg("Selected Time =" + ob.Selected_time().getText());
		msg("Service Centre Name =" + ob.center_Name().getText());
		msg("Service Centre Address =" + ob.center_Address().getText());
		Custom_click(ob.Center_keyArrow(), "Center keyArrow");
		Thread.sleep(2000);
		msg(ob.Select_service_center().getText());
		Custom_click(ob.back_btn(), "Back from Select service center");
		msg("Service Type " + ob.Service_Type().getText());
		Scroll_down_page_Action("Additional Instructions");
		msg("Customer Requests");
		ob.Customer_Requests();
		Scroll_down_page_Action("Review Service Details button");
		custom_sendkeys(ob.Additional_Instructions(), "Bike Stand,light ETC", "Another issue");
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void TC111_Review_Service_Details() {
		Custom_click(ob.Review_Service_Details_button(), ob.Review_Service_Details_button().getText());
		ob.Service_Details();
		Custom_click(ob.cancel_button(), "Cnacel Button");
		Custom_click(ob.back_btn(), "Back from Book Service page");
	}
}
