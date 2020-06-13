package MercuryDatadrivenTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import MercuryBrowserFactory.BrowserFactoryData;
import MercuryDatadrivenpages.Mercurydatadrivenhomepage;

public class mercurydatalogintest {
	

	@Test	
	
	public  void set() throws InterruptedException, IOException
	{
		String key1=null;
		String value1=null;
		WebDriver driver=BrowserFactoryData.start();
Mercurydatadrivenhomepage logindatapage=PageFactory.initElements(driver,Mercurydatadrivenhomepage.class);
logindatapage.verifyvalidlogin(key1,value1);}
	
}	