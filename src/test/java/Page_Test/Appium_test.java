package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.Login_page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
@Listeners(com.utility.listner.class)
public class Appium_test extends Base_Utility {
	
	public Login_page ob;
	
	@Test
public void TC001_test()
{
	ob = new Login_page();
	Custom_click(ob.close(), "Close");
	custom_sendkeys(ob.mobile_No(), config_getdata("mobileno"), "Login mobile number");
	((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
//	Custom_click(ob.right_button(), "Right Button");
	Custom_click(ob.continue_button(), "Coninue button");
	
	
}

}
