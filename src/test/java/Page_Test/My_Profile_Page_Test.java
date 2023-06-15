package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.My_Profile_Page;
import com.utility.Base_Utility;

@Listeners(com.utility.listner.class)
public class My_Profile_Page_Test extends Base_Utility {

	public Login_Page_Test login;
	public My_Profile_Page ob;

	@Test(priority = 0)
	public void TC026_Verify_My_Profile() throws InterruptedException {
		msg("************************My_Profile_Page_Test**************************");
		ob = new My_Profile_Page();
//		login = new Login_Page_Test();
//		login.login();
		Custom_click(ob.home(), "Home");
		Thread.sleep(2000);
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.my_profile(), "My profile");
		msg("User name = " + ob.user_name().getText());
		msg("User mobile number =" + ob.user_mobile_no().getText());
		msg("User email =" + ob.user_email().getText());
	}

	@Test(priority = 1)
	public void TC027_verify_more_detais_button() {
		Custom_click(ob.More_details(), "More details");
		ob.user_info();
	}

	@Test(priority = 2)
	public void TC028_edit_prifile() {
		Custom_click(ob.edit_profile_details_button(), "Edit profile details button");
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		if(ob.Choose_from_library().isDisplayed()!=true)
		{
		Custom_click(ob.while_using_the_app(), "while_using_the_app");
		Custom_click(ob.allow(), "Allow");
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		}
		
		Custom_click(ob.Choose_from_library(), " Chose profile pic from liberary ");
		driver.navigate().back();
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		Custom_click(ob.Take_a_Photo(), " Take a pic for profile ");
		driver.navigate().back();
		Custom_click(ob.profile_pic_edit_btn(), "profile pic edit button");
		Custom_click(ob.upload_close_button(), " Upload close button ");
		Custom_click(ob.Back(), " Back from edit profile Details");
		Custom_click(ob.Back(), " Back from profile Details");
		Custom_click(ob.close_my_profile_page(), " close my profile page ");

	}
}
