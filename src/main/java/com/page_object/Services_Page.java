package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Services_Page extends Base_Utility{
	public Services_Page()
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath ="//android.widget.FrameLayout[@content-desc ='Services']")
private WebElement Services;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/brandName']")
private WebElement Vehicle_brand_Name;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/brandDetail1']")
private WebElement Vehicle_Nick_Name;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/brandDetail2']")
private WebElement Vehicle_Number;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
private WebElement service_info_and_raised_button;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/service_date_lbl']")
private WebElement service_booked_date;
public WebElement Services()
{
	return Services;
}
public WebElement Vehicle_brand_Name()
{
	return Vehicle_brand_Name;
}
public WebElement Vehicle_Nick_Name()
{
	return Vehicle_Nick_Name;
}
public WebElement Vehicle_Number()
{
	return Vehicle_Number;
}
public WebElement service_info_and_raised_button()
{
	return service_info_and_raised_button;
}
public WebElement service_booked_date()
{
	return service_booked_date;
}
//*********************************************Service details********************************
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/centerName']")
private WebElement Service_center_name;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/centerAddress']")
private WebElement Service_center_address;
@FindBy(xpath ="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/estimatedPrice']")
private WebElement Estimated_Amount;
@FindBy(xpath="//android.widget.TextView[@resource-id ='com.customerapp.hero:id/estimatedDate']")
private WebElement Estimated_date;
@FindBy(xpath ="//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/support')]")
private List<WebElement> Support_info;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/callImg1']")
private WebElement call_supporter;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/keyArrow']")
private WebElement collapse_button;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
private WebElement back;
public WebElement Service_center_name()
{
	return Service_center_name;
}
public WebElement Service_center_address()
{
	return Service_center_address;
}
public WebElement Estimated_Amount()
{
	return Estimated_Amount;
}
public WebElement Estimated_date()
{
	return Estimated_date;
}
public void Support_info()
{
	msg("Suppoter name =" +Support_info.get(0).getText() );
	msg("Suppoter profile =" +Support_info.get(1).getText());
	msg("Suppoter Mobile number ="+Support_info.get(2).getText());
}
public WebElement call_supporter()
{
	return call_supporter;
}
public WebElement collapse_button()
{
	return collapse_button;
}
public WebElement back()
{
	return back;
}
//*********************************************Service Booked********************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/service_constraint_lay']")
private WebElement Service_booked_details;
public WebElement Service_booked_details()
{
	return Service_booked_details;
}
//*********************************************Last Serviced********************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/serviceHistory_constraint_lay']")
private WebElement Last_serviced;
@FindBy(xpath ="//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id')]")
private List<WebElement> Service_history;
public WebElement Last_serviced()
{
	return Last_serviced;
}
public void Service_history()
{
	for(int i=0;i<Service_history.size();i++)
	{
		String service_info = Service_history.get(i).getText();
		if(service_info.equalsIgnoreCase("Details"))
		{
			Custom_click(Service_history.get(i), service_info);
			msg("Vehicle brand name in Ongoing Service details= " + Vehicle_brand_Name().getText());
			msg("Vehicle number in Ongoing Service details  = " + Vehicle_Nick_Name().getText());
			msg("Vehicle Serial number in Ongoing Service details =" + Vehicle_Number().getText());
			if (Service_center_name().isDisplayed() == true) {
				msg("Service center name =" + Service_center_name().getText());
			} else {
				msg("Service center name is not given");
			}
			msg("Service center address =" + Service_center_address().getText());
			msg("******************Job card , Estimated date & price ************************");
			msg("Estimated Amount =" + Estimated_Amount().getText());
			msg("Estimated Date & Time =" + Estimated_date().getText());
			Support_info();
			Custom_click(call_supporter(), " call supporter name ");
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().back();
			Custom_click(back(),Service_history.get(0).getText() );
		}
		else
		{
			msg(service_info);
		}
		}
	}
//*********************************************Tips & DIY********************************
@FindBy(xpath ="//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/tips_diy_constraint_lay']")
private WebElement Tips_and_DIY;
@FindBy(xpath ="//android.widget.TextView[contains(@resource-id, 'com.customerapp.hero:id')]")
private List<WebElement> tips_list;
@FindBy(xpath ="//android.widget.ImageView[@content-desc ='PDF PAGE']")
private WebElement image_verify;
@FindBy(xpath ="//android.widget.TextView[@text ='DIY Videos']")
private WebElement DIY_Videos_button;
@FindBy(xpath ="//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/lbl')]")
private List<WebElement> DIY_Videos_list ;
@FindBy(xpath ="//android.widget.Button[@text ='Play']")
private WebElement play_video;
@FindBy(xpath ="//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross_btn']")
private WebElement Video_close_button;
public WebElement Tips_and_DIY()
{
	return Tips_and_DIY;
}
public void tips_list() throws InterruptedException
{
	for(int i=1;i<tips_list.size();i++)
	{
		String tips = tips_list.get(i).getText();
		msg(tips);
		Custom_click(tips_list.get(i), tips);
		Thread.sleep(4000);
		if(image_verify.isDisplayed())
		{
			msg(tips +" PDF image is available for guide");
		}
		else
		{
			msg(tips +" PDF image is not available for guide");
		}
		Custom_click(back, "Back from " +tips);
		i++;
	}
}
public WebElement DIY_Videos_button()
{
	return DIY_Videos_button;
}
public void DIY_Videos_list() throws InterruptedException
{
	for(int i=2;i<DIY_Videos_list.size();i++)
	{
		String video = DIY_Videos_list.get(i).getText();
		msg(video +" Video");
		i++;
		Custom_click(DIY_Videos_list.get(i), video);
		Thread.sleep(3000);
		Custom_click(play_video, video +" Play video");
		Thread.sleep(1000);
		Custom_click(Video_close_button, video +" close");
		i++;
		
	}
}
}

