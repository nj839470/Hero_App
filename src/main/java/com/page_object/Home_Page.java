package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.utility.Base_Utility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Home_Page extends Base_Utility {
	public Home_Page() {
		PageFactory.initElements(driver, this);
	}

	// *************************Temperature**********************
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/weather_lbl']")
	private WebElement temperature;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1'])[1]")
	private WebElement vehicle_drop_down;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/bike_name_lbl']")
	private List<WebElement> all_vehicle_inside_drop_down;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/vehicle_img']")
	private WebElement vehicle_img;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/ic_notification']")
	private WebElement notification;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
	private List<WebElement> notification_count;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.customerapp.hero:id/back_btn']")
	private WebElement notification_back;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/collapse_btn']")
	private WebElement Collapse_btn;

	public WebElement temperature() {
		return temperature;
	}

	public void all_vehicle_inside_drop_down() throws InterruptedException {
		Custom_click(vehicle_drop_down, " Drop down");
		for (int i = 0; i < all_vehicle_inside_drop_down.size(); i++) {
			Custom_click(all_vehicle_inside_drop_down.get(i), i + " vehicle");
			Thread.sleep(2000);
			Custom_click(vehicle_drop_down, " Drop down");
		}
		Custom_click(vehicle_drop_down, " Drop down");
	}

	public WebElement vehicle_img() {
		return vehicle_img;
	}

	public WebElement notification() {
		return notification;
	}

	public int notification_count() {
		return notification_count.size();
	}

	public WebElement notification_back() {
		return notification_back;
	}

	public WebElement Collapse_btn() {
		return Collapse_btn;
	}

//*************************Navigate Page**********************
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='0']")
	private WebElement Navigate_menu;
	@FindBy(xpath = "//android.widget.TextView[@text ='Search Destination']")
	private WebElement Search_destination;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl']")
	private WebElement Search_here;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/service_center_lbl']")
	private WebElement Searched_name;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/service_center_address_lbl']")
	private WebElement Searched_address;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Navigate_button;
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id ='com.customerapp.hero:id/navigate']")
	private WebElement Start;
	@FindBy(xpath = "//android.widget.TextView[@resource-id= 'com.customerapp.hero:id/lbl']")
	private WebElement change_search;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement Back_button;

	public WebElement Navigate_menu() {
		return Navigate_menu;
	}

	public WebElement Search_destination() {
		return Search_destination;
	}

	public WebElement Search_here() {
		return Search_here;
	}

	public WebElement Searched_name() {
		return Searched_name;
	}

	public WebElement Searched_address() {
		return Searched_address;
	}

	public WebElement Navigate_button() {
		return Navigate_button;
	}

	public WebElement Start() {
		return Start;

	}

	public WebElement change_search() {
		return change_search;
	}

	public WebElement Back_button() {
		return Back_button;
	}

//****************************Documents Page************************************
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='1']")
	private WebElement Documents_Menu;
	@FindBy(xpath = "//android.widget.TextView[@text ]")
	private List<WebElement> Documents_list;
	@FindBy(xpath = "//android.widget.TextView[@text ='Add now']")
	private WebElement Add_Now;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
	private WebElement Document_Check;
	@FindBy(xpath = "//android.widget.Button[@text ='While using the app']")
	private WebElement While_using_the_app;
	@FindBy(xpath = "//android.widget.Button[@text ='Allow']")
	private WebElement Allow;
	@FindBy(xpath = "//android.widget.TextView[@text ='Choose from library']")
	private WebElement Choose_Document_from_library;
	@FindBy(xpath = "//android.widget.TextView[@text ='Take a Photo']")
	private WebElement Take_a_Photo;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross_btn']")
	private WebElement document_upload_close_button;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement Back;

	public WebElement Documents_Menu() {
		return Documents_Menu;
	}

	public WebElement Back() {
		return Back;
	}

	public void Documents_list() throws InterruptedException {
		for (int i = 1; i < Documents_list.size(); i++) {
			String name = Documents_list.get(i).getText();
			Custom_click(Documents_list.get(i), name);
			msg(Document_Check.getText());
			Custom_click(Add_Now, name + " Add now");
			if (i == 1) {
				Custom_click(While_using_the_app, "While using the app");
				Custom_click(Allow, "Allow");
				Thread.sleep(2000);
				Custom_click(Add_Now, name + " Add now");
			}
			Custom_click(Choose_Document_from_library, name + " Document frmo library");
			driver.navigate().back();
			Custom_click(Add_Now, name + " Add now");
			Custom_click(Take_a_Photo, "Take a Photo");
			driver.navigate().back();
			Custom_click(Add_Now, name + " Add now");
			Custom_click(document_upload_close_button, "Close upload document page");
			Custom_click(Back, name + " Back Document");

		}
	}

//****************************Relationship Manager************************************
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='2']")
	private WebElement Relationship_Manager;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1']")
	private WebElement Relationship_Manager_name;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl2']")
	private WebElement Relationship_Manager_Address;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl3']")
	private WebElement Relationship_Manager_Contact_number;
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.customerapp.hero:id/tsmAsmName')]")
	private List<WebElement> Others_Contacts;

	public WebElement Relationship_Manager() {
		return Relationship_Manager;
	}

	public WebElement Relationship_Manager_name() {
		return Relationship_Manager_name;
	}

	public WebElement Relationship_Manager_Address() {
		return Relationship_Manager_Address;
	}

	public WebElement Relationship_Manager_Contact_number() {
		return Relationship_Manager_Contact_number;
	}

	public void Others_Contacts() {
		for (int i = 0; i < Others_Contacts.size(); i++) {
			msg("Others Contacts information =" + Others_Contacts.get(i).getText());
		}
	}

//****************************RSA************************************
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='3']")
	private WebElement RSA;
	@FindBy(xpath ="//android.widget.TextView[@text ='Locate nearest dealer']")
	private WebElement locate_nearest_dealer;

	public WebElement RSA() {
		return RSA;
	}
		public WebElement locate_nearest_dealer()
		{
			return locate_nearest_dealer;
		}
	

//****************************Technical Support************************************
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='4']")
	private WebElement Technical_Support;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/lbl1']")
	private WebElement Technical_Support_Manager_Name;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/lbl2']")
	private WebElement Technical_Support_Manager_Address;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/lbl3']")
	private WebElement Technical_Support_Manager_Contact_Number;

	public WebElement Technical_Support() {
		return Technical_Support;
	}

	public WebElement Technical_Support_Manager_Name() {
		return Technical_Support_Manager_Name;
	}

	public WebElement Technical_Support_Manager_Address() {
		return Technical_Support_Manager_Address;
	}

	public WebElement Technical_Support_Manager_Contact_Number() {
		return Technical_Support_Manager_Contact_Number;
	}

//****************************Dealer Locator************************************
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='5']")
	private WebElement Dealer_Locator;
	@FindBy(xpath = "(//android.widget.TextView[@text])[2]")
	private WebElement Select_State;
	@FindBy(xpath = "(//android.widget.TextView[@text])[3]")
	private WebElement Select_City;
	@FindBy(xpath = "//android.widget.TextView[@text]")
	private List<WebElement> Select_State_list;
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.customerapp.hero:id/floating_button2']")
	private WebElement map_view;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/service_center_lbl']")
	private List<WebElement> Dealer_name;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/service_center_address_lbl']")
	private WebElement Dealer_address;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/service_center_km_lbl']")
	private WebElement Dealer_distance;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/service_center_duration_lbl']")
	private WebElement Dealer_duration_time;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/callBtn']")
	private WebElement Call_Dealer;

	public WebElement Dealer_Locator() {
		return Dealer_Locator;
	}

	public WebElement Select_State() {
		return Select_State;
	}

	public WebElement Select_City() {
		return Select_City;
	}

	public void Select_State(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == 17) {
					Select_State_list.get(i).click();
					Select_State.click();
					i = 0;
				}
			}
		}
	}

	public void Select_City(String value) {
		for (int i = 0; i < Select_State_list.size(); i++) {
			if (Select_State_list.get(i).getText().equalsIgnoreCase(value)) {
				Custom_click(Select_State_list.get(i), value);
				break;
			} else {
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if (i == 17) {
					Select_State_list.get(i).click();
					Select_City.click();
					i = 0;
				}
			}
		}
	}

	public WebElement map_view() {
		return map_view;
	}

	public void Dealer_info() {
		int avilable_dealer = Dealer_name.size();
		msg("Total available dealer is =" + avilable_dealer);
		for (int i = 0; i < avilable_dealer; i++) {
			msg((i + 1) + " Dealer name =" + Dealer_name.get(i).getText());
			msg((i + 1) + " Dealer address =" + Dealer_address.getText());
			msg((i + 1) + " Dealer distance =" + Dealer_distance.getText());
			msg((i + 1) + " Dealer duration time =" + Dealer_duration_time.getText());
			Custom_click(Call_Dealer, (i + 1) + " Call Dealer button ");
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().back();
		}
	}

}
