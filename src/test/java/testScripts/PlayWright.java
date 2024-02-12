package testScripts;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PlayWright {
  @Test
  public void displayList() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.lambdatest.com/blog/");
	  List<WebElement> items = driver.findElements(
			  By.xpath("//ul[@id='menu-side-menu']//li[.//a[text()='Playwright Testing']]/preceding-sibling::li"));

	  System.out.println("Number of items before playwright :" +items.size());
	  System.out.println("*****");
	  for(WebElement elem:items)
	  {
		  System.out.println(elem.getText());
	  }
	  
	  List<WebElement> items1 = driver.findElements(
			  By.xpath("//ul[@id='menu-side-menu']//li[.//a[text()='Playwright Testing']]/following-sibling::li"));
	  System.out.println("Number of items after playwright :" +items1.size());
	  System.out.println("*****");
	  for(WebElement elem:items1)
	  {
		  System.out.println(elem.getText());
	  }
	  
  }
}
