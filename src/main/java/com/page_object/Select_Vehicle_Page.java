package com.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Select_Vehicle_Page extends Base_Utility {
	
	public Select_Vehicle_Page()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//android.widget.ImageView[@resource-id = 'com.customerapp.hero:id/ic_edit']")
	private WebElement edit_nickame;
	@FindBy(xpath ="//android.view.ViewGroup[@resource-id = 'com.customerapp.hero:id/btn_lay']")
	private WebElement continue_button;
	@FindBy(xpath ="//android.widget.ImageView[@index ='0']")
	private WebElement click_first_vehicle;
}
