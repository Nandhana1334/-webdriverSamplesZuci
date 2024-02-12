package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Suggestions {
  @Test
  public void clickSuggestion() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.navigate().to("https://www.google.com/");
	  WebElement txtArea = driver.findElement(By.id("APjFqb"));
	  txtArea.sendKeys("Java tutorial");
	  Thread.sleep(1000);
	  List<WebElement> items = driver.findElements(By.xpath("(//ul[@class='G43f7e'])[1]//li//descendant::div[@class='wM6W7d'])"));
	  System.out.println("Number of items..." +items.size());
	  for(WebElement elem:items)
	  {
		  System.out.println(elem.getText());
		  if(elem.getText().equalsIgnoreCase("Java tutorial pdf"))
		  {
			  elem.click();
			  break;
		  }
	  }
	  

	  
  }
}
