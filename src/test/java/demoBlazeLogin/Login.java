package demoBlazeLogin;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	
	@BeforeClass
	public void set()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void setup()
	{
		
		driver.get("https://www.demoblaze.com/");
		
	}
	
	@Test()
	public void invalidUser()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
       
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
        username.sendKeys("user");
		
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
        password.sendKeys("usernan");
	    
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Wrong password.");
		alert.accept();
		
	}
	@Test()
	public void invalidPassword()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
        
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
        username.sendKeys("usernan");
		
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
		
        password.sendKeys("nan");
	    
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Wrong password.");
		alert.accept();
		
	}
	@Test()
	public void invalidCredentials()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
        
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
        username.sendKeys("user");
		
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
        password.sendKeys("nan");
	    
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Wrong password.");
		alert.accept();
		
	}
	@Test()
	public void blankUser()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
        
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
        username.sendKeys("");
		
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
		password.sendKeys("nan");
	    
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		alert.accept();
		
	}
	@Test()
	public void blankPassword()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
        
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
        username.sendKeys("user");
		
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
        password.sendKeys("");
	    
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		alert.accept();
		
	}
	@Test()
	public void blankCredentials()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();

        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
        username.sendKeys("");
		
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
        password.sendKeys("");
	    
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		alert.accept();
		
	}
}
