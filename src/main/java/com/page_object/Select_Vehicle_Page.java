package com.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.utility.Base_Utility;

public class Select_Vehicle_Page extends Base_Utility {
	
	public Select_Vehicle_Page()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//android.widget.ImageView[@resource-id = 'com.customerapp.hero:id/ic_edit']")
	private WebElement edit_nickame_button;
	@FindBy(xpath ="//android.widget.EditText[@text = 'Enter Nickname']")
	private WebElement edit_nickame_text;
	@FindBy(xpath ="//android.widget.TextView[@text = 'Save']")
	private WebElement save_button;
	@FindBy(xpath ="//android.view.ViewGroup[@resource-id = 'com.customerapp.hero:id/btn_lay']")
	private WebElement continue_button;
	@FindBy(xpath ="//android.widget.ImageView[@index ='0']")
	private WebElement click_first_vehicle;
	@FindBy(xpath = "//android.widget.Button[@text = 'While using the app']")
	private WebElement While_using_the_app;
	@FindBy(xpath ="//android.widget.TextView[@text = 'We found 1 vehicles linked to you']")
	private WebElement vehicle_info;
	public WebElement edit_nickame_button()
	{
		return edit_nickame_button;
	}
	public WebElement edit_nickame_text()
	{
		return edit_nickame_text;
	}
	public WebElement continue_button()
	{
		return continue_button;
	}
	public WebElement click_first_vehicle()
	{
		return click_first_vehicle;
	}
	public WebElement save_button()
	{
		return save_button;
	}
	public WebElement While_using_the_app()
	{
		return While_using_the_app;
	}
	public void vehicle_count()
	{		int Vehicle_count =0;
		 String vehicle_mess = vehicle_info.getText();
		 System.out.println(vehicle_mess);
		char vehicle[]= vehicle_mess.toCharArray();
		for(int i =0;i<vehicle.length;i++)
		{
			if(Character.isDigit(vehicle[i]))
			{
				Vehicle_count = Vehicle_count + vehicle[i];
			}
		}
		test.log(Status.PASS, "Total number of Vehicles registered in this number is = " +Vehicle_count);
		log.info("Total number of Vehicles registered in this number is  " +Vehicle_count);
		}
	}

