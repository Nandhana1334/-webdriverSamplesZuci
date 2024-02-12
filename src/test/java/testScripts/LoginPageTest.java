package testScripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	
	WebDriver driver ;
	Properties connprop;
	
	
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) throws IOException
	{
		String path = System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		connprop = new Properties();
		connprop.load(fin);
		String strBrowser1 = connprop.getProperty("browser");
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
	
  @Test
  public void validLogin() {
	    ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("115");
		WebDriver driver = new ChromeDriver(options);
		//driver.get("https://the-internet.herokuapp.com/login");
		
//		WebElement userName = driver.findElement(By.id("username"));
//		userName.sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
		WebElement password = driver.findElement(By.id("password"));
    	password.sendKeys("SuperSecretPassword!");
		driver.findElement(By.tagName("button")).click();
//    	driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
//		driver.findElement(By.linkText("Elemental Selenium")).click();
		//driver.findElement(By.partialLinkText("Selenium")).click();
    	boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
    	Assert.assertTrue(isUserValid);
		
		
		
		
		
  }
  
  
}
