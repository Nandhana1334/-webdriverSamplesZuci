package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chkRadioTest {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	  WebElement age = driver.findElement(By.id("isAgeSelected"));
	  if(!age.isSelected())
	  {
		  age.click();
	  }
	  driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]")).click();
	  
	  
  }
}
