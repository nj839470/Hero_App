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
	public void TC068_Vehicle_details_on_service_page() throws InterruptedException {
		msg("************************Service Page**************************");
		ob = new Services_Page();
//		login = new Login_Page_Test();
//		login.login();
		try {
			Thread.sleep(2000);
			Custom_click(ob.Services(), " Services button");
			msg("Vehicle brand name = " + ob.Vehicle_brand_Name().getText());
			if (ob.Vehicle_Nick_Name().isDisplayed() == true) {
				msg("Vehicle nick name = " + ob.Vehicle_Nick_Name().getText());
			}
			if (ob.Vehicle_Number().isDisplayed() == true) {
				msg("Vehicle number =" + ob.Vehicle_Number().getText());
			}
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 1)
	public void TC069_verify_service_type() {
		try {
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
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 2)
	public void TC070_verify_Dealer_information() {
		ob.dealer_info();
	}

	@Test(priority = 3)
	public void TC071_Verify_dealer_manager_info() {
		try {
			msg("Manager type =" + ob.manager_type().getText());
			msg("Manager name =" + ob.manager_name().getText());
			Custom_click(ob.call_manager(), " Call amanger");
			driver.navigate().back();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			try {
				if(ob.Service_Schedule().isDisplayed()) { 
					msg("Manager contact number =" + ob.manage_phone_number().getText());
					msg("Service Schedule is visible"); }
			}catch (Exception e) { driver.navigate().back(); }
				} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 4)
	public void TC072_View_Service_schedule_750() {
		try {
			Custom_click(ob.Service_Schedule(), "View Service Schedule");
			Custom_click(ob.Kilometer(), ob.Kilometer().getText());
			Custom_click(ob.Kilometer_750(), "750 Kilometer");
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 5)
	public void TC073_View_Service_schedule_3500() {
		try {
//		swipe_page_direction(46, 295, 159, 295, "3500 Kilometer");	// for real device
//		swipe_page_direction(98, 565, 335, 565, "3500 Kilometer"); 	// for pCloudy device
//		swipe_page_direction(98, 465, 240, 465, "3500 Kilometer"); 	// for pCloudy device-13
		swipe_page_direction(69, 412, 250, 412, "3500 Kilometer");   // for Emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 6)
	public void TC074_View_Service_schedule_6500() {
		try {
//		swipe_page_direction(159, 295, 290, 295, "6500 Kilometer");	// for real device
//			swipe_page_direction(335, 565, 590, 565, "6500 Kilometer"); 	// for pCloudy device
//			swipe_page_direction(240, 465, 440, 465, "6500 Kilometer"); 	// for pCloudy device-13
			swipe_page_direction(250, 412, 435, 412, "6500 Kilometer"); // for Emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 7)
	public void TC075_View_Service_schedule_9500() {
		try {
//		swipe_page_direction(290, 295, 416, 295, "9500 Kilometer"); // for real device
//			swipe_page_direction(590, 565, 840, 565, "9500 Kilometer"); 	// for pCloudy device
//			swipe_page_direction(440, 465, 628, 465, "9500 Kilometer"); 	// for pCloudy device-13
			swipe_page_direction(435, 412, 620, 412, "9500 Kilometer"); // for emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 8)
	public void TC076_View_Service_schedule_12500() {
		try {
//		swipe_page_direction(416, 295, 545, 295, "12500 Kilometer"); // for real device
//			swipe_page_direction(840, 565, 1100, 565, "12500 Kilometer"); 	// for pCloudy device
//			swipe_page_direction(628, 465, 815, 465, "12500 Kilometer"); 	// for pCloudy device-13
			swipe_page_direction(620, 412, 824, 412, "12500 Kilometer"); // for Emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 9)
	public void TC077_View_Service_schedule_15500() {
		try {
//		swipe_page_direction(545, 295, 675, 295, "15500 Kilometer"); // for real device
//			swipe_page_direction(1100, 565, 1350, 565, "15500 Kilometer"); 	// for pCloudy device
//			swipe_page_direction(815, 465, 1005, 465, "15500 Kilometer"); 	// for pCloudy device-13
			swipe_page_direction(824, 412, 1002, 412, "15500 Kilometer"); // for Emulator
			String text = ob.KM_15500().getText();
			Custom_click(ob.KM_15500(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC077_View_Service_schedule_15500()", priority = 10)
	public void TC078_View_Service_schedule_18500() {
		try {
			String text = ob.KM_18500().getText();
			Custom_click(ob.KM_18500(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}

	}

	@Test(dependsOnMethods = "TC077_View_Service_schedule_15500()", priority = 11)
	public void TC079_View_Service_schedule_21500() {
		try {
			String text = ob.KM_21500().getText();
			Custom_click(ob.KM_21500(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC077_View_Service_schedule_15500()", priority = 12)
	public void TC080_View_Service_schedule_24500() {
		try {
			String text = ob.KM_24500().getText();
			Custom_click(ob.KM_24500(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC077_View_Service_schedule_15500()", priority = 13)
	public void TC081_View_Service_schedule_27500() {
		try {
			String text = ob.KM_27500().getText();
			Custom_click(ob.KM_27500(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 14)
	public void TC082_View_Service_schedule_60_days() {
		try {
			Custom_click(ob.Days(), ob.Days().getText());
			swipe_page_direction(1002, 412, 69, 412, "60 Days"); // for Emulator
//			swipe_page_direction(1357, 565, 98, 565, "60 Days"); // for pCloudy
//			swipe_page_direction(1005, 465, 100, 465, "60 Days"); 	// for pCloudy device-13
			// Line no: 230 to 234 is only for pCloudy device-13
//			try {
//			if(ob.Service_Schedule().isDisplayed()) {
//			Custom_click(ob.Service_Schedule(), "View Service Schedule"); 
//			Custom_click(ob.Days(), ob.Days().getText()); 
//			}}catch(Exception e) { }
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 15)
	public void TC083_View_Service_schedule_160_days() {
		try {
//			swipe_page_direction(46, 295, 159, 295, "160 Days");	// for real device
//			swipe_page_direction(98, 565, 335, 565, "160 Days");    // for pCloudy
//			swipe_page_direction(98, 465, 240, 465, "160 Days"); 	// for pCloudy device-13
			swipe_page_direction(69, 412, 250, 412, "160 Days");     // for Emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 16)
	public void TC084_View_Service_schedule_260_days() {
		try {
//			swipe_page_direction(159, 295, 290, 295, "260 Days");	// for real device
//			swipe_page_direction(335, 565, 590, 565, "260 Days"); 	// for pCloudy device
//			swipe_page_direction(240, 465, 440, 465, "260 Days"); 	// for pCloudy device-13
			swipe_page_direction(250, 412, 435, 412, "260 Days"); // for Emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 17)
	public void TC085_View_Service_schedule_360_days() {
		try {
//			swipe_page_direction(290, 295, 416, 295, "360 Days"); // for real device
//			swipe_page_direction(590, 565, 840, 565, "360 Days"); 	// for pCloudy device
//			swipe_page_direction(440, 465, 628, 465, "360 Days"); 	// for pCloudy device-13
			swipe_page_direction(435, 412, 620, 412, "360 Days"); // for emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 18)
	public void TC086_View_Service_schedule_460_days() {
		try {
//			swipe_page_direction(416, 295, 545, 295, "460 Days"); // for real device
//			swipe_page_direction(840, 565, 1100, 565, "460 Days"); 	// for pCloudy device
//			swipe_page_direction(628, 465, 820, 465, "460 Days"); 	// for pCloudy device-13
		    swipe_page_direction(620, 412, 824, 412, "460 Days"); // for Emulator
			ob.Service_schedule();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 19)
	public void TC087_View_Service_schedule_560_days() {
		try {
//			swipe_page_direction(545, 295, 675, 295, "560 Days"); // for real device
//			swipe_page_direction(1100, 565, 1350, 565, "560 Days"); 	// for pCloudy device
//			swipe_page_direction(820, 465, 1005, 465, "560 Days"); 	// for pCloudy device-13
			swipe_page_direction(824, 412, 1002, 412, "560 Days"); // for Emulator
			String text = ob.days_560().getText();
			Custom_click(ob.days_560(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC087_View_Service_schedule_560_days()", priority = 20)
	public void TC088_View_Service_schedule_660_days() {
		try {
			String text = ob.days_660().getText();
			Custom_click(ob.days_660(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC087_View_Service_schedule_560_days()", priority = 21)
	public void TC089_View_Service_schedule_760_days() {
		try {
			String text = ob.days_760().getText();
			Custom_click(ob.days_760(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC087_View_Service_schedule_560_days()", priority = 22)
	public void TC090_View_Service_schedule_860_days() {
		try {
			String text = ob.days_860().getText();
			Custom_click(ob.days_860(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(dependsOnMethods = "TC087_View_Service_schedule_560_days()", priority = 23)
	public void TC091_View_Service_schedule_960_days() {
		try {
			String text = ob.days_960().getText();
			Custom_click(ob.days_960(), text);
			msg("Paid Service for = " + text);
			ob.Service_schedule_More_Than_15500();
			try {
			Custom_click(ob.back_button(), " Back from Servie Schedule");
			if(ob.Last_serviced_history().isDisplayed()) { msg("Last service history is visible");}
			}catch (Exception e) {Custom_click(ob.back_button(), " Back from Servie Schedule"); }
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 24)
	public void TC092_Verify_Last_Serviced() {
		try {
			Custom_click(ob.Last_serviced_history(), "Last serviced history");
			Thread.sleep(2000);
			ob.Service_history();
			Custom_click(ob.back_button(), " Back from servie history");
		} catch (Exception e) {
			msg("" + e);

		}
	}

	@Test(priority = 25)
	public void TC093_Verify_all_tips_list() throws InterruptedException {
		Scroll_down_page_Action("Tips and DIY");
		Custom_click(ob.Tips_and_DIY(), "Tips and DIY");
		ob.tips_list();
	}

	@Test(priority = 26)
	public void TC094_Verify_all_DIY_Videos_list() throws InterruptedException {
		Custom_click(ob.DIY_Videos_button(), "DIY video button");
		ob.DIY_Videos_list();
		Custom_click(ob.back_button(), " Back from Tips and DIY page");
	}
}
