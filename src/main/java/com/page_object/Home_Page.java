package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.utility.Base_Utility;

public class Home_Page extends Base_Utility{
	public Home_Page()
	{
		PageFactory.initElements(driver, this);
	}
	//*************************Temperature**********************
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/weather_lbl']")
private WebElement temperature;
@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1'])[1]")
private WebElement vehicle_drop_down;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/bike_name_lbl']")
private List<WebElement> all_vehicle_inside_drop_down;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/vehicle_img']")
private WebElement vehicle_img;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/ic_notification']")
private WebElement notification;
@FindBy(xpath="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
private List<WebElement> notification_count;
@FindBy(xpath="//android.widget.ImageView[@resource-id='com.customerapp.hero:id/back_btn']")
private WebElement notification_back	;
@FindBy(xpath ="//android.widget.TextView[@resource-id='com.customerapp.hero:id/collapse_btn']")
private WebElement Collapse_btn;
public WebElement temperature()
{
	return temperature;
}

public void all_vehicle_inside_drop_down() throws InterruptedException
{
	Custom_click(vehicle_drop_down, " Drop down");
	for(int i=0;i<all_vehicle_inside_drop_down.size();i++)
	{
		Custom_click(all_vehicle_inside_drop_down.get(i), i +" vehicle");
		Thread.sleep(2000);
		Custom_click(vehicle_drop_down, " Drop down");
	}
	Custom_click(vehicle_drop_down, " Drop down");
}
public WebElement vehicle_img()
{
	return vehicle_img;
}
public WebElement notification()
{
	return notification;
}
public int notification_count()
{
	return notification_count.size();
}
public WebElement notification_back()
{
	return notification_back;
}
public WebElement Collapse_btn()
{
	return Collapse_btn;
}
//*************************Navigate Page**********************
@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='0']")
private WebElement Navigate_menu;
@FindBy(xpath ="//android.widget.TextView[@text ='Search Destination']")
private WebElement Search_destination;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl']")
private WebElement Search_here;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/service_center_lbl']")
private WebElement Searched_name;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/service_center_address_lbl']")
private WebElement Searched_address;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
private WebElement Navigate_button;
@FindBy(xpath ="//android.widget.FrameLayout[@resource-id ='com.customerapp.hero:id/navigate']")
private WebElement Start;
@FindBy(xpath ="//android.widget.TextView[@resource-id= 'com.customerapp.hero:id/lbl']")
private WebElement change_search;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
private WebElement Back_button;
		public WebElement Navigate_menu()
		{
			return Navigate_menu;
		}
		public WebElement Search_destination() {
			return Search_destination;
		}
		public WebElement Search_here()
		{
			return Search_here;
		}
		public WebElement Searched_name()
		{
			return Searched_name;
		}
		public WebElement Searched_address()
		{
			return Searched_address;
		}
		public WebElement Navigate_button()
		{
			return Navigate_button;
		}
		public WebElement Start()
		{
			return Start;
			
		}
		public WebElement change_search()
		{
			return change_search;
		}
		public WebElement Back_button()
		{
			return Back_button;
		}
//****************************Documents Page************************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='1']")
private WebElement Documents_Menu;
@FindBy(xpath ="//android.widget.TextView[@text ]")
private List<WebElement> Documents_list;
@FindBy(xpath ="//android.widget.TextView[@text ='Add now']")
private WebElement Add_Now;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
private WebElement Document_Check;
@FindBy(xpath ="//android.widget.Button[@text ='While using the app']")
private WebElement While_using_the_app;
@FindBy(xpath ="//android.widget.Button[@text ='Allow']")
private WebElement Allow;
@FindBy(xpath ="//android.widget.TextView[@text ='Choose from library']")
private WebElement Choose_Document_from_library;
@FindBy(xpath ="//android.widget.TextView[@text ='Take a Photo']")
private WebElement Take_a_Photo;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross_btn']")
private WebElement document_upload_close_button;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
private WebElement Back;
public WebElement Documents_Menu()
{
	return Documents_Menu;
}
public WebElement Back()
{
	return Back;
}
public void Documents_list() throws InterruptedException
{
	for(int i=1;i<Documents_list.size();i++) 
	{
		String name = Documents_list.get(i).getText();
		Custom_click(Documents_list.get(i), name);
		test.log(Status.PASS, Document_Check.getText());
		log.info(Document_Check.getText());
		Custom_click(Add_Now, name +" Add now");
		if(i==1)
		{
			Custom_click(While_using_the_app, "While using the app");
			Custom_click(Allow, "Allow");
			Thread.sleep(2000);
			Custom_click(Add_Now, name +" Add now");
		}
		Custom_click(Choose_Document_from_library, name+" Document frmo library");
		driver.navigate().back();
		Custom_click(Add_Now,name+ " Add now");
		Custom_click(Take_a_Photo, "Take a Photo");
		driver.navigate().back();
		Custom_click(Add_Now, name+" Add now");
		Custom_click(document_upload_close_button, "Close upload document page");
		Custom_click(Back, name +" Back Document");

	}
}
//****************************Relationship Manager************************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='2']")
private WebElement Relationship_Manager;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1']")
private WebElement Relationship_Manager_name;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl2']")
private WebElement Relationship_Manager_Address;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl3']")
private WebElement Relationship_Manager_Contact_number;
@FindBy(xpath ="//android.widget.TextView[contains(@resource-id, 'com.customerapp.hero:id/tsmAsmName')]")
private List<WebElement> Others_Contacts;
public WebElement Relationship_Manager()
{
	return Relationship_Manager;
}
public WebElement Relationship_Manager_name()
{
	return Relationship_Manager_name;	
}
public WebElement Relationship_Manager_Address()
{
	return Relationship_Manager_Address;
}
public WebElement Relationship_Manager_Contact_number()
{
	return Relationship_Manager_Contact_number;
}
public void Others_Contacts()
{
	for(int i=0;i<Others_Contacts.size();i++)
	{
		msg("Others Contacts information =" +Others_Contacts.get(i).getText());
	}
}
//****************************RSA************************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='3']")
private WebElement RSA;
public WebElement RSA()
{
	return RSA;
}
//****************************Technical Support************************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='4']")
private WebElement Technical_Support;
@FindBy(xpath ="//android.widget.TextView[@resource-id='com.customerapp.hero:id/lbl1']")
private WebElement Technical_Support_Manager_Name;
@FindBy(xpath ="//android.widget.TextView[@resource-id='com.customerapp.hero:id/lbl2']")
private WebElement Technical_Support_Manager_Address;
@FindBy(xpath ="//android.widget.TextView[@resource-id='com.customerapp.hero:id/lbl3']")
private WebElement Technical_Support_Manager_Contact_Number;
public WebElement Technical_Support()
{
	return Technical_Support;
}
public WebElement Technical_Support_Manager_Name()
{
	return Technical_Support_Manager_Name;
}
public WebElement Technical_Support_Manager_Address()
{
	return Technical_Support_Manager_Address;
}
public WebElement Technical_Support_Manager_Contact_Number()
{
	return Technical_Support_Manager_Contact_Number;
}
//****************************Dealer Locator************************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/root'][@index ='5']")
private WebElement Dealer_Locator;
@FindBy(xpath ="//android.widget.TextView[@text ='Select State']")
private WebElement Select_State;
@FindBy(xpath ="//android.widget.TextView[@text ='Select City']")
private WebElement Select_City;
public WebElement Dealer_Locator()
{
	return Dealer_Locator;
}
public WebElement Select_State()
{
	return Select_State;
}
public WebElement Select_City()
{
	return Select_City;
}
}