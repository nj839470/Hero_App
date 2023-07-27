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
//		login = new Login_Page_Test();
//		login.login();
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
		Custom_click(ob.winner_of_month(), ob.winner_of_month().getText());
		msg("Winner month =" +ob.winner_month().getText());
			ob.Winner_info();
			msg("Total ="+ob.Total_winner().getText());
			Custom_click(ob.back_button(), " Back from Winner Of The Month ");
		}catch(Exception e)
		{
			msg(""+e);
		}
	}
	
	@Test(priority = 8)
	public void TC089_verify_Points_Earning_and_Redemption() {
		msg(ob.point_earning_message().getText());
			ob.points_earning_redemption_view_detail();
			ob.point_earn_condition();
			msg(ob.Tier3_message().getText());
			ob.Tier3_distance_message();
			msg(ob.point_earning_end_message().getText());
			Custom_click(ob.back_button(), " Back from points earning redemption ");
	}
	@Test(priority = 9)
	public void TC090_verify_Service_Privilegers() {
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());
		ob.service_previleges_all_message();
		scrollByText("Show Less");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());

	}
	@Test(priority = 10)
	public void TC091_verify_Benefits_and_Experiences()
	{
		Scroll_down_page_Action("Benefits and Experiences");
		Custom_click(ob.show_more_Benefits_and_Experiences(), ob.show_more_Benefits_and_Experiences().getText() +" in Benefits & Experiences" );
		ob.Benefits_message();
		Custom_click(ob.show_more_Benefits_and_Experiences(), ob.show_more_Benefits_and_Experiences().getText() +" in Benefits & Experiences" );
	}
	@Test(priority = 11)
	public void TC092_verify_Remarkable_Rewards()
	{
		Custom_click(ob.Show_more_in_remarkable_rewards(), ob.Show_more_in_remarkable_rewards().getText());
		Scroll_down_page_Action("Remarkable show more");
		ob.Remarkable_Rewards_message();
		Custom_click(ob.show_more_Benefits_and_Experiences(), ob.show_more_Benefits_and_Experiences().getText());
		Custom_click(ob.back_button(), " Back from Hero GoodLife ");
	}

}