package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Automation {
  @Test
  public void automateForms() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
	  WebElement message = driver.findElement(By.id("user-message"));
	  message.sendKeys("Hello World");
	  WebElement showMessage = driver.findElement(By.xpath("//div//button[contains(text(),'Show Message')]"));
	  showMessage.click();
	  WebElement a = driver.findElement(By.id("value1"));
	  a.sendKeys("5");
	  WebElement b = driver.findElement(By.id("value2"));
	  b.sendKeys("5");
	  
	  WebElement getTotal = driver.findElement(By.xpath("//div//button[contains(text(),'Get Total')]"));
	  getTotal.click();
  }
  
}
