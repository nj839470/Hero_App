package Page_Test;

import org.testng.annotations.Test;

import com.page_object.Refer_a_friend_and_Contact_us;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Refer_a_friend_and_Contact_us_test extends Base_Utility {
	public Refer_a_friend_and_Contact_us ob;
	public Login_Page_Test login;
	@Test(priority = 0)
	public void TC040_Refer_a_friend() throws InterruptedException
	{
		msg("************************Refer a Friend**************************");
		ob = new Refer_a_friend_and_Contact_us();
		login = new Login_Page_Test();
		login.login();
		try{
		Custom_click(ob.home(), "Home");
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.refer_friend(), ob.refer_friend().getText());
		custom_sendkeys(ob.friend_name(), config_getdata("Friend_name"), "Friend name");
		custom_sendkeys(ob.friend_mob_no(), config_getdata("Friend_mob_no"), "Friend mob no");
		}catch(Exception e) 
		{ msg(""+e);
		}
	}
	@Test(priority = 1)
	public void TC041_Verify_Select_State()
	{
		try {
		Custom_click(ob.Select_state(), ob.Select_state().getText());
		ob.Select_State("UTTAR PRADESH");
		}catch(Exception e) 
		{ msg(""+e);
		}
	}
	@Test(priority = 2)
	public void TC042_Verify_Select_City()
	{
		try {
		Custom_click(ob.Select_City(), ob.Select_City().getText());
		ob.Select_City("AGRA");
		}catch(Exception e) 
		{ msg(""+e);
		}
		
	}
	@Test(priority = 3)
	public void TC043_Verify_Select_Model()
	{
		try {
		Custom_click(ob.Select_Model(), ob.Select_Model().getText());
		ob.Select_Model("Passion Pro");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		try {
		Custom_click(ob.Submit_button(), ob.Submit_button().getText());
		msg(ob.message().getText());
		Custom_click(ob.ok_button(), ob.ok_button().getText());
		}catch(Exception e)
		{msg(""+e);
			}
		}catch(Exception e) 
		{ msg(""+e);
		} 
	}
	public void TC044_Verify_Refer_yourself()
	{
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.refer_friend(), ob.refer_friend().getText()); 
		Custom_click(ob.Refer_yourself(), ob.Refer_yourself().getText());

	}
}
