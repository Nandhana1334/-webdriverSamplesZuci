package DemoBlaze;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class BlazeTest {
	 WebDriver driver;
	 Properties prop;
	  
	   @BeforeClass
	   public void setup() throws IOException
	   {
		   String path = System.getProperty("user.dir")+"//src//test//resources//configFiles//demoBlaze1.properties";
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
					
				
				
				
				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
			
		   
		   
	   }
	   
	   
	   @Test()
	   public void validLogin() throws InterruptedException {
		    
		  
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		   WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
		   login.click();
		   driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(prop.getProperty("username"));

	        driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(prop.getProperty("password"));
	        
			driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
			//a[@id='nameofuser']
			WebElement display = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
			
			Assert.assertEquals(display.getText(), "Welcome"+" " +prop.getProperty("username"));

	   }

	  @DataProvider(name="demoBlaze")
		public Object[] getData() throws CsvValidationException, IOException
		{
			String path=System.getProperty("user.dir")+"//src//test//resources//testData//demoBlaze.csv";
			CSVReader reader=new CSVReader(new FileReader(path));
			String cols[];
			ArrayList<Object> dataList=new ArrayList<Object>();
			while((cols=reader.readNext())!=null)
			{
				Object record[]= {cols[0]};
				dataList.add(record);
			}
			reader.close();
			return dataList.toArray(new Object[dataList.size()]
					[]);
		}
	  @Test(dataProvider="demoBlaze",dependsOnMethods="validLogin")
	  public void addItem(String itemname) throws Exception {
		  driver.navigate().refresh();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	      WebElement itemLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + itemname + "')]")));
	      itemLink.click();
	      WebElement cart=driver.findElement(By.xpath("//a[text()='Add to cart']"));
		  cart.click();
		  wait.until(ExpectedConditions.alertIsPresent());
		  
		  Alert alert=driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "Product added.");
		  alert.accept();
		  
		  WebElement hp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navbarExample']//a[text()='Home ']")));
	      hp.click();
		  
		  
		  
		  
		  
		  
	 
	  }
	  @Test(dataProvider ="demoBlaze",dependsOnMethods ="addItem")
	  public void checkCart(String item1)
	  {
		  driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		  WebElement cartItem1 = driver.findElement(By.xpath("//td[contains(text(),'Samsung galaxy s6')]"));
		  WebElement cartItem2 = driver.findElement(By.xpath("//td[contains(text(),'Nokia lumia 1520')]"));
		  Assert.assertEquals(cartItem1.getText(), "Samsung galaxy s6");
		  Assert.assertEquals(cartItem1.getText(), "Nokia lumia 1520");
		  
		  
	  }
	 
	}
	   
	   
