package Page_Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.Select_Vehicle_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
@Listeners(com.utility.listner.class)
public class Select_Vehicle_Page_Test extends Base_Utility {

	public Select_Vehicle_Page ob;
	public Login_Page_Test login;
	@Test(priority = 0)
	public void TC004_verify_Nick_Name()
	{
		login = new Login_Page_Test();
		ob = new Select_Vehicle_Page();
		login.login();
		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		VerifyElementPresent(ob.save_button(), "Save button before updating the nick name is ");
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("nickname"), "Nick Name ");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Custom_click(ob.save_button(), "Save button after updating the nick name is ");
		assertEquals(null,config_getdata("nickname"));
		}
	@Test(priority = 1)
	public void TC005_Select_Vehicle()
	{
		VerifyElementPresent(ob.continue_button(), "Continue Button before select vehicle is");
		Custom_click(ob.click_first_vehicle(), " Select first vehicle");
		VerifyElementPresent(ob.continue_button(), "Continue Button after select vehicle is");
		Custom_click(ob.continue_button(), "Continue Button after select vehicle");
		Custom_click(ob.While_using_the_app(), "While using the app");
		ob.vehicle_count();

	}
}

