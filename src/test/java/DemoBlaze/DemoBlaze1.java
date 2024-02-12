package DemoBlaze;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class DemoBlaze1 {
  
  WebDriver driver;
  Properties prop;
  
  @BeforeClass
  public void setup() throws IOException
  {
	   String path = System.getProperty("user.dir")+"//src//test//resources//configFiles//demoBlaze.properties";
	   FileInputStream fin = new FileInputStream(path);
	   prop = new Properties();
	   prop.load(fin);
	   
	   String strBrowser = prop.getProperty("browser");
	   System.out.println("Browser name:.."+strBrowser);
		if(strBrowser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge"))
		{
			
				driver = new EdgeDriver();
				
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
		}
	   
	   
  }
  
  
 // reading from csv file
  @Test(dataProvider ="demoBlaze")
  
  public void validLogin(String username,String password) throws InterruptedException {
 	    
 		driver.get(prop.getProperty("url"));
 		driver.findElement(By.id("login2")).click();
 		Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id=\"loginpassword\"]")).sendKeys(password);
        Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        
        
        
        
 		
 		//boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
 		 //Thread.sleep(1000);
}

  
  
  //reading from csv file
  
	
  @DataProvider(name ="demoBlaze")
  public Object[][] getLoginData() throws CsvValidationException, IOException 
  {
	   String path = System.getProperty("user.dir")+"//src//test//resources//testData//demoBlaze.csv";
	   CSVReader reader = new CSVReader(new FileReader(path));
	   String cols[];
	   
	   ArrayList<Object> dataList = new ArrayList<Object>();
	   cols=reader.readNext();
	   
	   Object record[]= {cols[0],cols[1]};
	   dataList.add(record);
	   
		
	   reader.close();
	   return dataList.toArray(new Object[dataList.size()][]);
  }
	   
	   

  
  
//  @Test(dataProvider = "searchItemData" ,dependsOnMethods="validLogin")
// public void searchItem(String itemName) throws InterruptedException {
//	  driver.navigate().refresh();
//	  Thread.sleep(1000);
//      //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//     // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//      WebElement itemLink = driver.findElement(By.xpath("//a[contains(text(),'" + itemName + "')]"));
//      itemLink.click();
//      driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
//      Thread.sleep(1000);
//      Alert alert = driver.switchTo().alert();
//      Assert.assertEquals(alert.getText(), "Product added");
//      alert.accept();
//
//
//  }
  
  
  public void searchItem(String[] itemNames) throws InterruptedException {
	    for (String itemName : itemNames) {
	        driver.navigate().refresh();
	        Thread.sleep(1000);
	        WebElement itemLink = driver.findElement(By.xpath("//a[contains(text(),'" + itemName + "')]"));
	        itemLink.click();
	        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
	        Thread.sleep(1000);
	        Alert alert = driver.switchTo().alert();
	        Assert.assertEquals(alert.getText(), "Product added");
	        alert.accept();
	        Thread.sleep(100);
	     // Using JavaScriptExecutor to navigate back
	        ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");

	        Thread.sleep(100);
	    }
  }
  
  @Test(dataProvider = "searchItemData", dependsOnMethods = "validLogin")
  public void searchMultipleItems(String[] itemNames) throws InterruptedException {
      searchItem(itemNames);
  }

  @DataProvider(name = "searchItemData")
  public Object[][] getSearchItemData() throws IOException, CsvValidationException {
      String path = System.getProperty("user.dir") + "//src//test//resources//testData//demoBlaze.csv";
      CSVReader reader = new CSVReader(new FileReader(path));

      ArrayList<Object[]> dataList = new ArrayList<>();

      String[] rowData;
      while ((rowData = reader.readNext()) != null) {
          dataList.add(new Object[]{rowData});
      }

      reader.close();

      return dataList.toArray(new Object[dataList.size()][]);
  }



//
//  @DataProvider(name = "searchItemData")
//  public Object[][] getSearchItemData() throws IOException, CsvValidationException {
//      String path = System.getProperty("user.dir") + "//src//test//resources//testData//demoBlaze.csv";
//      CSVReader reader = new CSVReader(new FileReader(path));
//
//      ArrayList<Object[]> dataList = new ArrayList<>();
//
//      String[] rowData;
//      while ((rowData = reader.readNext()) != null) {
//          String searchItem = rowData[2];
//          Object[] record = {searchItem};
//          dataList.add(record);
//      }
//
//      reader.close();
//
//      return dataList.toArray(new Object[dataList.size()][]);
//  }
  
//  @DataProvider(name = "searchItemData")
//  public Object[][] getSearchItemData() throws IOException, CsvValidationException {
//      String path = System.getProperty("user.dir") + "//src//test//resources//testData//demoBlaze.csv";
//      CSVReader reader = new CSVReader(new FileReader(path));
//
//      ArrayList<Object[]> dataList = new ArrayList<>();
//
//       String[] rowData;
//       rowData = reader.readNext();
////      while ((rowData = reader.readNext()) != null) {
////          dataList.add(rowData);
////      }
//      String searchItem = rowData[2];
////    Object[] record = {searchItem};
////    dataList.add(record);
//
//      reader.close();
//
//      return dataList.toArray(new Object[dataList.size()][]);
//  }



  
  
  
}