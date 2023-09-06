package Page_Test;

import org.testng.annotations.Test;

import com.page_object.Feedback_and_About_Hero;
import com.utility.Base_Utility;

public class Feedback_and_About_Hero_test extends Base_Utility {

	public Feedback_and_About_Hero ob;
	public Login_Page_Test login;
	@Test(priority = 0)
	public void TC051_verify_Feedback() throws InterruptedException {
		msg("************************Feedback and About Hero test**************************");
		ob =new Feedback_and_About_Hero();
		login = new Login_Page_Test();
		login.login();
		Custom_click(ob.home(), "Home");
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.feedback(), ob.feedback().getText());
		Thread.sleep(2000);
		Custom_click(ob.Category(), "Category");
		Thread.sleep(2000);
		Custom_click(ob.Category(), "Return Category");
		Thread.sleep(2000);
		Custom_click(ob.Sub_Category(), "Sub_Category");
		Thread.sleep(2000);
		Custom_click(ob.Sub_Category(), "Return Sub_Category");
		Thread.sleep(2000);
		Custom_click(ob.Sub_Sub_Category(), "Sub_Sub_Category");
		Thread.sleep(2000);
		Custom_click(ob.Sub_Sub_Category(), "Return Sub_Sub_Category ");
		Thread.sleep(2000);
		custom_sendkeys(ob.feedback_message(), "Nice facility", " your Feedback");
		Custom_click(ob.back_btn(), "Back from Feedback page");
		
	}
	@Test(priority = 1)
	public void TC052_verify_About_Hero() 
	{
		try {
		Custom_click(ob.about_hero(), ob.about_hero().getText());
		Thread.sleep(10000);
		msg(ob.about_hero_message_1().getText());
		msg(ob.about_hero_message_2().getText());
		Custom_click(ob.back_btn(), "Back from About Hero page");
		
		}catch(Exception e)
		{
		msg(""+e);
		}
	}
	@Test(priority = 2)
	public void TC053_verify_Side_menu_page_function() 
	{
		try {
		Custom_click(ob.goodlife(), "Goodlife");
		Thread.sleep(6000);
		msg("goodlife page test =" +ob.goodlife_page_test().getText());
		Custom_click(ob.back_btn(), "Back from GoodLife page");
		}catch(Exception e){msg("" +e);}
	}
		public void TC053_Vehicle_Details_in_Wheels_of_trust()
		{
		try {
		Custom_click(ob.wheels_of_trust(), "Wheels of trust");
		Thread.sleep(5000);
		try {
		Custom_click(ob.Language_select(), "English language");	
		}catch(Exception e){msg("Language poup is not populate");}
		try {
		Custom_click(ob.Vehicle_Details(), ob.Vehicle_Details().getText());
		Custom_click(ob.State(), ob.State().getText());
		ob.Select_State("Delhi");
		}catch(Exception e){msg("Text is not able to readable");}
		Custom_click(ob.back_btn(), "Back from wheels of trust page");
		}catch(Exception e){msg("" +e);}
		try {
		Custom_click(ob.Joyride(), "Joyride");
		msg("Joyride page test =" +ob.Joyride_page_test().getText());
		Custom_click(ob.back_btn(), "Back from Joyride page");
		driver.navigate().back();
		}catch(Exception e)
		{
			msg("" +e);
		}
	}
}
