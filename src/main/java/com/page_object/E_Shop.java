package com.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class E_Shop extends Base_Utility {

	public E_Shop() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Eshop\"]/android.view.ViewGroup/android.widget.TextView")
	private WebElement E_shop;
	@FindBy(xpath = "//android.view.View[@content-desc=\"cart\"]")
	private WebElement shoping_cart;
	@FindBy(xpath = "//android.view.View[@content-desc=\"wishlist\"]")
	private WebElement wishlist;
	@FindBy(xpath = "//android.view.View[@resource-id ='block-customer-login-heading']")
	private WebElement customer_login_heading;
	@FindBy(xpath = "//android.widget.EditText[@resource-id ='email']")
	private WebElement enter_email_or_mobile_number;
	@FindBy(xpath ="//android.view.View[@content-desc=\"Continue\"]")
	private WebElement Continue_button;
	@FindBy(xpath ="//android.view.View[@resource-id ='block-new-customer-heading']")
	private WebElement new_customer_heading;
	@FindBy(xpath ="//android.view.View[@content-desc=\"CREATE AN ACCOUNT\"]/android.widget.TextView")
	private WebElement Create_Account;
	public WebElement E_shop()
	{
		return E_shop;
	}
	public WebElement shoping_cart()
	{
		return shoping_cart;
	}
	public WebElement wishlist()
	{
		return wishlist;
	}
	public WebElement customer_login_heading()
	{
		return customer_login_heading;
	}
	public WebElement enter_email_or_mobile_number()
	{
		return enter_email_or_mobile_number;
	}
	public WebElement Continue_button()
	{
		return Continue_button;
	}
	public WebElement new_customer_heading()
	{
		return new_customer_heading;
	}
	public WebElement Create_Account()
	{
		return Create_Account;
	}
}
