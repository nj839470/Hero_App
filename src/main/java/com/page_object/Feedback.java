package com.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Feedback extends Base_Utility{
	
	public Feedback()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/rv_item_lbl'])[6]")
	private WebElement feedback;
	@FindBy(xpath ="(//android.widget.Spinner[@resource-id ='com.customerapp.hero:id/filled_exposed'])[1]")
	private WebElement Category;
	@FindBy(xpath ="(//android.widget.Spinner[@resource-id ='com.customerapp.hero:id/filled_exposed'])[2]")
	private WebElement Sub_Category;
	@FindBy(xpath ="(//android.widget.Spinner[@resource-id ='com.customerapp.hero:id/filled_exposed'])[3]")
	private WebElement Sub_Sub_Category;
	@FindBy(xpath ="//android.widget.EditText[@resource-id ='com.customerapp.hero:id/et_your_feedback']")
	private WebElement feedback_message;
	@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement submit_feedback;
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
}
