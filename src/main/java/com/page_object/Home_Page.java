package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Home_Page extends Base_Utility{
	public Home_Page()
	{
		PageFactory.initElements(driver, this);
	}
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
@FindBy(xpath ="//android.widget.TextView[@text ='Navigation']")
private WebElement Search_here;
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
}
