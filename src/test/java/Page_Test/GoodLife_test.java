package Page_Test;

import org.testng.annotations.Test;

import com.page_object.GoodLife;
import com.utility.Base_Utility;

public class GoodLife_test extends Base_Utility {

	public GoodLife ob;
	public Login_Page_Test login;

	@Test(priority = 0)
	public void verify_image_in_goodlife_page() throws InterruptedException {
		ob = new GoodLife();
		login = new Login_Page_Test();
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
	public void verify_Service_Privilegers() {
		scrollByText("Points Earning & Redemption");
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());
		ob.service_previleges_all_message();
		Custom_click(ob.show_more_service_privilegers(), ob.show_more_service_privilegers().getText());

	}
	
	public void verify_Points_Earning_and_Redemption() {
		msg(ob.point_earning_message().getText());
		Custom_click(ob.points_earning_redemption_view_detail(),
				"points earning redemption" + ob.points_earning_redemption_view_detail().getText());
			ob.point_earn_condition();
			msg(ob.Tier3_message().getText());
			msg(ob.Tier3_distance().getText() + " = " +ob.Tier3_distance_message().getText());
			msg(ob.point_earning_end_message().getText());
			Custom_click(ob.become_member_button(), ob.become_member_button().getText());
	}
}
