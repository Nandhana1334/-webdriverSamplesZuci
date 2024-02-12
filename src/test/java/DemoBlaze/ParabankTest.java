package DemoBlaze;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParabankTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	@Test(priority = 1)
	public void login()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user34");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("user34");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
		
		
	}
  @Test(priority = 2)
  public void openAccount() throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement openAcc=driver.findElement(By.xpath("//a[text()='Open New Account']"));
	    openAcc.click();
		Select acctype=new Select(driver.findElement(By.id("type")));
		acctype.selectByVisibleText("SAVINGS");
		wait.until(ExpectedConditions
		         .presenceOfNestedElementsLocatedBy
		         (By.id("fromAccountId"), By.tagName("option")));
		Select accNo=new Select(driver.findElement(By.id("fromAccountId")));
		accNo.selectByValue("17118");
		 WebElement acc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Open New Account']")));
		//driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		acc.click();
		WebElement displays = driver.findElement(By.xpath("//p[contains(text(),'Congratulations, your account is now open.')]"));
		
		Assert.assertEquals(displays.getText(), "Congratulations, your account is now open.");


		
//
  }
  @Test(priority = 3)
  public void transferFunds() throws InterruptedException
  {
	  	
	  driver.findElement(By.xpath("//a[text()='Transfer Funds']")).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement amount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='amount']")));
	 // WebElement amount=driver.findElement(By.xpath("//input[@id='amount']"));
	  amount.sendKeys("5000");
	  wait.until(ExpectedConditions
		         .presenceOfNestedElementsLocatedBy
		         (By.xpath("//select[@id='fromAccountId']"), By.tagName("option")));
  
	  Select fromAccNo=new Select(driver.findElement(By.id("fromAccountId")));
	  
	  fromAccNo.selectByValue("17118");
	  wait.until(ExpectedConditions
		         .presenceOfNestedElementsLocatedBy
		         (By.xpath("//select[@id='toAccountId']"), By.tagName("option")));
	  Select toAccNo=new Select(driver.findElement(By.id("toAccountId")));
	  toAccNo.selectByValue("17118");
	  driver.findElement(By.xpath("//input[@value='Transfer']")).click();
	  
	  WebElement displays = driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]"));
	  Assert.assertEquals(displays.getText(), "Transfer Complete!");
		
		
	 

  }
  @Test(priority = 4)
  public void accountOverview() throws InterruptedException
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement overView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Accounts Overview')]")));
	  overView.click();
  	 
  	
  	WebElement displays = driver.findElement(By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to holds')]"));
  	Assert.assertEquals(displays.getText(), "*Balance includes deposits that may be subject to holds");
	
  	
  	 
  }



}
