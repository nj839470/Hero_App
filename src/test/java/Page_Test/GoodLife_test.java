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
//		Thread.sleep(3000);
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
	public void TC082_verify_Service_Privilegers() {
		scrollByText("Points Earning & Redemption");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());
		ob.service_previleges_all_message();
		scrollByText("Points Earning & Redemption");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());

	}
	@Test(priority = 2)
	public void TC083_verify_Points_Earning_and_Redemption() {
		msg(ob.point_earning_message().getText());
		Custom_click(ob.points_earning_redemption_view_detail(),
				"points earning redemption" + ob.points_earning_redemption_view_detail().getText());
			ob.point_earn_condition();
			msg(ob.Tier3_message().getText());
			msg(ob.Tier3_distance().getText() + " = " +ob.Tier3_distance_message().getText());
			msg(ob.point_earning_end_message().getText());
			Custom_click(ob.back_button(), " Back from points earning redemption ");
	}
	@Test(priority = 3)
	public void TC084_verify_Winner_informaton()
	{
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
	@Test(priority = 4)
	public void TC085_verify_Benefits_and_Experiences()
	{
		scrollByText("Remarkable Rewards");	
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText() +" in Benefits & Experiences" );
		ob.Benefits_message();
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText() +" in Benefits & Experiences" );
	}
	@Test(priority = 5)
	public void TC086_verify_Remarkable_Rewards()
	{
		Scroll_down_page_Action("Become a GoodLife Member");
		Custom_click(ob.Show_more_in_remarkable_rewards(), ob.Show_more_in_remarkable_rewards().getText());
		Scroll_down_page_Action("Become a GoodLife Member");
		ob.Remarkable_Rewards_message();
		Custom_click(ob.Show_more_in_remarkable_rewards(), ob.Show_more_in_remarkable_rewards().getText());
	}
	@Test(priority = 6)
	public void TC087_Verify_Pro_Membership() throws InterruptedException
	{
		Custom_click(ob.become_member_button(), ob.become_member_button().getText());
		Thread.sleep(2000);
		ob.pro_membership_plan_info();
		Custom_click(ob.Select_plan_button(), ob.Select_plan_button().getText());
		Custom_click(ob.back_button(), " Back from profile Form ");
		Custom_click(ob.back_button(), " Back from plan ");
	}
	@Test(priority = 7)
	public void TC088_Verify_Silver_Membership()
	{
		ob.Silver_Membership_plan_info();
		Custom_click(ob.Select_plan_button(), ob.Select_plan_button().getText());
		Custom_click(ob.back_button(), " Back from profile Form ");
		Custom_click(ob.back_button(), " Back from plan ");
	}
	@Test(priority = 8)
	public void TC089_Verify_Gold_Membership()
	{
		scrollByText("Gold Membership");
		ob.Gold_Membership_info();
		Custom_click(ob.Select_plan_button(), ob.Select_plan_button().getText());
		Custom_click(ob.back_button(), " Back from profile Form ");
		Custom_click(ob.back_button(), " Back from plan ");
	}
	@Test(priority = 9)
	public void TC090_Verify_Platinum_Membership()
	{
		Scroll_down_page_Action("Platinum Membership");
		ob.Platinum_Membership_info();
		Custom_click(ob.Select_plan_button(), ob.Select_plan_button().getText());
		Custom_click(ob.back_button(), " Back from profile Form ");
		Custom_click(ob.back_button(), " Back from plan ");
		Custom_click(ob.back_button(), " Back from GoodLife Plans ");
		Custom_click(ob.back_button(), " Back from Hero GoodLife ");
	}
	}
