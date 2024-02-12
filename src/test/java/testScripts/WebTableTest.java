package testScripts;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
  @Test
  public void searchEmpDetails()
  {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
//	  List<WebElement> items = driver.findElements(
//			  By.xpath("//td[contains(text(),'Wagner')]//following-sibling::tr"));
//	  System.out.println("Number of items..." +items.size());
//	  for(WebElement elem:items)
//	  {
//		  System.out.println(elem.getText());
//	  }
	  
	  
	  WebElement d =driver.findElement(
			  By.xpath("//td[contains(text(),'Wagner')]//following-sibling::td[6]"));
	  System.out.println(d.getText());
	  
	  


	  
	  
  }
}
