package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
@Listeners(com.utility.listner.class)
public class Base_Utility
implements Config_data_provider, Excel_data_Provider, extent_reports_generator, library, ITestListener {
	public static Logger log;
	public static ExtentSparkReporter report;
	public static AppiumDriverLocalService service;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static listner lis;
	public static WebDriverWait wait;
	public static TouchAction action;
	String confipath = System.getProperty("user.dir") + "\\config_data\\config.properties";
	String excelpath = System.getProperty("user.dir") + "\\data\\data1.xlsx";
	public static AndroidDriver driver;

	@BeforeSuite
	//******************Automatic server start code ************************
	public void appiumTest() throws Exception {
		
		Thread.sleep(2000);
		service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Welcome\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options db = new UiAutomator2Options();
		db.setCapability("appium:automationName", "uiautomator2");
		db.setCapability("platformName", "Android");
		db.setCapability("appium:deviceName", "Pixel_6_API_31");
		db.setCapability("appium:udid", "emulator-5554");
 //       db.setCapability("appium:avd", "Pixel_6");// if u connect real device comment this line
        db.setCapability("appium:avdLaunchTimeout", 600000);
		db.setCapability("appium:app", (System.getProperty("user.dir") + "\\apk\\app-debug.apk"));
		Thread.sleep(2000);
		driver = new AndroidDriver(new URL(config_getdata("IpAddress")), db);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		log = LogManager.getLogger("Hero_App");
		db.setCapability("appium:ensureWebviewsHavePages", true);
		db.setCapability("appium:nativeWebScreenshot", true);
		db.setCapability("appium:newCommandTimeout", 6600);

	}
	//******************Automatic server start code ************************

//	public void OPEN_AND_INSTALL_APP() {
//		try {
////  //-----for virtual device---------
//			
////  DesiredCapabilities db = new DesiredCapabilities();
//			UiAutomator2Options db = new UiAutomator2Options();
//			db.setCapability("appium:automationName", "uiautomator2");
//			db.setCapability("platformName", "Android");
//			db.setCapability("appium:deviceName", "Pixel_6_API_31");
//			db.setCapability("appium:udid", "emulator-5554");
//			db.setCapability("appium:avdLaunchTimeout", 600000);
//			db.setCapability("appium:app", (System.getProperty("user.dir") + "\\apk\\app-debug.apk"));
////			if(checkIfServerIsRunning(4723))
////			{
////				stopServer();
////			}
////			startServer();
//			driver = new AndroidDriver(new URL(config_getdata("IpAddress")), db);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//			log = LogManager.getLogger("Hero_App");
//			db.setCapability("appium:ensureWebviewsHavePages", true);
//			db.setCapability("appium:nativeWebScreenshot", true);
//			db.setCapability("appium:newCommandTimeout", 6600);
//			lis = new listner();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//	
			// *************************pCloudy************************************************
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability("pCloudy_Username", "randhir.kumar@heromotocorp.com");
//	capabilities.setCapability("pCloudy_ApiKey", "2gdc5pv55mh54mqtwmvj4xbr");
//	capabilities.setCapability("pCloudy_DurationInMinutes", 15);
//	capabilities.setCapability("newCommandTimeout", 600);
//	capabilities.setCapability("launchTimeout", 90000);
//	capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel7_Android_13.0.0_81870");
//	capabilities.setCapability("platformVersion", "13.0.0");
//	capabilities.setCapability("platformName", "Android");
//	capabilities.setCapability("automationName", "uiautomator2");
//	capabilities.setCapability("pCloudy_ApplicationName", "Hero_app.apk");
//	capabilities.setCapability("appPackage", "com.customerapp.hero");
//	capabilities.setCapability("appActivity", "com.customerapp.hero.views.activity.MainActivity");
//	capabilities.setCapability("pCloudy_WildNet", "false");
//	capabilities.setCapability("pCloudy_EnableVideo", "false");
//	capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
//	capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
//	 driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	    log = LogManager.getLogger("Hero_App");
//**********************Prathmesh********************		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("pCloudy_Username", "randhir.kumar@heromotocorp.com");
//		capabilities.setCapability("pCloudy_ApiKey", "2gdc5pv55mh54mqtwmvj4xbr");
//		capabilities.setCapability("pCloudy_DurationInMinutes", 15);
//		capabilities.setCapability("newCommandTimeout", 600);
//		capabilities.setCapability("launchTimeout", 90000);
//		capabilities.setCapability("pCloudy_DeviceManufacturer", "GOOGLE");
//		capabilities.setCapability("pCloudy_DeviceVersion", "13.0.0");
//		capabilities.setCapability("platformVersion", "13.0.0");
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("automationName", "uiautomator2");
			// -------- for real device----------
//	
//		db.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//		db.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
//		db.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 9");
//		db.setCapability(MobileCapabilityType.UDID, "74633a84");
//		db.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//		db.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

	
	public void startServer() {
		CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		cmd.addArgument("C:\\Users\\Welcome\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");

		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor excutor = new DefaultExecutor();
		excutor.setExitValue(1);
		try {
			excutor.execute(cmd ,handler);
			Thread.sleep(10000);
			} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
			try {
				
				runtime.exec("taskkill /f /IM node.exe");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	public boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serversocket;
	try {
		serversocket = new ServerSocket(port);
		serversocket.close();
	} catch (IOException e) {
		isServerRunning =true;
	}finally
	{
		serversocket =null;
	}
		return isServerRunning;
	}

	@Override
	public String config_getdata(String key) {
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
		String path = System.getProperty("user.dir") + "\\Report\\index.html";
		report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Hero_App Test Report");
		report.config().setReportName("Hero_App");
		report.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Project Name", "Hero App");
		extent.setSystemInfo("Laptop", "Dell intel core i7");
		extent.setSystemInfo("QA", "Nitesh Kumar");
		extent.setSystemInfo("Operating system", "Windows 10 pro");
		extent.setSystemInfo("BrowserName", "Android Studio");
		return extent;
	}

	@Override
	public void custom_sendkeys(WebElement element, String value, String fieldname) {
		try {
			if (element.isEnabled() || element.isDisplayed() == true) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				element.sendKeys(value);
				test.log(Status.PASS, fieldname + " value send successfully =" + value + " " + fieldname);
				log.info(fieldname + " send successfully");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + " is not able to send" + e);
			log.error(fieldname + " is not able to send");
		//	lis.onTestFailure(null);
		}

	}

	@Override
	public void Custom_click(WebElement element, String fieldname) {
		try {
			if (element.isDisplayed() || element.isEnabled() == true) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				test.log(Status.PASS, "Successfully click on = " + fieldname);
				log.info(fieldname + " is clickable");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + "==Unable To Click ==" + e);
			log.error(fieldname + " is not clickable");
	//		lis.onTestFailure(null);
		}
	}

//======================================================================================================================================================	    
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void Scroll_down_page_Action(int startx, int starty, int endx, int endy, String fieldname) {
		try {
			Dimension dim = driver.manage().window().getSize();
//    	int startx = (int) (dim.width*0.5);
//    	int starty = (int) (dim.height*0.2);	    	
//    	int endx   =  (int) (dim.width*0.2);  	
//    	int endy   = (int) (dim.height*0.8);
			action = new TouchAction(driver);
			action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			test.log(Status.PASS, "Successfully Scroll page Action ==" + fieldname);
			log.info("Successfully  Scroll page down Action " + fieldname);

		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + "Unable To Scroll page Action ==" + e);
			log.error("==NOT==Unable To Scroll page down Action " + fieldname);
		}
	}

//======================================================================================================================================================
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void swipe_page_direction(int startx, int starty, int endx, int endy, String fieldname) {
		try {
			action = new TouchAction(driver);
			action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			log.info("Successfully  Swipe page direction Action " + fieldname);
		} catch (Exception e) {
			log.error("==NOT==Unable To Swipe page direction Action " + fieldname);
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void VerifyImagePresent(WebElement image, String fieldname) {
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					image);
			if (ImagePresent) {
				test.log(Status.PASS, "Image is present:  " + fieldname);
				log.info("Image is present " + fieldname);
			} else {
				test.log(Status.FAIL, fieldname + "==Image is not present ==");
				log.error("Image is not present" + fieldname);
		//		lis.onTestFailure(null);

			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + "==Image is not present ==" + e);
			log.error("Image is not present" + fieldname);
		//	lis.onTestFailure(null);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void PageLoaded() {
		String Title = null;
		try {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Title = driver.getTitle();
			test.log(Status.PASS, "Page is loaded : " + Title);
			log.info("Page is loaded " + Title);
		} catch (Exception e) {
			test.log(Status.FAIL, "==page is not loaded :" + e);
			log.error("page is not able to loaded " + Title);
		//	lis.onTestFailure(null);
		}
	}

	@Override
	public void VerifyElementPresent(WebElement ele, String fieldname) {
		try {
			if (ele.isDisplayed() && ele.isEnabled() == true) {
				String Text = ele.getText();
				test.log(Status.PASS, fieldname + " present:");
				log.info(fieldname + " present");
			} else {
				test.log(Status.PASS, fieldname + "  not present");
				log.info(fieldname + "  not present");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + " not present" + e);
			log.error(fieldname + "  not present");
		//	lis.onTestFailure(null);
		}

	}

	@Override
	public void msg(String filedname) {
		try {
			test.log(Status.PASS, filedname);
			log.info(filedname);
		} catch (Exception e) {
			test.log(Status.FAIL, filedname + e);
			log.error(filedname);
		//	lis.onTestFailure(null);
		}

	}
	
	
}
