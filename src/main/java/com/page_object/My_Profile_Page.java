package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class My_Profile_Page extends Base_Utility {
	public My_Profile_Page() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//android.widget.FrameLayout[@resource-id ='com.customerapp.hero:id/hmcDashboardFrg']")
	private WebElement home;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/side_menu_btn']")
	private WebElement side_menu_button;
	@FindBy(xpath = "//android.widget.TextView[@text ='My Profile']")
	private WebElement my_profile;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/user_name']")
	private WebElement user_name;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/user_mobile_no']")
	private WebElement user_mobile_no;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/user_email']")
	private WebElement user_email;
	@FindBy(xpath = "//android.widget.TextView[@text ='More details']")
	private WebElement More_details;
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/tv')]")
	private List<WebElement> user_info;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/user_dob']")
	private WebElement user_dob;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/gender']")
	private WebElement user_gender;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/blood_group']")
	private WebElement user_blood_group;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement edit_profile_details_button;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/profile_pic_edit_btn']")
	private WebElement profile_pic_edit_btn;
	@FindBy(xpath = "//android.widget.TextView[@text ='Choose from library']")
	private WebElement Choose_from_library;
	@FindBy(xpath = "//android.widget.TextView[@text ='Take a Photo']")
	private WebElement Take_a_Photo;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross_btn']")
	private WebElement upload_close_button;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement Back;
	@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross']")
	private WebElement close_my_profile_page;
	public WebElement home()
	{
		return home;
	}
	public WebElement side_menu_button() {
		return side_menu_button;
	}

	public WebElement my_profile() {
		return my_profile;
	}

	public WebElement user_name() {
		return user_name;
	}

	public WebElement user_mobile_no() {
		return user_mobile_no;
	}

	public WebElement user_email() {
		return user_email;
	}

	public WebElement More_details() {
		return More_details;
	}
	public WebElement Back() {
		return Back;
	}
	public void user_info() {
		msg(user_info.get(0).getText() + " = " + user_dob.getText());
		msg(user_info.get(1).getText() + " = " + user_gender.getText());
		msg(user_info.get(2).getText() + " = " + user_blood_group.getText());
	}

	public WebElement edit_profile_details_button() {
		return edit_profile_details_button;
	}

	public WebElement profile_pic_edit_btn() {
		return profile_pic_edit_btn;
	}

	public WebElement Choose_from_library() {
		return Choose_from_library;
	}
	public WebElement close_my_profile_page()
	{
		return close_my_profile_page;
	}

	public WebElement Take_a_Photo() {
		return Take_a_Photo;
	}

	public WebElement upload_close_button() {
		return upload_close_button;
	}
}
