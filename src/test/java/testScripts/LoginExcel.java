package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginExcel {
	WebDriver driver;
	Properties tempProp;

	@Parameters("browser")
	@BeforeMethod
	public void setup() throws IOException
	{
		tempProp = new Properties();
  		String path=System.getProperty("user.dir")+"//src//test//resources//config//config.properties";
  		FileInputStream fin = new FileInputStream(path);
  		tempProp.load(fin);
  		String strBrowser1=tempProp.getProperty("browser");
  		System.out.println("browser"+strBrowser1);
  		
		if(strBrowser1.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			if(strBrowser1.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.manage().deleteAllCookies();
			
		}
	}
	@DataProvider(name="loginData")
	

	public Object[][] getData() throws IOException, CsvValidationException{
		String path=System.getProperty("user.dir")+"//src//test//resources//testData//loginData.csv";
		CSVReader reader=new CSVReader(new FileReader(path));
		String cols[];
		ArrayList<Object> dataList=new ArrayList<Object>();
		while((cols=reader.readNext())!=null)
		{
			Object record[]= { cols[0], cols[1]};
			dataList.add(record);
		}
		reader.close();
		return dataList.toArray(new Object[dataList.size()][]);
	}
	@Test(dataProvider="loginData")
	

	public void validLogin(String username,String Password)
	{

	driver.get(tempProp.getProperty("url"));//LAUNCH THE PAGE
	//driver.findElement(By.id("username")).sendKeys(username);//LOCATE THE ELEMENT
	driver.findElement(By.id(readObjPath("user_name"))).sendKeys(username);
	//ENTER VALUES
	//driver.findElement(By.id("password")).sendKeys(Password);//LOCATE THE ELEMENT
	driver.findElement(By.name(readObjPath("user_pwd"))).sendKeys(Password);
	
	//driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
	driver.findElement(By.tagName(readObjPath("loginBtn"))).click();
	
//	boolean isValid=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//	AssertJUnit.assertTrue(isValid);
	}
	
	
	@Test
	public String readObjPath(String objName)
	{
		String objPath="";
		String path=System.getProperty("user.dir")+"//src//test//resources//testData/loginData.xlsx";
		FileInputStream fin;
		XSSFWorkbook workbook=null;
		try {
			fin=new FileInputStream(path);
			workbook=new XSSFWorkbook(fin);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		XSSFSheet loginSheet=workbook.getSheet("loginPage");
		int numRows=loginSheet.getLastRowNum();
		for(int i=1;i<=numRows;i++)
		{
			XSSFRow row=loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName))
			{
				objPath=row.getCell(1).getStringCellValue();
			}
		}
		return objPath;
	}

	   
	   
	  
	  
}
