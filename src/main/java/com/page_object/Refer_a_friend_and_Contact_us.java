package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Refer_a_friend_and_Contact_us extends Base_Utility {

	public Refer_a_friend_and_Contact_us() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id ='com.customerapp.hero:id/hmcDashboardFrg']")
	private WebElement home;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/side_menu_btn']")
	private WebElement side_menu_button;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[4]")
	private WebElement refer_friend;
	@FindBy(xpath = "(//android.widget.EditText[@resource-id ='com.customerapp.hero:id/text_input_editext'])[1]")
	private WebElement friend_name;
	@FindBy(xpath = "(//android.widget.EditText[@resource-id ='com.customerapp.hero:id/text_input_editext'])[2]")
	private WebElement friend_mob_no;
	public WebElement home() {
		return home;
	}

	public WebElement side_menu_button() {
		return side_menu_button;
	}
	public WebElement refer_friend() {
		return refer_friend;
	}

	public WebElement friend_name() {
		return friend_name;
	}

	public WebElement friend_mob_no() {
		return friend_mob_no;
	}
//************************************	Select_state **********************************
	@FindBy(xpath ="(//android.widget.TextView[@text])[3]")
	private WebElement Select_state;
	@FindBy(xpath = "//android.widget.TextView[@text]")
	private List<WebElement> Select_State_list;
	public WebElement Select_state()
	{
		return Select_state;
	}
	public void Select_State(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == 10) {
					Select_State_list.get(i).click();
					Select_state.click();
					i = 0;
				}
			}
		}
	}

//************************************	Select_City **********************************
	@FindBy(xpath ="(//android.widget.TextView[@text])[4]")
	private WebElement Select_City;
	public WebElement Select_City()
	{
		return Select_City;
	}
	public void Select_City(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == 10) {
					Select_State_list.get(i).click();
					Select_City.click();
					i = 0;
				}
			}
		}
	}

//************************************	Select_Model **********************************
	@FindBy(xpath ="(//android.widget.TextView[@text])[5]")
	private WebElement Select_Model;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Submit_button;
	@FindBy(xpath ="//android.widget.TextView[@resource-id = 'android:id/message']")
	private WebElement message;
	@FindBy(xpath ="//android.widget.Button[@resource-id ='android:id/button1']")
	private WebElement ok_button;
	public WebElement Select_Model()
	{
		return Select_Model;
	}
	public void Select_Model(String value) {
	for (int i = 0; i < Select_State_list.size(); i++) {
		if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
			Custom_click(Select_State_list.get(i), value);
			break;
		} else {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
			if (i == 10) {
				Select_State_list.get(i).click();
				Select_Model.click();
				i = 0;
			}
		}
	}
}
	public WebElement Submit_button()
	{
		return Submit_button;
	}
	public WebElement message()
	{
		return message;
	}
	public WebElement ok_button()
	{
		return ok_button;
	}
//************************************ Refer_yourself **********************************
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/detail_btn']")
	private WebElement Refer_yourself;
	public WebElement Refer_yourself()
	{
		return Refer_yourself;
	}
	//************************************ Contact Us **********************************
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[5]")
	private WebElement Contact_us;
	@FindBy(xpath ="//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/lbl3']")
	private List<WebElement> visit_Page;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/fb_header']")
	private List<WebElement> social_media_header;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/whatsapp_visit_page']")
	private WebElement whatsapp_visit_page;
	public WebElement Contact_us()
	{
		return Contact_us;
	}
	public void media_list()
	{
		for(int i=0,j=0; i<social_media_header.size();i++)
		{
			String header = social_media_header.get(i).getText();
			if(header.equalsIgnoreCase("Whatsapp"))
			{
				Custom_click(whatsapp_visit_page, header);
				msg(" Whatsapp number =" +whatsapp_visit_page.getText());
				j--;
			}
			Custom_click(visit_Page.get(j), header);
			j++;
			if(j>3)
			{
				Scroll_down_page_Action("Twitter");
			}
		}
	}
}
