package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DisplayMessage {
  @Test
  public void displayText() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://automationbookstore.dev/");
	  WebElement search = driver.findElement(By.id("searchBar"));
	  search.sendKeys("test");
	  Thread.sleep(1000);
	  WebElement icon = driver.findElement(By.linkText("Clear text"));
	  //icon.click();
	  if(icon.isDisplayed())
	  {
		  
		 icon.click();
		 System.out.println("text cleared");
	  }
	  else
	   {
		  System.out.println("clear icon hidden");
	   }
	  
	  
  }
}
