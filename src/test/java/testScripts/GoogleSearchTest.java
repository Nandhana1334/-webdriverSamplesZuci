package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoogleSearchTest {
  @Test//annotates-during runtime,
  public void searchJavaTest(){
//	    ChromeOptions options = new ChromeOptions();
//		options.setBrowserVersion("115");
		WebDriver driver = new ChromeDriver();
		
		

		//driver.get("https://www.google.com/");
		driver.navigate().to("https://www.google.com/");
		WebElement txtArea = driver.findElement(By.id("APjFqb"));
		txtArea.sendKeys("Java Tutorial");
		txtArea.sendKeys(Keys.ENTER);
		System.out.println("Before click back ...Page title: ..." + driver.getTitle());
		driver.navigate().back();
		System.out.println("After click ... Page title:..." +driver.getTitle());
		driver.navigate().forward();
		System.out.println("URL:..." + driver.getCurrentUrl());
		
  }
}
