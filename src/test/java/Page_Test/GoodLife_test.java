package Page_Test;

import org.testng.annotations.Test;

import com.page_object.GoodLife;
import com.utility.Base_Utility;

public class GoodLife_test extends Base_Utility {

	public GoodLife ob;
	public Login_Page_Test login;

	@Test(priority = 0)
	public void TC081_verify_image_in_goodlife_page() throws InterruptedException {
		msg("*********************Goodlife_page**************************");
		ob = new GoodLife();
		login = new Login_Page_Test();
		login.login();
		Thread.sleep(3000);
		Custom_click(ob.goodLife(), ob.goodLife().getText());
		Thread.sleep(2000);
		try {
			if (ob.goodlife_image().isDisplayed() == true) {
				msg("Image available on Goodlife page");
			} else {
				msg("Image missing on Good Life ");
			}
			msg(ob.goodlife_text().getText());
		} catch (Exception e) {
			msg("" + e);
		}
	}
	@Test(priority = 1)
	public void TC082_Verify_Pro_Membership() throws InterruptedException
	{
		msg("Plan Name =" +ob.plan_name().getText());
		ob.plan_info();
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());
		ob.pro_membership_plan_info();
	}
	@Test(priority = 2)
	public void TC083_Verify_Earning_History_in_Pro_Membership()
	{
		Custom_click(ob.Earning_History(), ob.Earning_History().getText());
			ob.earning_history();
		}
	@Test(priority = 3)
	public void TC084_Verify_Redemption_History_in_Pro_Membership()
	{
		Custom_click(ob.Redemption_History(), ob.Redemption_History().getText());
		try {
		msg(ob.Redemption_History_value().getText());
		}catch(Exception e) {
			msg("Redemption History value is given");
		}
		Custom_click(ob.back_button(), " Back from Transaction History");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());
		}
	@Test(priority = 4)
	public void TC085_Verify_Complete_profile()
	{
		msg(ob.Profile_text().getText());
		Custom_click(ob.update_profile(), ob.update_profile().getText());
		msg(ob.update_profile_text().getText());
		msg(ob.profile_goodlife().getText());
		Custom_click(ob.back_button(), " Back from Complete Profile Rewards");
	}
	@Test(priority = 5)
	public void TC086_Verify_Welcome_Rewards()
	{
		msg(ob.Welcome_text().getText());
		Custom_click(ob.View_Details(), ob.View_Details().getText());
		msg(ob.update_profile_text().getText());
		msg(ob.profile_goodlife().getText());
		Custom_click(ob.back_button(), " Back from Complete Profile Rewards");
	}
	@Test(priority = 6)
	public void TC087_Verify_refer_friend_in_Goodlife() throws InterruptedException
	{
		msg(ob.Referral_Offer().getText());
		Custom_click(ob.Know_more(), ob.Know_more().getText());
		ob.Referral_all_offer();
		Thread.sleep(2000);
		Custom_click(ob.back_button(), " Back from Vehicle Purchase Referral");
		Custom_click(ob.term_Condition(), ob.term_Condition().getText());
		Custom_click(ob.back_button(), " Back from Terms of Use");
		Custom_click(ob.back_button(), " Back from Referrals");
	}
	@Test(priority = 7)
	public void TC088_verify_Winner_informaton()
	{
		scrollByText("Points Earning & Redemption");
		try {
		msg(ob.winner_of_month().getText());
		try {
		msg("Winner month =" +ob.winner_month().getText());
		}catch(Exception e) { msg("Winner of month is not given"); }
		try {
		msg("Winner name =" +ob.winner_name().getText());
		}catch(Exception e) { msg("Winner name is not given"); }
		try {
		msg("Winner Loction =" +ob.winner_loc().getText());
		}catch(Exception e) { msg("Winner location not given"); }
		try {
		msg("Winner prize =" +ob.winner_prize().getText());
		}catch(Exception e) { msg("Winner prize is not given"); }
		}catch(Exception e) { msg("Winner of month information is not given"); }

	}
	
	@Test(priority = 8)
	public void TC089_verify_Points_Earning_and_Redemption() {
		scrollByText("Service Privileges");
		msg(ob.point_earning_message().getText());
		Custom_click(ob.points_earning_redemption_view_detail(),
				"points earning redemption" + ob.points_earning_redemption_view_detail().getText());
			ob.point_earn_condition();
			msg(ob.Tier3_message().getText());
			msg(ob.Tier3_distance().getText() + " = " +ob.Tier3_distance_message().getText());
			msg(ob.point_earning_end_message().getText());
			Custom_click(ob.back_button(), " Back from points earning redemption ");
	}
	@Test(priority = 9)
	public void TC090_verify_Service_Privilegers() {
		scrollByText("Benefits & Experiences");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());
		ob.service_previleges_all_message();
		scrollByText("Points Earning & Redemption");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());

	}
	@Test(priority = 10)
	public void TC091_verify_Benefits_and_Experiences()
	{
		scrollByText("Remarkable Rewards");	
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText() +" in Benefits & Experiences" );
		ob.Benefits_message();
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText() +" in Benefits & Experiences" );
	}
	@Test(priority = 11)
	public void TC092_verify_Remarkable_Rewards()
	{
		Scroll_down_page_Action("Remarkable show more");
		Custom_click(ob.Show_more_in_remarkable_rewards(), ob.Show_more_in_remarkable_rewards().getText());
		Scroll_down_page_Action("Become a GoodLife Member");
		ob.Remarkable_Rewards_message();
		Custom_click(ob.Show_more_in_remarkable_rewards(), ob.Show_more_in_remarkable_rewards().getText());
	}

}