package MercuryBrowserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BrowserFactoryData {
	public static WebDriver driver;
	@BeforeTest
	public static WebDriver  start()
	{
		String Browser="Chrome";
	System.setProperty("webdriver.chrome.driver","C:/mydriver/chromedriver.exe");
	 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.DAYS.SECONDS);
		driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
		return driver;
	}


	}


