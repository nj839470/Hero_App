package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Vehicle_Details extends Base_Utility {

	public Vehicle_Details() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id ='com.customerapp.hero:id/hmcDashboardFrg']")
	private WebElement home;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/side_menu_btn']")
	private WebElement side_menu_button;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[2]")
	private WebElement Vehicle_Details;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/sp_selected_vehicle']")
	private WebElement Selected_vehicle;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/img_vehicle']")
	private WebElement Vehicle_img;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_primary_vehicle']")
	private WebElement vehicle_status;
	@FindBy(xpath = "//android.widget.TextView[@resource-id= 'com.customerapp.hero:id/tv_vehicle_no']")
	private WebElement Vehicle_number;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/title'])[1]")
	private WebElement verify_GoodLife;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/lbl'])[2]")
	private WebElement verify_goodlife_page;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/title'])[2]")
	private WebElement verify_joyRide;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/subtitle']")
	private WebElement verify_joyRide_page;
	public WebElement home() {
		return home;
	}

	public WebElement side_menu_button() {
		return side_menu_button;
	}

	public WebElement Vehicle_details() {
		return Vehicle_Details;
	}

	public WebElement Selected_vehicle() {
		return Selected_vehicle;
	}

	public WebElement Vehicle_img() {
		return Vehicle_img;
	}

	public WebElement vehicle_status() {
		return vehicle_status;
	}

	public WebElement Vehicle_number() {
		return Vehicle_number;
	}
	public WebElement verify_GoodLife()
	{
		return verify_GoodLife;
	}
	public WebElement verify_goodlife_page()
	{
		return verify_goodlife_page;
	}
	public WebElement verify_joyRide()
	{
		return verify_joyRide;
	}
	public WebElement verify_joyRide_page()
	{
		return verify_joyRide_page;
	}

//**************************************More details *************************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_details']")
	private WebElement more_details;

	public WebElement more_details() {
		return more_details;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_header']")
	private List<WebElement> Vehicle_header;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_value']")
	private List<WebElement> vehicle_info;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_value'])[4]")
	private WebElement nick_name_edit;
	@FindBy(xpath = "//android.widget.EditText[@resource-id ='com.customerapp.hero:id/text_input_editext']")
	private WebElement nick_name_input_field;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement save_button;

	public void vehicle_info() {
		try {
		for (int i = 0; i < vehicle_info.size(); i++) {
			msg(Vehicle_header.get(i).getText() + " = " + vehicle_info.get(i).getText());
		}
		}catch(Exception e) 
		{ msg(""+e);
		}
	}

	public WebElement nick_name_edit() {
		return nick_name_edit;
	}

	public WebElement nick_name_input_field() {
		return nick_name_input_field;
	}

	public WebElement save_button() {
		return save_button;
	}

//******************************************My vehicle documents *****************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_documents']")
	private WebElement my_vehicle_documents;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement back_button;

	public WebElement my_vehicle_documents() {
		return my_vehicle_documents;
	}

	public WebElement back_button() {
		return back_button;
	}

//******************************************My owners Manual *****************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_owners_manual']")
	private WebElement owners_manual;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
	private WebElement owners_title;
	@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/imageview']")
	private WebElement Manual_Owners_info;

	public WebElement owners_manual() {
		return owners_manual;
	}

	public WebElement owners_title() {
		return owners_title;
	}
	public WebElement Manual_Owners_info()
	{
		return Manual_Owners_info;
	}
//********************************************** Service History ***********************************
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_service_history']")
	private WebElement My_vehicle_Service_history;
	public WebElement My_vehicle_Service_history()
	{
		return My_vehicle_Service_history;
	}
	//********************************************** Tips and DIY videos ***********************************
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[3]")
	private WebElement Tips_and_DIY_videos;
	@FindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Tips\"]/android.widget.TextView")
	private WebElement Tips_info;
	@FindBy(xpath ="//android.widget.LinearLayout[@content-desc=\"DIY Videos\"]/android.widget.TextView")
	private WebElement DIY_Videos;
	public WebElement Tips_and_DIY_videos()
	{
		return Tips_and_DIY_videos;
	}
	public WebElement Tips_info()
	{
		return Tips_info;
	}
	public WebElement DIY_Videos()
	{
		return DIY_Videos;
	}

}
