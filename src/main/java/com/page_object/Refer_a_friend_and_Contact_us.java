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
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[3]")
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
	@FindBy(xpath = "(//android.widget.TextView[@text])[3]")
	private WebElement Select_state;
	@FindBy(xpath = "//android.widget.TextView[@text]")
	private List<WebElement> Select_State_list;

	public WebElement Select_state() {
		return Select_state;
	}

	public void Select_State(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == (Select_State_list.size() - 1)) {
					Select_State_list.get(i).click();
					Select_state.click();
					i = 0;
				}
			}
		}
	}

//************************************	Select_City **********************************
	@FindBy(xpath = "(//android.widget.TextView[@text])[4]")
	private WebElement Select_City;

	public WebElement Select_City() {
		return Select_City;
	}

	public void Select_City(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == (Select_State_list.size() - 1)) {
					Select_State_list.get(i).click();
					Select_City.click();
					i = 0;
				}
			}
		}
	}

//************************************	Select_Model **********************************
	@FindBy(xpath = "(//android.widget.TextView[@text])[5]")
	private WebElement Select_Model;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Submit_button;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'android:id/message']")
	private WebElement message;
	@FindBy(xpath = "//android.widget.Button[@resource-id ='android:id/button1']")
	private WebElement ok_button;

	public WebElement Select_Model() {
		return Select_Model;
	}

	public void Select_Model(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == (Select_State_list.size() - 1)) {
					Select_State_list.get(i).click();
					Select_Model.click();
					i = 0;
				}
			}
		}
	}

	public WebElement Submit_button() {
		return Submit_button;
	}

	public WebElement message() {
		return message;
	}

	public WebElement ok_button() {
		return ok_button;
	}

//************************************ Refer_yourself **********************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/detail_btn']")
	private WebElement Refer_yourself;

	public WebElement Refer_yourself() {
		return Refer_yourself;
	}

	// ************************************ Contact Us
	// **********************************
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[6]")
	private WebElement Contact_us;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/lbl3']")
	private List<WebElement> visit_Page;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/fb_header']")
	private List<WebElement> social_media_header;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/whatsapp_visit_page']")
	private WebElement whatsapp_visit_page;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/fb_text']")
	private List<WebElement> Visit_page_text;
	@FindBy(xpath = "//android.widget.Button[@text ='Log in']")
	private WebElement facebook_login;
	@FindBy(xpath = "//android.view.View[@content-desc=\"Log in\"]/android.widget.TextView")
	private WebElement instagram_login;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement contact_via_email;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement back;
	@FindBy(xpath = "(//android.widget.TextView[@text])[4]")
	private WebElement subscribers_count;
	@FindBy(xpath = "//android.widget.Button[@resource-id ='join-form-submit']")
	private WebElement Linkedin_agree_and_join;
	@FindBy(xpath = "(//android.view.View[@content-desc ='Join now']/android.widget.TextView)[1]")
	private WebElement Linkedin_Join_now;
	@FindBy(xpath = "//android.widget.Button[@text ='Dismiss']")
	private WebElement Close_linkedin_pop_message;
	@FindBy(xpath = "//android.view.View[@resource-id ='modal-header']")
	private WebElement Twiter_header;

	public WebElement Contact_us() {
		return Contact_us;
	}
	public WebElement back()
	{
		return back;
	}
	public void facebook() throws InterruptedException {
		try {
			String header = social_media_header.get(0).getText();
			msg(Visit_page_text.get(0).getText());
			Custom_click(visit_Page.get(0), header);
			Thread.sleep(2000);
			Custom_click(facebook_login, header + " Login");
			Custom_click(back, " Back from " + header);
		} catch (Exception e) {
			msg("" + e);
		}
	}

	public void instagram() throws InterruptedException {
		try {
			String header = social_media_header.get(1).getText();
			msg(Visit_page_text.get(1).getText());
			Custom_click(visit_Page.get(1), header);
			Thread.sleep(4000);
			Custom_click(instagram_login, header + " Login");
			Custom_click(back, " Back from " + header);
		} catch (Exception e) {
			msg("" + e);
		}
	}

	public void Whatsapp() {
		try {
			String header = social_media_header.get(2).getText();
			msg(Visit_page_text.get(2).getText());
			msg(" Whatsapp number =" + whatsapp_visit_page.getText());
			Custom_click(whatsapp_visit_page, header);
			try {
				if (whatsapp_visit_page.isDisplayed() == true) {
					msg("We can’t find WhatsApp on your device. Please install for better experience");
				} else {
					Custom_click(back, " Back from " + header);
					driver.navigate().back();
				}
			} catch (Exception e) {
				msg("WhatsApp on your device is available");
			}
		} catch (Exception e) {
			msg("" + e);
		}
	}

	public void youTube() throws InterruptedException {
		try {
			String header = social_media_header.get(3).getText();
			msg(Visit_page_text.get(3).getText());
			Custom_click(visit_Page.get(2), header);
			Thread.sleep(2000);
			msg("Total subscribers count =" + subscribers_count.getText());
			Custom_click(back, " Back from " + header);
		} catch (Exception e) {
			msg("" + e);
		}
	}

	public void Linkedin() throws InterruptedException {
		try {
			String header = social_media_header.get(4).getText();
			msg(Visit_page_text.get(4).getText());
			Custom_click(visit_Page.get(3), header);
			Thread.sleep(2000);
			Custom_click(Close_linkedin_pop_message, "Close linkedin pop message");
			try {
				Custom_click(Linkedin_Join_now, header + " " + Linkedin_Join_now.getText());
			} catch (Exception e) {
				Custom_click(Linkedin_agree_and_join, header);
				Custom_click(Linkedin_agree_and_join, Linkedin_agree_and_join.getText());
			}
			Custom_click(back, " Back from " + header);
		} catch (Exception e) {
			msg("" + e);
		}
	}

	public void twitter() throws InterruptedException {
		try {
			Scroll_down_page_Action("Twitter");
			String header = social_media_header.get(4).getText();
			msg(Visit_page_text.get(4).getText());
			Custom_click(visit_Page.get(4), header);
			Thread.sleep(7000);
			msg(Twiter_header.getText());
			Custom_click(back, " Back from " + header);
		} catch (Exception e) {
			msg("" + e);
		}
	}

	// ************************************ Contact Via Email
	// **********************************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Contact_via_email;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.google.android.gm:id/welcome_tour_title']")
	private WebElement Welcome_message;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.google.android.gm:id/welcome_tour_text']")
	private WebElement Welcome_message2;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.google.android.gm:id/welcome_tour_next']")
	private WebElement welcome_tour_next;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.google.android.gm:id/welcome_tour_promotion']")
	private WebElement welcome_tour_promotion;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.google.android.gm:id/welcome_tour_done']")
	private WebElement welcome_tour_done;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.google.android.gm:id/setup_addresses_title']")
	private WebElement addresses_title;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.google.android.gm:id/setup_addresses_add_another']")
	private WebElement add_email_address;
	@FindBy(xpath = "(//android.widget.LinearLayout[@resource-id ='com.google.android.gm:id/account_setup_item'])[1]")
	private WebElement google;

	public WebElement Contact_via_email() {
		return Contact_via_email;
	}

	public WebElement Welcome_message() {
		return Welcome_message;
	}

	public WebElement Welcome_message2() {
		return Welcome_message2;
	}

	public WebElement welcome_tour_next() {
		return welcome_tour_next;
	}

	public WebElement welcome_tour_promotion() {
		return welcome_tour_promotion;
	}

	public WebElement welcome_tour_done() {
		return welcome_tour_done;
	}

	public WebElement addresses_title() {
		return addresses_title;
	}

	public WebElement add_email_address() {
		return add_email_address;
	}

	public WebElement google() {
		return google;
	}
}
