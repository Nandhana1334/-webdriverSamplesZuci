package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JqueryIFrame {
  @Test
  public void iFrame() {
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/iframe");
	  
	  driver.switchTo().frame("mce_0_ifr");
	  driver.findElement(By.tagName("p")).sendKeys(" Sample exercise");
	  driver.switchTo().defaultContent();
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Powered by Tiny')]")).click();
	  
  }
}
