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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginPageTest1 {
   WebDriver driver;
   Properties prop;
   @Parameters("browser")
   @BeforeMethod
   public void setup() throws IOException
   {
	   String path = System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
	   FileInputStream fin = new FileInputStream(path);
	   prop = new Properties();
	   prop.load(fin);
	   
	   String strBrowser = prop.getProperty("browser");
		System.out.println("Browser name:.."+strBrowser);
		if(strBrowser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			if(strBrowser.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
			
		}
	   
	   
   }
   
   //reading from property file
   //*******
//   @Test
//   public void validLogin() {
//	    
//		driver.get(prop.getProperty("url"));
//
//		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
//		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("SuperSecretPassword!");
//		driver.findElement(By.tagName("button")).click();
//  	
//		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//		Assert.assertTrue(isUserValid);
//   }
   
  // reading from csv file
   @Test(dataProvider ="loginData")
 public void validLogin(String username,String password) {
	    
		driver.get(prop.getProperty("url"));

		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.tagName("button")).click();
	
		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isUserValid);
 }
   
   //reading from csv file
   
	
   @DataProvider(name ="loginData")
   public Object[][] getData() throws CsvValidationException, IOException 
   {
	   String path = System.getProperty("user.dir")+"//src//test//resources//testData//loginData.csv";
	   CSVReader reader = new CSVReader(new FileReader(path));
	   String cols[];
	   ArrayList<Object> dataList = new ArrayList<Object>();
	   while((cols=reader.readNext())!=null)
	   {
		   Object record[]= {cols[0],cols[1]};
		   dataList.add(record);
	   }
	   reader.close();
	   return dataList.toArray(new Object[dataList.size()][]);
	   
	   
   }
   
   
   

		
		
		
   
   
	
}
