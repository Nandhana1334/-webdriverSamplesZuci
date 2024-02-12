package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchScenarios {
  @Test(priority = 1)
  public void scenario1() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  
	  
  }
  @Test(enabled = false)
  public void scenario2() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Selenium Tutorial");
	  srcBox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
	  
	  
  }
  @Test(priority =2)
  public void scenario3() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Ansible Tutorial");
	  srcBox.sendKeys(Keys.ENTER);
	  Assert.assertEquals(driver.getTitle(), "Ansible Tutorial - Google Search");
	  
	  
  }
}
