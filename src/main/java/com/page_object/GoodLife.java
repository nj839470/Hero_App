package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class GoodLife extends Base_Utility {
	public GoodLife() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/navigation_bar_item_small_label_view'])[2]")
	private WebElement GoodLife;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/goodLifeSlider_imageview']")
	private WebElement goodlife_image;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1']")
	private WebElement goodlife_text;
	public WebElement goodLife()
	{
		return GoodLife;
	}
	public WebElement goodlife_image() {
		return goodlife_image;
	}

	public WebElement goodlife_text() {
		return goodlife_text;
	}

//******************************show_more_service_privilegers*******************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/down_ic_btn']")
	private WebElement show_more_service_privilegers;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/benefit_lbl']")
	private List<WebElement> service_previleges_all_message;

	public WebElement show_more_service_privilegers() {
		return show_more_service_privilegers;
	}

	public void service_previleges_all_message() {
		for (int i = 0; i < service_previleges_all_message.size(); i++) {
			msg(service_previleges_all_message.get(i).getText());
		}
	}

//******************************Points Earning & Redemption*******************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl3']")
	private WebElement point_earning_message;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/points_earning_redemption_view_detail_btn']")
	private WebElement points_earning_redemption_view_detail;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl19']")
	private WebElement Tier3_message;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl13']")
	private WebElement Tier3_distance;
	@FindBy(xpath ="//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/lbl')]")
	private List<WebElement> point_earn_condition;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/lbl3'])[9]")
	private WebElement Tier3_distance_message;
	@FindBy(xpath  ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/thats_not_end_lbl1']")
	private WebElement point_earning_end_message;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement become_member_button;
	@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement back_button;
	public WebElement point_earning_message() {
		return point_earning_message;
	}
	public WebElement points_earning_redemption_view_detail() {
		return points_earning_redemption_view_detail;
	}
	public WebElement Tier3_message()
	{
		return Tier3_message;
	}
	public void point_earn_condition()
	{
		for(int i=0;i<point_earn_condition.size();i++) {
			if(i<3)
			{
				msg(point_earn_condition.get(i).getText());
			}
			else if(i>=3 && i <=12)
			{
				msg(point_earn_condition.get(i).getText() +" = " + point_earn_condition.get(i+1).getText());
				i++;
			}
			else if(i==13)
			{
				msg(point_earn_condition.get(i).getText());
			}
			else if(i>=14 && i<=25)
			{
				msg(point_earn_condition.get(i).getText() +" = " + point_earn_condition.get(i+1).getText());
				i++;
			}
			else
			{
				Scroll_down_page_Action("Become a GoodLife Member");
				break;
			}
		}
	}
	public WebElement Tier3_distance()
	{
		return Tier3_distance;
	}
	public WebElement Tier3_distance_message()
	{
		return Tier3_distance_message;
	}
	public WebElement point_earning_end_message()
	{
		return point_earning_end_message;
	}
	public WebElement become_member_button()
	{
		return become_member_button;
	}
	public WebElement back_button()
	{
		return back_button;
	}
	//******************************winner information *******************************
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1']")
	private WebElement winner_of_month;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl2'])[2]")
	private WebElement winner_month;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/winner_name_lbl']")
	private WebElement winner_name;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/winner_loc_lbl']")
	private WebElement winner_loc;
	@FindBy(xpath ="//android.widget.TextView[@resource-id='com.customerapp.hero:id/winner_prize_lbl2']")
	private WebElement winner_prize;
	public WebElement winner_of_month()
	{
		return winner_of_month;
	}
	public WebElement winner_month()
	{
		return winner_month;
		
	}
	public WebElement winner_name()
	{
		return winner_name;
	}
	public WebElement winner_loc()
	{
		return winner_loc;
	}
	public WebElement winner_prize()
	{
		return winner_prize;
	}
	//******************************Benefits and Experiences *******************************	
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/benefit_lbl']")
	private List<WebElement> Benefits_message;
	public void Benefits_message()
	{
		for(int i=0;i<Benefits_message.size();i++)
		{
			msg(Benefits_message.get(i).getText());
		}
	}
	//******************************Remarkable Rewards *******************************
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/down_ic_btn'])[2]")
	private WebElement Show_more_in_remarkable_rewards;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/benefit_lbl']")
	private List<WebElement> Remarkable_Rewards_message;
	public WebElement Show_more_in_remarkable_rewards()
	{
		return Show_more_in_remarkable_rewards;
	}
	public void Remarkable_Rewards_message()
	{
		for(int i=0;i<Remarkable_Rewards_message.size();i++)
		{
			msg(Remarkable_Rewards_message.get(i).getText());
		}
	}
	

//******************************Pro Membership in become member *******************************
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/plan_name'])[1]")
	private WebElement plan_name;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/plan_price'])[1]")
	private WebElement plan_price;
	@FindBy(xpath ="//android.widget.TextView[@text]")
	private List<WebElement> pro_membership_plan_info;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl'])[2]")
	private WebElement Select_plan_button;
	public WebElement plan_name()
	{
		return plan_name;
	}
	public void pro_membership_plan_info()
	{
		for(int i=1;i<10;i++)
		{
			if(i<3)
			{
				msg(pro_membership_plan_info.get(i).getText());
			}
			else if(i>=3 && i<9)
			{
			msg(pro_membership_plan_info.get(i).getText() +" = " +pro_membership_plan_info.get(i+1).getText());
			i++;
			}
			else if(i==9)
			{
				Custom_click(pro_membership_plan_info.get(i), pro_membership_plan_info.get(i).getText());
			}
		}
	}
	public WebElement Select_plan_button()
	{
		return Select_plan_button;
	}
}
