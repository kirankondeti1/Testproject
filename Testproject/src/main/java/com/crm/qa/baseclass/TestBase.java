package com.crm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Anil\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			//prop = new Properties(System.getProperties());
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Anil\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Anil\\workspace\\Firstproject\\browserdrivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}
		// EventFiringWebDriver e_driver = new EventFiringWebDriver(driver); //
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver eventListener = new WebEventListener();
		// e_driver.register(eventListener); driver = e_driver;
	//	driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/");
	}
}
