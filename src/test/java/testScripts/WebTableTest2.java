package testScripts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest2 {
  @Test
  public void searchTable() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
	  List<WebElement> items = driver.findElements(
			  By.xpath("//td[contains(text(),'San Francisco')]//preceding-sibling::td[2]"));
	  System.out.println("Number of items..." +items.size());
	  
	  for(WebElement elem:items)
		  {
			  System.out.println(elem.getText());
		  }
		  
  }
}
