package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PopupWinTest {
  @Test
  public void sampleWindow() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://stqatools.com/demo/Windows.php");
	  String parentWin = driver.getWindowHandle();
	  System.out.println("Parent window handle: " +parentWin);
	  driver.findElement(By.xpath("//button[contains(text(),'open new Tab')]")).click();
	  
	  Set<String> tabs = driver.getWindowHandles();
	  System.out.println("Number of windows: "+tabs.size());
	  for(String childWin:tabs)
	  {
		  System.out.println(childWin);
		  if(!childWin.equalsIgnoreCase(parentWin))
		  {
			  driver.switchTo().window(childWin);
			  driver.findElement(By.linkText("Java")).click();  
		  }
	  }
	  driver.close();
	  driver.switchTo().window(parentWin);
	  driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]")).click();
	  Set<String> wins = driver.getWindowHandles();
	  System.out.println("Number of windows: " +wins.size());
	  for(String childWin:wins)
	  {
		  System.out.println(childWin);
		  if(!childWin.equalsIgnoreCase(parentWin))
		  {
			  driver.switchTo().window(childWin);
		  }
	  }
	  driver.quit();
  }
}
