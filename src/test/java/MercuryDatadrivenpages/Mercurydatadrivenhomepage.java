package MercuryDatadrivenpages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mercurydatadrivenhomepage {
	public static WebDriver driver;
	

	public  Mercurydatadrivenhomepage(WebDriver ldriver) {
	this.driver=ldriver;
	}
	@FindBy(how=How.XPATH,using ="//*[@id=\"email\"]") WebElement Email;
	@FindBy(how =How.XPATH ,using ="//*[@id=\"pass\"]")WebElement password;
	@FindBy(how=How.XPATH,using ="//*[@id=\"loginbutton\"]")
	static WebElement LoginButton ;
	@DataProvider(name="testdata")
	public void verifyvalidlogin(String Emailid,String Passid) throws InterruptedException
	{
  Email.sendKeys(Emailid);
		password.sendKeys(Passid);
	  Thread.sleep(3000);
		LoginButton.click();
	}
	 
	public String[][] getExcelData(String filename) throws IOException{
		String[][] arrayExcelData = null;
		int[] arr=new int [5];
	FileInputStream fis=new FileInputStream(filename);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	DataFormatter dataFormatter = new DataFormatter();
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	XSSFRow row1=sheet.getRow(0);
	int colcount=row1.getLastCellNum();
	System.out.println("Total no of Column count is "+colcount);
	int rownum=sheet.getLastRowNum()+1;
	System.out.println("Total no of row count is "+rownum);
	arrayExcelData=new String [rownum][colcount];

	for(int i=0; i<rownum;i++)
	{
		for
		(int j=0;j<colcount;j++)
				{
		arrayExcelData[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}


	return arrayExcelData;
	}
	@DataProvider(name="testdata")
   

	public Object[][] loginData() {
		Object[][] arrayObject = null;
		try {
			arrayObject = getExcelData("Users/manib/eclipse-workspace/MercuryDataDriven/src/test/java/TestData/data1.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return arrayObject;

	}





}
