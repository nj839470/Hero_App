package com.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.utility.Base_Utility;
@Listeners(com.utility.listner.class)
public class Login_page extends Base_Utility {
	public Login_page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//android.widget.ImageView[@content-desc=\"Cancel\"]")
	private WebElement close;
	@FindBy(id = "com.customerapp.hero:id/text_input_editext")
	private WebElement mobile_No;
	@FindBy(id= "com.customerapp.hero:id/cus_orange_button_lay")
	private WebElement continue_button;
	@FindBy(id ="com.customerapp.hero:id/welcome_view")
	private WebElement right_button;
	public WebElement close()
	{
		return close;
	}

	public WebElement mobile_No()
	{
		return mobile_No;
	}
	public WebElement continue_button()
	{
		return continue_button;
	}
	public WebElement right_button()
	{
		return right_button;
	}
	public void enterOTP()
	{
		for(int i=0;i<=5;i++)
		{
			driver.findElement(By.xpath("//android.widget.EditText[@index='i']")).sendKeys("i");
		}
	}
}
