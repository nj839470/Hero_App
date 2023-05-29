package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
@Listeners(com.utility.listner.class)
public class Base_Utility implements Config_data_provider , Excel_data_Provider , extent_reports_generator , library ,ITestListener
{
	public static Logger log;
	public static ExtentSparkReporter report;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static listner lis;
	public WebDriverWait wait;
	String confipath=System.getProperty("user.dir")+"\\config_data\\config.properties";
	String excelpath = System.getProperty("user.dir") + "\\data\\data1.xlsx";
	public static AndroidDriver driver;
	
	
@BeforeTest
public void OPEN_AND_INSTALL_APP() 
{
	try {
  //-----for virtual device---------
	UiAutomator2Options db=new UiAutomator2Options();
//	DesiredCapabilities db = new DesiredCapabilities();
	db.setCapability("appium:automationName", "uiautomator2");
	db.setCapability("platformName", "Android");
	db.setCapability("appium:deviceName", "Pixel_6_API_31");
	db.setCapability("appium:udid", "emulator-5554");
	db.setCapability("appium:avdLaunchTimeout", 600000);
	db.setCapability("appium:app",(System.getProperty("user.dir")+"\\apk\\app-debug.apk"));
	driver =new AndroidDriver(new URL(config_getdata("IpAddress")), db);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	log = LogManager.getLogger("Hero_App_Apk");
	db.setCapability("appium:ensureWebviewsHavePages", true);
	db.setCapability("appium:nativeWebScreenshot", true);
	db.setCapability("appium:newCommandTimeout", 6600);
	 lis = new listner();

 //-------- for real device----------
//	
//		db.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//		db.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
//		db.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 9");
//		db.setCapability(MobileCapabilityType.UDID, "74633a84");
//		db.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//		db.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

	} catch (Exception e) {
	System.out.println(e);
	}
}
@Override
public String config_getdata(String key) 
{
	String value = "";
	try {
		FileInputStream fis = new FileInputStream(confipath);
		Properties prop = new Properties();
		prop.load(fis);
		value = prop.getProperty(key);

	} catch (Exception e) {
		System.out.println("Problem in read data from property file" + e);
	}
	return value;
}
@Override
public String excel_getdata(int sheetno, int row_No, int col_No) {
	String value = "";
	try {
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook wf = new XSSFWorkbook(fis);
		XSSFSheet sheet = wf.getSheetAt(sheetno);
		value = sheet.getRow(row_No).getCell(col_No).getStringCellValue();

	} catch (Exception e) {
		System.out.println("Problem in read data from excel file" + e);
	}
	return value;
}
@Override
public int getRowCount(int sheetno) {
	int count = 0;
	try {
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook wf = new XSSFWorkbook(fis);
		XSSFSheet sheet = wf.getSheetAt(sheetno);
		count = sheet.getLastRowNum();

	} catch (Exception e) {
		System.out.println("Problem in read data from excel file for Row_Count" + e);
	}
	return count;
}
@Override
public int getColCount(int sheetno) {
	int count = 0;
	try {
		FileInputStream fis = new FileInputStream(excelpath);
		XSSFWorkbook wf = new XSSFWorkbook(fis);
		XSSFSheet sheet = wf.getSheetAt(sheetno);
		count = sheet.getRow(0).getLastCellNum();
	} catch (Exception e) {
		System.out.println("Problem in read data from excel file for Row_Count" + e);
	}
	return count;
}
@Override
public void excel_writedata(int sheetno, int row_No, int col_No, String value) {
	try {
		FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetno);
			sheet.createRow(row_No).createCell(col_No).setCellValue(value);
			FileOutputStream fos = new FileOutputStream(excelpath);
			workbook.write(fos);
			workbook.close();
		} catch (Exception e) {
		System.out.println("Problem in Write data in excel file" + e);
	}
	
}
@Override
public ExtentReports getreports() {
	String path=System.getProperty("user.dir")+"\\Report\\index.html";
	report=new ExtentSparkReporter(path);
	report.config().setDocumentTitle("Hero_App Test Report");
	report.config().setReportName("Hero_App");
	report.config().setTheme(Theme.DARK);
	extent=new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("System Name", "Project Name");
	extent.setSystemInfo("Laptop-Dell", "Hero_App");
	extent.setSystemInfo("QA", "Nitesh Kumar");
	extent.setSystemInfo("Operating system", "Windows 10 pro");
	extent.setSystemInfo("BrowserName", "Chrome");
	return extent;
}
@Override
public void custom_sendkeys(WebElement element, String value, String fieldname) {
	try {
		if(element.isEnabled() || element.isDisplayed()==true) {
			 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		    	wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			element.sendKeys(value);
		test.log(Status.PASS, fieldname+ " value send successfully ="+value +" " +fieldname );
		log.info(fieldname +" send successfully");
		}
}
catch(Exception e) {
		test.log(Status.FAIL, fieldname +" is not able to send" +e);
		log.error(fieldname +" is not able to send");
		lis.onTestFailure(null);
		}
	
}
@Override
public void Custom_click(WebElement element, String fieldname) {
	try {
		if(element.isDisplayed() || element.isEnabled()==true) {
			 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	    	wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			test.log(Status.PASS, "Successfully click on = "+ fieldname);
			log.info(fieldname + " is clickable");
		}
	}
catch(Exception e) {
		test.log(Status.FAIL,fieldname+ "==Unable To Click =="+e);
		log.error(fieldname + " is not clickable");
		lis.onTestFailure(null);
					}
	}
//======================================================================================================================================================	    
@SuppressWarnings({ "deprecation", "rawtypes" })
public void Scroll_down_page_Action(String fieldname) {  	
    try {
    	Dimension dim = driver.manage().window().getSize();	    	
    	int startx = (int) (dim.width*0.5);
    	int starty = (int) (dim.height*0.2);	    	
    	int endx   =  (int) (dim.width*0.2);  	
    	int endy   = (int) (dim.height*0.8);
    	TouchAction action = new TouchAction(driver);
    	action.press(PointOption.point(startx ,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx ,endy))
    		.release().perform();
    	test.log(Status.PASS, "Successfully Scroll page Action =="+ fieldname);
    	log.info("Successfully  Scroll page down Action "+fieldname);
    	
    }catch(Exception e) {		    	
		test.log(Status.FAIL,fieldname+ "Unable To Scroll page Action =="+e);
    	log.error("==NOT==Unable To Scroll page down Action "+fieldname);
	}	    
}
//======================================================================================================================================================
@SuppressWarnings({ "rawtypes", "deprecation" })
	public void swipe_page_direction(int startx,int starty,int endx,int endy,String fieldname ) {
  	try {
  		TouchAction action = new TouchAction(driver);
      	action.press(PointOption.point(startx ,starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx ,endy))
  		.release().perform();
      	log.info("Successfully  Swipe page direction Action "+fieldname);
  	}catch(Exception e) {		    	
  		log.error("==NOT==Unable To Swipe page direction Action "+fieldname);
		}	
  }
////////////////////////////////////////////////////////////////////////////////////////////////////
@Override
public void VerifyImagePresent(WebElement image, String fieldname) {
	try {
		Boolean ImagePresent = (Boolean)((JavascriptExecutor) driver)
.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image);
		if (ImagePresent) {
			test.log(Status.PASS, "Image is present:  " + fieldname);
			log.info("Image is present " + fieldname);
		}
		else
		{
			test.log(Status.FAIL, fieldname + "==Image is not present ==" );
			log.error("Image is not present" + fieldname);
			lis.onTestFailure(null);
			
			}
	} catch (Exception e) {
		test.log(Status.FAIL, fieldname + "==Image is not present ==" + e);
		log.error("Image is not present" + fieldname);
	lis.onTestFailure(null);
	}
}
@SuppressWarnings("deprecation")
@Override
public void PageLoaded() {
	String	Title = null;
	try {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Title = driver.getTitle();
			test.log(Status.PASS, "Page is loaded : " + Title);
			log.info("Page is loaded " + Title);
		} catch (Exception e) {
			test.log(Status.FAIL, "==page is not loaded :" + e);
			log.error("page is not able to loaded " + Title);
			lis.onTestFailure(null);
			}
	}
@Override
public void VerifyElementPresent(WebElement ele, String fieldname) {
	try {
		if (ele.isDisplayed()&& ele.isEnabled()== true){
			String Text = ele.getText();
			test.log(Status.PASS,  fieldname +" present:" );
			log.info(fieldname +" present");
		}
		else
		{
			test.log(Status.PASS, fieldname +"  not present" );
			log.info(fieldname +"  not present" );
		}
	} catch (Exception e) {
		test.log(Status.FAIL, fieldname + " not present" + e);
		log.error(fieldname  +"  not present");
		lis.onTestFailure(null);
	}

	
}
}


