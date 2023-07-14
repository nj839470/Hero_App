package Page_Test;

import static org.testng.Assert.assertEquals;

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
	public void TC039_Refer_a_friend() throws InterruptedException
	{
		msg("************************Refer a Friend**************************");
		ob = new Refer_a_friend_and_Contact_us();
		login = new Login_Page_Test();
		login.login();
		Thread.sleep(3000);
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
	public void TC040_Verify_Select_State()
	{
		try {
		Custom_click(ob.Select_state(), ob.Select_state().getText());
		ob.Select_State("HARYANA");
		}catch(Exception e) 
		{ msg(""+e);
		}
	}
	@Test(priority = 2)
	public void TC041_Verify_Select_City()
	{
		try {
		Custom_click(ob.Select_City(), ob.Select_City().getText());
		ob.Select_City("AMBALA");
		}catch(Exception e) 
		{ msg(""+e);
		}
		
	}
	@Test(priority = 3)
	public void TC042_Verify_Select_Model()
	{
		try {
		Custom_click(ob.Select_Model(), ob.Select_Model().getText());
		ob.Select_Model("Passion Pro");
		driver.navigate().back();
		try {
		Custom_click(ob.Submit_button(), ob.Submit_button().getText());	
		msg(ob.message().getText());
		Custom_click(ob.ok_button(), ob.ok_button().getText());
		}catch(Exception e)
		{msg("Submit button is not available");
			}
		}catch(Exception e) 
		{ msg("Not able to Select Model");
		} 
	}
	@Test(priority = 4)
	public void TC043_Verify_Refer_yourself() throws InterruptedException
	{
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.refer_friend(), ob.refer_friend().getText()); 
		Custom_click(ob.Refer_yourself(), ob.Refer_yourself().getText());
		assertEquals(config_getdata("mobileno"), ob.friend_mob_no().getText());
		try {
		if(config_getdata("mobileno").equalsIgnoreCase(ob.friend_mob_no().getText()))
		{
			msg("Information matched as per registered account by mobile number");
			Custom_click(ob.Select_Model(), ob.Select_Model().getText());
			ob.Select_Model("Passion Pro");
			Custom_click(ob.Submit_button(), ob.Submit_button().getText());
			msg(ob.message().getText());
			Custom_click(ob.ok_button(), ob.ok_button().getText());
		}
		else
		{
			msg("Mobile number not matched with registered mobile number");
			Custom_click(ob.Select_Model(), ob.Select_Model().getText());
			ob.Select_Model("Passion Pro");
			Custom_click(ob.Submit_button(), ob.Submit_button().getText());
			msg(ob.message().getText());
			Custom_click(ob.ok_button(), ob.ok_button().getText());
		}
		}catch(Exception e) 
		{ msg(""+e);
		}
	
	}
	@Test(priority = 5)
	public void TC044_Verify_Facebook_in_Contact_us_page() throws InterruptedException
	{
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.Contact_us(), ob.Contact_us().getText());
		ob.facebook();
		}
	@Test(priority = 6)
	public void TC045_Verify_instagram_in_Contact_us_page() throws InterruptedException
	{
		ob.instagram();
	}
	@Test(priority = 7)
	public void TC046_Verify_Whatsapp_in_Contact_us_page()
	{
		ob.Whatsapp();
	}
	@Test(priority = 8)
	public void TC047_Verify_youTube_in_Contact_us_page() throws InterruptedException
	{
		ob.youTube();
	}
	@Test(priority = 9)
	public void TC048_Verify_Linkedin_in_Contact_us_page() throws InterruptedException
	{
		ob.Linkedin();
	}
	@Test(priority = 10)
	public void TC049_Verify_twitter_in_Contact_us_page() throws InterruptedException
	{
		ob.twitter();
	}
	@Test(priority = 11)
	public void TC050_Verify_Contact_via_Email() throws InterruptedException
	{
		Custom_click(ob.Contact_via_email(), ob.Contact_via_email().getText());
		if(ob.Contact_via_email().isDisplayed()==true)
		{
			Custom_click(ob.Contact_via_email(), ob.Contact_via_email().getText());
		}
		Thread.sleep(2000);
		msg(ob.Welcome_message().getText());
		msg(ob.Welcome_message2().getText());
		Custom_click(ob.welcome_tour_next(), "welcome tour next");
		msg(ob.welcome_tour_promotion().getText());
		Custom_click(ob.welcome_tour_done(), ob.welcome_tour_done().getText());
		msg(ob.addresses_title().getText());
		Custom_click(ob.add_email_address(), ob.add_email_address().getText());
		Custom_click(ob.google(), "Setup email with google");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Custom_click(ob.back(), " Back from Contact Us page");
	}
}
