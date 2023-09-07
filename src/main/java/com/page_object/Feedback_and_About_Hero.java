package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Feedback_and_About_Hero extends Base_Utility{
	
	public Feedback_and_About_Hero()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id ='com.customerapp.hero:id/hmcDashboardFrg']")
	private WebElement home;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/side_menu_btn']")
	private WebElement side_menu_button;
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[7]")
	private WebElement feedback;
	@FindBy(xpath ="(//android.widget.ImageButton[@content-desc='Show dropdown menu'])[1]")
	private WebElement Category;
	@FindBy(xpath ="(//android.widget.ImageButton[@content-desc='Show dropdown menu'])[2]")
	private WebElement Sub_Category;
	@FindBy(xpath ="(//android.widget.ImageButton[@content-desc='Show dropdown menu'])[3]")
	private WebElement Sub_Sub_Category;
	@FindBy(xpath ="//android.widget.EditText[@resource-id ='com.customerapp.hero:id/et_your_feedback']")
	private WebElement feedback_message;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement submit_feedback;
	@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement back_btn;
	public WebElement home() {
		return home;
	}

	public WebElement side_menu_button() {
		return side_menu_button;
	}
	public WebElement feedback()
	{
		return feedback;
	}
	public WebElement Category()
	{
		return Category;
	}

	public WebElement Sub_Category()
	{
		return Sub_Category;
	}
	
	public WebElement Sub_Sub_Category()
	{
		return Sub_Sub_Category;
	}
	public WebElement feedback_message()
	{
		return feedback_message;
	}
	public WebElement submit_feedback()
	{
		return submit_feedback;
	}
	public WebElement back_btn()
	{
		return back_btn;
	}
	
	//************************************************About Hero***************************************
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[8]")
	private WebElement about_hero;
	@FindBy(xpath ="//android.view.View[@resource-id='container-6a13db6644']/android.view.View")
	private WebElement about_hero_message_1;
	@FindBy(xpath ="//android.view.View[@resource-id='container-6a13db6644']/android.widget.TextView")
	private WebElement about_hero_message_2;
	@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross']")
	private WebElement Cross_button;
	public WebElement about_hero()
	{
		return about_hero;
	}
	public WebElement about_hero_message_1()
	{
		return about_hero_message_1;
	}
	public WebElement about_hero_message_2()
	{
		return about_hero_message_2;
	}
	public WebElement Cross_button()
	{
		return Cross_button;
	}
	//**********************************************Wheels of_Trust_Select_State*********************************
	@FindBy(xpath ="//androidx.recyclerview.widget.RecyclerView[@resource-id ='com.customerapp.hero:id/sideMenuOffer']//android.widget.ImageView")
	private WebElement goodlife;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl']")
	private WebElement goodlife_page_test;
	@FindBy(xpath ="//android.view.View[@resource-id ='cookieNotice']")
	private WebElement cookieNotice;
	@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/iv_trust']")
	private WebElement wheels_of_trust;
	@FindBy(xpath ="//android.widget.RadioButton[@resource-id ='eng_lang_select']")
	private WebElement Language_select;
	@FindBy(xpath ="(//android.view.View[contains(@text , 'Vehicle')])[1]")
	private WebElement Vehicle_Details;
	@FindBy(xpath ="//android.view.View[@resource-id ='QRCodeState']")
	private WebElement State;
	@FindBy(xpath ="//android.widget.CheckedTextView[@resource-id ='android:id/text1']")
	private List<WebElement> Select_State;
	public WebElement goodlife()
	{
		return goodlife;
	}
	public WebElement goodlife_page_test()
	{
		return goodlife_page_test;
	}
	public WebElement wheels_of_trust()
	{
		return wheels_of_trust;
	}
	public WebElement Language_select()
	{
		return Language_select;
	}
	public WebElement Vehicle_Details()
	{
		return Vehicle_Details;
	}
	public WebElement State()
	{
		return State;
	}
	public void Select_State(String State_Name)
	{
		for(int i=0;i<Select_State.size();i++)
		{
			String State_name = Select_State.get(i).getText();
			if(State_name.equalsIgnoreCase(State_Name))
			{
				Custom_click(Select_State.get(i), State_name);
				break;
			}
			else
			{
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if(i== (Select_State.size()-1))
				{
					Select_State.get(i).click();
					State.click();
					i=0;
				}
			}
		}
	}
	public WebElement cookieNotice()
	{
		return cookieNotice;
	}
 //**********************************************Wheels of_Trust_Select_city*********************************
	@FindBy(xpath ="//android.view.View[@resource-id ='QRCodeCity']")
	private WebElement City;
	@FindBy(xpath ="//android.widget.CheckedTextView[@resource-id ='android:id/text1']")
	private List<WebElement> Select_city;
	@FindBy(xpath ="//android.widget.EditText[@resource-id = 'pincode']")
	private WebElement Pincode;
	@FindBy(xpath ="//android.view.View[contains(@text , 'Select Two')]")
	private WebElement Two_Wheeler;
	@FindBy(xpath ="//android.widget.Image[@text = 'motorcycle']")
	private WebElement motorcycle;
	public WebElement City()
	{
		return City;
	}
	public void Select_city(String State_Name)
	{
		for(int i=0;i<Select_city.size();i++)
		{
			String State_name = Select_city.get(i).getText();
			if(State_name.equalsIgnoreCase(State_Name))
			{
				Custom_click(Select_city.get(i), State_name);
				break;
			}
			else
			{
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if(i== (Select_city.size()-1))
				{
					Select_city.get(i).click();
					City.click();
					i=0;
				}
			}
		}
	}
	public WebElement Pincode()
	{
		return Pincode;
	}
	public WebElement Two_Wheeler()
	{
		return Two_Wheeler;
	}
	public WebElement motorcycle()
	{
		return motorcycle;
	}
	//**********************************************Wheels of_Trust_Select_company*********************************
	@FindBy(xpath ="//android.view.View[@resource-id ='QRcodeMake']")
	private WebElement Company;
	@FindBy(xpath ="//android.widget.CheckedTextView[@resource-id ='android:id/text1']")
	private List<WebElement> Select_Company;
	public WebElement Company()
	{
		return Company;
	}
	public void Select_Company(String State_Name)
	{
		for(int i=0;i<Select_Company.size();i++)
		{
			String State_name = Select_Company.get(i).getText();
			if(State_name.equalsIgnoreCase(State_Name))
			{
				Custom_click(Select_Company.get(i), State_name);
				break;
			}
			else
			{
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if(i== (Select_Company.size()-1))
				{
					Select_Company.get(i).click();
					Company.click();
					i=0;
				}
			}
		}
	}
	//**********************************************Wheels of_Trust_Select_Model*********************************
	@FindBy(xpath ="//android.view.View[@resource-id ='QRCodeModel']")
	private WebElement Model;
	@FindBy(xpath ="//android.widget.CheckedTextView[@resource-id ='android:id/text1']")
	private List<WebElement> Select_Model;
	@FindBy(xpath ="//android.widget.EditText[@resource-id ='datepicker-view-mode']")
	private WebElement enter_registraction_months_and_Years;
	@FindBy(xpath ="//android.widget.Button[@text ='Next']")
	private WebElement next_button;
	public WebElement Model()
	{
		return Model;
	}
	public void Select_Model(String State_Name)
	{
		for(int i=0;i<Select_Model.size();i++)
		{
			String State_name = Select_Model.get(i).getText();
			if(State_name.equalsIgnoreCase(State_Name))
			{
				Custom_click(Select_Model.get(i), State_name);
				break;
			}
			else
			{
				((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
				if(i== (Select_Model.size()-1))
				{
					Select_Model.get(i).click();
					Model.click();
					i=0;
				}
			}
		}
	}
	public WebElement enter_registraction_months_and_Years()
	{
		return enter_registraction_months_and_Years;
	}
	public WebElement next_button()
	{
		return next_button;
	}
	//**********************************************Wheels of_Trust_Select_Registraction_Months_And_Year*********************************
	
	//**********************************************Joyride*********************************
	@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/iv_joyride']")
	private WebElement Joyride;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
	private WebElement Joyride_page_test;
	
	
	public WebElement Joyride()
	{
		return Joyride;
	}
	public WebElement Joyride_page_test()
	{
		return Joyride_page_test;
	}
}
